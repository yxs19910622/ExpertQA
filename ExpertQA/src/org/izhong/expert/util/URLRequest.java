package org.izhong.expert.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class URLRequest {
	
	public String getContentByUrl(String urlAddress, String encoding, String parameters){		
		HttpClient client = new HttpClient();
        String response = null;
        String keyword = null;
        PostMethod postMethod = new PostMethod(urlAddress);
//        try {
//            if (parameters != null)
//                keyword = new String(parameters("gb2312"), "ISO-8859-1");
//        } catch (UnsupportedEncodingException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }

        // NameValuePair[] data = { new NameValuePair("keyword", keyword) };
        // // 将表单的值放入postMethod中
        // postMethod.setRequestBody(data);
        //    以上部分是带参数抓取,我自己把它注销了．大家可以把注销消掉研究下         

        try {
            int statusCode = client.executeMethod(postMethod);
            response = new String(postMethod.getResponseBodyAsString()
                    .getBytes(encoding), "utf-8");//这里要注意下 encoding要和你抓取网页的编码要一样
            response = response.replaceAll("\n","");
            response = response.replaceAll("\r","");
            //String p = response;
            //p = response.replaceAll("\\&[a-zA-Z]{1,10};", "").
            //p = response.replaceAll("\n\n", "");
            //replaceAll("<[^>]*>", ""); = 去掉网页中带有html语言的标签

        } catch (Exception e) {

            e.printStackTrace();
        }
        return response;
	}
	
	/**
	 * 获取指定URL地址的内容，
	 * @param urlAddress
	 * @return
	 */
	public String getContentByUrl(String urlAddress){
        StringBuffer sTotalString = new StringBuffer("");
        String sCurrentLine = "";
		try {			
            java.io.InputStream l_urlStream;
            java.net.URL l_url = new java.net.URL(urlAddress);
            java.net.HttpURLConnection l_connection = (java.net.HttpURLConnection) l_url.openConnection();
            l_connection.connect();
            l_urlStream = l_connection.getInputStream();
            java.io.BufferedReader l_reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(l_urlStream));
            while ((sCurrentLine = l_reader.readLine()) != null) {
                sTotalString.append(sCurrentLine);
            }           
         } catch(IOException e) {  
        	 e.printStackTrace();  
         }  
		
		return sTotalString.toString();
	}
	/**
	 * 获取指定URL地址的内容，
	 * @param urlAddress HTTP地址
	 * @param urlEncoding 编码
	 * @return
	 */
	public String getContentByUrl(String urlAddress, String urlEncoding){
		return getContentByUrl(urlAddress,"utf-8","");
	}
}
