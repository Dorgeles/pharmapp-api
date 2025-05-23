
/*
 * Created on 2024-11-08 ( Time 00:22:29 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.utils;


import com.wdyapplications.pharmapp.utils.contract.SearchParam;
import com.wdyapplications.pharmapp.utils.enums.OperatorEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities
 * 
 * @author Geo
 *
 */
public class Utilities {
	public static List<String> fileLinesToList(String filePath) throws IOException {
		List<String>   listToReturn = new ArrayList<>();
		BufferedReader br           = getBufferedReader(filePath);
		String         line;

		while ((line = br.readLine()) != null) {
			listToReturn.add(line);
		}
		br.close();
		return listToReturn;
	}

	private static BufferedReader getBufferedReader(String path) throws FileNotFoundException {
		FileInputStream input       = new FileInputStream(new File(path).getAbsolutePath());
		DataInputStream inputStream = new DataInputStream(input);
		return new BufferedReader(new InputStreamReader(inputStream));
	}

	public static final List<String> URI_KPI_CACHEABLE = Arrays.asList(
			"/setting/getByCriteria");

	public static boolean isKpisCacheable(String uri) {
//		return URI_KPI_CACHEABLE.stream().anyMatch(uri::startsWith);
		return URI_KPI_CACHEABLE.stream().anyMatch(uri::startsWith);
	}
	public static boolean isKpisCacheable(StringBuffer uri) {
		return URI_KPI_CACHEABLE.stream().anyMatch(uri.toString()::startsWith);
	}




	public static String normalizeName(String fileName) {
		if (fileName == null) {
			throw new NullArgumentException("fileName");
		}
		String fileNormalize = null;
		fileNormalize = fileName.trim().replaceAll("\\s+", "_");
		fileNormalize = fileNormalize.replace("'", "");
		fileNormalize = fileNormalize.replace("`", "");
		fileNormalize = fileNormalize.replace("-", "_");
		fileNormalize = Normalizer.normalize(fileNormalize, Normalizer.Form.NFD);
		fileNormalize = fileNormalize.replaceAll("[^\\p{ASCII}]", "");
		fileNormalize = fileNormalize.replaceAll("[^-a-zA-Z0-9_\\-\\.]", "");

		return fileNormalize.toLowerCase();
	}


	public static String readJsonDefn(String url) throws Exception {
		// implement it the way you like
		StringBuffer   bufferJSON = new StringBuffer();
		BufferedReader br         = getBufferedReader(url);
		String         line;

		while ((line = br.readLine()) != null) {
			bufferJSON.append(line);
		}
		br.close();
		return bufferJSON.toString();
	}

	public static String getEsTemplateByJobType(String jobType) {
		return String.format("/templates/es/template_%s.json", jobType);
	}

	public static String regularValue(String jobType) {
		return String.format("/templates/es/template_%s.json", jobType);
	}
	public static String getMonthLibelleByNumber(Integer moisNumb) {
//        System.out.println(" moisNumb ==>  "+moisNumb);
		String mois= "";
		switch (moisNumb) {
			case 1:
				mois = "Jan";
				break;
			case 2:
				mois = "Fev";
				break;
			case 3:
				mois = "Mars";
				break;
			case 4:
				mois = "Avr";
				break;
			case 5:
				mois = "Mai";
				break;
			case 6:
				mois = "Juin";
				break;
			case 7:
				mois = "Juil";
				break;
			case 8:
				mois = "Août";
				break;
			case 9:
				mois = "Sept";
				break;
			case 10:
				mois = "Oct";
				break;
			case 11:
				mois = "Nov";
				break;
			case 12:
				mois = "Dec";
				break;
		}
		return mois;
	}

	public static BigDecimal calculTaux(Double value1, Double value2, int newScale, int roundingMode) {
		double     variation = 0;
		BigDecimal result    = new BigDecimal(0);
		if (value1 != 0d && value2 != 0d) {
			variation = (value1 * 100) / value2;
			BigDecimal bigDecimal       = new BigDecimal(variation);
			BigDecimal roundedWithScale = bigDecimal.setScale(newScale, roundingMode);
			result = roundedWithScale;
		}
		if (value2 == 0L) {
			result = new BigDecimal(0);
		}

		return result;
	}

