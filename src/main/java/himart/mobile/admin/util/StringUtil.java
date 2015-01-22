package himart.mobile.admin.util;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 문자열 관련 유틸리티
 * @author SeoJohoon
 */

public class StringUtil {
	/**
	 * 스크립트에 영향을 미치는 문자(", ' 등)를 2바이트 문자로 변경
	 * 
	 * @param value 원본 문자열
	 * @return 변환된 문자열
	 */
	public static String replaceQuot(String value) {
		String value_l = value;

		value_l = value_l.replaceAll("\"", "＂");
		value_l = value_l.replaceAll("\'", "＇");

		return value_l;
	}

	/**
	 * 문자열이 NULL 또는 공백인지 확인
	 * 
	 * @param value 확인할 문자열
	 * @return NULL 또는 공백 여부
	 */
	public static boolean isNull(String value) {
		return (value == null || "".equals(value));
	}

	/**
	 * NULL 문자열을 다른 문자로 대체
	 * 
	 * @param value 원본 문자열
	 * @param replaceValue 대체 문자열
	 * @return 변환 문자열
	 */
	public static String replaceNull(String value, String replaceValue) {
		return value == null ? replaceValue : value;
	}

	/**
	 * NULL문자열을 공백문자로 대체
	 * 
	 * @param value 원본 문자열
	 * @return 변환 문자열
	 */
	public static String replaceNullToEmptyString(String value) {
		return replaceNull(value, "");
	}

	/**
	 * <pre>
	 * 원본 문자열의 길이가 변환 문자열의 길이보다 작을 경우 원본 문자열 앞에 대체문자로 채움
	 * 단, 한글과 같은 2바이트 문자를 1글자로 인식
	 * </pre>
	 * 
	 * @param value 원본 문자열
	 * @param length 변환 후 문자열 길이
	 * @param paddingChar 대체 문자
	 * @return 변환 문자열
	 */
	public static String lPadding(String value, int length, char paddingChar) {
		String value_l = replaceNullToEmptyString(value);

		int gapLength = length - value_l.length();

		if (gapLength <= 0) {
			return value_l;
		}

		StringBuffer newString_l = new StringBuffer();

		for (int i = 0; i < gapLength; i++) {
			newString_l.append(paddingChar);
		}

		newString_l.append(value);

		return newString_l.toString();
	}

	/**
	 * <pre>
	 * 원본 문자열의 길이가 변환 문자열의 길이보다 작을 경우 원본 문자열 앞에 대체문자로 채움
	 * 단, 한글과 같은 2바이트 문자를 2글자로 인식
	 * </pre>
	 * 
	 * @param value 원본 문자열
	 * @param length 변환 후 문자열 길이
	 * @param paddingChar 대체 문자
	 * @return 변환 문자열
	 */
	public static String lPaddingB(String value, int length, char paddingChar) {
		String value_l = replaceNullToEmptyString(value);

		int gapLength;

		gapLength = length - getLength(value_l);

		if (gapLength <= 0) {
			return value_l;
		}

		StringBuffer newString_l = new StringBuffer();

		for (int i = 0; i < gapLength; i++) {
			newString_l.append(paddingChar);
		}

		newString_l.append(value);

		return newString_l.toString();
	}

	/**
	 * <pre>
	 * 원본 문자열의 길이가 변환 문자열의 길이보다 작을 경우 원본 문자열 뒤에 대체문자로 채움
	 * 단, 한글과 같은 2바이트 문자를 1글자로 인식
	 * </pre>
	 * 
	 * @param value 원본 문자열
	 * @param length 변환 후 문자열 길이
	 * @param paddingChar 대체 문자
	 * @return 변환 문자열
	 */
	public static String rPadding(String value, int length, char paddingChar) {
		String value_l = replaceNullToEmptyString(value);

		int gapLength = length - value_l.length();

		if (gapLength <= 0) {
			return value_l;
		}

		StringBuffer newString_l = new StringBuffer(value);

		for (int i = 0; i < gapLength; i++) {
			newString_l.append(paddingChar);
		}

		return newString_l.toString();
	}

	/**
	 * <pre>
	 * 원본 문자열의 길이가 변환 문자열의 길이보다 작을 경우 원본 문자열 뒤에 대체문자로 채움
	 * 단, 한글과 같은 2바이트 문자를 2글자로 인식
	 * </pre>
	 * 
	 * @param value 원본 문자열
	 * @param length 변환 후 문자열 길이
	 * @param paddingChar 대체 문자
	 * @return 변환 문자열
	 */
	public static String rPaddingB(String value, int length, char paddingChar) {
		String value_l = replaceNullToEmptyString(value);

		int gapLength;

		gapLength = length - getLength(value_l);

		if (gapLength <= 0) {
			return value_l;
		}

		StringBuffer newString_l = new StringBuffer(value);

		for (int i = 0; i < gapLength; i++) {
			newString_l.append(paddingChar);
		}

		return newString_l.toString();
	}

