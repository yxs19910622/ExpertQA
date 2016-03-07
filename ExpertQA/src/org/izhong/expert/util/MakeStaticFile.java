package org.izhong.expert.util;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

public class MakeStaticFile {
	
	/**
	 * 生成静态文件（注：要Request的文件不能超过30000字节）
	 * @param request  HttpServletRequest 对象
	 * @param makeFile 要生成的文件
	 * @param jspFile 获取的文件
	 * @param tagContent 静态文件的标识 
	 * @param urlEncoding 请求URL的编码
	 * @param makeFileEncoding 生成文件的编码
	 * @param staticFileMinute >0 按分钟计算 <=0按当天是否生成过计算
	 * @return true=生成了  false=没有生成
	 * @author xie 2010-9-22
	 */
	public boolean make(HttpServletRequest request,String makeFile,String jspFile,String tagContent,String urlEncoding,String makeFileEncoding,int staticFileMinute){
		return make( makeFile, jspFile, tagContent, urlEncoding, makeFileEncoding, staticFileMinute ,request);
	}
	public boolean make(String makeFile,String jspFile,String tagContent,String urlEncoding,String makeFileEncoding,int staticFileMinute ,HttpServletRequest request){
		boolean rtn = false;
		try{		
			String staticFile = request.getSession().getServletContext().getRealPath("/") + makeFile;
			//String staticFile = "/home/xueyuan/webapps/ROOT/" + makeFile; //linux
			FileOperate fop = new FileOperate();
			boolean condition = false;
			if(staticFileMinute > 0){ // 按分钟计算
				condition = fop.isNeedReWriteFile(staticFile,staticFileMinute);
			}else{ //按当是否生成过文件计算
				condition = !fop.isModifiedAtToday(staticFile);
			}
			if(condition) {
			//if(!fop.isModifiedAtToday(staticFile)){//文件如果不是当天生成的
			//if(fop.isNeedReWriteFile(staticFile,1)){ //文件生成1分钟后……
				URLRequest urlrequest = new URLRequest();
				String url = "http://" + request.getServerName() + ":"+request.getLocalPort() + request.getContextPath() + jspFile;
				//String url = "http://127.0.0.1" + jspFile;
				String fileContent = "";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try{
					fileContent = "<!--BEGIN1 "+tagContent + "@" + sdf.format(new java.util.Date() )+ "-->";
					fileContent += urlrequest.getContentByUrl(url,urlEncoding);
					fileContent += "<!--END1-->";
					fileContent = fileContent.replaceAll("\t","");
					fop.createFile(staticFile, fileContent, makeFileEncoding);
					rtn = true;
				}catch(Exception e){
					System.err.println(e);					
				}
			}
		}catch(Exception e){
			System.err.println(e);
		}		
		return rtn;
	}
}
