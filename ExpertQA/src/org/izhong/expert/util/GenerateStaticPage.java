package org.izhong.expert.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GenerateStaticPage {

	public static void convert2Html(String sSourceUrl, String sDestDir,   
			String sHtmlFile) throws IOException {   
		int HttpResult;   
		URL url = new URL(sSourceUrl);   
		URLConnection urlconn = url.openConnection();   
		urlconn.connect();   
		HttpURLConnection httpconn = (HttpURLConnection) urlconn;   
		HttpResult = httpconn.getResponseCode();   
		if (HttpResult != HttpURLConnection.HTTP_OK) {   

		} else {   
			InputStreamReader isr = new InputStreamReader(httpconn   
					.getInputStream(), "GB2312");   
			BufferedReader in = new BufferedReader(isr);   

			String inputLine;   
			if (!sDestDir.endsWith("/"))   
				sDestDir += "/";   
			FileOutputStream fout = new FileOutputStream(sDestDir + sHtmlFile);   
			while ((inputLine = in.readLine()) != null) {   
				fout.write(inputLine.getBytes());   

			}   
			in.close();   
			fout.close();   
		}   
	}
	public static void main(String[] args) {
		
	}
}
