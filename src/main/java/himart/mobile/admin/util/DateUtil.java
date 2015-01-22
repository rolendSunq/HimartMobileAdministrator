package himart.mobile.admin.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


/**
 * 하이마트 모바일서비스 관리자 시스템
 *
 * @description 날짜 관련 유틸리티
 * @author SeoJohoon
 */

public class DateUtil {
	private static Locale DEFAULT_LOCALE = Locale.KOREA;

	private static String STANDARD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 일요일
	 */
	public static int DAY_SUNDAY = 1;

	/**
	 * 월요일
	 */
	public static int DAY_MONDAY = 2;

	/**
	 * 화요일
	 */
	public static int DAY_TUESDAY = 3;

	/**
	 * 수요일
	 */
	public static int DAY_WEDNESDAY = 4;

	/**
	 * 목요일
	 */
	public static int DAY_THURSDAY = 5;

	/**
	 * 금요일
	 */
	public static int DAY_FRIDAY = 6;

	/**
	 * 토요일
	 */
	public static int DAY_SATURDAY = 7;

	/**
	 * 현재날짜를 특정 포맷의 정수형으로 반환
	 * 
	 * @param pattern 날짜 포맷
	 * @return 특정 포맷의 정수형 현재날짜
	 */
	private static int getNumberByPattern(String pattern) {
		SimpleDateFormat formatter_l = null;

		if (StringUtil.isNull(pattern)) {
			formatter_l = new SimpleDateFormat(STANDARD_DATE_FORMAT, DEFAULT_LOCALE);
		}
		else {
			formatter_l = new SimpleDateFormat(pattern, DEFAULT_LOCALE);
		}

		String date_l = formatter_l.format(new Date());

		return Integer.parseInt(date_l);
	}

	/**
	 * 현재 시각을 정수형으로 반환
	 * 
	 * @return 현재 시각
	 */
	public static int getCurrentHour() {
		return getNumberByPattern("HH");
	}

	/**
	 * 현재 분을 정수형으로 반환
	 * 
	 * @return 현재 분
	 */
	public static int getCurrentMinute() {
		return getNumberByPattern("mm");
	}

	/**
	 * 현재 초를 정수형으로 반환
	 * 
	 * @return 현재 초
	 */
	public static int getCurrentSecond() {
		return getNumberByPattern("ss");
	}

	/**
	 * 현재 년도를 정수형으로 반환
	 * 
	 * @return 현재 년도
	 */
	public static int getCurrentYear() {
		return getNumberByPattern("yyyy");
	}

	/**
	 * 현재 월을 정수형으로 반환
	 * 
	 * @return 현재 월
	 */
	public static int getCurrentMonth() {
		return getNumberByPattern("MM");
	}

	/**
	 * 현재 일을 정수형으로 반환
	 * 
	 * @return 현재 일
	 */
	public static int getCurrentDay() {
		return getNumberByPattern("dd");
	}

	/**
	 * 특정 날짜 패턴의 현재일자 문자열을 반환
	 * 
	 * @param pattern 날짜 패턴
	 * @return 현재일자
	 */
	public static String getFormatedCurrentDate(String pattern) {
		return getFormatedDate(new Date(), pattern);
	}

	/**
	 * 특정 날짜 패턴의 주어진 일자 문자열을 반환
	 * 
	 * @param pattern 날짜 패턴
	 * @return 현재일자
	 */
	public static String getFormatedDate(Date date, String pattern) {
		SimpleDateFormat formatter_l = null;

		if (StringUtil.isNull(pattern)) {
			formatter_l = new SimpleDateFormat(STANDARD_DATE_FORMAT, DEFAULT_LOCALE);
		}
		else {
			formatter_l = new SimpleDateFormat(pattern, DEFAULT_LOCALE);
		}

		return formatter_l.format(date);
	}

