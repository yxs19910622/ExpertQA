package org.izhong.expert.util;

import sun.misc.BASE64Decoder; 
import java.io.*;

import org.izhong.web.util.SevenZipCompression;

public class Base64Helper{

	public static String getBASE64(String s) { 
		if (s == null) return null; 
		return (new sun.misc.BASE64Encoder()).encode( s.getBytes() ); 
	} 

	public static byte[] getFromBASE64(String s) { 
		if (s == null) return null; 
		BASE64Decoder decoder = new BASE64Decoder(); 
		try { 
			byte[] b = decoder.decodeBuffer(s); 
			return b; 
		} catch (Exception e) { 
			return null; 
		} 
	} 
	
	public static byte[] objectToBytes(Object obj) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream sOut = new ObjectOutputStream(out);
		sOut.writeObject(obj);
		sOut.flush();
		byte[] bytes = out.toByteArray();

		return bytes;
	} 
	
	public static Object bytesToObject(byte[] bytes) throws Exception {
		//byteתobject
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream sIn = new ObjectInputStream(in);
		return sIn.readObject();

	} 
	public static void main(String[] arge){
          //String code = "AD2IhYbzdMvQ1Uf5TKSEksu1CLGe6dZGn08TVROxdqiXhq+tk+sxmRdmaZ2FDoojoshl5HGbWhv6wHdlDv77uQx2Gk78lTWROQaw/Li5mCNzuiwfEqaJY9YA+gA=";
		    String code = "AD2IhYbzdMvQ1Uf5TKSEkrw2p+aDvRcmr85YP2Nzyc8yc44ZRYsE26cfWIhwH1fSd4Y482J1r1sghGx1cjC/1oEiDwnWruxHMKKLX8ISMvzqzS4ZFpMb9d+vUBsjlxHKNR9bKA0BiCeecPLUXsQQdOQAAAAA";
		    String aa = "AD2IhYbzdMvQ1Uf5TKSEkrw2p aDvRcmr85YP2Nzyc8yc44ZRYsE26cfWIhwH1fSd4Y482J1r1sghGx1cjC/1oEiDwnWruxHMKKLX8ISMvzqzS4ZFpMb9d vUBsjlxHKNR9bKA0BiCeecPLUXsQQdOQAAAAA";
		    String dd = "AD2IhYbzdMvQ1Uf5TKSEkrw2p+aDvRcmr85YP2Nzyc8yc44ZRYsE26cfWIhwH1fSd4Y482J1r1sghGx1cjC/1oEiDwnWwzyFL+lopRDEhDE+usLkcRMCvV/5ia7CEKC032BXAa/fY+r8/JwaLMsU9cAAAAAA";
		    //String code = "易中公司0123456789";
		try {
			byte[] bt = Base64Helper.getFromBASE64(dd);
			String str = SevenZipCompression.Decompression(bt);
			//{"LoginName":"b@b.com","PassWord":"123456","Date":"2012-08-24","DeviceSN":"FF02EC0026BF8AFFFF64&0","Data":"tSi[`J"}
			System.out.println("str----"+str);
			String urlData = str.substring(0,str.indexOf("}")+1);
			String[] arrs = urlData.split(",");
			System.out.println(arrs[0].split(":")[1].replace("\"", ""));
			System.out.println(arrs[1].split(":")[1].replace("\"", ""));
			System.out.println(arrs[3].split(":")[1].replace("\"", ""));
			///Base64Helper.testWrite(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}




