package com.codex.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;

/**
 * 时间处理工具类
 * 
 * @author Yang.Gao
 *
 */
public class DateUtil {

	static Logger logger = Logger.getLogger(DateUtil.class);

	/**
	 * yyyy-MM-dd
	 */
	public static String YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * yyyy-MM
	 */
	public static String YYYY_MM = "yyyy-MM";

	public static String YYYY_MM_DD_HH = "yyyy-MM-dd-HH";
	
	/**
	 * 根据制定的格式格式化时间
	 * 
	 * @param date 需要格式化的时间
	 * @param format 格式：
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat dateFm = new SimpleDateFormat(format);
		return dateFm.format(date);
	}

	/**
	 * 将string转换为date
	 * 
	 * @param str
	 * @param type
	 * @return
	 */
	public static Date stringToDate(String str, String type) {
		SimpleDateFormat sdf = new SimpleDateFormat(type);// 小写的mm表示的是分钟
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前时间字符串，yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getTimeNow() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return dateTimeFormat.format(calendar.getTime());
	}

	/**
	 * 打印接口开始时间，并返回当前时间
	 * @param actionName
	 * @return
	 */
	public static Calendar printTimeStart(String actionName) {
		Calendar now = Calendar.getInstance();
		String startTime = getTimeFromCalendar(now);
		logger.info("接口《" + actionName + "》开始时间：" + startTime);
		return now;
	}

	/**
	 * 打印某一步耗时，并返回当前时间
	 * @param start
	 * @param actionName
	 * @param msg
	 * @return
	 */
	public static Calendar printTimeCost(Calendar start, String actionName, String msg) {
		Calendar now = Calendar.getInstance();
		long difference = now.getTimeInMillis() - start.getTimeInMillis();
		String nowTime = getTimeFromCalendar(now);
		double costTime = (double) difference / 1000;
		logger.info("接口《" + actionName + "--" + msg + "》完成时间：" + nowTime + ",耗时：" + costTime + "秒！");
		return now;
	}

	private static String getTimeFromCalendar(Calendar now) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String nowTime = dateTimeFormat.format(now.getTime());
		return nowTime;
	}

	/**
	 * 获取当前时间字符串，yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateNow() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return dateTimeFormat.format(calendar.getTime());
	}

	/**
	 * 获取当前时间字符串，yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateNowWithSSS() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		dateTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return dateTimeFormat.format(calendar.getTime());
	}

	/**
	 * 获取当前时间对象
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 获取指定日期时间几天后的凌晨日期时间（时分秒都为0）
	 * 
	 * @param date
	 * @param intervalDay 正数，几天之后 负数，几天之前
	 * @return
	 */
	public static Date getZeroDateTimeAfterSomeDay(Date date, int intervalDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, intervalDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取今天前几天或者后几天的字符串形式
	 * 
	 * @author 李战平
	 * @param intervalDay 正数，几天之后 负数，几天之前
	 * @param format 格式
	 * @return
	 */
	public static String getSomeDayStr(int intervalDay, String format) {
		return formatDate(getZeroDateTimeAfterSomeDay(getCurrentDate(), intervalDay), format);
	}

	public static int getHours() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static Date getintervalHoursTime(int intervalHour) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, intervalHour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	public static Date getintervalMinutesTime(int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.add(Calendar.MINUTE, minutes);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static String getLastHourStr() {
		Date d = getintervalHoursTime(-1);
		return formatDate(d, YYYY_MM_DD_HH);
	}

	public static String getNextHourStr() {
		Date d = getintervalHoursTime(1);
		return formatDate(d, YYYY_MM_DD_HH);
	}

	public static String getNowHourStr() {
		Date d = getintervalHoursTime(0);
		return formatDate(d, YYYY_MM_DD_HH);
	}
	
	public static String getLastMinutesStr(int minutes) {
		Date d = getintervalMinutesTime(minutes);
		return formatDate(d, "yyyy-MM-dd HH:mm:ss");
	}

	public static List<String> getSevenDaysSameHourStr() {
		List<String> result = new ArrayList<String>();
		int interval = 0;
		Date date = null;
		for (int i = 0; i < 7; i++) {
			interval = -i * 24;
			date = getintervalHoursTime(interval);
			result.add(formatDate(date, YYYY_MM_DD_HH));
		}
		return result;
	}

	/**
	 * 获得今天日期的字符串形式
	 * 
	 * @return
	 */
	public static String getTodayStr() {
		return formatDate(getCurrentDate(), YYYY_MM_DD);
	}
	
	public static String getSevenDayAgoStr() {
		return getSomeDayStr(-7, YYYY_MM_DD);
	}

	/**
	 * 获取昨天字符串,yyyy-MM-dd
	 * 
	 * @author 李战平
	 * @return
	 */
	public static String getYestrdayStr() {
		return getSomeDayStr(-1, YYYY_MM_DD);
	}

	/**
	 * 获取明天字符串,yyyy-MM-dd
	 * 
	 * @author 李战平
	 * @return
	 */
	public static String getTomorrowStr() {
		return getSomeDayStr(1, YYYY_MM_DD);
	}

	/** 
	 * 得到两个日期相差天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getBetweenDay(Date date1, Date date2) {
		Calendar d1 = new GregorianCalendar();
		d1.setTime(date1);
		Calendar d2 = new GregorianCalendar();
		d2.setTime(date2);
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		System.out.println("days=" + days);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	public static void main(String args[]) {
		System.out.println(getNextHourStr());
		System.out.println(getNowHourStr());
		System.out.println(getSevenDaysSameHourStr());
		System.out.println(getSevenDayAgoStr());
	}


	/**
	 * 加几小时
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date addHour(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, number);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 减几小时
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date reduceHour(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, -number);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 加几分钟
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date addMinute(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, number);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 减几分钟
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date reduceMinute(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, -number);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 当前时间增加几年
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date addYear(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, number);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 当前时间减少几年
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date reduceYear(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -number);
		date = calendar.getTime();
		return date;
	}
	/**
	 *
	 * 当前时间增加几月
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date addMonth(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, number);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 当前时间增加几月
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date reduceMonth(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -number);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 当前日期增加几天
	 * @param date
	 * @param number
	 * @return
	 */
	public static Date addDay(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, number);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		return date;
	}
	/**
	 * 当前日期减去几天
	 * @param date
	 * @param number
	 * @return
	 */

	public static Date reduceDay(Date date,int number) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -number);
		date = calendar.getTime();
		return date;
	}

	/**
	 * @Title: DateToString
	 * @Description: Date转换为String
	 * @param @param date
	 * @param @param type
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String DateToString(Date date, String type) {
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		return sdf.format(date);
	}
}