	/**
	 * IP 주소 문자열의 각 숫자를 '0'문자를 포함시켜 3자리로 고정시킨다.
	 * 
	 * @param ipAddress 원본 IP주소 문자열
	 * @return 변환문자열
	 */
	public static String lPaddingIPAddress(String ipAddress) {
		if (isNull(ipAddress)) {
			return ipAddress;
		}

		StringBuffer ipAddress_l = new StringBuffer();

		try {
			String[] ipAddresses_l = ipAddress.split("[.]");

			for (int i = 0; i < ipAddresses_l.length; i++) {
				if (i > 0) {
					ipAddress_l.append(".");
				}

				ipAddress_l.append(lPadding(ipAddresses_l[i], 3, '0'));
			}
		} catch (Exception ex) {
			return ipAddress;
		}

		return ipAddress_l.toString();
	}

	/**
	 * 3자리로 고정된 IP 주소체계에서 숫자 앞 0을 제거
	 * 
	 * @param ipAddress 원본 IP주소 문자열
	 * @return 변환 문자열
	 */
	public static String lTrimIPAddress(String ipAddress) {
		if (isNull(ipAddress)) {
			return ipAddress;
		}

		StringBuffer ipAddress_l = new StringBuffer();

		try {
			String[] ipAddresses_l = ipAddress.split("[.]");

			for (int i = 0; i < ipAddresses_l.length; i++) {
				if (i > 0) {
					ipAddress_l.append(".");
				}

				ipAddress_l.append(Integer.valueOf(ipAddresses_l[i]));
			}
		} catch (Exception ex) {
			return ipAddress;
		}

		return ipAddress_l.toString();
	}

	/**
	 * 숫자형 문자열인지 확인
	 * 
	 * @param value 문자열
	 * @return 숫자형 문자열인지 여부
	 */
	public static boolean isNumber(String value) {
		if (isNull(value)) {
			return false;
		}

		return value.matches("^[0-9]+$");
	}

	/**
	 * 구분자를 포함 한 문자열을 배열로 반환
	 * 
	 * @param value 문자열
	 * @param separator 구분자
	 * @return 배열
	 */
	public static String[] explode(String value, String separator) {
		if (isNull(value) || isNull(separator)) {
			return new String[] { value };
		}
		else {
			ExtendStringTokenizer extendStringTokenizer_l = new ExtendStringTokenizer(value, separator);
			String[] array_l = new String[extendStringTokenizer_l.countTokens()];

			int i = 0;

			while (extendStringTokenizer_l.hasMoreTokens()) {
				array_l[i] = extendStringTokenizer_l.nextToken();
				i++;
			}

			return array_l;
		}
	}

	/**
	 * 배열을 구분자를 포함하는 문자열로 변환
	 * 
	 * @param value 문자열 배열
	 * @param separator 구분자
	 * @return 변환된 문자열
	 */
	public static String implode(String[] value, String separator) {
		if (value == null || value.length <= 0) {
			return (new String(""));
		}
		else {
			String value_l = new String();
			for (int i = 0; i < value.length; i++) {
				if (!isNull(value[i])) {
					value_l += value[i] + separator;
				}
			}
			if (value_l.endsWith(separator)) {
				value_l = value_l.substring(0, (value_l.length() - separator.length()));
			}
			return value_l;
		}
	}

	/**
	 * 문자열 자르기 (한글 2바이트 인식)
	 * 
	 * @param value 문자열
	 * @param beginIndex 시작위치
	 * @param endIndex 종료위치
	 * @return 문자열
	 */
	public static String substringB(String value, int beginIndex, int endIndex) {
		if (isNull(value)) {
			return "";
		}

		byte[] value_arr = null;

		try {
			value_arr = value.getBytes("UTF-8");
		} catch (UnsupportedEncodingException ex) {
		}

		if (value_arr == null || value_arr.length <= 0 || value_arr.length <= beginIndex || value_arr.length < endIndex) {
			return "";
		}

		return new String(value_arr, beginIndex, (endIndex - beginIndex));
	}

	/**
	 * 문자열 자르기 (한글 2바이트 인식)
	 * 
	 * @param value 문자열
	 * @param index 시작위치
	 * @return 문자열
	 */
	public static String substringB(String value, int index) {
		return substringB(value, index, getLength(value));
	}

	/**
	 * 지정한 길이 만큼의 임의의 문자열을 생성
	 *
	 * @param length 생성할 문자열의 길이
	 * @return 임의의 문자열
	 */
	public static String getRandomString(int length) {
		StringBuffer result_l = new StringBuffer();

		for (int i = 0; i < length; i++) {
			result_l.append(getRandomChar());
		}

		return result_l.toString();
	}

	private static char getRandomChar() {
		int random_l = (int) Math.round(Math.random() * 1000);

		if (String.valueOf((char) random_l).matches("^[0-9a-zA-Z]+$")) {
			return (char) random_l;
		}
		else {
			return getRandomChar();
		}
	}

