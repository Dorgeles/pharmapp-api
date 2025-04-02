package com.wdyapplications.pharmapp.utils.okhttp;

import com.wdyapplications.pharmapp.utils.ParamsUtils;
import com.wdyapplications.pharmapp.utils.dto.ImageDto;
import com.wdyapplications.pharmapp.utils.okhttp.base.OkHttpClientUtilsBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class MinioExternalService extends OkHttpClientUtilsBase {
    @Autowired
    private ParamsUtils paramUtils;


    public String saveImage(ImageDto recordImageDto) throws Exception {
        try {
            Map<String, Object> data = new HashMap<>();
            Map<String, Object> req = new HashMap<>();
            data.put("file", recordImageDto.getFileBase64());
            data.put("filename", recordImageDto.getFilename());
            data.put("bucket_name", paramUtils.getMinioBucketName());
            data.put("subdirectory_name", recordImageDto.getPath());
            req.put("data", data);
            ObjectMapper objectMapper = new ObjectMapper();
            String request = objectMapper.writeValueAsString(req);
            System.out.println("l'url de requete est : " + paramUtils.getMinioUrl() + "/minio-api/uploadFileFromBase64");
            okhttp3.Response apiResponse = post(paramUtils.getMinioUrl()+ "/minio-api/uploadFileFromBase64", request, "json");
            Map<String, Object> respMap = toResponseAsMap(apiResponse);
            JSONObject json = new JSONObject(respMap);
            if (json.has("items")) {
                System.out.println("la reponse est : " + json);
                JSONArray items = json.getJSONArray("items");
                if (items != null && !items.isEmpty()) {
                    return items.getJSONObject(0).getString("name");
                }
            }
        } catch (Exception e) {
            System.out.println("la requete a echoue : " + e.getMessage());
            throw new Exception(e.getMessage());
        }
        return  null;
    }
}
