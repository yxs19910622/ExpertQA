package org.izhong.web.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.izhong.expert.model.DocumentInfos;
import org.izhong.expert.model.QuestionQueryResultObj;
import org.izhong.expert.model.SYS_AccessLog;
import org.izhong.expert.model.SYS_TryDocument;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.SystemInfos;
import org.izhong.expert.util.DateUtil;
import org.izhong.web.model.DownloadFileItem;
import org.izhong.web.model.DownloadPackage;
import org.izhong.web.util.ArgumentNullException;
import org.izhong.web.util.SevenZipCompression;

public class ExpertService{
	protected Logger log = Logger.getLogger(getClass());
	
	private ExpertServiceImpl impl;
	
	public ExpertService() {
		this.impl = new ExpertServiceImpl();
	}
	
	public boolean TestConnection() {
        return true;
    }
		 
	/**
	 * 批量添加 SYS_ACCESSLOGS
	 * @param connectParamPack
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public boolean AddAccessLogs(DownloadPackage connectParamPack) throws DocumentException, IOException
	{
		log.warn("AddClientAccessLogs:connectParamPack:"+connectParamPack);	
		
		DownloadFileItem connectionitem = null;
        DownloadFileItem accesslogitem = null;
		for (int i = 0; i < connectParamPack.getCount(); i++) {
        	if("UserInfo".equals(connectParamPack.getItems()[i].getItemName()))
        	{
        		connectionitem = connectParamPack.getItems()[i];
        	}
        	else if("AccessLogs".equals(connectParamPack.getItems()[i].getItemName())){
        		accesslogitem = connectParamPack.getItems()[i];
        	}
        }
		Element element = SevenZipCompression.Decompression(connectionitem);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectname = element.element("ProjectName").getText();
		String username = element.element("UserName").getText();
		String userState = element.element("UserState").getText();
		
		List<SYS_AccessLog> accessLogs = new ArrayList<SYS_AccessLog>();		
		Element accesslogs = SevenZipCompression.Decompression(accesslogitem);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Element> els = accesslogs.elements();
		int size = els.size();
		for(int i=0;i<size;i++)
		{
			SYS_AccessLog o = new SYS_AccessLog();

			Element el = els.get(i);
			o.setTid(0);
			o.setCurrentUserState(userState);
			o.setOperatUserState(userState);
			o.setLoginName(loginName);
			o.setUserName(username);
			o.setDeviceSerial(deviceSN);			
			o.setOperationType(el.attribute("OperationType").getText());
			o.setOperationArea(el.attribute("OperationArea").getText());	
			try
			{
				o.setOperationDate(df.parse(el.attribute("OperationDate").getText()));						
			}catch(Exception e) { }
			o.setCreateTime(Calendar.getInstance().getTime());
			o.setProjectName(projectname);
			
			accessLogs.add(o);
		}
		return this.impl.AddClientAccessLogs(loginName, password, deviceSN, projectname, accessLogs);
	}
	/**
	 * 批量添加登录日志־
	 * Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [ProjectName][/ProjectName]
     * [AccessLogs]
     * [Item CreateTime="" Description="" /]
     * [Item CreateTime="" Description="" /]
     * [AccessLogs]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 */
	public boolean AddClientAccessLog(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		String description = element.element("Description").getText();
		
		return impl.AddClientAccessLog(loginName, password, deviceSN, projectName, description);
	}
	
