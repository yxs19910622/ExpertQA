package org.izhong.expert.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	/**
	 * 新增Cookie，有效期为7天
	 * @param response
	 * @param name
	 * @param value
	 * @author whz
	 */
	public static void addCookie(HttpServletResponse response,String name,String value)
	{
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		if(!"EMenu".equals(name))
		{
			cookie.setMaxAge(7*24*60*60);
		}
		response.addCookie(cookie);
	}
	
	/**
     * 去除Cookie
     * @param request
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name){
    	Cookie[] cookies = request.getCookies();
    	if (null != cookies) {
            for (int i = 0; i < cookies.length; i++) {
               if (cookies[i].getName().equals(name)){
            	   cookies[i].setPath("/");
            	   cookies[i].setMaxAge(0);
            	   response.addCookie(cookies[i]);
            	   break;
               }
            }
        }
    }
    
    /**
     * 退出登录，清除所有cookie
     * @param request
     * @param response
     * @author whz
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response){
    	removeCookie(request,response,"EUserID");
    	removeCookie(request,response,"EUserName");
    	//removeCookie(request,response,"ELoginName");
    	removeCookie(request,response,"Eemail");
    	removeCookie(request,response,"EMenu");
    	removeCookie(request,response,"operate");
    	removeCookie(request,response,"userMap");
    	removeCookie(request,response,"No");
    }
	
	/**
	 * ���Cookie
	 * @param request
	 * @param name
	 * @return
	 * @author whz
	 */
	public static Cookie getCookieByName(HttpServletRequest request,String name){
		Map<String,Cookie> cookieMap = ReadCookieMap(request);
		if(cookieMap.containsKey(name)){
			Cookie cookie = cookieMap.get(name);
			return cookie;
		}else{
			return null;
		} 
	}
	
	
	
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
		Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
		Cookie[] cookies = request.getCookies();
		if(null!=cookies){
			for(Cookie cookie : cookies){
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	} 


}
