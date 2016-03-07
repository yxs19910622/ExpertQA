package org.izhong.expert.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 获得当前时间
	 * @return
	 * @author whz
	 */
	public static Date getCurrTime()
	{
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	
	/**
	 * 获得给客户端发送的时间，单位(秒)
	 * @return
	 * @author whz
	 */
	public static long clientTime()
	{
		long time = new Date().getTime();
		time = time/1000;
		return time;
	}
	public static Date getCurrentDay()
	{
		Calendar calendar = Calendar.getInstance();		
		return new Date(calendar.get(Calendar.YEAR)-1900,calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
	}
	public static String getCurrTimeStr()
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(getCurrTime());
	}
	
	public static String getCurrDate()
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		return df.format(getCurrTime());
	}
	
	public static String formatDate(Date date)
	{
		if(date!=null)
		{
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(date);
		}else{
			return "";
		}
	}
	
	public static String formatShortDate(Date date)
	{
		if(date!=null)
		{
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			return df.format(date);
		}else{
			return "";
		}
	}	
	
	/**
	 * 获得试用期结束时间
	 * 试用期结束=试用期开始+28+7
	 * @return
	 * @author whz
	 */
	public static Date getTryEndTime(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 35);
		return calendar.getTime();
	}
	/**
	 * 服务结束日期
	 * @param date
	 * @return
	 * @author whz
	 */
	public static Date getServiceEnd(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 365);
		return calendar.getTime();
	}
	
	
	public static Date addYears(Date date, int amount)  
    {  
        return dateAdd(date, Calendar.YEAR, amount);  
    }  
  
    public static Date addMonths(Date date, int amount)  
    {  
        return dateAdd(date, Calendar.MONTH, amount);
    }  
  
	public static Date addDays(Date date, int amount)  
    {  
        return dateAdd(date, Calendar.DATE, amount);  
    }  

	public static Date addHours(Date date, int amount)
	{
		return dateAdd(date, Calendar.HOUR, amount);
	}
	
	public static Date addMinutes(Date date, int amount)
	{
		return dateAdd(date, Calendar.MINUTE, amount);
	}
	
	public static Date addSeconds(Date date, int amount)
	{
		return dateAdd(date, Calendar.SECOND, amount);
	}
	
	private static Date dateAdd(Date date, int calendarField, int amount)  
    {  
        if(date == null)  
        {  
            throw new IllegalArgumentException("The date must not be null");  
        } else  
        {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.add(calendarField, amount);  
            return c.getTime();  
        }  
    } 
	
	/**
	 * 自1970.01.01到现在的总天数
	 * @return
	 * @author whz
	 */
	public static long getTotalDays()
	{
		long day = new Date().getTime()/(60*60)/1000/24;
		return day;
	}
	
	/**
	 * 字符串转换为DATE类型
	 * @param date
	 * @return
	 * @author whz
	 */
	public static Date formatStrToDate(String date)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(BaseUtil.isNotEmpty(date))
		{
			try {
				return df.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
