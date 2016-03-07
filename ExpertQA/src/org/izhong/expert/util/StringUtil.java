package org.izhong.expert.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	public static String UnicodeToUTF8(String strIn){

		String strOut = null;
		if(strIn == null || strIn.trim().equals(""))
		{
			return strIn;
		}
		try {
			strOut=(new String(strIn.getBytes("iso-8859-1"),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return strOut;
	}
	
	public static String replaceEscape(String str)
	{
		return str.replace("&amp;", "&")
				.replace("&lt;", "<")
				.replace("&gt;", ">")
				.replace("&apos;", "'")
				.replace("&quot;", "\"");
	}
	
	public static String replaceNull(String str)
	{
		return str==null?"":str;
	}
	
	
	public static String UrlEncode(String str, String charset)
    {
        if(str == null)
        {
            return "";
        }
        String s = "";
        try
        {
            s = URLEncoder.encode(str, charset);
        }
        catch(Exception e) { }
        return s;
    }

    public static String UrlEncode(String str)
    {
        return UrlEncode(str, "utf-8");
    }
    
    public static String UnicodeToChar(String unicodeString){
		String rtn = ""; 
		try{
			String sss[] = unicodeString.split("a");
			for (int i=sss.length-1;i>=0;i--){
				char letter = (char)Integer.parseInt(sss[i]);
				rtn += new Character(letter).toString();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rtn;
	}
	
	public static String CharToUnicode(String a){
		String rtn = "";
		try {
			if(null != a && a.length()>0){
				for(int i=a.length()-1;i>=0;i--){
					rtn += a.substring(i, i+1).hashCode();
					rtn += i>0?"a":"";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
	}
	
	public static String replaceBlank(String str) {  
		String dest = "";  
		if (str!=null) {  
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");  
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}  
		return dest;  
	}
}
