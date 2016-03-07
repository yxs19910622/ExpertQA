package org.izhong.expert.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import sun.misc.BASE64Decoder;


public class BaseUtil {
	
	public static boolean isEmpty(String str) {
		return (str == null) || (str.length() == 0);
	}

	public static boolean isNotEmpty(String str) {
		
		return !isEmpty(str);
	}
	
	/**
	 * 生成ID号
	 * @return
	 * @author whz
	 */
	public static String generateIdentifier(){
		 DateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		 String uuid = format.format(new Date().getTime())+new Double(Math.random()*100000).intValue();
		 return uuid ;	
	 }
	
	public static String Md5(String plainText) {
		StringBuffer buf = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString();
	}
	
	/**
	 * 获得密码盐(8位随机数)
	 * @return
	 * @author whz
	 */
	public static String getPasswordSalt()
	{
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();
	    int number;
	    for (int i = 0; i < 8; i++) {   
	    	number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }
	    return sb.toString();
	}
	
	/**
	 * 获得激活码
	 * @return
	 * @author whz
	 */
	public static String getActivation()
	{
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();   
	    StringBuffer sb = new StringBuffer();
	    int number;
	    for (int i = 0; i < 16; i++) {   
	    	number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }
	    return sb.toString();
	}
	
	/**
	 * 解密数据
	 * @param encryData
	 * @return
	 * @author whz
	 */
	public static String Decryption(String encryData)
	{
		if(isEmpty(encryData)){return null;}
		BASE64Decoder baseDecoder = new BASE64Decoder();
		byte[] DECOMPRESSPROPERTIES = new byte[] {0x5d,0x00,0x00,0x00,0x01};
		String result = null;
		try {
			byte[] tobyte = baseDecoder.decodeBuffer(encryData);
			ByteArrayInputStream inStream = new ByteArrayInputStream(tobyte);
			sevenzip.compression.lzma.Decoder decoder = new sevenzip.compression.lzma.Decoder();
			decoder.SetDecoderProperties(DECOMPRESSPROPERTIES);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
			long outSize = tobyte.length+50;
			decoder.Code(inStream, outStream, outSize);
			result = outStream.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		//System.out.println(BaseUtil.getActivation());
		System.out.println(BaseUtil.Decryption("AD2IhYbzdMvQ1Uf5TKSEkrw2p+aEKCjRxjcqkKICQ07awBFJK4fTwXQIsUt7SPNsSXWDRs93+uv/wYTQCYw1mnCaXSVATHpbneoDOnL4wFWqezt4lQ0ghcyea79SyE2oyjwJT6J+zHpPy3AlNbYqa1nmRE1O6SXyvwA="));
	}
}