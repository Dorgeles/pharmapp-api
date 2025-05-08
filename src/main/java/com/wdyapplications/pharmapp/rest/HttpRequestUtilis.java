package com.wdyapplications.pharmapp.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wdyapplications.pharmapp.business.UserActivityBusiness;
import com.wdyapplications.pharmapp.dao.repository.SettingRepository;
import com.wdyapplications.pharmapp.utils.FunctionalError;
import com.wdyapplications.pharmapp.utils.Utilities;
import com.wdyapplications.pharmapp.utils.contract.Request;
import com.wdyapplications.pharmapp.utils.contract.Response;
import com.wdyapplications.pharmapp.utils.dto.UserActivityDto;
import com.wdyapplications.pharmapp.utils.dto.UsersDto;
import com.wdyapplications.pharmapp.utils.es.EsUtils;
import com.wdyapplications.pharmapp.utils.es.HighClientFactory;
import com.wdyapplications.pharmapp.utils.redis.CacheUtils;
import com.wdyapplications.pharmapp.utils.security.SecurityUtils;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class HttpRequestUtilis {
    @Autowired
    private HighClientFactory highClientFactory;
    @Autowired
    private SettingRepository settingRepository;

    static final String JOB_TYPE = "pharmapp_log_info";

//
    public static void calledEncryptRequestManagement(FilterChain chain, HttpServletRequest httpServletRequest,
                                                      HttpServletResponse httpServletResponse, String uri, String requestValue, FunctionalError functionalError, SettingRepository settingRepository,UserActivityBusiness userActivityBusiness, CacheUtils cacheUtils) throws IOException, ServletException {

        String serviceLibelle   = "";
        String requestValueLog  = "";
        String decriptRequest = "";
        int actualVersionNumber   = 0;
        String responseValueLog = "";
        int versionNumber   = 0;
        String  deviceId        = "";
        String ipAddress        = Utilities.getClientIp(httpServletRequest);
        UsersDto user           = new UsersDto();

        try {
            actualVersionNumber = Integer.parseInt(settingRepository.findByCode("ACTUAL_VERSION_NUMBER", Boolean.FALSE).getValeur());
            String     resp;
            JSONObject reqToJson;
            // get request value
            String encryptRequest = requestValue;
            // decrypt request
            decriptRequest = SecurityUtils.ExtractDataFromAesMobile(ExtractData(encryptRequest));
            String redisKey = decriptRequest + uri;
            redisKey = Utilities.normalizeName(redisKey);
            redisKey = Base64.getEncoder().encodeToString(redisKey.getBytes());
            // build request to send
            String responseToPublish = "";
            reqToJson = Utilities.notBlank(decriptRequest) ? new JSONObject(decriptRequest) : new JSONObject();
            if (!reqToJson.has("user")) {
                responseToPublish = ReturnAccesDenied(httpServletRequest, httpServletResponse,
                        " User non renseigné non renseigné ", functionalError);
                requestValueLog =SecurityUtils.EncryptResponseMobile(responseToPublish);
                publishResponse(requestValueLog, httpServletResponse);
            }
            user.setId(Integer.parseInt(reqToJson.get("user").toString()));
            if (Utilities.blank(decriptRequest) || Utilities.isFalse(reqToJson.has("serviceLibelle"))) {
                System.out.println("--- Forbidden serviceLibelle is not valid ----");
                responseToPublish = ReturnAccesDenied(httpServletRequest, httpServletResponse,
                        " serviceLibelle non renseigné ", functionalError);
                responseValueLog = SecurityUtils.EncryptResponseMobile(responseToPublish);
            } else {
                decriptRequest  = reqToJson.toString();
                serviceLibelle  = reqToJson.get("serviceLibelle").toString();
                if (!reqToJson.has("versionNumber")) {
                    String respo = "Vous n'êtes pas autorisé a utiliser l'application";
                    String encrypReponse = SecurityUtils.EncryptResponseMobile(respo);
                    publishResponse(encrypReponse, httpServletResponse);
                }
                // recupération de la version du code de l'application mobile
                 versionNumber = Integer.parseInt(reqToJson.get("versionNumber").toString());
                // recupération de l'id de l'appareil
                deviceId = reqToJson.get("deviceId").toString();
                if (versionNumber <= actualVersionNumber) {
                    String respo = returnOldVersionSet(httpServletRequest, httpServletResponse,
                            " Version :: " + actualVersionNumber, functionalError);
                    String encrypReponse = SecurityUtils.EncryptResponseMobile(respo);
                    publishResponse(encrypReponse, httpServletResponse);
                }
                HttpServletRequestWritableWrapper requestWrapper = new HttpServletRequestWritableWrapper(
                        httpServletRequest, decriptRequest.getBytes());
                HttpServletResponseReadableWrapper responseWrapper = new HttpServletResponseReadableWrapper(
                        httpServletResponse);
                chain.doFilter(requestWrapper, responseWrapper);
                responseValueLog = responseWrapper.getResponseData();

                //si l'uri fais parti des uri cacheable
                Object cachedData = cacheUtils.getCachedData(redisKey);
                if (  cachedData != null){
                    responseValueLog = (String) cachedData;
                }else {
                    if ( Utilities.isKpisCacheable(uri) ){
                        cacheUtils.cacheData(redisKey, responseValueLog, 15);
                    }
                }
                // System.out.println("responseValueLog " + responseValueLog);
                responseToPublish = SecurityUtils.EncryptResponseMobile(responseValueLog);
            }
            publishResponse(responseToPublish, httpServletResponse);
        } catch (Exception e) {
            responseValueLog = e.getMessage();
        } finally {
            logRequest(uri, user.getId(), serviceLibelle, ipAddress, responseValueLog, requestValue, versionNumber, deviceId, userActivityBusiness);
        }
    }


    public static void addStatusCodeAndpublishResponse(String uri,HttpServletRequest httpServletRequest, ServletResponse response, HttpServletResponse httpServletResponse,FilterChain chain) throws IOException {
        if(Utilities.areEquals(uri, "/fetchStatus")) {
            String requestValueLog = response.toString();
            // TODO: ajout du user ayant mener l'action dans la requête
            HttpServletRequestWritableWrapper requestWrapper = new HttpServletRequestWritableWrapper(
                    httpServletRequest, requestValueLog.getBytes());
            HttpServletResponseReadableWrapper responseWrapper = new HttpServletResponseReadableWrapper(
                    httpServletResponse);
            try {
                chain.doFilter(requestWrapper, responseWrapper);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String responseValueLog = responseWrapper.getResponseData();
            JSONObject subResponse = new JSONObject(responseValueLog);
            subResponse.put("code", responseWrapper.getStatus());
            HttpRequestUtilis.publishResponse(subResponse.toString(), httpServletResponse);;

        }else {
            try {
                chain.doFilter(httpServletRequest, response);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }


    public static void publishResponse(String resp, HttpServletResponse httpServletResponse) throws IOException {
        OutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(resp.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    public static void addStatusCodeAndpublishResponse(String resp, HttpServletResponse httpServletResponse) throws IOException {
        OutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(resp.getBytes());
        outputStream.flush();
        outputStream.close();
    }


    public static void noEncryptRequestThenChainDoFilter(ServletResponse response, FilterChain chain, HttpServletRequest httpServletRequest, String requestValue)
            throws IOException, ServletException {
        JSONObject reqToJson;
        reqToJson = new JSONObject(requestValue);

        // TODO: ajout du ipAdress et la cookies ayant mener l'action dans la requête
        reqToJson.put("ipAddress", Utilities.getClientIp(httpServletRequest));
        reqToJson.put("cookies", httpServletRequest.getHeader("cookies"));
        requestValue = reqToJson.toString();
        String requestValueLog = reqToJson.toString();
        HttpServletRequestWritableWrapper requestWrapper = new HttpServletRequestWritableWrapper(
                httpServletRequest, requestValueLog.getBytes());
        //httpServletRequest.getRequestURI()
        chain.doFilter(requestWrapper, response);
    }

    public static String ExtractRequest(ServletRequest request) {
        String requestBody = "";
        try {
            request.setCharacterEncoding("UTF-8");
            StringBuilder builder = new StringBuilder();
            String        aux     = "";
            while ((aux = request.getReader().readLine()) != null) {
                String rawString         = aux;
                byte[] bytes             = StringUtils.getBytesUtf8(rawString);
                String utf8EncodedString = StringUtils.newStringUtf8(bytes);
                builder.append(utf8EncodedString);
            }
            requestBody = builder.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return requestBody;
    }

    public static void logRequest(
            String uri, int userId, String serviceLibelle, String ipAddress, String responseValueLog, String requestValueLog,
             Integer versionNumber,String deviceId, UserActivityBusiness userActivityBusiness) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run()
            {

                // Mes declarations
                UserActivityDto             dto      = new UserActivityDto();
                JSONObject          res          = new JSONObject(responseValueLog);
                Map<String, String> resp         = null;
                Map<String, String> requestLog   = new HashMap<>();
                ObjectMapper        objectMapper = null;
                try
                {
                    dto.setServiceLibelle(serviceLibelle);
                    dto.setRemoteIp(ipAddress);
                    dto.setUserId(userId);
                    dto.setRequest(requestValueLog);
                    dto.setResponse(responseValueLog);
                    dto.setHasError(res.has("hasError") ? String.valueOf(res.getBoolean("hasError")) : "false");
                    dto.setDeviceId(deviceId);
                    dto.setUri(uri);
                    dto.setVersionNumber(versionNumber.toString());
                    dto.setCreatedAt(Utilities.getCurrentLongDate("yyyy-MM-dd HH:mm:ss"));
                    Request<UserActivityDto> request = new Request<>();
                    request.setDatas(Arrays.asList(dto));
                    request.setUser(userId);
                    Response<UserActivityDto> response = userActivityBusiness.create(request, Locale.FRENCH);

//                    requestLog.put("remoteAddr", ipAddress);
//
//                    if (Utilities.isNotBlank(serviceLibelle))
//                    {
//
//                        requestLog.put("serviceLibelle", serviceLibelle);
//                    }
//
//                    if (versionNumber != 0)
//                    {
//                        requestLog.put("versionNumber", versionNumber.toString());
//                    }
//
//                    requestLog.put("request", requestValueLog);
//
//                    requestLog.put("response", responseValueLog);
//
//                    requestLog.put("hasError", res.has("hasError") ? String.valueOf(res.getBoolean("hasError")) : "false");
//
//                    requestLog.put("userId", String.valueOf(userId));
//                    requestLog.put("deviceId", deviceId);
//
//                    requestLog.put("uri", uri != null ? uri : "N/A");
//
//                    requestLog.put("createdAt", Utilities.getCurrentLongDate("yyyy-MM-dd HH:mm:ss"));
//
//
//                    // je cré instance de l'ObjectMapper
//                    objectMapper = new ObjectMapper();
//
//                    // permet de convertir
//                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//                    // je convertis la valeur de la requête en Request
//                    if (responseValueLog.length() == 0 || responseValueLog == "")
//                    {
//                        resp = objectMapper.readValue("{\"null\":\"null \"}", Map.class);
//                    } else
//                    {
//                        resp = objectMapper.readValue(responseValueLog, Map.class);
//                    }
//
//                    // je set la valeur du hasError
//
//                    // je set le jour
//                    requestLog.put("day", Utilities.getCurrentLongDate("yyyy-MM-dd"));
//                    requestLog.put("month", Utilities.getCurrentLongDate("yyyy-MM"));
//                    requestLog.put("year", Utilities.getCurrentLongDate("yyyy"));
//                    requestLog.put("week", String.valueOf(substitutDateByPeriode(requestLog.get("day"), "week")));
//
//
//                    // loginfoBusiness.create(requestLog, new Locale("fr"));
//                    final String forIndex = Utilities.getCurrentLongDate("yyyyMMdd");
//
//                    EsUtils.insert(JOB_TYPE + forIndex, "_doc",
//                            Utilities.getEsTemplateByJobType(JOB_TYPE), highClientFactory, requestLog
//                    );
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }

    public static Object substitutDateByPeriode(Object arg, String period) throws ParseException
    {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date           = dateTimeFormat.parse(arg.toString());
        Calendar         calendar       = Calendar.getInstance();
        calendar.setTime(date);
        Object object           = null;
        Object objectMonthOfDay = null;
        if (Utilities.areEquals(period, "day"))
        {
            //object = StringUtils.leftPad(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2, "0");
            //return object;

            //TODO formater le jour en jj/mm
            object           = calendar.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + calendar.get(Calendar.DAY_OF_MONTH) : calendar.get(Calendar.DAY_OF_MONTH);
            objectMonthOfDay = (calendar.get(Calendar.MONTH) + 1) < 10 ? "0" + (calendar.get(Calendar.MONTH) + 1) : calendar.get(Calendar.MONTH) + 1;
            return object + "/" + objectMonthOfDay;
        }
        if (Utilities.areEquals(period, "week"))
        {
            object = calendar.get(Calendar.WEEK_OF_YEAR);
            object = "S_" + object;
            return object;
        }
        if (Utilities.areEquals(period, "month"))
        {
            object = calendar.get(Calendar.MONTH) + 1;
            object = Utilities.getMonthLibelleByNumber(Integer.valueOf(object.toString()));
            return object;
        }
        if (Utilities.areEquals(period, "year"))
        {
            object = String.valueOf(calendar.get(Calendar.YEAR));
            return object;
        }
        object = calendar.get(Calendar.MONTH) + 1;
        object = Utilities.getMonthLibelleByNumber(Integer.valueOf(object.toString()));
        return object;
    }


    public static String ReturnAccesDenied(HttpServletRequest req, HttpServletResponse res, String message, FunctionalError functionalError) {
        String responseValue = "";
        try {
            Response respObj = new Response();
            respObj.setHasError(Boolean.TRUE);
            String lang   = req.getHeader("lang");
            Locale locale = null;
            if (lang != null) {
                locale = new Locale(lang, "");
            } else {
                locale = new Locale("en", "");
            }
            respObj.setStatus(functionalError.AUTH_FAIL(message, locale));
            responseValue = new Gson().toJson(respObj, Response.class);
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            res.setHeader("plainData", Boolean.TRUE + "");
            res.setHeader("Access-Control-Expose-Headers", "plainData");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseValue;
    }

    public static String returnFailedToGetDataVersionPharmapp(HttpServletRequest req, HttpServletResponse res, String message, FunctionalError functionalError) {
        String responseValue = "";
        try {
            Response respObj = new Response();
            respObj.setHasError(Boolean.TRUE);
            String lang   = req.getHeader("lang");
            Locale locale = null;
            if (lang != null) {
                locale = new Locale(lang, "");
            } else {
                locale = new Locale("en", "");
            }
            respObj.setStatus(functionalError. DATA_NOT_EXIST(message, locale));
            responseValue = new Gson().toJson(respObj, Response.class);
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            res.setHeader("plainData", Boolean.TRUE + "");
            res.setHeader("Access-Control-Expose-Headers", "plainData");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseValue;
    }

    public static String returnOldVersionSet(HttpServletRequest req, HttpServletResponse res, String message, FunctionalError functionalError) {
        String responseValue = "";
        try {
            Response respObj = new Response();
            respObj.setHasError(Boolean.TRUE);
            String lang   = req.getHeader("lang");
            Locale locale = null;
            if (lang != null) {
                locale = new Locale(lang, "");
            } else {
                locale = new Locale("en", "");
            }
            respObj.setStatus(functionalError.DISALLOWED_OPERATION(message, locale));
            responseValue = new Gson().toJson(respObj, Response.class);
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            res.setHeader("plainData", Boolean.TRUE + "");
            res.setHeader("Access-Control-Expose-Headers", "plainData");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseValue;
    }

    public static void returnExpiredSession(HttpServletRequest req, HttpServletResponse res, String message, FunctionalError functionalError) {
        String responseValue = "";
        try {
            Response respObj = new Response();
            respObj.setHasError(Boolean.TRUE);
            String lang   = req.getHeader("lang");
            Locale locale = null;
            if (lang != null) {
                locale = new Locale(lang, "");
            } else {
                locale = new Locale("en", "");
            }
            respObj.setStatus(functionalError.AUTH_FAIL(message, locale));
            responseValue = new Gson().toJson(respObj, Response.class);
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            res.setHeader("plainData", Boolean.TRUE + "");
            res.setHeader("Access-Control-Expose-Headers", "plainData");
            publishResponse(responseValue, res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String ExtractData(String requestBody) {
//		System.out.println("--- encryptRequest requestBody  ----" + requestBody);
        String data = "";
        try {
            if (Utilities.notBlank(requestBody)) {
                JSONObject jsonObject = new JSONObject(requestBody);
                data = jsonObject.get("data").toString();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

}