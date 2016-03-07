package org.izhong.web.util;

import org.codehaus.xfire.transport.http.XFireServletController;

public class Tools {
	
	/**
	 * 获得客户端的IP地址
	 * @return
	 * @author whz
	 */
	public static String getIp()
	{
		return XFireServletController.getRequest().getRemoteAddr();
	}
}