	/**
	 * 주어진 문자열의 길이를 반환
	 *
	 * @param value
	 * @return
	 */
	public static int getLength(String value) {
		if (StringUtil.isNull(value)) {
			return 0;
		}

		try {
			return value.getBytes("UTF-8").length;
		} catch (UnsupportedEncodingException ex) {
			return 0;
		}
	}

	/**
	 * 전각문자를 반각문자로 변경
	 * @param value 변경할값
	 * @return String 변경된값
	 */
	public static String toHalfChar(String value) {
		StringBuffer strBuf = new StringBuffer();
		char c = 0;
		int nSrcLength = value.length();
		for (int i = 0; i < nSrcLength; i++) {
			c = value.charAt(i);

			if (c >= '！' && c <= '～') {
				c -= 0xfee0;
			}
			else if (c == '　') {
				c = 0x20;
			}

			strBuf.append(c);
		}
		return strBuf.toString();
	}

	/**
	 * 반각문자를 전각문자로 변경
	 * 
	 * @param src 변경할값
	 * @return String 변경된값
	 */
	public static String toFullChar(String value) {
		if (value == null) {
			return null;
		}

		StringBuffer strBuf = new StringBuffer();
		char c = 0;
		int nSrcLength = value.length();

		for (int i = 0; i < nSrcLength; i++) {
			c = value.charAt(i);

			if (c >= 0x21 && c <= 0x7e) {
				c += 0xfee0;
			}
			else if (c == 0x20) {
				c = 0x3000;
			}

			strBuf.append(c);
		}
		return strBuf.toString();
	}

	/**
	 * 특정 문자 사이의 문자열을 반환
	 * getMidStr("ABCDE", "B", "E"); ==> CD
	 *
	 * @param value 원본문자열
	 * @param start_Position 시작문자
	 * @param end_Position 종료문자
	 * @return
	 */
	public static String getMidStr(String value, String start_String, String end_String, int position) {
		String result = value.trim();

		if (value.length() > position) {
			if (result.indexOf(start_String, position) >= 0 && result.indexOf(end_String, result.indexOf(start_String, position)) >= result.indexOf(start_String, position)) {
				result = result.substring(result.indexOf(start_String) + start_String.length(), result.indexOf(end_String, result.indexOf(start_String) + start_String.length()));
			}
		}

		return result;
	}

	public static String getMidStr(String value, String start_String, String end_String) {
		return getMidStr(value, start_String, end_String, 0);
	}

	/**
	 * 특정 문자 사이의 문자열을 제거
	 * removeStr("ABCDE", "B", "E"); ==> ABE
	 *
	 * @param value 원본문자열
	 * @param start_String 시작문자
	 * @param end_String 종료문자
	 * @return
	 */
	public static String removeStr(String value, String start_String, String end_String) {
		String result = value.trim();

		while (result.indexOf(start_String) >= 0 && result.indexOf(end_String, result.indexOf(start_String)) >= result.indexOf(start_String)) {
			result = result.substring(0, result.indexOf(start_String)) + result.substring(result.indexOf(end_String, result.indexOf(start_String) + start_String.length()) + end_String.length());
		}

		return result;
	}

	/**
	 * 문자열이 특정 문자로 끝나는 경우 해당 문자를 제거
	 * removeEndStr("ABCDE", "E"); ==> ABCD
	 *
	 * @param value 원본문자열
	 * @param end_String 종료문자
	 * @return
	 */
	public static String removeEndStr(String value, String end_String) {
		while (value.toLowerCase().endsWith(end_String.toLowerCase())) {
			value = value.substring(0, value.toLowerCase().lastIndexOf(end_String.toLowerCase()));
		}

		return value.trim();
	}

	/**
	 * 문자열을 쉼표로 구분된 Map객체로 변환
	 * 
	 * @param agreeItem
	 * @return
	 */
	public static Map<String, String> convertArray(String item) {
		if (isNull(item)) {
			return null;
		}

		String[] tempItemArray = item.replaceAll(" ", "").split(",");

		Map<String, String> itemMap = new HashMap<String, String>();

		for (int i = 0; i < tempItemArray.length; i++) {
			itemMap.put(tempItemArray[i], "Y");
		}

		return itemMap;
	}

	/**
	 * 모바일 서버에 저장할 파일명을 생성
	 * 
	 * @param userId
	 * @param orginalFilename
	 * @return
	 */
	public static synchronized String getNewFilename(String userId, String orginalFilename) {
		String returnMap = null;

		if (!isNull(userId)) {
			String ext = ".";

			if (orginalFilename.lastIndexOf(".") >= 0) {
				ext += orginalFilename.substring(orginalFilename.lastIndexOf(".") + ".".length());
			}

			returnMap = userId + "_" + DateUtil.convertDateString(new Date(), "yyyyMMddHHmmssSSS") + ext;

			try {
				Thread.sleep(1);
			} catch (InterruptedException ignore) {
			}
		}

		return returnMap;
	}
}
