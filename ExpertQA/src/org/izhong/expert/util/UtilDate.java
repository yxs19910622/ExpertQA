package org.izhong.expert.util;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 名称：自定义订单类
 * 功能：工具类，可以用作获取系统日期、订单编号等
 * 类属性：支付宝公共类
 * 版本：2.0
 * 日期：2008-12-25
 * 作者：支付宝公司销售部技术支持团队
 * 联系：0571-26888888
 * 版权：支付宝公司
 * */
/* *
 *类名：UtilDate
 *功能：自定义订单类
 *详细：工具类，可以用作获取系统日期、订单编号等
 *版本：3.2
 *日期：2011-03-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class UtilDate {
	
    /** 年月日时分秒(无下划线) yyyyMMddHHmmss */
    public static final String dtLong                  = "yyyyMMddHHmmss";
    
    /** 完整时间 yyyy-MM-dd HH:mm:ss */
    public static final String simple                  = "yyyy-MM-dd HH:mm:ss";
    
    /** 年月日(无下划线) yyyyMMdd */
    public static final String dtShort                 = "yyyyMMdd";
	
    
    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     * @return
     *      以yyyyMMddHHmmss为格式的当前系统时间
     */
	public  static String getOrderNum(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtLong);
		return df.format(date);
	}
	
	/**
	 * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public  static String getDateFormatter(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(simple);
		return df.format(date);
	}
	
	/**
	 * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
	 * @return
	 */
	public static String getDate(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtShort);
		return df.format(date);
	}
	
	/**
	 * 产生随机的三位数
	 * @return
	 */
	public static String getThree(){
		Random rad=new Random();
		return rad.nextInt(1000)+"";
	}
	
	/**
	 * 获取当前时间返回以此格式MMddHHmmssSS字符串
	 * @return
	 */
	public static String getDate1(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat("MMddHHmmss");
		return df.format(date);
	}
	
	/**
	 * 生成订单号
	 * @author Liping
	 * @return
	 */
	/*public static String getOrderCode()
	{
		//时间
		String date = String.valueOf(System.currentTimeMillis());
		//随机数
		Random ran = new Random(System.currentTimeMillis());
		Integer intNum = ran.nextInt(899999)+100000;
		
		StringBuffer orderCode = new StringBuffer("");
		orderCode.append("WEB-").append(date).append("-").append(intNum);
		
		return orderCode.toString();
	}*/
	
	//随即产生6位数字
	public static String getSix(){
		Random rad=new Random();
		String res = rad.nextInt(10000000)+"";
		if(res.length()<7){
			res+="0";
		}
		return res;
	}
	
	/**
	 * 订单Id 订单号，长度为16个字节的数字串，由商户系统生成，失败的订单号允许重复支付。
	 * 规则：月日时分秒六位随机数
	 * @author zhaoqs
	 * @return
	 */
	public static String getOrderCode()
	{
		//时间
		String date = getDate1();
		//随机数
		Random ran = new Random(System.currentTimeMillis());
		Integer intNum = ran.nextInt(1000000);
		
		String intNumTemp = intNum.toString();
		for(int i=0; i<6-intNum.toString().length(); i++) {
			intNumTemp = intNumTemp + "0";
		}
		
		String orderCode = date + intNumTemp;
		
		return orderCode;
	}
	
	public static void main(String args[]) {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(UtilDate.getSix());
		}
//		for(int i=0; i<100; i++) {
//			System.out.println(UtilDate.getDate1());
//			System.out.println(UtilDate.getOrderCode());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
