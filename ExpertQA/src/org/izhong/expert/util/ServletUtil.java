package org.izhong.expert.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ServletUtil {
	
	/**
	 * 
	 * @param response
	 * @param resStr
	 * @author whz
	 */
	public static void writerToClient(HttpServletResponse response, String resStr)
	{
		response.setCharacterEncoding("utf-8");

		PrintWriter writer = null;
		 try {
			 writer = response.getWriter();
			 writer.write(resStr);
			 writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
