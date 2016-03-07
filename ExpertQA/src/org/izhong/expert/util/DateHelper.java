package org.izhong.expert.util;



import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;

/*
 * ===========================================================================
 * Copyright 2007 WEBTRANING Corp. All Rights Reserved.
 * WEBTRANING PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * ===========================================================================
 * @version 1.0, 2007-8-11
 * @author  Jack Chen 
 * ===========================================================================
 * 
 */

public class DateHelper {

	public DateHelper() {
		super();
		//constructor from parent
	}
	/**
	 * 返回系统当前日期
	 * @return
	 */
    public static String getCurrentStr(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
    	return df.format(new Date());
    }
	public static java.sql.Date getCurrentDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}
	/**
	 * 将日期型数据转换成 YYYY-MM-DD 格式的字符串
	 * 
	 * @param d java.util.Date
	 * @return 格式化后的字符串
	 */
	public static String getYMDFormatDateStr(Date d) {
		return getDate(d, "YYYY-MM-DD");
	}
	
	/**
	 * 将日期型数据转换成 YYYY.MM.DD 格式的字符串
	 * 
	 * @param d java.util.Date
	 * @return 格式化后的字符串
	 */
	public static String getYMDFormatDateStr2(Date d) {
		return getDate(d, "YYYY.MM.DD");
	}
	/**
	 * 将日期型数据转换成 YYYY-MM-DD HH24:MI:SS 格式的字符串
	 * 
	 * @param d java.util.Date
	 * @return 格式化后的字符串
	 */
	public static String getYMDHMSFormatDateStr(Date d) {
		return getDate(d, "YYYY-MM-DD HH24:MI:SS");
	}
	/**
	 * 将日期型数据转换成 YYYY-MM-DD HH24:MI 格式的字符串
	 * 
	 * @param d java.util.Date
	 * @return 格式化后的字符串
	 */
	public static String getYMDHMFormatDateStr(Date d) {
		return getDate(d, "YYYY-MM-DD HH24:MI");
	}
	/**
	 * 将日期型数据转换成 YYYY年MM月DD日 格式的字符串
	 * 
	 * @param d java.util.Date
	 * @return 格式化后的字符串
	 */
	public static String getYMDForZhCnFormatDateStr(Date d) {
		return getDate(d, "YYYY年MM月DD日");
	}
	/**
	 * 获取输入格式的日期字符串，字符串遵循Oracle格式
	 * 
	 * @param d -日期
	 * @param format -指定日期格式，格式的写法为Oracle格式
	 * @return 按指定的日期格式转换后的日期字符串
	 */
	public static String getDate(Date d, String format) {
		if (d == null)
			return "";
		Hashtable h = new Hashtable();
		String javaFormat = new String();
		String s = format.toLowerCase();
		if (s.indexOf("yyyy") != -1)
			h.put(new Integer(s.indexOf("yyyy")), "yyyy");
		else if (s.indexOf("yy") != -1)
			h.put(new Integer(s.indexOf("yy")), "yy");
		if (s.indexOf("mm") != -1)
			h.put(new Integer(s.indexOf("mm")), "MM");

		if (s.indexOf("dd") != -1)
			h.put(new Integer(s.indexOf("dd")), "dd");
		if (s.indexOf("hh24") != -1)
			h.put(new Integer(s.indexOf("hh24")), "HH");
		if (s.indexOf("mi") != -1)
			h.put(new Integer(s.indexOf("mi")), "mm");
		if (s.indexOf("ss") != -1)
			h.put(new Integer(s.indexOf("ss")), "ss");

		int intStart = 0;
		while (s.indexOf("-", intStart) != -1) {
			intStart = s.indexOf("-", intStart);
			h.put(new Integer(intStart), "-");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf("/", intStart) != -1) {
			intStart = s.indexOf("/", intStart);
			h.put(new Integer(intStart), "/");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf(" ", intStart) != -1) {
			intStart = s.indexOf(" ", intStart);
			h.put(new Integer(intStart), " ");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf(":", intStart) != -1) {
			intStart = s.indexOf(":", intStart);
			h.put(new Integer(intStart), ":");
			intStart++;
		}
		
		intStart = 0;
		while (s.indexOf(".", intStart) != -1) {
			intStart = s.indexOf(".", intStart);
			h.put(new Integer(intStart), ".");
			intStart++;
		}

		if (s.indexOf("年") != -1)
			h.put(new Integer(s.indexOf("年")), "年");
		if (s.indexOf("月") != -1)
			h.put(new Integer(s.indexOf("月")), "月");
		if (s.indexOf("日") != -1)
			h.put(new Integer(s.indexOf("日")), "日");
		if (s.indexOf("时") != -1)
			h.put(new Integer(s.indexOf("时")), "时");
		if (s.indexOf("分") != -1)
			h.put(new Integer(s.indexOf("分")), "分");
		if (s.indexOf("秒") != -1)
			h.put(new Integer(s.indexOf("秒")), "秒");

		int i = 0;
		while (h.size() != 0) {
			Enumeration e = h.keys();
			int n = 0;
			while (e.hasMoreElements()) {
				i = ((Integer) e.nextElement()).intValue();
				if (i >= n)
					n = i;
			}
			String temp = (String) h.get(new Integer(n));
			h.remove(new Integer(n));

			javaFormat = temp + javaFormat;
		}
		SimpleDateFormat df = new SimpleDateFormat(javaFormat, new DateFormatSymbols());

		return df.format(d);
	}
	
	/**
	 * 将指定格式的字符串转换为日期型
	 * 
	 * @param strDate -日期
	 * @param oracleFormat--oracle型日期格式
	 * @return 转换得到的日期
	 */
	public static Date stringToDate(String strDate, String oracleFormat) {
		// SimpleDateFormat df=new SimpleDateFormat(javaFormat,new
		// DateFormatSymbols());
		// SimpleDateFormat df = new SimpleDateFormat(javaFormat);
		if (strDate == null)
			return null;
		Hashtable h = new Hashtable();
		String javaFormat = new String();
		String s = oracleFormat.toLowerCase();
		if (s.indexOf("yyyy") != -1)
			h.put(new Integer(s.indexOf("yyyy")), "yyyy");
		else if (s.indexOf("yy") != -1)
			h.put(new Integer(s.indexOf("yy")), "yy");
		if (s.indexOf("mm") != -1)
			h.put(new Integer(s.indexOf("mm")), "MM");

		if (s.indexOf("dd") != -1)
			h.put(new Integer(s.indexOf("dd")), "dd");
		if (s.indexOf("hh24") != -1)
			h.put(new Integer(s.indexOf("hh24")), "HH");
		if (s.indexOf("mi") != -1)
			h.put(new Integer(s.indexOf("mi")), "mm");
		if (s.indexOf("ss") != -1)
			h.put(new Integer(s.indexOf("ss")), "ss");

		int intStart = 0;
		while (s.indexOf("-", intStart) != -1) {
			intStart = s.indexOf("-", intStart);
			h.put(new Integer(intStart), "-");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf("/", intStart) != -1) {
			intStart = s.indexOf("/", intStart);
			h.put(new Integer(intStart), "/");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf(" ", intStart) != -1) {
			intStart = s.indexOf(" ", intStart);
			h.put(new Integer(intStart), " ");
			intStart++;
		}

		intStart = 0;
		while (s.indexOf(":", intStart) != -1) {
			intStart = s.indexOf(":", intStart);
			h.put(new Integer(intStart), ":");
			intStart++;
		}

		if (s.indexOf("年") != -1)
			h.put(new Integer(s.indexOf("年")), "年");
		if (s.indexOf("月") != -1)
			h.put(new Integer(s.indexOf("月")), "月");
		if (s.indexOf("日") != -1)
			h.put(new Integer(s.indexOf("日")), "日");
		if (s.indexOf("时") != -1)
			h.put(new Integer(s.indexOf("时")), "时");
		if (s.indexOf("分") != -1)
			h.put(new Integer(s.indexOf("分")), "分");
		if (s.indexOf("秒") != -1)
			h.put(new Integer(s.indexOf("秒")), "秒");

		int i = 0;
		while (h.size() != 0) {
			Enumeration e = h.keys();
			int n = 0;
			while (e.hasMoreElements()) {
				i = ((Integer) e.nextElement()).intValue();
				if (i >= n)
					n = i;
			}
			String temp = (String) h.get(new Integer(n));
			h.remove(new Integer(n));

			javaFormat = temp + javaFormat;
		}
		// System.out.println(javaFormat);
		SimpleDateFormat df = new SimpleDateFormat(javaFormat);

		Date myDate;
		try {
			myDate = df.parse(strDate);
		} catch (Exception e) {
			return null;
		}

		return myDate;
	}
	
	// 传入的时间加23:59返回
	public static Date parse2Date(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (dateStr.length() < 19)
			return new Date();

		try {
			return sdf.parse(dateStr.substring(0, 10) + " " + dateStr.substring(11, 19));
		} catch (Exception e) {
			System.out.println("日期转换错误:" + e.getMessage());
			return new Date();
		}
	}
	// 传入的时间带空格1900-01-01 0:00:00
	public static String parse3Date(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String  sw=null;
		if (dateStr.length() < 19){
		try {
			 sw=sdf.parse(dateStr.substring(0, 10) + "  0" + dateStr.substring(12, 18)).toString();
		} catch (Exception e) {
			System.out.println("日期转换错误:" + e.getMessage());
			return new Date().toString();
			}
		}else{
			try {
			 sw=sdf.parse(dateStr).toString();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sw;
	}

	// 日期转换，周春芝
	public static String parse2DateString(String date){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date d = null;
			try {
				d = df.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return df.format(d);
		}

	public static void main(String args[]) {
		Date date = parse2Date("2011-9-4 0:00:00");
		//Data data1 = null;
		String dataString = "2011-1-4 0:00:00";
		String datay ="";
		String datam="";
		String datad ="";
	
		System.out.println("date=="+parse2DateString(dataString));
		
		String str = DateHelper.getYMDHMSFormatDateStr(date);
		System.out.println(str);
	
		String aa = DateHelper.getYMDHMSFormatDateStr(new Date());
		System.out.println("aa======"+aa);
	}

}
