package com.leshun.plc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * 
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	@SuppressWarnings("unused")
	private static String firstDay;
	private static String[] parsePatterns = { "yyyy-MM-dd",
			"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
			"yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM" };
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private static DateFormat dateFormat2 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static DateFormat dateFormat3 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSSZ");
	/**
	 * 日期时间格式化对象
	 */
	private static DateFormat dateTimeFormatString = new SimpleDateFormat(
			"yyyyMMddHHmm");

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd）
	 */
	public static String formatDate(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyyMMddHHmmss）
	 */
	public static String getDateTimeString() {
		return formatDate(new Date(), "yyyyMMddHHmmss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	public static String getLastYear() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, -1);
		Date last = c.getTime();
		return formatDate(last, "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 转化日期
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(Object str, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (str == null) {
			return null;
		}
		try {
			return sdf.parse(str.toString());
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 从字符串转换为date 默认格式为 "yyyy-MM-dd"
	 * 
	 * @param source
	 * @return
	 */
	public static final Date parseDate(String source) {
		if (source == null || source.length() == 0)
			return null;
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 从字符串转换为date 默认格式为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param source
	 * @return
	 */
	public static final Date parseDate2(String source) {
		if (source == null || source.length() == 0)
			return null;
		try {
			return dateFormat2.parse(source);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 从字符串转换为date 默认格式为 yyyy-MM-dd HH:mm:ss.SSSZ
	 * 
	 * @param source
	 * @return
	 */
	public static final Date parseDate3(String source) {
		if (source == null || source.length() == 0)
			return null;
		try {
			return dateFormat3.parse(source);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60
				- min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000
				- hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "."
				+ sss;
	}

	/**
	 * 获取当前时间上个月最后一秒 返回时分秒
	 */
	public static String getLastMonthDay(Date oldDay) {
		Calendar cal = Calendar.getInstance();
		Date date = null;
		if (oldDay != null) {
			date = oldDay;
		} else {
			date = new Date();
		}
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONTH); // 上个月月份
		// int day1 = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//起始天数
		// int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 结束天数

		System.out.println("###last month:" + month);
		if (month == 0) {
			year = cal.get(Calendar.YEAR) - 1;
			month = 12;
		} else {
			year = cal.get(Calendar.YEAR);
		}
		String endDay = year + "-" + month + "-"
				+ getDaysByYearMonth(year, month);
		return endDay + " 23:59:59";
	}

	/**
	 * 获取当前时间上个月最后一秒 返回时分秒
	 */
	public static String getFirstMonthDay() {
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return dateFormat.format(cal_1.getTime());
	}

	/**
	 * 获取指定时间上个月最后一秒 返回时分秒
	 */
	public static String getLastMonthDay2(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONTH); // 上个月月份
		// int day1 = cal.getActualMinimum(Calendar.DAY_OF_MONTH);//起始天数
		int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 结束天数

		System.out.println("###last month:" + month);
		if (month == 0) {
			year = cal.get(Calendar.YEAR) - 1;
			month = 12;
		} else {
			year = cal.get(Calendar.YEAR);
		}
		String endDay = year + "-" + month + "-" + day;
		return endDay + " 23:59:59";
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getDayBefore(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayBefore = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
		return dayBefore;
	}

	/**
	 * 获取指定日期前几天日期，返回String类型
	 * 
	 * @param specifiedDay
	 * @param i
	 *            天数
	 * @return yyyy-MM-dd
	 */
	public static String getDayBefore(Date date, int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - i);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayBefore;
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 *            指定日期
	 * @param pattern1
	 *            输入日期格式
	 * @return
	 */
	public static Date getDayBefore(String specifiedDay, String inPattern) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat(inPattern).parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		// String dayBefore = new
		// SimpleDateFormat(outPattern).format(c.getTime());
		return c.getTime();
	}

	/**
	 * 格式化输出 默认格式为 "yyyyMMddHHmm"
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateTimeString(Date date) {
		if (date == null)
			return "";
		return dateTimeFormatString.format(date);
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 获取两个日期之间的月数
	 *
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoMonth(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24) / 30;
	}

	/**
	 * 根据起止日期获取date list
	 * 
	 * @param startDate
	 * @return
	 */
	public static List<Date> getDateList(Date startDate, Date endDate) {
		List<Date> list = new ArrayList<Date>();
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			startCalendar.setTime(startDate);
			endCalendar.setTime(endDate);
			list.add(startDate);
			while (true) {
				startCalendar.add(Calendar.DAY_OF_MONTH, 1);
				if (startCalendar.getTimeInMillis() < endCalendar
						.getTimeInMillis()) {
					list.add(dateFormat
							.parse(df.format(startCalendar.getTime())));
				} else {
					break;
				}
			}
			list.add(endDate);
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	// 获取当前时间的上一个月第一天开始时间(没有时分)
	public static String getPreMonthDay() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONTH); // 上个月月份
		int startDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);// 起始天
		System.out.println("###fist month:" + month);
		if (month == 0) {
			year = cal.get(Calendar.YEAR) - 1;
			month = 12;
		} else {
			year = cal.get(Calendar.YEAR);
		}
		String startDayTime = year + "-" + month + "-" + startDay;
		try {
			Date newDate = new SimpleDateFormat("yy-MM-dd").parse(startDayTime);
			cal.setTime(newDate);
			startDayTime = new SimpleDateFormat("yyyyMMdd")
					.format(cal.getTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return startDayTime;
	}

	// 获取当前时间的上一个月的总天数
	public static int getPreMonthDays() {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int year = 0;
		int month = cal.get(Calendar.MONTH); // 上个月月份
		// int startDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);// 起始天
		if (month == 0) {
			year = cal.get(Calendar.YEAR) - 1;
			month = 12;
		} else {
			year = cal.get(Calendar.YEAR);
		}
		return getDaysByYearMonth(year, month);
	}

	/* 指定年月 算所在月的总天数 */
	public static int getDaysByYearMonth(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public static String formatChanger(String dateStr, String oldFormat,
			String newFormat) {
		SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
		SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);
		try {
			Date date = sdfOld.parse(dateStr);
			dateStr = sdfNew.format(date);
		} catch (ParseException e) {
		}

		return dateStr;
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// System.out.println(DateUtils.getDayBefore(getDate()));
		// System.out.println(getPreMonthDay());
		// System.out.println(formatDate(DateUtils.addMonths(parseDate("2017-1-1"),
		// 1))+"===");
		// System.out.println(getDaysByYearMonth(2017, 1));
		// getPreMonthDays() ;
		// System.out.println(formatDate(parseDate("2010/3/6")));
		// System.out.println(getDate("yyyy年MM月dd日 E"));
		// long time = new Date().getTime()-parseDate("2012-11-19").getTime();
		// System.out.println(time/(24*60*60*1000));
		//
		// System.out.println(getYear()+"------"+getLastYear());
		//
		// System.out.println(getDaysByYearMonth(2017, 2));

		// Date beforeDay = DateUtils.addDays(new Date(), -1);
		// String mm = DateUtils.formatDate(beforeDay, "yyyy-MM");
		// // mm+"-01"+" 00:00:00"
		// Date startDate = DateUtils.parseDate2(mm + "-01" + " 00:00:00");
		// String beYyMm = DateUtils.formatDate(beforeDay, "yyyy-MM-dd");
		// Date endDate = DateUtils.parseDate2(beYyMm + " 23:59:59");
		// System.out.println(startDate);
		// System.out.println(endDate);
		// System.out.println(parseDate("20180302133410", "yyyyMMddHHmmss"));
		// String hhmmss = DateUtils.getTime().replace(":", "");
		// System.out.println(hhmmss);
		// 20180414-20180420
		// Date queryDatePara = DateUtils.parseDate("20180323", "yyyyMMdd");
		//
		// Date yestoday = DateUtils.addDays(new Date(), -8);
		// Date beforeday = DateUtils.addDays(new Date(), -1);
		//
		// boolean res = queryDatePara.compareTo(yestoday)>0;
		// boolean res2 = queryDatePara.compareTo(beforeday)<0;
		// boolean f = queryDatePara.after(yestoday);
		// boolean f2 = queryDatePara.before(beforeday);
		//
		// System.out.println(yestoday);
		// System.out.println(queryDatePara);
		// System.out.println(res);
		// System.out.println(res2);
		// System.out.println(f);
		// System.out.println(f2);

		DateFormat dateTimeFormatString = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSSZ");
		System.out.println(dateTimeFormatString.format(new Date()));
		String sssz = "2018-04-09 15:53:49.967+0800";
		System.out.println(dateTimeFormatString.parseObject(sssz));

		String week = getWeek();
		System.out.println(week);

	}
}