	/**
	 * 현재 일자의 요일 값을 얻어 온다. ( 일요일(1) ~ 토요일(7) )
	 * 
	 * @return 현재일자의 요일값
	 */
	public static int getCurrentDateOfWeek() {
		Calendar cal_l = Calendar.getInstance();
		return cal_l.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 특정 년/월의 마지막 일자를 반환
	 * 
	 * @param year 년도
	 * @param month 월
	 * @return 마지막 일자
	 */
	public static int getLastDay(int year, int month) {
		GregorianCalendar cal_l = new GregorianCalendar(year, (month - 1), 1);
		return cal_l.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * 주어진 기간의 년도 목록을 반환
	 * 
	 * @param startYear 시작년도
	 * @param endYear 종료년도
	 * @return 년도 목록
	 */
	public static List<String> getYearList(int startYear, int endYear) {
		List<String> listYears_l = new ArrayList<String>();

		for (int i = startYear; i <= endYear; i++) {
			listYears_l.add(String.valueOf(i));
		}

		return listYears_l;
	}

	/**
	 * 주어진 년/월의 일자 목록을 반환
	 * 
	 * @param year 년도
	 * @param month 월
	 * @return 일자(d) 목록
	 */
	public static List<String> getDaysList(int year, int month) {
		List<String> listDays_l = new ArrayList<String>();

		for (int i = 1; i <= getLastDay(year, month); i++) {
			listDays_l.add(String.valueOf(i));
		}

		return listDays_l;
	}

	/**
	 * 주어진 년/월의 일자 목록을 반환
	 * 
	 * @param year 년도
	 * @param month 월
	 * @return 일자(d) 목록
	 */
	public static List<String> getDaysList(String year, String month) {
		return getDaysList(Integer.parseInt(year), Integer.parseInt(month));
	}

	/**
	 * 주어진 년/월의 날짜 목록을 반환
	 * 
	 * @param year 년도
	 * @param month 월
	 * @param pattern 날짜포맷
	 * @return 날짜 목록
	 */
	public static List<String> getDatesList(int year, int month, String pattern) {
		List<String> listDays_l = new ArrayList<String>();

		for (int i = 1; i <= getLastDay(year, month); i++) {
			listDays_l.add(convertDateString(StringUtil.lPaddingB(String.valueOf(year), 4, '0') + StringUtil.lPaddingB(String.valueOf(month), 2, '0') + StringUtil.lPaddingB(String.valueOf(i), 2, '0'), "yyyyMMdd", pattern));
		}

		return listDays_l;
	}

	/**
	 * 주어진 년/월의 날짜 목록을 반환
	 * 
	 * @param year 년도
	 * @param month 월
	 * @return 날짜 목록
	 */
	public static List<String> getDatesList(int year, int month) {
		return getDatesList(year, month, "yyyyMMdd");
	}

	/**
	 * 주어진 년/월의 날짜 목록을 반환
	 * 
	 * @param year 년도
	 * @param month 월
	 * @param pattern 날짜포맷
	 * @return 날짜 목록
	 */
	public static List<String> getDatesList(String year, String month, String pattern) {
		return getDatesList(Integer.parseInt(year), Integer.parseInt(month), pattern);
	}

	/**
	 * 주어진 년/월의 날짜 목록을 반환
	 * 
	 * @param year 년도
	 * @param month 월
	 * @return 날짜 목록
	 */
	public static List<String> getDatesList(String year, String month) {
		return getDatesList(Integer.parseInt(year), Integer.parseInt(month), "yyyyMMdd");
	}

	/**
	 * 주어진 년/월의 특정 주차의 날짜 목록을 반환
	 *
	 * @param year 년도
	 * @param month 월
	 * @param week 주차
	 * @param pattern 날짜포맷
	 * @return
	 */
	public static List<String> getDatesList(int year, int month, int week, String pattern) {
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		calendar.set(Calendar.WEEK_OF_MONTH, week);

		List<String> listDays_l = new ArrayList<String>();

		Date startDate = calendar.getTime();

		for (int i = 0; i < 7; i++) {
			listDays_l.add(i, convertDateString(getNextDate(startDate, i), pattern));
		}

		return listDays_l;
	}

	/**
	 * 주어진 년/월의 특정 주차의 날짜 목록을 반환
	 *
	 * @param year 년도
	 * @param month 월
	 * @param week 주차
	 * @return
	 */
	public static List<String> getDatesList(int year, int month, int week) {
		return getDatesList(year, month, week, "yyyyMMdd");
	}

	/**
	 * 주어진 년/월의 특정 주차의 날짜 목록을 반환
	 *
	 * @param year 년도
	 * @param month 월
	 * @param week 주차
	 * @param pattern 날짜포맷
	 * @return
	 */
	public static List<String> getDatesList(String year, String month, int week, String pattern) {
		return getDatesList(Integer.parseInt(year), Integer.parseInt(month), week, pattern);
	}

	/**
	 * 주어진 년/월의 특정 주차의 날짜 목록을 반환
	 *
	 * @param year 년도
	 * @param month 월
	 * @param week 주차
	 * @return
	 */
	public static List<String> getDatesList(String year, String month, int week) {
		return getDatesList(Integer.parseInt(year), Integer.parseInt(month), week, "yyyyMMdd");
	}

	/**
	 * 주어진 날짜가 올바른지 확인
	 * 
	 * @param year 년도
	 * @param month 월
	 * @param day 일
	 * @return 유효 여부
	 */
	public static boolean isValiedDate(int year, int month, int day) {
		SimpleDateFormat formatter_l = new SimpleDateFormat("yyyy.MM.dd", DEFAULT_LOCALE);

		try {
			Date l_dtResult = formatter_l.parse(StringUtil.lPadding(year + "", 4, '0') + "." + StringUtil.lPadding(month + "", 2, '0') + "." + StringUtil.lPadding(day + "", 2, '0'));

			String l_strResult = formatter_l.format(l_dtResult);

			if (l_strResult.equalsIgnoreCase(StringUtil.lPadding(year + "", 4, '0') + "." + StringUtil.lPadding(month + "", 2, '0') + "." + StringUtil.lPadding(day + "", 2, '0'))) {
				return true;
			}
			else {
				return false;
			}
		} catch (ParseException pEx) {
			return false;
		}
	}

	/**
	 * 주어진 날짜가 올바른지 확인
	 * 
	 * @param dateString 날짜형 문자열
	 * @param pattern 문자열의 패턴
	 * @return 유효 여부
	 */
	public static boolean isValiedDate(String dateString, String pattern) {
		SimpleDateFormat formatter_l = null;

		if (StringUtil.isNull(pattern)) {
			formatter_l = new SimpleDateFormat(STANDARD_DATE_FORMAT, DEFAULT_LOCALE);
		}
		else {
			formatter_l = new SimpleDateFormat(pattern, DEFAULT_LOCALE);
		}

		try {
			Date l_dtResult = formatter_l.parse(dateString);

			String resultStr = formatter_l.format(l_dtResult);

			if (resultStr.equalsIgnoreCase(dateString)) {
				return true;
			}
			else {
				return false;
			}
		} catch (ParseException pEx) {
			return false;
		}
	}

	/**
	 * 주어진 일자간의 차이 일수를 문자열로 반환
	 * 
	 * @param startDate 시작일자
	 * @param endDate 종료일자
	 * @param pattern 일자 관련 문자열의 패턴
	 * @return 두 일자의 차이 일수
	 */
	public static long getDistanceDates(String startDate, String endDate, String pattern) {
		SimpleDateFormat formatter_l = null;

		if (StringUtil.isNull(pattern)) {
			formatter_l = new SimpleDateFormat(STANDARD_DATE_FORMAT, DEFAULT_LOCALE);
		}
		else {
			formatter_l = new SimpleDateFormat(pattern, DEFAULT_LOCALE);
		}

		long l_lDay2day = 0;

		try {
			l_lDay2day = (formatter_l.parse(endDate).getTime() - formatter_l.parse(startDate).getTime()) / (1000 * 60 * 60 * 24);
		} catch (Exception e) {
			return l_lDay2day;
		}

		return l_lDay2day;
	}

	/**
	 * 주어진 날짜형 문자열의 포맷을 변경하여 반환
	 * 
	 * @param dateString 변환할 문자열
	 * @param fromPattern 변환전 패턴
	 * @param toPattern 변환후 패턴
	 * @return 변환된 문자열
	 */
	public static String convertDateString(String dateString, String fromPattern, String toPattern) {

		if (StringUtil.isNull(dateString) || StringUtil.isNull(fromPattern)) {
			return "";
		}

		Date date_l;

		try {
			if (StringUtil.isNull(toPattern)) {
				date_l = new SimpleDateFormat(STANDARD_DATE_FORMAT, DEFAULT_LOCALE).parse(dateString);
			}
			else {
				date_l = new SimpleDateFormat(fromPattern, DEFAULT_LOCALE).parse(dateString);
			}
		} catch (ParseException e) {
			return dateString;
		}

		return new SimpleDateFormat(toPattern).format(date_l);
	}

	/**
	 * 주어진 패턴으로 날짜형 문자열을 반환
	 * 
	 * @param date 변환한 Date
	 * @param toPattern 변환할 패턴
	 * @return 변환된 문자열
	 */
	public static String convertDateString(Date date, String toPattern) {
		if (StringUtil.isNull(toPattern)) {
			return new SimpleDateFormat(STANDARD_DATE_FORMAT, DEFAULT_LOCALE).format(date);
		}
		else {
			return new SimpleDateFormat(toPattern, DEFAULT_LOCALE).format(date);
		}
	}

	/**
	 * 기준일자에 일정 일수 전후의 일자를 반환
	 *
	 * @param date 기준일자
	 * @param increaseDay 전후 일수 (양수: 이후, 음수: 이전)
	 * @return 전후일자
	 */
	private static Date getCalcuateDate(Date date, int increaseDay) {
		Calendar cal_l = new GregorianCalendar();
		cal_l.setTime(date);
		cal_l.add(Calendar.DATE, increaseDay);
		return cal_l.getTime();
	}

	/**
	 * 다음일자를 반환
	 *
	 * @param date 기준일자
	 * @return 다음일자
	 */
	public static Date getNextDate(Date date) {
		return getCalcuateDate(date, 1);
	}

	/**
	 * 특정 일수 이후의 일자를 반환
	 *
	 * @param date 기준일자
	 * @param increaseDay 전후 일수 (양수: 이후, 음수: 이전)
	 * @return 다음일자
	 */
	public static Date getNextDate(Date date, int increaseDay) {
		return getCalcuateDate(date, increaseDay);
	}

	/**
	 * 이전일자를 반환
	 *
	 * @param date 기준일자
	 * @return 이전일자
	 */
	public static Date getPreviousDate(Date date) {
		return getCalcuateDate(date, -1);
	}

	/**
	 * 특정 일수 이전의 일자를 반환
	 *
	 * @param date 기준일자
	 * @param decreaseDay 전후 일수 (양수: 이전, 음수: 이후)
	 * @return 이전일자
	 */
	public static Date getPreviousDate(Date date, int decreaseDay) {
		return getCalcuateDate(date, (-1) * decreaseDay);
	}

	/**
	 * 특정 월수 전후의 일자를 반환
	 *
	 * @param date 기준일자
	 * @param increaseMonth 전후월수
	 * @return 전후일자
	 */
	public static Date getNextDateWithMonth(Date date, int increaseMonth) {
		Calendar cal_l = new GregorianCalendar();
		cal_l.setTime(date);
		cal_l.add(Calendar.MONTH, increaseMonth);
		return cal_l.getTime();
	}

	/**
	 * 특정 년수 전후의 일자를 반환
	 *
	 * @param date 기준일자
	 * @param increaseYear 전후년수
	 * @return 전후일자
	 */
	public static Date getNextDateWithYear(Date date, int increaseYear) {
		Calendar cal_l = new GregorianCalendar();
		cal_l.setTime(date);
		cal_l.add(Calendar.YEAR, increaseYear);
		return cal_l.getTime();
	}

	/**
	 * <pre>
	 * HHmmss / HHmm / mmss 형식의 시간문자열을 원하는 캐릭터(ch)로 쪼개 돌려준다 (ABLE Frame의 버그 제거)
	 * 예) DateUtil.formatTime("153245", ":") ==> 15:32:45
	 *     DateUtil.formatTime("1532", ":") ==> 15:32
	 * </pre>
	 * 
	 * @param sTime 시간문자열
	 * @param ch 구분자
	 * @return
	 */
	public static String formatTime(String sTime, String ch) {
		if (StringUtil.isNull(sTime)) {
			return sTime;
		}

		sTime = sTime.replaceAll("[^0-9]*", "");

		if (sTime.length() == 6) {
			return (new StringBuilder(String.valueOf(sTime.substring(0, 2)))).append(ch).append(sTime.substring(2, 4)).append(ch).append(sTime.substring(4, 6)).toString();
		}
		else if (sTime.length() == 4) {
			return (new StringBuilder(String.valueOf(sTime.substring(0, 2)))).append(ch).append(sTime.substring(2, 4)).toString();
		}
		else {
			throw new IllegalArgumentException((new StringBuilder("Invalid time format: ")).append(sTime).toString());
		}
	}
}