	public static BigDecimal calculTaux(Double value1, Double value2, int newScale) {
		return calculTaux(value1, value2, newScale, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal calculTaux(Double value1, Double value2) {
		return calculTaux(value1, value2, 2);
	}

	public static boolean hasValidFormat(String date) {
		String format = findDateFormatByParsing(date);
		return isNotBlank(format);
	}

	public static String findDateFormatByParsingForMinHour(String date) {
		if (blank(date)) {
			return null;
		}

		List<String> datasPatterns = new ArrayList<String>();

		datasPatterns.addAll(Arrays.asList("HH", "HH:mm", "HH:mm:ss", "HH:mm:ss.SSS"));

		for (String pattern : datasPatterns) {
			try {
				//					SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				//					sdf.setLenient(false);
				//					sdf.parse(date);
				org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
				formatter.parseDateTime(date);
				return pattern;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return null;
	}

	public static String findDateFormatByParsing(String date) {
		if (blank(date)) {
			return null;
		}

		List<String> datasPatterns = new ArrayList<String>();
		datasPatterns.add("EEE MMM dd HH:mm:ss z yyyy");
		datasPatterns.addAll(Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy", "dd.MM.yyyy", "ddMMyyyy"));
		datasPatterns.addAll(Arrays.asList("dd/MM/yyyy HH", "dd-MM-yyyy HH", "dd.MM.yyyy HH", "ddMMyyyy HH"));
		datasPatterns.addAll(Arrays.asList("dd/MM/yyyy HH:mm", "dd-MM-yyyy HH:mm", "dd.MM.yyyy HH:mm", "ddMMyyyy HH:mm"));
		datasPatterns.addAll(Arrays.asList("dd/MM/yyyy HH:mm:ss", "dd-MM-yyyy HH:mm:ss", "dd.MM.yyyy HH:mm:ss", "ddMMyyyy HH:mm:ss"));
		datasPatterns.addAll(Arrays.asList("dd/MM/yyyy HH:mm:ss.S", "dd-MM-yyyy HH:mm:ss.S", "dd.MM.yyyy HH:mm:ss.S", "ddMMyyyy HH:mm:ss.S"));
		datasPatterns.addAll(Arrays.asList("dd/MM/yyyy HH:mm:ss.SS", "dd-MM-yyyy HH:mm:ss.SS", "dd.MM.yyyy HH:mm:ss.SS", "ddMMyyyy HH:mm:ss.SS"));
		datasPatterns.addAll(Arrays.asList("dd/MM/yyyy HH:mm:ss.SSS", "dd-MM-yyyy HH:mm:ss.SSS", "dd.MM.yyyy HH:mm:ss.SSS", "ddMMyyyy HH:mm:ss.SSS"));

		datasPatterns.addAll(Arrays.asList("yyyy/MM/dd", "yyyy-MM-dd", "yyyy.MM.dd", "yyyyMMdd"));
		datasPatterns.addAll(Arrays.asList("yyyy/MM/dd HH", "yyyy-MM-dd HH", "yyyy.MM.dd HH", "yyyyMMdd HH"));
		datasPatterns.addAll(Arrays.asList("yyyy/MM/dd HH:mm", "yyyy-MM-dd HH:mm", "yyyy.MM.dd HH:mm", "yyyyMMdd HH:mm"));
		datasPatterns.addAll(Arrays.asList("yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss", "yyyy.MM.dd HH:mm:ss", "yyyyMMdd HH:mm:ss"));
		datasPatterns.addAll(Arrays.asList("yyyy/MM/dd HH:mm:ss.S", "yyyy-MM-dd HH:mm:ss.S", "yyyy.MM.dd HH:mm:ss.S", "yyyyMMdd HH:mm:ss.S"));
		datasPatterns.addAll(Arrays.asList("yyyy/MM/dd HH:mm:ss.SS", "yyyy-MM-dd HH:mm:ss.SS", "yyyy.MM.dd HH:mm:ss.SS", "yyyyMMdd HH:mm:ss.SS"));
		datasPatterns.addAll(Arrays.asList("yyyy/MM/dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy.MM.dd HH:mm:ss.SSS", "yyyyMMdd HH:mm:ss.SSS"));

		datasPatterns.addAll(Arrays.asList("dd/MM", "dd-MM", "dd.MM", "ddMM"));
		datasPatterns.addAll(Arrays.asList("MM/yyyy", "MM-yyyy", "MM.yyyy", "MMyyyy"));

		datasPatterns.addAll(Arrays.asList("MM/dd", "MM-dd", "MM.dd", "MMdd"));
		datasPatterns.addAll(Arrays.asList("yyyy/MM", "yyyy-MM", "yyyy.MM", "yyyyMM"));

		datasPatterns.addAll(Arrays.asList("yyyy"));

		datasPatterns.addAll(Arrays.asList("HH", "HH:mm", "HH:mm:ss", "HH:mm:ss.S", "HH:mm:ss.SS", "HH:mm:ss.SSS"));

		for (String pattern : datasPatterns) {
			try {
				//					SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				//					sdf.setLenient(false);
				//					sdf.parse(date);
				org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
				formatter.parseDateTime(date);
				return pattern;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return null;
	}

	public static boolean isDate(String date) {
		String format = findDateFormatByParsing(date);
		return format != null;
	}


	public static Date getCurrentDate() {
		return new Date();
	}

	public static Date addMinutes(Date date, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}

	public static boolean areEquals(Object obj1, Object obj2) {
		return (Objects.equals(obj1, obj2));
	}

	public static <T extends Comparable<T>, Object> boolean areEquals(T obj1, T obj2) {
		return (obj1 == null ? obj2 == null : obj1.equals(obj2));
	}

	public static boolean areNotEquals(Object obj1, Object obj2) {
		return !areEquals(obj1, obj2);
	}

	public static <T extends Comparable<T>, Object> boolean areNotEquals(T obj1, T obj2) {
		return !(areEquals(obj1, obj2));
	}

	public static        List<String>     PROFILES_TO_IGNORE   = Arrays.asList(
			"local",
			//"dev",
			//"development",
			"staging"
	);

	private static final String[] IP_HEADER_CANDIDATES = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP",
			"HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {
		final String defaultLocahostIp = "0:0:0:0:0:0:0:1";
		final String localhostStr      = "localhost";
		for (String header : IP_HEADER_CANDIDATES) {
			String ip = request.getHeader(header);
			if (ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip)) {
				return areNotEquals(ip, defaultLocahostIp) ? ip : localhostStr;
			}
		}
		return areNotEquals(request.getRemoteAddr(), defaultLocahostIp) ? request.getRemoteAddr() : localhostStr;
	}

	private static List<String> listeBase = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1",
			"2", "3", "4", "5", "6", "7", "8", "9");

	public static String combinaisonString() {
		String lettres = "";
		try {
			Random random;
			for (int i = 0; i < 10; i++) {
				random = new Random();
				int rn = random.nextInt(35 - 0 + 1) + 0;
				lettres += listeBase.get(rn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lettres;
	}
	public static boolean blank(String str) {
		return !notBlank(str);
	}

	public static String formatDate(String date, String initDateFormat, String endDateFormat) throws ParseException {
		if (!notBlank(date)) {
			return "";
		}
		Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
		SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
		String parsedDate = formatter.format(initDate);

		return parsedDate;
	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static int duration(Date startDate, Date endDate) {
		long duration = ChronoUnit.DAYS.between(asLocalDate(startDate), asLocalDate(endDate));
		return Integer.parseInt(String.valueOf(duration + 1));
	}

	public static int duration(LocalDate startLocalDate, LocalDate endLocalDate) {
		long duration = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
		return Integer.parseInt(String.valueOf(duration + 1));
	}
	public static String getCurrentLongDate(String format)
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
	}


	/**
	 * Check if a String given is an Integer.
	 *
	 * @param s
	 * @return isValidInteger
	 *
	 */
	public static boolean isInteger(String s) {
		boolean isValidInteger = false;
		try {
			Integer.parseInt(s);

			// s is a valid integer
			isValidInteger = true;
		} catch (NumberFormatException ex) {
			// s is not an integer
		}

		return isValidInteger;
	}

	public static String generateCodeOld() {
		String formatted = null;
		formatted = RandomStringUtils.randomAlphanumeric(8).toUpperCase();
		return formatted;
	}

	public static String generateCode() {
		String formatted = null;
		SecureRandom secureRandom = new SecureRandom();
		int num = secureRandom.nextInt(100000000);
		formatted = String.format("%05d", num);
		return formatted;
	}
	public static Date getExpireTimeToMinute(int expireTime) {
		int addMinuteTime = expireTime; // 2 minute
		Date targetTime = Calendar.getInstance().getTime();
		targetTime = DateUtils.addMinutes(targetTime, addMinuteTime); // add minute
		return targetTime;
	}
	public static int GenerateRandom (int min, int max) {
// 		 int min = 101;
// 	      int max = 100000;
		int random_int = (int)(Math.random() * (max - min + 1) + min);
		return random_int;
	}

	public static boolean isTrue(Boolean b) {
		return b != null && b;
	}

	public static boolean isFalse(Boolean b) {
		return !isTrue(b);
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Long.parseLong(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Check if a Integer given is an String.
	 *
	 * @param i
	 * @return isValidString
	 *
	 */
	public static boolean isString(Integer i) {
		boolean isValidString = true;
		try {
			Integer.parseInt(i + "");

			// i is a valid integer

			isValidString = false;
		} catch (NumberFormatException ex) {
			// i is not an integer
		}

		return isValidString;
	}

	public static boolean isValidEmail(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}

	public static String encrypt(String str) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		byte[] hashedBytes = digest.digest(str.getBytes("UTF-8"));

		return convertByteArrayToHexString(hashedBytes);
	}

	public static boolean isDateValid(String date) {
		try {
			String simpleDateFormat = "dd/MM/yyyy";

			if (date.contains("-"))
				simpleDateFormat = "dd-MM-yyyy";
			else if (date.contains("/"))
				simpleDateFormat = "dd/MM/yyyy";
			else
				return false;

			DateFormat df = new SimpleDateFormat(simpleDateFormat);
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static String GenerateValueKey(String code) {
		String result = null;
		// String prefix = prefixe;
		String suffix = null;
		String middle = null;
		String separator = "-";
		final String defaut = "000001";
		try {

			SimpleDateFormat dt = new SimpleDateFormat("yy-MM-dd-ss");
			String _date = dt.format(new Date());
			String[] spltter = _date.split(separator);
			middle = spltter[0] + spltter[1] + spltter[2] + spltter[3];
			if (code != null) {
				// Splitter le code pour recuperer les parties
				// String[] parts = code(separator);
				String part = code.substring(1);
				// System.out.println("part" + part);

				if (part != null) {
					int cpt = Integer.parseInt(part);
					cpt++;

					String _nn = String.valueOf(cpt);

					switch (_nn.length()) {
						case 1:
							suffix = "00000" + _nn;
							break;
						case 2:
							suffix = "0000" + _nn;
							break;
						case 3:
							suffix = "000" + _nn;
							break;
						case 4:
							suffix = "00" + _nn;
							break;
						case 5:
							suffix = "0" + _nn;
							break;
						default:
							suffix = _nn;
							break;
					}
					// result = prefix + separator + middle + separator +
					// suffix;
					result = middle + separator + suffix;
				}
			} else {
				// result = prefix + separator + middle + separator + defaut;
				result = middle + separator + defaut;
			}
		} catch (Exception e) {

		}
		return result;
	}

	public static Integer getAge(Date dateNaissance) throws ParseException, Exception {
		Integer annee = 0;

		if (dateNaissance == null) {
			annee = 0;
		}
		Calendar birth = new GregorianCalendar();
		birth.setTime(dateNaissance);
		Calendar now = new GregorianCalendar();
		now.setTime(new Date());
		int adjust = 0;
		if (now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
			adjust = -1;
		}
		annee = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
		return annee;
	}

	public static Boolean AvailableCode(String code) {
		if (code == null || code.isEmpty()) {
			return false;
		}
		Locale local = new Locale(code, "");
		return LocaleUtils.isAvailableLocale(local);

	}

	public static String normalizeFileName(String fileName) {
		String fileNormalize = null;
		fileNormalize = fileName.trim().replaceAll("\\s+", "_");
		fileNormalize = fileNormalize.replace("'", "");
		fileNormalize = Normalizer.normalize(fileNormalize, Normalizer.Form.NFD);
		fileNormalize = fileNormalize.replaceAll("[^\\p{ASCII}]", "");

		return fileNormalize;
	}

	private static String convertByteArrayToHexString(byte[] arrayBytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < arrayBytes.length; i++) {
			stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return stringBuffer.toString();
	}

	public static SimpleDateFormat findDateFormat(String date) {
		SimpleDateFormat simpleDateFormat = null;
		String regex_dd_MM_yyyy = "\\A0?(?:3[01]|[12][0-9]|[1-9])[/.-]0?(?:1[0-2]|[1-9])[/.-][0-9]{4}\\z";

		if (date.matches(regex_dd_MM_yyyy))
			if (date.contains("-"))
				simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");


		return simpleDateFormat;
	}

	/**
	 * @return Permet de retourner la date courante du système
	 *
	 */
	public static String getCurrentLocalDateTimeStamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	/**
	 * @param l
	 *            liste de vérification de doublons
	 * @return retourne le nombre de doublon trouvé
	 *
	 */
	public static int getDupCount(List<String> l) {
		int cnt = 0;
		HashSet<String> h = new HashSet<>(l);

		for (String token : h) {
			if (Collections.frequency(l, token) > 1)
				cnt++;
		}

		return cnt;
	}

	public static boolean saveImage(String base64String, String nomCompletImage, String extension) throws Exception {

		BufferedImage image = decodeToImage(base64String);

		if (image == null) {

			return false;

		}

		File f = new File(nomCompletImage);

		// write the image

		ImageIO.write(image, extension, f);

		return true;

	}

	public static boolean saveVideo(String base64String, String nomCompletVideo) throws Exception {

		try {

			byte[] decodedBytes = Base64.getDecoder().decode(base64String);
			File file2 = new File(nomCompletVideo);
			FileOutputStream os = new FileOutputStream(file2, false);
			os.write(decodedBytes);
			os.close();

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return true;

	}

	public static BufferedImage decodeToImage(String imageString) throws Exception {

		BufferedImage image = null;

		byte[] imageByte;

		imageByte = Base64.getDecoder().decode(imageString);

		try (ByteArrayInputStream bis = new ByteArrayInputStream(imageByte)) {

			image = ImageIO.read(bis);

		}

		return image;

	}

	public static String encodeToString(BufferedImage image, String type) {

		String imageString = null;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {

			ImageIO.write(image, type, bos);

			byte[] imageBytes = bos.toByteArray();

			imageString = new String(Base64.getEncoder().encode(imageBytes));

			bos.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return imageString;

	}

	public static String convertFileToBase64(String pathFichier) {
		File originalFile = new File(pathFichier);
		String encodedBase64 = null;
		try {
			FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
			byte[] bytes = new byte[(int) originalFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.getEncoder().encodeToString((bytes)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return encodedBase64;
	}

	public static String getImageExtension(String str) {
		String extension = "";
		int i = str.lastIndexOf('.');
		if (i >= 0) {
			extension = str.substring(i + 1);
			return extension;
		}
		return null;
	}

	public static boolean fileIsImage(String image) {

		String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|jpeg))$)";
		Pattern pattern = Pattern.compile(IMAGE_PATTERN);
		Matcher matcher = pattern.matcher(image);

		return matcher.matches();

	}

	public static boolean fileIsVideo(String video) {

		String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(mp4|avi|camv|dvx|mpeg|mpg|wmv|3gp|mkv))$)";
		Pattern pattern = Pattern.compile(IMAGE_PATTERN);
		Matcher matcher = pattern.matcher(video);

		return matcher.matches();

	}

	public static void createDirectory(String chemin) {
		File file = new File(chemin);
		if (!file.exists()) {
			try {
				FileUtils.forceMkdir(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void deleteFolder(String chemin) {
		File file = new File(chemin);
		try {
			if (file.exists() && file.isDirectory()) {
				FileUtils.forceDelete(new File(chemin));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteFile(String chemin) {
		File file = new File(chemin);
		try {
			if (file.exists() && file.getName() != null && !file.getName().isEmpty()) {

				FileUtils.forceDelete(new File(chemin));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean notBlank(String str) {
		return str != null && !str.isEmpty() && !str.equals(" ");
	}
	
	public static boolean notEmpty(List<String> lst) {
		return lst != null && !lst.isEmpty() && lst.stream().noneMatch(s -> s.equals(" ")) && lst.stream().noneMatch(s -> s.equals(null));
	}
	
	public static <T> boolean isNotEmpty(List<T> list){
		return (list != null && !list.isEmpty());
	}
	public static <T> boolean isEmpty(List<T> list) {
		return (list == null || list.isEmpty());
	}


	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return (map == null || map.isEmpty());
	}


	public static <T> boolean isNotEmpty(T[] array) {
        return (array != null && array.length > 0);
    }

	public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotBlank(Date date) {
        return date != null;
    }

	public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0 || str.isEmpty()) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

	static public String GetCode(String Value, Map<String, String> Table) {

		for (Entry<String, String> entry : Table.entrySet()) {
			if (entry.getValue().equals(Value)) {
				return entry.getKey();
			}
		}
		return Value;
	}

	public static boolean anObjectFieldsMapAllFieldsToVerify(List<Object> objets, Map<String, Object> fieldsToVerify) {
		for (Object objet : objets) {
			boolean oneObjectMapAllFields = true;
			JSONObject jsonObject = new JSONObject(objet);
			for (Entry<String, Object> entry : fieldsToVerify.entrySet()) {
				// slf4jLogger.info("jsonObject " +jsonObject);
				String key = entry.getKey();
				Object value = entry.getValue();
				try {
					if (!jsonObject.get(key).equals(value)) {
						oneObjectMapAllFields = false;
						break;
					}
				} catch (Exception e) {
					oneObjectMapAllFields = false;
					break;
				}
			}
			if (oneObjectMapAllFields)
				return true;
		}

		return false;
	}

	public static String generateAlphanumericCode(Integer nbreCaractere) {
		String formatted = null;
		formatted = RandomStringUtils.randomAlphanumeric(nbreCaractere).toUpperCase();
		return formatted;
	}

	public static Boolean verifierEmail(String email) {
		Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher emailMatcher = emailPattern.matcher(email);
		return emailMatcher.matches();
	}


	public static <T> boolean searchParamIsNotEmpty(SearchParam<T> fieldParam) {
        return fieldParam != null && isNotBlank(fieldParam.getOperator()) && OperatorEnum.IS_VALID_OPERATOR(fieldParam.getOperator()) &&
                (
                        (OperatorEnum.IS_BETWEEN_OPERATOR(fieldParam.getOperator()) && fieldParam.getStart() != null && isNotBlank(fieldParam.getStart().toString()) && fieldParam.getEnd() != null && isNotBlank(fieldParam.getEnd().toString()))
                                ||
                                (OperatorEnum.IS_IN_OPERATOR(fieldParam.getOperator()) && isNotEmpty(fieldParam.getDatas()))
                                ||
                                (OperatorEnum.OPERATOR_NOT_NEEDS_ANY_VALUE(fieldParam.getOperator()))
                                ||
                                (OperatorEnum.OPERATOR_NEEDS_FIELD_VALUE(fieldParam.getOperator()))
                );
    }

    public static <T> boolean searchParamIsNotEmpty(SearchParam<T> fieldParam, T fieldValue) {
        return fieldParam != null && isNotBlank(fieldParam.getOperator()) && OperatorEnum.IS_VALID_OPERATOR(fieldParam.getOperator()) &&
                (
                        (OperatorEnum.IS_BETWEEN_OPERATOR(fieldParam.getOperator()) && fieldParam.getStart() != null && isNotBlank(fieldParam.getStart().toString()) && fieldParam.getEnd() != null && isNotBlank(fieldParam.getEnd().toString()))
                                ||
                                (OperatorEnum.IS_IN_OPERATOR(fieldParam.getOperator()) && isNotEmpty(fieldParam.getDatas()))
                                ||
                                (OperatorEnum.OPERATOR_NOT_NEEDS_ANY_VALUE(fieldParam.getOperator()))
                                ||
                                (OperatorEnum.OPERATOR_NEEDS_FIELD_VALUE(fieldParam.getOperator()) && fieldValue != null && isNotBlank(fieldValue.toString()))
                );
    }
}