	public boolean AddClientAccessLogs(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException, ParseException
	{
		if(connectParamPack==null || connectParamPack.getCount()==0)
		{
			return false;
		}
		
		DownloadFileItem connectionitem = null;
        DownloadFileItem accountLogitem = null;
        
        for (int i = 0; i < connectParamPack.getCount(); i++) {
        	if("UserInfo".equals(connectParamPack.getItems()[i].getItemName()))
        	{
        		connectionitem = connectParamPack.getItems()[i];
        	}
        	else if("AccessLogs".equals(connectParamPack.getItems()[i].getItemName())){
        		accountLogitem = connectParamPack.getItems()[i];
        	}
        }
		Element element = SevenZipCompression.Decompression(connectionitem);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		Element accessLogEl = SevenZipCompression.Decompression(accountLogitem);
        Map<Date, String> map = new HashMap<Date, String>();
        List<Element> lstLogs = accessLogEl.elements();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int count = lstLogs.size();
        for (int i = 0; i < count; i++) {
			map.put(df.parse(lstLogs.get(i).attribute("CreateTime").getText()), lstLogs.get(i).attribute("Description").getText());
		}
		return impl.AddClientAccessLogs(loginName, password, deviceSN, projectName, map);
	}
	
	/**
	 * 获取系统当前时间
	 * Xml格式
     *[Root]
     *[LoginName][/LoginName]
     *[PassWord][/PassWord]
     *[DeviceSN][/DeviceSN]
     *[/Root]
     * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 */
	@Deprecated
	public long GetSystemDataTime(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		log.warn("GetSystemDataTime:connectParamPack:"+connectParamPack);
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		
		return impl.GetSystemDataTime(loginName, password, deviceSN);
	}
	
	public long GetSystemDateTime(DownloadPackage connectParamPack) throws DocumentException, IOException
	{
		log.warn("GetSystemDataTime:connectParamPack:"+connectParamPack);
		
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectname = element.element("ProjectName").getText();
		
		return impl.GetSystemDateTime(loginName, password, deviceSN, projectname);
	}
	
	/**
	 * 验证用户首次登录
	 * Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 */
	public DownloadPackage VerifyFirstLogin(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		
		SysUsers sysuser = impl.VerifyFirstLogin(loginName, password, deviceSN);
		
		Element result = DocumentHelper.createElement("Root");
		
		
		//
		// TODO:此处代码为补救代码，在程序更新后删除即可。（sht）
		//
		String tryStartDate = DateUtil.formatDate(sysuser.getTryStartDate());
		String tryEndDate = DateUtil.formatDate(sysuser.getTryEndDate());
		String serviceStartDate = DateUtil.formatDate(sysuser.getServiceStartDate());
		String serviceEndDate = DateUtil.formatDate(sysuser.getServiceEndDate());
		if(((serviceStartDate.isEmpty() == false)&&(serviceEndDate.isEmpty() == false))
				&&((tryStartDate.isEmpty() == true)&&(tryEndDate.isEmpty() == true)))
		{
			tryStartDate = serviceStartDate;
			tryEndDate = serviceEndDate;
		}
		result.addElement("TryStartDate").addText(tryStartDate);
		result.addElement("TryEndDate").addText(tryEndDate);
		result.addElement("ServiceStartDate").addText(serviceStartDate);
		result.addElement("ServiceEndDate").addText(serviceEndDate);	
		/* 上面删除后，此处需打开。
		 * result.addElement("TryStartDate").addText(tryStartDate);
		 * result.addElement("TryEndDate").addText(tryEndDate);
		 * result.addElement("ServiceStartDate").addText(serviceStartDate);
		 * result.addElement("ServiceEndDate").addText(serviceEndDate);
		 */
		result.addElement("ExpireRemindDays").addText(String.valueOf(sysuser.getExpireRemindDays()));
		
		return SevenZipCompression.Compression("Items",result);
	}
	
	/**
	 * 实现用户自动登录功能，打开专家问答页面
	 * Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 */
	public boolean VerifyUser(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		
		boolean verifyResult = impl.VerifyUser(loginName, password, deviceSN);
		if(verifyResult == true)
		{
			//TODO:
		}
		return verifyResult;
	}
	
	public boolean VerifyUser2(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		boolean verifyResult = impl.VerifyUser2(loginName, password, deviceSN, projectName);
		if(verifyResult == true)
		{
			//TODO:
		}
		return verifyResult;
	}

	public boolean IsPrepareTryEnd(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();		

		boolean isunregisteruser = impl.IsPrepareTryEnd(deviceSN, projectName);
		return isunregisteruser;
	}
	
	public boolean IsTryEnd(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();

		boolean isunregisteruser = impl.IsTryEnd(loginName, password, deviceSN, projectName);
		return isunregisteruser;
	}
	
	public boolean IsPayEnd(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();

		boolean isunregisteruser = impl.IsPayEnd(loginName, password, deviceSN, projectName);
		return isunregisteruser;
	}
	
	public boolean IsRepeatLogin(DownloadPackage connectParamPack) throws Exception
	{
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();

		boolean isunregisteruser = impl.IsRepeatLogin(loginName, password, deviceSN, projectName);
		return isunregisteruser;
	}
	
	public boolean Logout(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		boolean logoutresult = impl.Logout(loginName, password, deviceSN, projectName);
		return logoutresult;
	}
	
	/**
	 * 判断用户的问题是否存在新回复
	 * Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [ProjectName][/ProjectName]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 */
	public boolean IsExistsUserNewReply(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		return impl.IsExistsUserNewReply(loginName, password, deviceSN, projectName);
	}
	
	/**
	 * 下载用户信息
	 * Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [ProjectName][/ProjectName]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 */
	public DownloadPackage DownloadUserInfo(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();

		SysUsers sysuser = impl.GetUserInfo(loginName, password, deviceSN);
		
		Element result = DocumentHelper.createElement("Root");
		
		//
		// TODO:此处代码为补救代码，在程序更新后删除即可。（sht）
		//
		String tryStartDate = DateUtil.formatDate(sysuser.getTryStartDate());
		String tryEndDate = DateUtil.formatDate(sysuser.getTryEndDate());
		String serviceStartDate = DateUtil.formatDate(sysuser.getServiceStartDate());
		String serviceEndDate = DateUtil.formatDate(sysuser.getServiceEndDate());
		if(((serviceStartDate.isEmpty() == false)&&(serviceEndDate.isEmpty() == false))
				&&((tryStartDate.isEmpty() == true)&&(tryEndDate.isEmpty() == true)))
		{
			tryStartDate = serviceStartDate;
			tryEndDate = serviceEndDate;
		}
		result.addElement("TryStartDate").addText(tryStartDate);
		result.addElement("TryEndDate").addText(tryEndDate);
		result.addElement("ServiceStartDate").addText(serviceStartDate);
		result.addElement("ServiceEndDate").addText(serviceEndDate);	
		/* 上面删除后，此处需打开。
		 * result.addElement("TryStartDate").addText(tryStartDate);
		 * result.addElement("TryEndDate").addText(tryEndDate);
		 * result.addElement("ServiceStartDate").addText(serviceStartDate);
		 * result.addElement("ServiceEndDate").addText(serviceEndDate);
		 */
		
		result.addElement("ExpireRemindDays").addText(String.valueOf(sysuser.getExpireRemindDays()));
		return SevenZipCompression.Compression("Items", result);
	}
	
	public DownloadPackage DownloadUserInfo2(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		Element sysuserEl = impl.GetUserInfo2(loginName, password, deviceSN, projectName);
		return SevenZipCompression.Compression("Items", sysuserEl);
	}
	
	/**
	 * 下载系统文件列表信息
	 * Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [ProjectName][/ProjectName]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 */
	public DownloadPackage DownloadSystemInfos(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();		
		List<SystemInfos> lstSystemInfo = impl.GetSystemInfos(loginName, password, deviceSN, projectName);
		Element rootEl = DocumentHelper.createElement("Root");
		for (int i = 0; i < lstSystemInfo.size(); i++) {
			SystemInfos info = lstSystemInfo.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("DocumentID", info.getDocumentID());
			bodyEl.addAttribute("Date", DateUtil.formatDate(info.getDocumentDate()));
			//注意此处与DownloadDocumentInfos中相同位置处理略有不同
			//因为需要处理多版本问题，故到客户端的文件名称不一致
			bodyEl.addAttribute("Location", info.getTitle() + info.getFileExtension());
			bodyEl.addAttribute("Version", info.getVersion());
			bodyEl.addAttribute("DeleteStatus", info.getDeleteStatus());
			rootEl.add(bodyEl);
		}
		return SevenZipCompression.Compression("Items", rootEl);
	}

	/**
	 * 下载资源文件列表信息
	 *  Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [ProjectName][/ProjectName]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 */
	public DownloadPackage DownloadDocumentInfos(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException {
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();

		List<DocumentInfos> lstDocumsntInfo= impl.GetDocumentInfos(loginName, password, deviceSN, projectName);
		Element rootEl = DocumentHelper.createElement("Root");
		for (int i = 0; i < lstDocumsntInfo.size(); i++) {
			DocumentInfos info = lstDocumsntInfo.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("DocumentID", info.getDocumentID());
			bodyEl.addAttribute("Date", DateUtil.formatDate(info.getDocumentDate()));
			bodyEl.addAttribute("Location", info.getLocation());//.replace("\\", "\\\\"));
			bodyEl.addAttribute("Version", info.getVersion());
			bodyEl.addAttribute("DeleteStatus", info.getDeleteStatus());
			rootEl.add(bodyEl);
		}
		return SevenZipCompression.Compression("Items", rootEl);
	}
	
	/**
	 * 下载指定比较后的待更新系统文件包
	 * Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [ProjectName][/ProjectName]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ArgumentNullException 
	 * @throws ParseException 
	 */
	public DownloadPackage DownloadSystemFiles(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException, ParseException {		
		if(connectParamPack==null || connectParamPack.getCount()==0)
		{
			DownloadPackage dpk = new DownloadPackage();
			dpk.setItems(new DownloadFileItem[0]);
			dpk.setCount(0);
			return dpk;
		}
		
		DownloadFileItem connectionitem = null;
        DownloadFileItem userFiles = null;
        
        for (int i = 0; i < connectParamPack.getCount(); i++) {
        	if("UserInfo".equals(connectParamPack.getItems()[i].getItemName()))
        	{
        		connectionitem = connectParamPack.getItems()[i];
        	}
        	else if("FileInfo".equals(connectParamPack.getItems()[i].getItemName())){
        		userFiles = connectParamPack.getItems()[i];
        	}
        }
        
        Element element = SevenZipCompression.Decompression(connectionitem);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		Element userfileEl = SevenZipCompression.Decompression(userFiles);
		Object [] result = impl.GetSystemFiles(loginName, password, deviceSN, projectName, userfileEl);
		
		List<String> fileIDs = (List<String>)result[0];
		List<String> fileLocationsa = (List<String>)result[1];
		List<SystemInfos> lstSystemInfo= (List<SystemInfos>)result[2];
		Element rootEl = DocumentHelper.createElement("Root");
		if(lstSystemInfo==null)
		{
			new ArgumentNullException("DownloadSystemFile Data Size = 0");
		}
		for (int i = 0; i < lstSystemInfo.size(); i++) {
			SystemInfos info = lstSystemInfo.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("DocumentID", info.getDocumentID());
			bodyEl.addAttribute("Title", ((info.getTitle() == null) ? "" :  info.getTitle()));
			bodyEl.addAttribute("Creator", ((info.getCreator() == null) ? "" :  info.getCreator()));
			bodyEl.addAttribute("Subject", ((info.getSubject() == null) ? "" :  info.getSubject()));
			bodyEl.addAttribute("Description", ((info.getDescription() == null) ? "" :  info.getDescription()));
			bodyEl.addAttribute("Publisher", ((info.getPublisher() == null) ? "" :  info.getPublisher()));
			bodyEl.addAttribute("Contributor", ((info.getContributor() == null) ? "" :  info.getContributor()));
			bodyEl.addAttribute("Date", DateUtil.formatDate(info.getDocumentDate()));
			bodyEl.addAttribute("Type", ((info.getType() == null) ? "" :  info.getType()));
			bodyEl.addAttribute("Format", ((info.getFormat() == null) ? "" :  info.getFormat()));
			bodyEl.addAttribute("Identifier", ((info.getIdentifier() == null) ? "" :  info.getIdentifier()));
			bodyEl.addAttribute("Source", ((info.getSource() == null) ? "" :  info.getSource()));
			bodyEl.addAttribute("Language", ((info.getLanguage() == null) ? "" :  info.getLanguage()));
			bodyEl.addAttribute("Relation", ((info.getRelation() == null) ? "" :  info.getRelation()));
			bodyEl.addAttribute("Coverage", ((info.getCoverage() == null) ? "" :  info.getCoverage()));
			bodyEl.addAttribute("Rights", ((info.getRights() == null) ? "" :  info.getRights()));
			bodyEl.addAttribute("MD5", ((info.getMd5() == null) ? "" :  info.getMd5()));
			//特殊处理，因应相同文件名称多版本问题
			bodyEl.addAttribute("Location", info.getTitle() + info.getFileExtension());//((info.getLocation() == null) ? "" :  info.getLocation()));
			bodyEl.addAttribute("Version", ((info.getVersion() == null) ? "" :  info.getVersion()));
			bodyEl.addAttribute("FileExtension", ((info.getFileExtension() == null) ? "" :  info.getFileExtension()));
			rootEl.add(bodyEl);
		}
		return SevenZipCompression.Compression("SysInfos", rootEl, fileIDs, fileLocationsa);
	}
	
	/**
	 * 下载指定比较后的待更新资源文件包
	 * Xml格式
     * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [ProjectName][/ProjectName]
     * [/Root]
	 * @param connectParamPack
	 * @return
	 * @author whz
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws ArgumentNullException 
	 */
	public DownloadPackage DownloadDocumentFiles(DownloadPackage connectParamPack) throws IOException, DocumentException, ArgumentNullException, ParseException {
		if(connectParamPack==null || connectParamPack.getCount()==0)
		{
			DownloadPackage dpk = new DownloadPackage();
			dpk.setItems(new DownloadFileItem[0]);
			dpk.setCount(0);
			return dpk;
		}
		
		DownloadFileItem connectionitem = null;
        DownloadFileItem userFiles = null;
		
		for (int i = 0; i < connectParamPack.getCount(); i++) {
        	if("UserInfo".equals(connectParamPack.getItems()[i].getItemName()))
        	{
        		connectionitem = connectParamPack.getItems()[i];
        	}
        	else if("FileInfo".equals(connectParamPack.getItems()[i].getItemName())){
        		userFiles = connectParamPack.getItems()[i];
        	}
        }        
        Element element = SevenZipCompression.Decompression(connectionitem);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		Element userfileEl = SevenZipCompression.Decompression(userFiles);
		Object [] result = impl.GetDocumentFiles(loginName, password, deviceSN, projectName, userfileEl);
		if(result==null)
		{
			new ArgumentNullException("DownloadDocument Data Size = 0");
		}
		List<String> fileIDs = (List<String>)result[0];
		List<String> fileLocations = (List<String>)result[1];
		List<DocumentInfos> lstSystemInfo = (List<DocumentInfos>)result[2];
		Element rootEl = DocumentHelper.createElement("Root");
		for (int i = 0; i < lstSystemInfo.size(); i++) {
			DocumentInfos info = lstSystemInfo.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("DocumentID", info.getDocumentID());
			bodyEl.addAttribute("Title", ((info.getTitle() == null) ? "" :  info.getTitle()));
			bodyEl.addAttribute("Creator", ((info.getCreator() == null) ? "" :  info.getCreator()));
			bodyEl.addAttribute("Subject", ((info.getSubject() == null) ? "" :  info.getSubject()));
			bodyEl.addAttribute("Description", ((info.getDescription() == null) ? "" :  info.getDescription()));
			bodyEl.addAttribute("Publisher", ((info.getPublisher() == null) ? "" :  info.getPublisher()));
			bodyEl.addAttribute("Contributor", ((info.getContributor() == null) ? "" :  info.getContributor()));
			bodyEl.addAttribute("Date", DateUtil.formatDate(info.getDocumentDate()));
			bodyEl.addAttribute("Type", ((info.getType() == null) ? "" :  info.getType()));
			bodyEl.addAttribute("Format", ((info.getFormat() == null) ? "" :  info.getFormat()));
			bodyEl.addAttribute("Identifier", ((info.getIdentifier() == null) ? "" :  info.getIdentifier()));
			bodyEl.addAttribute("Source", ((info.getSource() == null) ? "" :  info.getSource()));
			bodyEl.addAttribute("Language", ((info.getLanguage() == null) ? "" :  info.getLanguage()));
			bodyEl.addAttribute("Relation", ((info.getRelation() == null) ? "" :  info.getRelation()));
			bodyEl.addAttribute("Coverage", ((info.getCoverage() == null) ? "" :  info.getCoverage()));
			bodyEl.addAttribute("Rights", ((info.getRights() == null) ? "" :  info.getRights()));
			bodyEl.addAttribute("MD5", ((info.getMd5() == null) ? "" :  info.getMd5()));
			bodyEl.addAttribute("Location", ((info.getLocation() == null) ? "" :  info.getLocation()));
			bodyEl.addAttribute("Version", ((info.getVersion() == null) ? "" :  info.getVersion()));
			bodyEl.addAttribute("FileExtension", ((info.getFileExtension() == null) ? "" :  info.getFileExtension()));
			rootEl.add(bodyEl);
		}
		return SevenZipCompression.Compression("DocInfos", rootEl, fileIDs, fileLocations);
	}
	
	public DownloadPackage DownloadUpdateTableInfos(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();

		Element updateTableInfo = impl.GetUpdateTableInfos(loginName, password, deviceSN, projectName);
		return SevenZipCompression.Compression("UpdateTableInfo", updateTableInfo);
	}
	
	public DownloadPackage DownloadUpdateTableData(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
		Element userEl = null;
		Element updateEl = null;
		for(int i=0;i<connectParamPack.getCount();i++)
		{
			String itemName = connectParamPack.getItems()[i].getItemName();
			if("UserInfo".equals(itemName))
			{
				userEl = SevenZipCompression.Decompression(connectParamPack.getItems()[i]);			
			}
			else if("UpdateTableInfo".equals(itemName))
			{
				updateEl = SevenZipCompression.Decompression(connectParamPack.getItems()[i]);			
			}
		}
		
		String loginName = userEl.element("LoginName").getText();
		String password = userEl.element("PassWord").getText();
		String deviceSN = userEl.element("DeviceSN").getText();
		String projectName = userEl.element("ProjectName").getText();
				
		Element updateTableInfo = impl.GetUpdateTableData(loginName, password, deviceSN, projectName, updateEl);
		return SevenZipCompression.Compression("UpdateTableData", updateTableInfo);
	}
	
	public DownloadPackage DownloadAnnouncementInfo(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();

		Element updateTableInfo = impl.GetAnnouncementInfo(loginName, password, deviceSN, projectName);
		return SevenZipCompression.Compression("AnnouncementInfo", updateTableInfo);
	}
	   
//	{{ 下载文件
	/*
	 * 下载用户公告信息，数据来源于RES_UserAnnouncementInfo表
	 */
	public DownloadPackage DownloadUserAnnouncementInfo(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
		Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		Element announcementInfo = impl.GetUserAnnouncementInfo(loginName, password, deviceSN, projectName);
		return SevenZipCompression.Compression("AnnouncementInfo", announcementInfo);
	}
	
	/*
	 * 下载指定文件编号的文件
	 * XML格式
	 * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [/Root]
	 */
	public DownloadPackage DownloadSingleNodeFiles(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
        Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		String cataogNodeID = element.element("CatalogNodeID").getText();
		
		Object [] result = impl.GetDownloadSingleNodeFile(loginName, password, deviceSN, projectName, cataogNodeID);
		if(result==null)
		{
			new ArgumentNullException("DownloadDocument Data Size = 0");
		}
		List<String> fileIDs = (List<String>)result[0];
		List<String> fileLocations = (List<String>)result[1];
		List<DocumentInfos> lstSystemInfo = (List<DocumentInfos>)result[2];
		Element rootEl = DocumentHelper.createElement("Root");
		for (int i = 0; i < lstSystemInfo.size(); i++) {
			DocumentInfos info = lstSystemInfo.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("DocumentID", info.getDocumentID());
			bodyEl.addAttribute("Title", ((info.getTitle() == null) ? "" :  info.getTitle()));
			bodyEl.addAttribute("Creator", ((info.getCreator() == null) ? "" :  info.getCreator()));
			bodyEl.addAttribute("Subject", ((info.getSubject() == null) ? "" :  info.getSubject()));
			bodyEl.addAttribute("Description", ((info.getDescription() == null) ? "" :  info.getDescription()));
			bodyEl.addAttribute("Publisher", ((info.getPublisher() == null) ? "" :  info.getPublisher()));
			bodyEl.addAttribute("Contributor", ((info.getContributor() == null) ? "" :  info.getContributor()));
			bodyEl.addAttribute("Date", DateUtil.formatDate(info.getDocumentDate()));
			bodyEl.addAttribute("Type", ((info.getType() == null) ? "" :  info.getType()));
			bodyEl.addAttribute("Format", ((info.getFormat() == null) ? "" :  info.getFormat()));
			bodyEl.addAttribute("Identifier", ((info.getIdentifier() == null) ? "" :  info.getIdentifier()));
			bodyEl.addAttribute("Source", ((info.getSource() == null) ? "" :  info.getSource()));
			bodyEl.addAttribute("Language", ((info.getLanguage() == null) ? "" :  info.getLanguage()));
			bodyEl.addAttribute("Relation", ((info.getRelation() == null) ? "" :  info.getRelation()));
			bodyEl.addAttribute("Coverage", ((info.getCoverage() == null) ? "" :  info.getCoverage()));
			bodyEl.addAttribute("Rights", ((info.getRights() == null) ? "" :  info.getRights()));
			bodyEl.addAttribute("MD5", ((info.getMd5() == null) ? "" :  info.getMd5()));
			bodyEl.addAttribute("Location", ((info.getLocation() == null) ? "" :  info.getLocation()));
			bodyEl.addAttribute("Version", ((info.getVersion() == null) ? "" :  info.getVersion()));
			bodyEl.addAttribute("FileExtension", ((info.getFileExtension() == null) ? "" :  info.getFileExtension()));
			rootEl.add(bodyEl);
		}
		return SevenZipCompression.Compression("DocInfos", rootEl, fileIDs, fileLocations);
	}
	/*
	 * 下载法律法规的XML文档
	 * XML格式
	 * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [/Root]
	 */
	public DownloadPackage DownloadLawXmlDocuments(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
        Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();

		Object [] result = impl.GetDownloadLawXmlDocuments(loginName, password, deviceSN, projectName);
		if(result==null)
		{
			new ArgumentNullException("DownloadDocument Data Size = 0");
		}
		List<String> fileIDs = (List<String>)result[0];
		List<String> fileLocations = (List<String>)result[1];
		List<DocumentInfos> lstSystemInfo = (List<DocumentInfos>)result[2];
		Element rootEl = DocumentHelper.createElement("Root");
		for (int i = 0; i < lstSystemInfo.size(); i++) {
			DocumentInfos info = lstSystemInfo.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("DocumentID", info.getDocumentID());
			bodyEl.addAttribute("Title", ((info.getTitle() == null) ? "" :  info.getTitle()));
			bodyEl.addAttribute("Creator", ((info.getCreator() == null) ? "" :  info.getCreator()));
			bodyEl.addAttribute("Subject", ((info.getSubject() == null) ? "" :  info.getSubject()));
			bodyEl.addAttribute("Description", ((info.getDescription() == null) ? "" :  info.getDescription()));
			bodyEl.addAttribute("Publisher", ((info.getPublisher() == null) ? "" :  info.getPublisher()));
			bodyEl.addAttribute("Contributor", ((info.getContributor() == null) ? "" :  info.getContributor()));
			bodyEl.addAttribute("Date", DateUtil.formatDate(info.getDocumentDate()));
			bodyEl.addAttribute("Type", ((info.getType() == null) ? "" :  info.getType()));
			bodyEl.addAttribute("Format", ((info.getFormat() == null) ? "" :  info.getFormat()));
			bodyEl.addAttribute("Identifier", ((info.getIdentifier() == null) ? "" :  info.getIdentifier()));
			bodyEl.addAttribute("Source", ((info.getSource() == null) ? "" :  info.getSource()));
			bodyEl.addAttribute("Language", ((info.getLanguage() == null) ? "" :  info.getLanguage()));
			bodyEl.addAttribute("Relation", ((info.getRelation() == null) ? "" :  info.getRelation()));
			bodyEl.addAttribute("Coverage", ((info.getCoverage() == null) ? "" :  info.getCoverage()));
			bodyEl.addAttribute("Rights", ((info.getRights() == null) ? "" :  info.getRights()));
			bodyEl.addAttribute("MD5", ((info.getMd5() == null) ? "" :  info.getMd5()));
			bodyEl.addAttribute("Location", ((info.getLocation() == null) ? "" :  info.getLocation()));
			bodyEl.addAttribute("Version", ((info.getVersion() == null) ? "" :  info.getVersion()));
			bodyEl.addAttribute("FileExtension", ((info.getFileExtension() == null) ? "" :  info.getFileExtension()));
			rootEl.add(bodyEl);
		}	
		return SevenZipCompression.Compression("DocInfos", rootEl, fileIDs, fileLocations);
	}
	/*	
     * 首次登录之后下载试看文件（当前为劳动合同部分的问答及法规类文件）
	 * XML格式
	 * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [/Root]
	 */
	public DownloadPackage DownloadTryDocuments(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
        Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();

		Object [] result = impl.GetDownloadTryDocuments(loginName, password, deviceSN, projectName);
		if(result==null)
		{
			new ArgumentNullException("DownloadDocument Data Size = 0");
		}
		List<String> fileIDs = (List<String>)result[0];
		List<String> fileLocations = (List<String>)result[1];
		List<DocumentInfos> lstSystemInfo = (List<DocumentInfos>)result[2];
		Element rootEl = DocumentHelper.createElement("Root");
		for (int i = 0; i < lstSystemInfo.size(); i++) {
			DocumentInfos info = lstSystemInfo.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("DocumentID", info.getDocumentID());
			bodyEl.addAttribute("Title", ((info.getTitle() == null) ? "" :  info.getTitle()));
			bodyEl.addAttribute("Creator", ((info.getCreator() == null) ? "" :  info.getCreator()));
			bodyEl.addAttribute("Subject", ((info.getSubject() == null) ? "" :  info.getSubject()));
			bodyEl.addAttribute("Description", ((info.getDescription() == null) ? "" :  info.getDescription()));
			bodyEl.addAttribute("Publisher", ((info.getPublisher() == null) ? "" :  info.getPublisher()));
			bodyEl.addAttribute("Contributor", ((info.getContributor() == null) ? "" :  info.getContributor()));
			bodyEl.addAttribute("Date", DateUtil.formatDate(info.getDocumentDate()));
			bodyEl.addAttribute("Type", ((info.getType() == null) ? "" :  info.getType()));
			bodyEl.addAttribute("Format", ((info.getFormat() == null) ? "" :  info.getFormat()));
			bodyEl.addAttribute("Identifier", ((info.getIdentifier() == null) ? "" :  info.getIdentifier()));
			bodyEl.addAttribute("Source", ((info.getSource() == null) ? "" :  info.getSource()));
			bodyEl.addAttribute("Language", ((info.getLanguage() == null) ? "" :  info.getLanguage()));
			bodyEl.addAttribute("Relation", ((info.getRelation() == null) ? "" :  info.getRelation()));
			bodyEl.addAttribute("Coverage", ((info.getCoverage() == null) ? "" :  info.getCoverage()));
			bodyEl.addAttribute("Rights", ((info.getRights() == null) ? "" :  info.getRights()));
			bodyEl.addAttribute("MD5", ((info.getMd5() == null) ? "" :  info.getMd5()));
			bodyEl.addAttribute("Location", ((info.getLocation() == null) ? "" :  info.getLocation()));
			bodyEl.addAttribute("Version", ((info.getVersion() == null) ? "" :  info.getVersion()));
			bodyEl.addAttribute("FileExtension", ((info.getFileExtension() == null) ? "" :  info.getFileExtension()));
			rootEl.add(bodyEl);
		}	
		List<SYS_TryDocument> lstTryDocuments = (List<SYS_TryDocument>)result[3];		
		Element rootEl2 = DocumentHelper.createElement("Root");
		for(int i=0;i<lstTryDocuments.size();i++)
		{
			SYS_TryDocument document = lstTryDocuments.get(i);
			
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("CatalogNodeID", document.getCatalogNodeID());
			rootEl2.add(bodyEl);
		}
		return SevenZipCompression.Compression("DocInfos", rootEl, "CatalogNodeIDs", rootEl2, fileIDs, fileLocations);
	}
	/*
	 * 批量下载指资源编号组的文件组
	 * XML格式
	 * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [/Root]
	 */
	public DownloadPackage DownloadMultiNodeFiles(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
		if(connectParamPack==null || connectParamPack.getCount()==0)
		{
			DownloadPackage dpk = new DownloadPackage();
			dpk.setItems(new DownloadFileItem[0]);
			dpk.setCount(0);
			return dpk;
		}
		
		DownloadFileItem connectionitem = null;
        DownloadFileItem userFiles = null;
		
		for (int i = 0; i < connectParamPack.getCount(); i++) {
        	if("UserInfo".equals(connectParamPack.getItems()[i].getItemName()))
        	{
        		connectionitem = connectParamPack.getItems()[i];
        	}
        	else if("FileInfo".equals(connectParamPack.getItems()[i].getItemName())){
        		userFiles = connectParamPack.getItems()[i];
        	}
        }        
        Element element = SevenZipCompression.Decompression(connectionitem);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		
		Element userfileEl = SevenZipCompression.Decompression(userFiles);
		Object [] result = impl.GetDownloadMultiNodeFiles(loginName, password, deviceSN, projectName, userfileEl);
		if(result==null)
		{
			new ArgumentNullException("DownloadDocument Data Size = 0");
		}
		List<String> fileIDs = (List<String>)result[0];
		List<String> fileLocations = (List<String>)result[1];
		List<DocumentInfos> lstSystemInfo = (List<DocumentInfos>)result[2];
		Element rootEl = DocumentHelper.createElement("Root");
		for (int i = 0; i < lstSystemInfo.size(); i++) {
			DocumentInfos info = lstSystemInfo.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("DocumentID", info.getDocumentID());
			bodyEl.addAttribute("Title", ((info.getTitle() == null) ? "" :  info.getTitle()));
			bodyEl.addAttribute("Creator", ((info.getCreator() == null) ? "" :  info.getCreator()));
			bodyEl.addAttribute("Subject", ((info.getSubject() == null) ? "" :  info.getSubject()));
			bodyEl.addAttribute("Description", ((info.getDescription() == null) ? "" :  info.getDescription()));
			bodyEl.addAttribute("Publisher", ((info.getPublisher() == null) ? "" :  info.getPublisher()));
			bodyEl.addAttribute("Contributor", ((info.getContributor() == null) ? "" :  info.getContributor()));
			bodyEl.addAttribute("Date", DateUtil.formatDate(info.getDocumentDate()));
			bodyEl.addAttribute("Type", ((info.getType() == null) ? "" :  info.getType()));
			bodyEl.addAttribute("Format", ((info.getFormat() == null) ? "" :  info.getFormat()));
			bodyEl.addAttribute("Identifier", ((info.getIdentifier() == null) ? "" :  info.getIdentifier()));
			bodyEl.addAttribute("Source", ((info.getSource() == null) ? "" :  info.getSource()));
			bodyEl.addAttribute("Language", ((info.getLanguage() == null) ? "" :  info.getLanguage()));
			bodyEl.addAttribute("Relation", ((info.getRelation() == null) ? "" :  info.getRelation()));
			bodyEl.addAttribute("Coverage", ((info.getCoverage() == null) ? "" :  info.getCoverage()));
			bodyEl.addAttribute("Rights", ((info.getRights() == null) ? "" :  info.getRights()));
			bodyEl.addAttribute("MD5", ((info.getMd5() == null) ? "" :  info.getMd5()));
			bodyEl.addAttribute("Location", ((info.getLocation() == null) ? "" :  info.getLocation()));
			bodyEl.addAttribute("Version", ((info.getVersion() == null) ? "" :  info.getVersion()));
			bodyEl.addAttribute("FileExtension", ((info.getFileExtension() == null) ? "" :  info.getFileExtension()));
			rootEl.add(bodyEl);
		}
		List<String> lstCatalogNodeIDs = (List<String>)result[3];		
		Element rootEl2 = DocumentHelper.createElement("Root");
		for(int i=0;i<lstCatalogNodeIDs.size();i++)
		{
			String catalognodeid = lstCatalogNodeIDs.get(i);
			
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("CatalogNodeID", catalognodeid);
			rootEl2.add(bodyEl);
		}
		return SevenZipCompression.Compression("DocInfos", rootEl, "CatalogNodeIDs", rootEl2, fileIDs, fileLocations);
	}
	
	/*
	 * 依指定关键字获取专家问答部分的问题列表
	 * XML格式
	 * [Root]
     * [LoginName][/LoginName]
     * [PassWord][/PassWord]
     * [DeviceSN][/DeviceSN]
     * [/Root]
	 */
	public DownloadPackage GetLABQAQuestionList(DownloadPackage connectParamPack) throws DocumentException, IOException, ArgumentNullException
	{
        Element element = SevenZipCompression.Decompression(connectParamPack.getItems()[0]);
		String loginName = element.element("LoginName").getText();
		String password = element.element("PassWord").getText();
		String deviceSN = element.element("DeviceSN").getText();
		String projectName = element.element("ProjectName").getText();
		String questionkey = element.element("QuestionKey").getText();
		
		Object values = impl.GetLABQAQuestionList(loginName, password, deviceSN, projectName, questionkey);
		List<QuestionQueryResultObj> listobj = (List<QuestionQueryResultObj>)values;
		Element questionresult = DocumentHelper.createElement("Root");
		questionresult.addAttribute("QuestionKey", questionkey);
		for(int i=0;i<listobj.size();i++)
		{
			QuestionQueryResultObj resultObj = listobj.get(i);
			
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("CAPTIONTEXT", resultObj.getCaptiontext());
			bodyEl.addAttribute("QUESTIONURL", resultObj.getQuestionID());			
			questionresult.add(bodyEl);
		}
		return SevenZipCompression.Compression("QuestionQueryResultObj", questionresult);
	}
	//}} 下载文件
}