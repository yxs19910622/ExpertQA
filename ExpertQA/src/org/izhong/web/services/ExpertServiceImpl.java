package org.izhong.web.services;

import java.lang.invoke.ConstantCallSite;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.text.BoxView;

import org.apache.log4j.Logger;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.izhong.expert.model.CatalogFullTree;
import org.izhong.expert.model.Catalogs;
import org.izhong.expert.model.ClientAccessLogs;
import org.izhong.expert.model.DeviceRegisters;
import org.izhong.expert.model.DocumentInfos;
import org.izhong.expert.model.HypertextLinkExtends;
import org.izhong.expert.model.HypertextLinks;
import org.izhong.expert.model.QuestionLawRefs;
import org.izhong.expert.model.QuestionQueryResultObj;
import org.izhong.expert.model.RES_LawExample;
import org.izhong.expert.model.RES_QuestionExample;
import org.izhong.expert.model.RES_UserAnnouncement;
import org.izhong.expert.model.Replys;
import org.izhong.expert.model.ResQuestions;
import org.izhong.expert.model.SYS_AccessLog;
import org.izhong.expert.model.SYS_TryDocument;
import org.izhong.expert.model.SYS_TryUserDocument;
import org.izhong.expert.model.SYS_UserLoginRecord;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.SystemInfos;
import org.izhong.expert.model.UpdateTableInfos;
import org.izhong.expert.model.UseAccessLogs;
import org.izhong.expert.model.UseTechniqueInfos;
import org.izhong.expert.model.UserProducts;
import org.izhong.expert.service.AccessLogService;
import org.izhong.expert.service.ClientExpertService;
import org.izhong.expert.service.LogsService;
import org.izhong.expert.service.ReplysService;
import org.izhong.expert.service.UserInfoService;
import org.izhong.expert.service.UserService2;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.StringUtil;
import org.izhong.web.model.DownloadPackage;
import org.izhong.web.util.ArgumentNullException;
import org.izhong.web.util.StaticTable;
import org.springframework.util.Assert;

import com.sun.xml.internal.txw2.Document;

import sun.misc.Cleaner;

public class ExpertServiceImpl {
	
	protected Logger log = Logger.getLogger(getClass());
	private AccessLogService accessLogService = InitDao.getInstance().getAccessLogService();
	private UserInfoService userInfoService = InitDao.getInstance().getUserInfoService();
	private ClientExpertService clientExpertService = InitDao.getInstance().getClientExpertService();
	private UserService2 userService2 = InitDao.getInstance().getUserService2();
	private ReplysService replysService = InitDao.getInstance().getReplysService();
	private LogsService logsService = InitDao.getInstance().getLogsService();
	

	//{{公共方法：添加或修改
	
	public boolean AddClientAccessLog(String loginName, String password, String deviceSN, String projectName, String description) throws ArgumentNullException{
		SysUsers sysuser = checkDeviceSN(loginName, password, deviceSN);
		
		ClientAccessLogs acl = new ClientAccessLogs();
		acl.setUserID(sysuser.getUserID());
		acl.setDeviceSerialNumber(deviceSN);
		acl.setProjectName(projectName);
		acl.setCreateTime(DateUtil.getCurrTime());
		acl.setDescription(description);
		clientExpertService.addClientAccessLogs(acl);
		
		return true;
	}
	
	public boolean AddClientAccessLogs(String loginName, String password, String deviceSN, String projectName, Map<Date, String> map) throws ArgumentNullException, ParseException{
		SysUsers sysuser = checkDeviceSN(loginName, password, deviceSN);
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry<Date, String> e = (Map.Entry<Date, String>)iter.next();
			ClientAccessLogs acl = new ClientAccessLogs();
			acl.setUserID(sysuser.getUserID());
			acl.setDeviceSerialNumber(deviceSN);
			acl.setProjectName(projectName);
			acl.setCreateTime(e.getKey());
			acl.setDescription(e.getValue());
			clientExpertService.addClientAccessLogs(acl);
		}
		return true;
	}	

	//}}
	
	//{{公共方法：查询
	
	/**
	 * 
	 * @param loginName
	 * @param password
	 * @param deviceSN
	 * @param projectName
	 * @param accessLogs
	 * @return
	 */
	public boolean AddClientAccessLogs(String loginName, String password, String deviceSN, String projectName, List<SYS_AccessLog> accessLogs)
	{
		if(!accessLogs.isEmpty())
		{
			Calendar ender = Calendar.getInstance();
			long size = accessLogs.size();
			for(int i=0;i<size;i++)
			{
				SYS_AccessLog accessLog = accessLogs.get(i);
				
				//System.out.println(accessLog);
				this.accessLogService.addSYS_AccessLog(accessLog);
				//System.out.println(i + 2);			
			}
			return true;
		}
		return false;
	}
	
	@Deprecated
	public long GetSystemDataTime(String loginName, String password, String deviceSN) throws ArgumentNullException {
		this.checkDeviceSN(loginName, password, deviceSN);
		
		return DateUtil.clientTime();
	}

	public long GetSystemDateTime(String loginName, String password, String deviceSN, String projectname)
	{
		return DateUtil.clientTime();
	}
	
	public SysUsers VerifyFirstLogin(String loginName, String password, String deviceSN) throws ArgumentNullException {
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(password)) //?
		{
			throw new ArgumentNullException("用户名和密码不能为空");
		}
		SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			throw new ArgumentNullException("用户名不存在");
		}
		if(!BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			throw new ArgumentNullException("密码不正确");
		}
		if(BaseUtil.isNotEmpty(sysuser.getDeviceSerialNumber()))
		{
			if(!deviceSN.equals(sysuser.getDeviceSerialNumber()))
			{
				throw new ArgumentNullException("设备未注册");
			}
		}else{
			sysuser.setDeviceSerialNumber(deviceSN);
			userInfoService.modDevice(sysuser);
		}
		return sysuser;
	}

	public boolean VerifyUser(String loginName, String password, String deviceSN) throws ArgumentNullException {
		checkUser(loginName, password, deviceSN);
		return true;
	}

	public boolean VerifyUser2(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(password) || BaseUtil.isEmpty(deviceSN) )
		{
			throw new ArgumentNullException("用户名、密码等不能为空");
		}
		SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			throw new ArgumentNullException("用户名不存在");
		}
		if(!BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			throw new ArgumentNullException("密码不正确");
		}
		//本版1.1不再绑定设备
		Date currentday = DateUtil.getCurrentDay();
		List<UserProducts> products = this.userInfoService.getUserProductsByProNo(projectName, sysuser.getUserID());
		if (!products.isEmpty() && (products.get(0).getServiceEndDate() != null) && (currentday.getTime() <= products.get(0).getServiceEndDate().getTime()))
		{//处于服务期
			
		} else if (sysuser.getTryEndDate() != null)	
		//} else if ((sysuser.getTryEndDate() != null) &&(currentday.getTime() <= sysuser.getTryEndDate().getTime()))			
		{//处于试用期，试用期之外也可以登录
			
		}	
		else throw new ArgumentNullException("数据不正确");
		
		Date currenttime = DateUtil.getCurrTime();		
		List<SYS_UserLoginRecord> loginrecords = this.userService2.qrySYS_UserLoginRecords(sysuser.getUserID());
		if(loginrecords.isEmpty())
		{//如果登录记录为空
			Date endtime = DateUtil.addHours(currenttime, StaticTable.CLIENTKEEPCONNECTIONHOURS);
			SYS_UserLoginRecord loginrecord = new SYS_UserLoginRecord();
			loginrecord.setUserid(sysuser.getUserID());
			loginrecord.setDeviceserialnumber(deviceSN);
			loginrecord.setLogintime(currenttime);
			loginrecord.setEndtime(endtime);
			
			this.userService2.addSYS_UserLoginRecord(loginrecord);
			return true;
		}
		else
		{//否则判断用户是否为当前用户
			SYS_UserLoginRecord logrecord = loginrecords.get(0);
			if(logrecord.getDeviceserialnumber().equals(deviceSN))
			{//如果用户为当前用户，则更新登录时间为当前时间
				//避免同一账户在同一时间被多处使用
				Date endtime = DateUtil.addHours(currenttime, StaticTable.CLIENTKEEPCONNECTIONHOURS);
				logrecord.setLogintime(currenttime);
				logrecord.setEndtime(endtime);
				this.userService2.updateSYS_UserLoginRecord(logrecord);
				return true;
			}
			else
			{//判断时间是否过期
				long endtime = logrecord.getEndtime().getTime();
				long curtime = DateUtil.getCurrTime().getTime();
				if(endtime < curtime)
				{//如果上次截止日期已经过期，则本次不同设备可以登录			
					Date nextendtime = DateUtil.addHours(currenttime, StaticTable.CLIENTKEEPCONNECTIONHOURS);
					logrecord.setDeviceserialnumber(deviceSN);
					logrecord.setLogintime(currenttime);
					logrecord.setEndtime(nextendtime);
					this.userService2.updateSYS_UserLoginRecord(logrecord);
					return true;
				}
			}
			//不一致，则退出
			throw new ArgumentNullException("账户已经登录");
		}		
	}
	/*
	 * 准备试看是否结束
	 */
	public boolean IsPrepareTryEnd(String deviceSN, String projectName) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(deviceSN) )
		{
			throw new ArgumentNullException("设备信息不能为空");
		}
		int count = this.userService2.countTryDocumentCount(deviceSN, projectName);
		return (StaticTable.USERTRYCATALOGCOUNT <= count);
	}
	/*
	 * 试看期是否结束
	 */
	public boolean IsTryEnd(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(password) || BaseUtil.isEmpty(deviceSN) )
		{
			throw new ArgumentNullException("用户名、密码等不能为空");
		}
		SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			throw new ArgumentNullException("用户名不存在");
		}
		if(!BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			throw new ArgumentNullException("密码不正确");
		}
//		if(!deviceSN.equals(sysuser.getDeviceSerialNumber()) && !deviceSN.equals(sysuser.getDeviceType()))
//		{
//			throw new ArgumentNullException("设备未注册");
//		}
		//判断当前用户试用期是否已经结束
		long currenttime = DateUtil.getCurrentDay().getTime();
		if((sysuser.getTryEndDate() != null) && (currenttime <= sysuser.getTryEndDate().getTime()))
		{
			return false;
		}
		return true;
	}
	/*
	 * 服务期是否结束
	 */
	public boolean IsPayEnd(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(password) || BaseUtil.isEmpty(deviceSN) )
		{
			throw new ArgumentNullException("用户名、密码等不能为空");
		}
		SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			throw new ArgumentNullException("用户名不存在");
		}
		if(!BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			throw new ArgumentNullException("密码不正确");
		}
//		if(!deviceSN.equals(sysuser.getDeviceSerialNumber()) && !deviceSN.equals(sysuser.getDeviceType()))
//		{
//			throw new ArgumentNullException("设备未注册");
//		}
		//判断当前用户试用期是否已经结束
		long currenttime = DateUtil.getCurrentDay().getTime();
		List<UserProducts> products = this.userInfoService.getUserProductsByProNo(projectName, sysuser.getUserID());
		if(products.isEmpty()
			|| ((products.get(0).getServiceEndDate() != null) && (currenttime <= products.get(0).getServiceEndDate().getTime())))
		{//如果产品激活信息为空，或者当前时间小于服务截止日期
			return false;
		}
		return true;
	}
	/*
	 * 是否重复登录：如果未取当前用户编号的登录数据，返回假；否则如果设备号相同返回假，不相同返回真
	 */
	public boolean IsRepeatLogin(String loginName, String password, String deviceSN, String projectName) throws Exception
	{
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(password) || BaseUtil.isEmpty(deviceSN) )
		{
			throw new ArgumentNullException("用户名、密码等不能为空");
		}
		SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			throw new ArgumentNullException("用户名不存在");
		}
		if(!BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			throw new ArgumentNullException("密码不正确");
		}
		List<SYS_UserLoginRecord> loginrecords = this.userService2.qrySYS_UserLoginRecords(sysuser.getUserID());
		if(loginrecords.isEmpty())
		{//如果未登录
			return false;
		}
		else
		{
			//否则如果非本机登录，则返回真，本机登录返回假值
			return !loginrecords.get(0).getDeviceserialnumber().equals(deviceSN);
		}
	}
	
	public boolean Logout(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(deviceSN) )
		{
			throw new ArgumentNullException("用户名、密码等不能为空");
		}
		SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			throw new ArgumentNullException("用户名不存在");
		}
		this.userService2.deleteSYS_UserLoginRecord(sysuser.getUserID());
		return true;
	}
	
	public boolean IsExistsUserNewReply(String loginName, String password, String deviceSN, String ProjectName) throws ArgumentNullException{
		SysUsers sysuser = checkUser(loginName, password, deviceSN);
		UseAccessLogs ual = logsService.qryUseLastInfo(sysuser.getUserID());
		if(ual==null)
		{
			return false;
		}
		Date lastTime = ual.getAccessTime();
		if(ual.getAccessTime()!=null)	//TODO:临时判断
		{
			return true;
		}
		List<Replys> lstReplys = replysService.qryNewReplys(sysuser.getUserID(), lastTime);
		
		return (lstReplys != null) ? true : false;
	}
	
	public SysUsers GetUserInfo(String loginName, String password, String deviceSN) throws ArgumentNullException{
		SysUsers sysuser = checkUser(loginName, password, deviceSN);
		return sysuser;
	}
	
	public Element GetUserInfo2(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(deviceSN) )
		{
			throw new ArgumentNullException("设备信息不能为空");
		}
		//下载用户状态
		//是否准备试用状态、是否正试用用户、是否付费用户、是否服务过期用户
		boolean ispreparetryuser = false;
		boolean istrybounduser = false;		
		boolean ispaybounduser = false;
		String userName = "";		
		if(BaseUtil.isEmpty(loginName))
		{//如果账户为空，则表示为准备试用状态
			ispreparetryuser = true;
		}
		else
		{
			SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
			if (sysuser == null)
			{
				throw new ArgumentNullException("账户不存在");
			}
			if (!BaseUtil.Md5(password + sysuser.getPasswordSalt()).equals(
					sysuser.getPassword())) {
				throw new ArgumentNullException("密码不正确");
			}
			// 判断DeviceSerialNumber与DeviceType字段是否为空。
			// 业务逻辑：一个注册用户只能同时使用两个设备号
//			if (!deviceSN.equals(sysuser.getDeviceSerialNumber()) && !deviceSN.equals(sysuser.getDeviceType())) {
//				throw new ArgumentNullException("设备未注册");
//			}
			long currenttime = DateUtil.getCurrentDay().getTime();
			List<UserProducts> products = this.userInfoService.getUserProductsByProNo(projectName, sysuser.getUserID());
			if (!products.isEmpty() && (products.get(0).getServiceEndDate() != null)) // && (currenttime <= products.get(0).getServiceEndDate().getTime()))
			{//处于服务期
				ispaybounduser = true;
			} else if (sysuser.getTryEndDate() != null) //&&(currenttime <= sysuser.getTryEndDate().getTime()))
			{//处于试用期
				istrybounduser = true;
			}
			userName = sysuser.getUserName();
		}
		//构造返回结果
		Element result = DocumentHelper.createElement("Root");		
		result.addElement("LoginName").addText(StringUtil.replaceNull(loginName));
		result.addElement("UserName").addText(StringUtil.replaceNull(userName));
		result.addElement("IsPrepareTryUser").addText(ispreparetryuser ? "TRUE" : "FALSE");		
		result.addElement("IsTryBoundUser").addText(istrybounduser ? "TRUE" : "FALSE");		
		result.addElement("IsPayBoundUser").addText(ispaybounduser ? "TRUE" : "FALSE");
		return result;
	}
	
	public Element GetUpdateTableInfos(String loginName, String password, String deviceSN,String projectName) throws ArgumentNullException
	{
		this.checkUserTryState(loginName, password, deviceSN, projectName);
		this.checkUserProduct(loginName, projectName, false);
		List<UpdateTableInfos> list = clientExpertService.qryUpdateTableInfosAll(projectName);
		
		Element root = DocumentHelper.createElement("Root");
		for(int i=0;i<list.size();i++)
		{
			UpdateTableInfos curr = list.get(i);
			Element bodyEl = DocumentHelper.createElement("Item");
			bodyEl.addAttribute("TID", String.valueOf(curr.getTid()));
			bodyEl.addAttribute("TableName", curr.getTableName());
			bodyEl.addAttribute("LastDate", DateUtil.formatDate(curr.getLastDate()));			

			root.add(bodyEl);
		}
		return root;
	}
	
	public Element GetAnnouncementInfo(String loginName, String password, String deviceSN,String projectName) throws ArgumentNullException
	{
		checkDeviceSN(loginName, password, deviceSN);
		Element root = DocumentHelper.createElement("Root");
			   	 
    	 Element itemEl2 = DocumentHelper.createElement("HypertextLinks");
    	 root.add(itemEl2); 	 
    	 List<HypertextLinks> lsthl = this.clientExpertService.qryHypertextLinksAll(projectName);
    	 int count2 = lsthl.size();
    	 for(int i=0;i<count2;i++)
    	 {
    		 HypertextLinks hl = lsthl.get(i);
    		 Element sub2 = DocumentHelper.createElement("Item");
    		 sub2.addAttribute("HypertextName", hl.getHypertextName());
    		 sub2.addAttribute("HypertextText", hl.getHypertextText());
    		 sub2.addAttribute("ViewText", StringUtil.replaceNull(hl.getViewText()));
    		 sub2.addAttribute("HypertextAddress", StringUtil.replaceNull(hl.getHypertextAddress()));
    		 sub2.addAttribute("HypertextTip", StringUtil.replaceNull(hl.getHypertextTip()));
    		 sub2.addAttribute("MustLogin", StringUtil.replaceNull(hl.getMustLogin()));
    		 itemEl2.add(sub2);
    	 }
    	 
	   	 Element itemEl = DocumentHelper.createElement("HypertextLinkExtends");
	   	 root.add(itemEl);	   	 
	   	 List<HypertextLinkExtends> lsthle = this.clientExpertService.qryHypertextLinkExtendsAll(projectName);
	   	 int count = lsthle.size();
	   	 for(int i=0;i<count;i++)
	   	 {
	   		 HypertextLinkExtends hle = lsthle.get(i);
	   		 Element sub = DocumentHelper.createElement("Item");
	   		 sub.addAttribute("TID", String.valueOf(hle.getTid()));
	   		 sub.addAttribute("HypertextName", hle.getHypertextName());
	   		 sub.addAttribute("ViewText", StringUtil.replaceNull(hle.getViewText()));
	   		 sub.addAttribute("ExtendAddress", StringUtil.replaceNull(hle.getExtendAddress()));
	   		 sub.addAttribute("MustLogin", StringUtil.replaceNull(hle.getMustLogin()));
	   		 itemEl.add(sub);
	   	 }
	   	 Element itemEl3 = DocumentHelper.createElement("UseTechniqueInfos");
	   	 root.add(itemEl3);
	   	 List<UseTechniqueInfos> lstuti = this.clientExpertService.qryUserTechniqueInfosAll(projectName);
	   	 int count3 = lstuti.size();
	   	 for(int i=0;i<count3;i++)
	   	 {
	   		 UseTechniqueInfos uti = lstuti.get(i);
	   		 Element sub3 = DocumentHelper.createElement("Item");
	   		 sub3.addAttribute("TID", String.valueOf(uti.getTid()));
	   		 sub3.addAttribute("TechName", uti.getTechName());
	   		 sub3.addAttribute("TechText", uti.getTechText());
	   		 sub3.addAttribute("IndexNo", String.valueOf(uti.getIndexNo()));
	   		 itemEl3.add(sub3);
	   	 }
		return root;
	}
	
	public Element GetUpdateTableData(String loginName, String password, String deviceSN,String projectName, Element updateEl) throws ArgumentNullException
	{
		this.checkUserTryState(loginName, password, deviceSN, projectName);
		this.checkUserProduct(loginName, projectName, false);
		
		Element root = DocumentHelper.createElement("Root");
		List subEl = updateEl.elements();
		 for (Iterator it = subEl.iterator(); it.hasNext();) {
	         Element elem = (Element) it.next();
	         String tableName = elem.getText();
	         
			if ("CatalogFullTree".equals(tableName)) {
				Element itemEl = DocumentHelper.createElement(tableName);
				root.add(itemEl);

				List<CatalogFullTree> lstcft = this.clientExpertService.qryCatalogFullTreeAll(projectName);
				int count = lstcft.size();
				for (int i = 0; i < count; i++) {
					CatalogFullTree cft = lstcft.get(i);
					Element sub = DocumentHelper.createElement("Item");
					sub.addAttribute("CatalogNodeID", cft.getCatalogNodeID());
					sub.addAttribute("CatalogNodeName", cft.getCatalogNodeName());
					sub.addAttribute("CatalogID", cft.getCatalogID());
					sub.addAttribute("NodeType", cft.getNodeType());
					sub.addAttribute("ViewResource", cft.getViewResource());
					sub.addAttribute("EditResource", cft.getEditResource());
					sub.addAttribute("SaveResource", cft.getSaveResource());
					sub.addAttribute("TransmitResource", cft.getTransmitResource());
					sub.addAttribute("CanCatalogSearch", cft.getCanCatalogSearch());
					sub.addAttribute("CanFullTextSearch", cft.getCanFullTextSearch());
					sub.addAttribute("FullTextSearchResource", StringUtil.replaceNull(cft.getFullTextSearchResource()));
					sub.addAttribute("CanShowExtensions", cft.getCanShowExtensions());
					sub.addAttribute("IndexNo",String.valueOf(cft.getIndexNo()));
					itemEl.add(sub);
				}
			} else if ("Catalogs".equals(tableName)) {
				Element itemEl = DocumentHelper.createElement(tableName);
				root.add(itemEl);

				List<Catalogs> getlogs = this.clientExpertService.qryCatalogsAll(projectName);
				int count = getlogs.size();
				for (int i = 0; i < count; i++) {
					Catalogs curr = getlogs.get(i);
					Element sub = DocumentHelper.createElement("Item");
					sub.addAttribute("CatalogID", curr.getCatalogID());
					sub.addAttribute("CatalogName", curr.getCatalogName());
					sub.addAttribute("FullCatalogName", curr.getFullCatalogName());
					sub.addAttribute("ParentCatalogID", curr.getParentCatalogID());
					sub.addAttribute("InParentIndexNo", String.valueOf(curr.getInParentIndexNo()));
					sub.addAttribute("LevelName", String.valueOf(curr.getLevelName()));
					sub.addAttribute("NodeType", curr.getNodetype());
					itemEl.add(sub);
				}
			} else if ("Questions".equals(tableName)) {
				Element itemEl = DocumentHelper.createElement(tableName);
				root.add(itemEl);

				List<ResQuestions> questionList = this.clientExpertService.qryResQuestionsAll(projectName);
				int count = questionList.size();
				for (int i = 0; i < count; i++) {
					ResQuestions cur = questionList.get(i);
					Element item = DocumentHelper.createElement("Item");
					item.addAttribute("QuestionID", cur.getQuestionID());
					item.addAttribute("Subject", cur.getSubject());
					item.addAttribute("Title", cur.getTitle());
					item.addAttribute("Description", cur.getDescription());
					item.addAttribute("Answer", cur.getAnswer());
					item.addAttribute("ReferenceNotes", StringUtil.replaceNull(cur.getReferenceNotes()));
					item.addAttribute("Example", StringUtil.replaceNull(cur.getExample()));
					item.addAttribute("Interpretation", StringUtil.replaceNull(cur.getInterpretation()));
					item.addAttribute("Notes", StringUtil.replaceNull(cur.getNotes()));
					itemEl.add(item);
				}
			} else if ("QuestionLawRefs".equals(tableName)) {
				Element itemEl = DocumentHelper.createElement(tableName);
				root.add(itemEl);

				List<QuestionLawRefs> lstqlr = this.clientExpertService.qryQuestionLawRefsAll(projectName);
				int count = lstqlr.size();
				for (int i = 0; i < count; i++) {
					QuestionLawRefs qlr = lstqlr.get(i);
					Element sub = DocumentHelper.createElement("Item");
					sub.addAttribute("TID", String.valueOf(qlr.getTid()));
					sub.addAttribute("QuestionID", qlr.getQuestionID());
					sub.addAttribute("DocumentID", qlr.getDocumentID());
					sub.addAttribute("DocumentName", qlr.getDocumentName());
					sub.addAttribute("EntityNo", StringUtil.replaceNull(qlr.getEntityNo()));
					sub.addAttribute("Description", StringUtil.replaceNull(qlr.getDescription()));
					itemEl.add(sub);
				}
			} else if("LawExamples".equals(tableName))
			{
				Element itemEl = DocumentHelper.createElement(tableName);
				root.add(itemEl);
				List<RES_LawExample> lstqlr = this.clientExpertService.qryRES_LawExamplesAll(projectName);
				int count = lstqlr.size();
				for (int i = 0; i < count; i++) {
					RES_LawExample qlr = lstqlr.get(i);
					Element sub = DocumentHelper.createElement("Item");
					sub.addAttribute("ExampleID", qlr.getExampleid());
					sub.addAttribute("Subject", StringUtil.replaceNull(qlr.getSubject()));
					sub.addAttribute("Title", StringUtil.replaceNull(qlr.getTitle()));					
					sub.addAttribute("Example", StringUtil.replaceNull(qlr.getExample()));
					sub.addAttribute("Interpretation", StringUtil.replaceNull(qlr.getInterpretation()));
					sub.addAttribute("Notes", StringUtil.replaceNull(qlr.getNotes()));
					itemEl.add(sub);
				}
			} else if("QuestionExamples".equals(tableName))
			{
				Element itemEl = DocumentHelper.createElement(tableName);
				root.add(itemEl);
				List<RES_QuestionExample> lstqlr = this.clientExpertService.qryRES_QuestionExamplesAll(projectName);
				int count = lstqlr.size();
				for (int i = 0; i < count; i++) {
					RES_QuestionExample qlr = lstqlr.get(i);
					Element sub = DocumentHelper.createElement("Item");
					sub.addAttribute("TID", String.valueOf(qlr.getTid()));
					sub.addAttribute("QuestionID", StringUtil.replaceNull(qlr.getQuestionid()));
					sub.addAttribute("CatalogNodeID", StringUtil.replaceNull(qlr.getCatalognodeid()));					
					sub.addAttribute("CatalogNodeName", StringUtil.replaceNull(qlr.getCatalognodename()));
					sub.addAttribute("NodeType", StringUtil.replaceNull(qlr.getNodetype()));
					itemEl.add(sub);
				}
			}
	     }
		 return root;
	}

	public List<SystemInfos> GetSystemInfos(String loginName, String password, String deviceSN,String projectName) throws ArgumentNullException {
		this.checkUserTryState(loginName, password, deviceSN, projectName);
		this.checkUserProduct(loginName, projectName, false);
		return clientExpertService.qrySystemInfoListByProjectName(projectName);
	}

	public List<DocumentInfos> GetDocumentInfos(String loginName, String password, String deviceSN,String projectName) throws ArgumentNullException {
		this.checkUserTryState(loginName, password, deviceSN, projectName);
		this.checkUserProduct(loginName, projectName, false);		
		return clientExpertService.qryDocumentInfoListByProjectName(projectName);
	}
	
	public Object[] GetSystemFiles(String loginName, String password, String deviceSN, String projectName, Element userFiles) throws ArgumentNullException, ParseException {
		if(userFiles!=null)
		{
			this.checkUserTryState(loginName, password, deviceSN, projectName);
			this.checkUserProduct(loginName, projectName, false);
			
			String fullStr = "";			
			List<Element> lstEl = userFiles.elements();
			List<String> lstStr = new ArrayList<String>();
			int count = lstEl.size();			
			for(int i=0;i<count;i++)
			{
				lstStr.add(lstEl.get(i).getText());
//				String did = lstEl.get(i).getText();
//				fullStr += "'" + did + "'";
//				if(i < count - 1) fullStr += ",";
			}
			List<SystemInfos> lstSystemInfos = clientExpertService.qrySystemInfoListByIDs(lstStr);
			List<String> fileIDs = new ArrayList<String>();
			List<String> fileLocations = new ArrayList<String>();
			for(int i=0;i<lstSystemInfos.size();i++)
			{
				fileIDs.add(lstSystemInfos.get(i).getDocumentID());
				fileLocations.add(lstSystemInfos.get(i).getLocation());
			}
			return new Object[] {fileIDs, fileLocations, lstSystemInfos};
		}
		return null;
	}
	
	public Object[] GetDocumentFiles(String loginName, String password, String deviceSN, String projectName, Element userFiles) throws ArgumentNullException, ParseException {
		if(userFiles!=null)
		{
			this.checkUserTryState(loginName, password, deviceSN, projectName);
			this.checkUserProduct(loginName, projectName, false);
			
			List<Element> lstEl = userFiles.elements();
			List<String> fileIDs = new ArrayList<String>();
			List<String> fileLocations = new ArrayList<String>();
			List<DocumentInfos> lstSystemInfos = new ArrayList<DocumentInfos>();
			
			//JDBC每次in时只能处理1000条
			int PAGEMAXCOUNT = 1000;
			int startindex = 0;
			while(startindex < lstEl.size())
			{
				//本次操作最大值
				int lastindex = Math.min(startindex + PAGEMAXCOUNT, lstEl.size());
				List<String> lstStr = new ArrayList<String>();
				for(;startindex<lastindex;startindex++)
				{
					lstStr.add(lstEl.get(startindex).getText());
				}
				List<DocumentInfos> lstSystemInfos2 = clientExpertService.qryDocumentInfoListByIDs(lstStr);
				for(int i=0;i<lstSystemInfos2.size();i++)
				{
					DocumentInfos infos = lstSystemInfos2.get(i);
					fileIDs.add(infos.getDocumentID());
					fileLocations.add(infos.getLocation());
					lstSystemInfos.add(infos);
				}
			}
			return new Object[] {fileIDs, fileLocations, lstSystemInfos};
		}
		return null;
	}
	
	/*
	 * 下载用户公告信息，数据来源于RES_UserAnnouncementInfo表
	 */
	public Element GetUserAnnouncementInfo(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{
		if (BaseUtil.isEmpty(deviceSN)) {
			throw new ArgumentNullException("deviceSN IS NULL");
		}
		SysUsers sysuser = this.GetUser(loginName, password, deviceSN);
		
		Element root = DocumentHelper.createElement("Root");
		Element itemEl2 = DocumentHelper.createElement("USERANNOUNCEMENTS");
		root.add(itemEl2);
		List<RES_UserAnnouncement> lsthl = this.userService2.qryRES_UserAnnouncements(projectName, sysuser.getUserID());
		int count2 = lsthl.size();
		for (int i = 0; i < count2; i++) {
			RES_UserAnnouncement hl = lsthl.get(i);
			Element sub2 = DocumentHelper.createElement("Item");
			sub2.addAttribute("TID", String.valueOf(hl.getTid()));
			sub2.addAttribute("MESSAGETEXT", hl.getMessagetext());
			sub2.addAttribute("EXTENSIONLINK", StringUtil.replaceNull(hl.getExtensionlink()));
			sub2.addAttribute("INDEXNO", String.valueOf(hl.getIndexno()));
			itemEl2.add(sub2);
		}
		return root;
	}
	
	public Object[] GetDownloadSingleNodeFile(String loginName, String password, String deviceSN, String projectName, String catalogNodeID) throws ArgumentNullException
	{
		if(deviceSN.isEmpty()) return null;		
		this.checkUserState(loginName, password, deviceSN, projectName, catalogNodeID);
		
		List<DocumentInfos> lstDocumentInfos = clientExpertService.qryDocumentInfoListByCatalogNodeID(catalogNodeID);
		if(lstDocumentInfos.size() > 0) this.addUserTryDocument(projectName, deviceSN, catalogNodeID);
		
		List<String> fileIDs = new ArrayList<String>();
		List<String> fileLocations = new ArrayList<String>();
		for(int i=0;i<lstDocumentInfos.size();i++)
		{
			fileIDs.add(lstDocumentInfos.get(i).getDocumentID());
			fileLocations.add(lstDocumentInfos.get(i).getLocation());
		}
		return new Object[] {fileIDs, fileLocations, lstDocumentInfos};
	}
	
	public Object[] GetDownloadLawXmlDocuments(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{	
		if(deviceSN.isEmpty()) return null;
		this.mincheckUserTryState(loginName, password, deviceSN, projectName);
		
		List<DocumentInfos> lstDocumentInfos = clientExpertService.qryDocumentInfoListByLawXmlDocuments(deviceSN);
		List<String> fileIDs = new ArrayList<String>();
		List<String> fileLocations = new ArrayList<String>();
		for(int i=0;i<lstDocumentInfos.size();i++)
		{
			fileIDs.add(lstDocumentInfos.get(i).getDocumentID());
			fileLocations.add(lstDocumentInfos.get(i).getLocation());
		}
		return new Object[] {fileIDs, fileLocations, lstDocumentInfos};
	}	
	
	public Object[] GetDownloadTryDocuments(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{	
		if(deviceSN.isEmpty()) return null;
		this.checkUserTryState(loginName, password, deviceSN, projectName);
		
		List<SYS_TryDocument> tryDocuments = this.userService2.qrySYS_TryDocumentAll(deviceSN);
		List<DocumentInfos> lstDocumentInfos = clientExpertService.qryDocumentInfoListByTryDocuments(deviceSN);
		List<String> fileIDs = new ArrayList<String>();
		List<String> fileLocations = new ArrayList<String>();
		for(int i=0;i<lstDocumentInfos.size();i++)
		{
			fileIDs.add(lstDocumentInfos.get(i).getDocumentID());
			fileLocations.add(lstDocumentInfos.get(i).getLocation());
		}
		return new Object[] {fileIDs, fileLocations, lstDocumentInfos, tryDocuments};
	}
	
	public Object[] GetDownloadMultiNodeFiles(String loginName, String password, String deviceSN, String projectName, Element userfileEl) throws ArgumentNullException
	{		
		if(deviceSN.isEmpty()) return null;
		this.checkUserState(loginName, password, deviceSN, projectName, "");
		
		List<Element> lstEl = userfileEl.elements();
		List<String> nodeids = new ArrayList<String>();
		int count = lstEl.size();			
		for(int i=0;i<count;i++)
		{
			String catalognodeid = lstEl.get(i).getText();
			nodeids.add(catalognodeid);
		}
		List<DocumentInfos> lstSystemInfos = this.clientExpertService.qryDocumentInfoListByCatalogNodeIDs(nodeids);
		List<String> fileIDs = new ArrayList<String>();
		List<String> fileLocations = new ArrayList<String>();
		for(int i=0;i<lstSystemInfos.size();i++)
		{
			fileIDs.add(lstSystemInfos.get(i).getDocumentID());
			fileLocations.add(lstSystemInfos.get(i).getLocation());
		}
		return new Object[] {fileIDs, fileLocations, lstSystemInfos, nodeids};
	}
	
	public Object GetLABQAQuestionList(String loginName, String password, String deviceSN, String projectName, String questionkey) throws ArgumentNullException
	{
		if(deviceSN.isEmpty()) return null;
		this.checkUserState(loginName, password, deviceSN, projectName, "");
		this.checkUserProduct(loginName, projectName, false);
		
		String urlPrefix = StaticTable.QuestionURLPrefix;
		List<QuestionQueryResultObj> values = this.clientExpertService.qryOnlineQuestions(questionkey);
		int totalsize = values.size();
		for(int i=0;i<totalsize;i++)
		{
			QuestionQueryResultObj obj = values.get(i);
			obj.setQuestionID(urlPrefix + obj.getQuestionID());
		}
		return values;
	}

	//}}
	
//{{私有方法
	/**
	 * 验证设备
	 * @param loginName
	 * @param deviceSN
	 * @throws ArgumentNullException
	 * @author whz
	 */
	private SysUsers checkDeviceSN(String loginName, String passWord, String deviceSN) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(deviceSN))
		{
			throw new ArgumentNullException("deviceSN IS NULL");
		}
		
		SysUsers sysuser = userInfoService.getSysUserByDevice(deviceSN);
		
		if(sysuser!=null)
		{
//			if(!loginName.equals(sysuser.getEmail()))
//			{
//				throw new ArgumentNullException("user is null");
//			}
//			if(passWord.equals(BaseUtil.Md5(sysuser.getPassword()+sysuser.getPasswordSalt())))
//			{
//				throw new ArgumentNullException("passowrd error");
//			}
		}else{
			DeviceRegisters dr = userInfoService.getDeviceInfo(deviceSN);
			if(dr==null)
			{
				throw new ArgumentNullException("deviceSN bu cun zai");
			}
		}
		return sysuser;
	}
	
	private SysUsers checkUser(String loginName,String password,String deviceSN) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(password) || BaseUtil.isEmpty(deviceSN))
		{
			throw new ArgumentNullException("用户名、密码、设备不能为空");
		}
		
		SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			throw new ArgumentNullException("用户不存在");
		}
//		if(!deviceSN.equals(sysuser.getDeviceSerialNumber()) && !deviceSN.equals(sysuser.getDeviceType()))
//		{
//			throw new ArgumentNullException("设备未注册");
//		}
		if(!BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			throw new ArgumentNullException("密码不正确");
		}
		//判断是否为试用用户，且已过期
		//判断条件，试用日期小于当前日期，且服务日期为空
//		long currenttime = DateUtil.getCurrentDay().getTime();
//		List<UserProducts> products = this.userInfoService.getUserProductsByProNo(projectName, sysuser.getUserID());
//		if (!products.isEmpty() && (products.get(0).getServiceEndDate() != null)) // && (currenttime <= products.get(0).getServiceEndDate().getTime()))
//		{
//			
//		}
//		if (sysuser.getServiceEndDate() != null) {
//			if (sysuser.getServiceEndDate().getTime() < currenttime) {
//				// 如果服务日期不为空，且服务日期小于当前日期的，表示服务超期用户
//				throw new ArgumentNullException("服务已经过期");
//			}
//		} else if ((sysuser.getTryEndDate() != null) && (sysuser.getTryEndDate().getTime() < currenttime)) {
//			// 试用期已经过期
//			throw new ArgumentNullException("试看体验已经结束");
//		}
		return sysuser;
	}

	private SysUsers GetUser(String loginName,String password,String deviceSN) throws ArgumentNullException
	{
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(password) || BaseUtil.isEmpty(deviceSN))
		{
			throw new ArgumentNullException("用户名、密码、设备不能为空");
		}
		SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			throw new ArgumentNullException("用户名不存在");
		}
		if(!BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			throw new ArgumentNullException("密码不正确");
		}
		// 判断DeviceSerialNumber与DeviceType字段是否为空。
		// 业务逻辑：一个注册用户只能同时使用两个设备号
//		if (!deviceSN.equals(sysuser.getDeviceSerialNumber()) && !deviceSN.equals(sysuser.getDeviceType())) {
//			throw new ArgumentNullException("设备未注册");
//		}
		return sysuser;
	}
	
	private void checkUserState(String loginName, String password, String deviceSN, String projectName, String catalogNodeID) throws ArgumentNullException
	{
		if (BaseUtil.isEmpty(deviceSN)) {
			throw new ArgumentNullException("deviceSN IS NULL");
		}
		if (BaseUtil.isNotEmpty(loginName)) {// 如果登录账户不为空，则需进一步判断密码是否错误
			SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
			if (sysuser == null) {
				throw new ArgumentNullException("用户名不存在");
			}
			if (!BaseUtil.Md5(password + sysuser.getPasswordSalt()).equals(sysuser.getPassword())) {
				throw new ArgumentNullException("密码不正确");
			}
			// 判断DeviceSerialNumber与DeviceType字段是否为空。
			// 业务逻辑：一个注册用户只能同时使用两个设备号
//			if (!deviceSN.equals(sysuser.getDeviceSerialNumber()) && !deviceSN.equals(sysuser.getDeviceType())) {
//				throw new ArgumentNullException("设备未注册");
//			}
			long currenttime = DateUtil.getCurrentDay().getTime();
			List<UserProducts> products = this.userInfoService.getUserProductsByProNo(projectName, sysuser.getUserID());
			if (!products.isEmpty() && (products.get(0).getServiceEndDate() != null))
			{
				if (products.get(0).getServiceEndDate().getTime() < currenttime) {
					// 如果服务日期不为空，且服务日期小于当前日期的，表示服务超期用户
					throw new ArgumentNullException("服务已经过期");
				} else {
					//正常服务期内
					return;
				}
			}
//			else if ((sysuser.getTryEndDate() != null) && (sysuser.getTryEndDate().getTime() < currenttime)) {
//				// 试用期已经过期
//				throw new ArgumentNullException("试看体验已经结束");
//			}
			else throw new ArgumentNullException("试看体验期不能下载");
		} else {// 否则则需判断用户试用数量是否超过开放数量（此处为：60）
			boolean isnotexists = false;
			if(BaseUtil.isNotEmpty(catalogNodeID))
			{//判断当前节点是否已经在列表中存在
				List<SYS_TryUserDocument> existlist = this.userService2.qrySYS_TryUserDocuments("CATALOGNODEID='" + catalogNodeID +"' AND DEVICESERIALNUMBER='" + deviceSN + "'", "");
				if(existlist.isEmpty()) isnotexists = true;
			}
			if(isnotexists)
			{//如果当前选择节点不存在，则判断是否已经超出数量
				int count = this.userService2.countTryDocumentCount(deviceSN, projectName);
				if (count >= StaticTable.USERTRYCATALOGCOUNT) {
					throw new ArgumentNullException("试看体验已经结束");
				}
			}
		}
	}
	
	private void checkUserTryState(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{
		if (BaseUtil.isEmpty(deviceSN)) {
			throw new ArgumentNullException("deviceSN IS NULL");
		}
		if (BaseUtil.isNotEmpty(loginName)) {// 如果登录账户不为空，则需进一步判断密码是否错误
			SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
			if (sysuser == null) {
				throw new ArgumentNullException("用户名不存在");
			}
			if (!BaseUtil.Md5(password + sysuser.getPasswordSalt()).equals(sysuser.getPassword())) {
				throw new ArgumentNullException("密码不正确");
			}
			// 判断DeviceSerialNumber与DeviceType字段是否为空。
			// 业务逻辑：一个注册用户只能同时使用两个设备号
//			if (!deviceSN.equals(sysuser.getDeviceSerialNumber()) && !deviceSN.equals(sysuser.getDeviceType())) {
//				throw new ArgumentNullException("设备未注册");
//			}
			long currenttime = DateUtil.getCurrentDay().getTime();
			List<UserProducts> products = this.userInfoService.getUserProductsByProNo(projectName, sysuser.getUserID());
			if (!products.isEmpty() && (products.get(0).getServiceEndDate() != null))
			{
				if (products.get(0).getServiceEndDate().getTime() < currenttime) {
					// 如果服务日期不为空，且服务日期小于当前日期的，表示服务超期用户
					throw new ArgumentNullException("服务已经过期");
				} else {
					//正常服务期内
					return;
				}
			}
			else if (sysuser.getTryEndDate() != null)// && (sysuser.getTryEndDate().getTime() < currenttime))
			{
				// 试用期已经过期：取消试用期已经过期限制
				//throw new ArgumentNullException("试看体验已经结束");
				return;
			}
		} else {// 否则则需判断用户试用数量是否超过开放数量（此处为：60）
			int count = this.userService2.countTryDocumentCount(deviceSN, projectName);
			if (count >= StaticTable.USERTRYCATALOGCOUNT) {
				throw new ArgumentNullException("试看体验已经结束");
			}
		}
	}

	private void mincheckUserTryState(String loginName, String password, String deviceSN, String projectName) throws ArgumentNullException
	{
		if (BaseUtil.isEmpty(deviceSN)) {
			throw new ArgumentNullException("deviceSN IS NULL");
		}
		if (BaseUtil.isNotEmpty(loginName)) {// 如果登录账户不为空，则需进一步判断密码是否错误
			SysUsers sysuser = userInfoService.getSysUserByLogName(loginName);
			if (sysuser == null) {
				throw new ArgumentNullException("用户名不存在");
			}
			if (!BaseUtil.Md5(password + sysuser.getPasswordSalt()).equals(sysuser.getPassword())) {
				throw new ArgumentNullException("密码不正确");
			}
			long currenttime = DateUtil.getCurrentDay().getTime();
			List<UserProducts> products = this.userInfoService.getUserProductsByProNo(projectName, sysuser.getUserID());
			if (!products.isEmpty() && (products.get(0).getServiceEndDate() != null))
			{
				return;
			}
			else if (sysuser.getTryEndDate() != null)
			{
				return;
			}
		}
	}
	
	private void checkUserProduct(String userName, String projectName, boolean isMustChecked) throws ArgumentNullException
	{
		boolean isexist = false;		
		List<UserProducts> products = this.userInfoService.getUserProductsByUserName(userName);
		if(!products.isEmpty())
		{
			for(int i=0;i<products.size();i++)
			{
				//是否存在相同的项目名称，或者客户端等于“劳动法USBV11”而服务端等于“劳动法V11”
				UserProducts product = products.get(i);
				if(product.getProductAlias().equalsIgnoreCase(projectName)
					|| (product.getProductAlias().equalsIgnoreCase(StaticTable.LAWPROJECTNAME) && projectName.equalsIgnoreCase(StaticTable.LAWUSBPROJECTNAME)))
				{
					long endtime = product.getServiceEndDate().getTime();
					long curtime = DateUtil.getCurrTime().getTime();
					if(endtime < curtime)
					{//如果服务截止日期小于当前日期，表示已经过期
						throw new ArgumentNullException("账户已经过期");
					}
					isexist = true;
					break;
				}
			}			
		}
		//如果必须强验证，且未取要验证的数据
		if(!isexist && isMustChecked) throw new ArgumentNullException("账户未激活");		
	}
	
	private boolean addUserTryDocument(String projectname, String deviceSN, String catalogNodeID)
	{
		SYS_TryUserDocument tryUserDocument = new SYS_TryUserDocument();
		tryUserDocument.setProjectName(projectname);
		tryUserDocument.setCatalogNodeID(catalogNodeID);
		tryUserDocument.setDeviceSerialNumber(deviceSN);
		tryUserDocument.setDownloadTime(DateUtil.getCurrTime());
		
		userService2.addSYS_TryUserDocument(tryUserDocument);
		
		return true;
	}
//}}

	public static void main(String[] args) {
		try {
//			List<SYS_AccessLog> accessLogs = new ArrayList<SYS_AccessLog>();
//			SYS_AccessLog o = new SYS_AccessLog();
//			o.setTid(0);
//			o.setCurrentUserState("已付费111");
//			o.setOperatUserState("已付费111");
//			o.setLoginName("testFFFF64@izhong.com");
//			o.setUserName("测试客户111");
//			o.setDeviceSerial("TF655AY9K3AR9L");
//			o.setOperationType("启动111");
//			o.setOperationArea("");			
//			o.setOperationDate(Calendar.getInstance().getTime());
//			o.setCreateTime(Calendar.getInstance().getTime());
//			o.setProjectName("劳动法V11");
//			accessLogs.add(o);
//			
//			Thread.sleep(10000);
//			o = new SYS_AccessLog();
//			o.setTid(0);
//			o.setCurrentUserState("已付费222");
//			o.setOperatUserState("已付费222");
//			o.setLoginName("testFFFF64@izhong.com");
//			o.setUserName("测试客户222");
//			o.setDeviceSerial("TF655AY9K3AR9L");
//			o.setOperationType("启动222");
//			o.setOperationArea("");			
//			o.setOperationDate(Calendar.getInstance().getTime());
//			o.setCreateTime(Calendar.getInstance().getTime());
//			o.setProjectName("劳动法V11");
//			accessLogs.add(o);
//			
//			Thread.sleep(10000);
//			o = new SYS_AccessLog();
//			o.setTid(0);
//			o.setCurrentUserState("已付费333");
//			o.setOperatUserState("已付费333");
//			o.setLoginName("testFFFF64@izhong.com");
//			o.setUserName("测试客户333");
//			o.setDeviceSerial("TF655AY9K3AR9L");
//			o.setOperationType("启动333");
//			o.setOperationArea("");			
//			o.setOperationDate(Calendar.getInstance().getTime());
//			o.setCreateTime(Calendar.getInstance().getTime());
//			o.setProjectName("劳动法V11");
//			accessLogs.add(o);
			String text = "<Root><Item>RD005232</Item><Item>RD005231</Item><Item>RD006307</Item><Item>RD006314</Item><Item>RD006315</Item><Item>RD006316</Item><Item>RD006323</Item><Item>RD006325</Item><Item>RD006326</Item><Item>RD006327</Item><Item>RD006328</Item><Item>RD006340</Item><Item>RD006341</Item><Item>RD006344</Item><Item>RD006552</Item><Item>RD006556</Item><Item>RD006562</Item><Item>RD006563</Item><Item>RD006231</Item><Item>RD006234</Item><Item>RD006246</Item><Item>RD006367</Item><Item>RD006372</Item><Item>RD006383</Item><Item>RD006385</Item><Item>RD006387</Item><Item>RD006390</Item><Item>RD006391</Item><Item>RD006392</Item><Item>RD006393</Item><Item>RD006394</Item><Item>RD006395</Item><Item>RD006396</Item><Item>RD006268</Item><Item>RD006287</Item><Item>RD006292</Item><Item>RD006725</Item><Item>RD006570</Item><Item>RD006571</Item><Item>RD006573</Item><Item>RD006574</Item><Item>RD006576</Item><Item>RD006584</Item><Item>RD006585</Item><Item>RD006587</Item><Item>RD006591</Item><Item>RD006594</Item><Item>RD006596</Item><Item>RD006597</Item><Item>RD006599</Item><Item>RD006603</Item><Item>RD006605</Item><Item>RD006546</Item><Item>RD006554</Item><Item>RD006555</Item><Item>RD006334</Item><Item>RD006337</Item><Item>RD006586</Item><Item>RD006592</Item><Item>RD006593</Item><Item>RD006600</Item><Item>RD006664</Item><Item>RD006665</Item><Item>RD006667</Item><Item>RD006668</Item><Item>RD006670</Item><Item>RD006673</Item><Item>RD006674</Item><Item>RD006330</Item><Item>RD006333</Item><Item>RD006726</Item><Item>RD006727</Item><Item>RD006728</Item><Item>RD006729</Item><Item>RD006730</Item><Item>RD006731</Item><Item>RD006732</Item><Item>RD006733</Item><Item>RD006734</Item><Item>RD006735</Item><Item>RD006736</Item><Item>RD006737</Item><Item>RD006239</Item><Item>RD006249</Item><Item>RD006262</Item><Item>RD006278</Item><Item>RD006558</Item><Item>RD006559</Item><Item>RD006566</Item><Item>RD006567</Item><Item>RD006577</Item><Item>RD006578</Item><Item>RD006620</Item><Item>RD006627</Item><Item>RD006638</Item><Item>RD006646</Item><Item>RD006657</Item><Item>RD006663</Item><Item>RD006672</Item><Item>RD006790</Item><Item>RD006796</Item><Item>RD006802</Item><Item>RD006831</Item><Item>RD006832</Item><Item>RD006833</Item><Item>RD006834</Item><Item>RD006835</Item><Item>RD006836</Item><Item>RD006838</Item><Item>RD006839</Item><Item>RD006840</Item><Item>RD006841</Item><Item>RD006842</Item><Item>RD006282</Item><Item>RD006283</Item><Item>RD006874</Item><Item>RD006875</Item><Item>RD006876</Item><Item>RD006877</Item><Item>RD006878</Item><Item>RD006879</Item><Item>RD006880</Item><Item>RD006881</Item><Item>RD006882</Item><Item>RD006884</Item><Item>RD006248</Item><Item>RD006250</Item><Item>RD006398</Item><Item>RD006399</Item><Item>RD006400</Item><Item>RD006401</Item><Item>RD006221</Item><Item>RD006227</Item><Item>RD006572</Item><Item>RD006583</Item><Item>RD006251</Item><Item>RD006256</Item><Item>RD006259</Item><Item>RD006260</Item><Item>RD006265</Item><Item>RD006275</Item><Item>RD006276</Item><Item>RD006302</Item><Item>RD006303</Item><Item>RD006339</Item><Item>RD006342</Item><Item>RD006345</Item><Item>RD006346</Item><Item>RD006348</Item><Item>RD006214</Item><Item>RD006676</Item><Item>RD006402</Item><Item>RD006403</Item><Item>RD006404</Item><Item>RD006405</Item><Item>RD006406</Item><Item>RD006407</Item><Item>RD006408</Item><Item>RD006409</Item><Item>RD006410</Item><Item>RD006411</Item><Item>RD006412</Item><Item>RD006413</Item><Item>RD006580</Item><Item>RD006581</Item><Item>RD006588</Item><Item>RD006589</Item><Item>RD006601</Item><Item>RD006490</Item><Item>RD006492</Item><Item>RD006493</Item><Item>RD006494</Item><Item>RD006495</Item><Item>RD006498</Item><Item>RD006499</Item><Item>RD006501</Item><Item>RD006502</Item><Item>RD006505</Item><Item>RD006506</Item><Item>RD006507</Item><Item>RD006509</Item><Item>RD006269</Item><Item>RD006522</Item><Item>RD006527</Item><Item>RD006532</Item><Item>RD006608</Item><Item>RD006610</Item><Item>RD006614</Item><Item>RD006628</Item><Item>RD006631</Item><Item>RD006632</Item><Item>RD006633</Item><Item>RD006634</Item><Item>RD006635</Item><Item>RD006636</Item><Item>RD006637</Item><Item>RD006582</Item><Item>RD006590</Item><Item>RD006595</Item><Item>RD006598</Item><Item>RD006677</Item><Item>RD006678</Item><Item>RD006679</Item><Item>RD006680</Item><Item>RD006681</Item><Item>RD006684</Item><Item>RD006685</Item><Item>RD006688</Item><Item>RD006689</Item><Item>RD006690</Item><Item>RD006691</Item><Item>RD006695</Item><Item>RD006696</Item><Item>RD006697</Item><Item>RD006423</Item><Item>RD006642</Item><Item>RD006751</Item><Item>RD006752</Item><Item>RD006753</Item><Item>RD006754</Item><Item>RD006755</Item><Item>RD006756</Item><Item>RD006757</Item><Item>RD006758</Item><Item>RD006759</Item><Item>RD006761</Item><Item>RD006762</Item><Item>RD006272</Item><Item>RD006273</Item><Item>RD006288</Item><Item>RD006293</Item><Item>RD006296</Item><Item>RD006564</Item><Item>RD006480</Item><Item>RD006484</Item><Item>RD006485</Item><Item>RD006486</Item><Item>RD006602</Item><Item>RD006607</Item><Item>RD006613</Item><Item>RD006629</Item><Item>RD006630</Item><Item>RD006682</Item><Item>RD006683</Item><Item>RD006694</Item><Item>RD006712</Item><Item>RD006713</Item><Item>RD006719</Item><Item>RD006744</Item><Item>RD006768</Item><Item>RD006769</Item><Item>RD006648</Item><Item>RD006653</Item><Item>RD006654</Item><Item>RD006669</Item><Item>RD006686</Item><Item>RD006692</Item><Item>RD006718</Item><Item>RD006760</Item><Item>RD006811</Item><Item>RD006817</Item><Item>RD006843</Item><Item>RD006844</Item><Item>RD006846</Item><Item>RD006847</Item><Item>RD006892</Item><Item>RD006893</Item><Item>RD006894</Item><Item>RD006895</Item><Item>RD006896</Item><Item>RD006897</Item><Item>RD006898</Item><Item>RD006899</Item><Item>RD006900</Item><Item>RD006901</Item><Item>RD006902</Item><Item>RD006903</Item><Item>RD006533</Item><Item>RD006539</Item><Item>RD006544</Item><Item>RD006551</Item><Item>RD006553</Item><Item>RD006557</Item><Item>RD006798</Item><Item>RD006799</Item><Item>RD006800</Item><Item>RD006801</Item><Item>RD006803</Item><Item>RD006804</Item><Item>RD006805</Item><Item>RD006569</Item><Item>RD006579</Item><Item>RD006889</Item><Item>RD006349</Item><Item>RD006350</Item><Item>RD006606</Item><Item>RD006611</Item><Item>RD006612</Item><Item>RD006738</Item><Item>RD006739</Item><Item>RD006740</Item><Item>RD006741</Item><Item>RD006742</Item><Item>RD006743</Item><Item>RD006745</Item><Item>RD006746</Item><Item>RD006747</Item><Item>RD006885</Item><Item>RD006886</Item><Item>RD006887</Item><Item>RD006890</Item><Item>RD006891</Item><Item>RD006908</Item><Item>RD006910</Item><Item>RD006916</Item><Item>RD006917</Item><Item>RD006918</Item><Item>RD006919</Item><Item>RD006920</Item><Item>RD006921</Item><Item>RD006922</Item><Item>RD006923</Item><Item>RD006924</Item><Item>RD006925</Item><Item>RD006192</Item><Item>RD006199</Item><Item>RD006205</Item><Item>RD006351</Item><Item>RD006352</Item><Item>RD006353</Item><Item>RD006355</Item><Item>RD006356</Item><Item>RD006357</Item><Item>RD006358</Item><Item>RD006360</Item><Item>RD006362</Item><Item>RD006363</Item><Item>RD006364</Item><Item>RD006365</Item><Item>RD006366</Item><Item>RD006368</Item><Item>RD006320</Item><Item>RD006361</Item><Item>RD006565</Item><Item>RD006904</Item><Item>RD006905</Item><Item>RD006906</Item><Item>RD006907</Item><Item>RD006909</Item><Item>RD006911</Item><Item>RD006912</Item><Item>RD006913</Item><Item>RD006914</Item><Item>RD006915</Item><Item>RD006240</Item><Item>RD006244</Item><Item>RD006258</Item><Item>RD006264</Item><Item>RD006216</Item><Item>RD006218</Item><Item>RD006419</Item><Item>RD006426</Item><Item>RD006430</Item><Item>RD006431</Item><Item>RD006434</Item><Item>RD006435</Item><Item>RD006439</Item><Item>RD006440</Item><Item>RD006445</Item><Item>RD006446</Item><Item>RD006451</Item><Item>RD006228</Item><Item>RD006604</Item><Item>RD006609</Item><Item>RD006615</Item><Item>RD006389</Item><Item>RD006698</Item><Item>RD006700</Item><Item>RD006701</Item><Item>RD006702</Item><Item>RD006703</Item><Item>RD006704</Item><Item>RD006705</Item><Item>RD006706</Item><Item>RD006707</Item><Item>RD006708</Item><Item>RD006709</Item><Item>RD006710</Item><Item>RD006711</Item><Item>RD006812</Item><Item>RD006818</Item><Item>RD006270</Item><Item>RD006414</Item><Item>RD006415</Item><Item>RD006416</Item><Item>RD006417</Item><Item>RD006274</Item><Item>RD006284</Item><Item>RD006289</Item><Item>RD006299</Item><Item>RD006447</Item><Item>RD006454</Item><Item>RD006460</Item><Item>RD006464</Item><Item>RD006468</Item><Item>RD006510</Item><Item>RD006511</Item><Item>RD006513</Item><Item>RD006224</Item><Item>RD006229</Item><Item>RD006241</Item><Item>RD006245</Item><Item>RD006774</Item><Item>RD006806</Item><Item>RD006807</Item><Item>RD006808</Item><Item>RD006809</Item><Item>RD006810</Item><Item>RD006813</Item><Item>RD006814</Item><Item>RD006815</Item><Item>RD006816</Item><Item>RD006819</Item><Item>RD006820</Item><Item>RD006827</Item><Item>RD006837</Item><Item>RD006848</Item><Item>RD006849</Item><Item>RD006850</Item><Item>RD006851</Item><Item>RD006852</Item><Item>RD006853</Item><Item>RD006854</Item><Item>RD006855</Item><Item>RD006856</Item><Item>RD006858</Item><Item>RD006859</Item><Item>RD006860</Item><Item>RD006418</Item><Item>RD006420</Item><Item>RD006421</Item><Item>RD006422</Item><Item>RD006424</Item><Item>RD006425</Item><Item>RD006427</Item><Item>RD006428</Item><Item>RD006429</Item><Item>RD006436</Item><Item>RD006437</Item><Item>RD006203</Item><Item>RD006619</Item><Item>RD006748</Item><Item>RD006749</Item><Item>RD006750</Item><Item>RD006254</Item><Item>RD006261</Item><Item>RD006266</Item><Item>RD006277</Item><Item>RD006280</Item><Item>RD006281</Item><Item>RD006286</Item><Item>RD006291</Item><Item>RD006300</Item><Item>RD006301</Item><Item>RD006455</Item><Item>RD006474</Item><Item>RD006442</Item><Item>RD006443</Item><Item>RD006448</Item><Item>RD006449</Item><Item>RD006235</Item><Item>RD006242</Item><Item>RD006369</Item><Item>RD006456</Item><Item>RD006465</Item><Item>RD006469</Item><Item>RD006471</Item><Item>RD006475</Item><Item>RD006483</Item><Item>RD006488</Item><Item>RD006497</Item><Item>RD006504</Item><Item>RD006515</Item><Item>RD006519</Item><Item>RD006524</Item><Item>RD006201</Item><Item>RD006209</Item><Item>RD006211</Item><Item>RD006212</Item><Item>RD006222</Item><Item>RD006225</Item><Item>RD006233</Item><Item>RD006370</Item><Item>RD006371</Item><Item>RD006373</Item><Item>RD006374</Item><Item>RD006375</Item><Item>RD006376</Item><Item>RD006378</Item><Item>RD006379</Item><Item>RD006380</Item><Item>RD006381</Item><Item>RD006382</Item><Item>RD006384</Item><Item>RD006386</Item><Item>RD006271</Item><Item>RD006295</Item><Item>RD006322</Item><Item>RD006217</Item><Item>RD006220</Item><Item>RD006223</Item><Item>RD006226</Item><Item>RD006230</Item><Item>RD006232</Item><Item>RD006247</Item><Item>RD006255</Item><Item>RD006257</Item><Item>RD006263</Item><Item>RD006267</Item><Item>RD006279</Item><Item>RD006252</Item><Item>RD006253</Item><Item>RD006517</Item><Item>RD006518</Item><Item>RD006237</Item><Item>RD006452</Item><Item>RD006641</Item><Item>RD006647</Item><Item>RD006649</Item><Item>RD006650</Item><Item>RD006651</Item><Item>RD006652</Item><Item>RD006655</Item><Item>RD006658</Item><Item>RD006659</Item><Item>RD006661</Item><Item>RD006662</Item><Item>RD006294</Item><Item>RD006640</Item><Item>RD006643</Item><Item>RD006324</Item><Item>RD006377</Item><Item>RD006388</Item><Item>RD006397</Item><Item>RD006432</Item><Item>RD006433</Item><Item>RD006714</Item><Item>RD006715</Item><Item>RD006720</Item><Item>RD006721</Item><Item>RD006722</Item><Item>RD006723</Item><Item>RD006724</Item><Item>RD006304</Item><Item>RD006321</Item><Item>RD006520</Item><Item>RD006521</Item><Item>RD006523</Item><Item>RD006526</Item><Item>RD006535</Item><Item>RD006538</Item><Item>RD006542</Item><Item>RD006543</Item><Item>RD006547</Item><Item>RD006548</Item><Item>RD006549</Item><Item>RD006550</Item><Item>RD006481</Item><Item>RD006482</Item><Item>RD006487</Item><Item>RD006489</Item><Item>RD006644</Item><Item>RD006660</Item><Item>RD006675</Item><Item>RD006716</Item><Item>RD006821</Item><Item>RD006822</Item><Item>RD006823</Item><Item>RD006824</Item><Item>RD006825</Item><Item>RD006826</Item><Item>RD006828</Item><Item>RD006829</Item><Item>RD006830</Item><Item>RD006717</Item><Item>RD006861</Item><Item>RD006862</Item><Item>RD006864</Item><Item>RD006865</Item><Item>RD006866</Item><Item>RD006867</Item><Item>RD006868</Item><Item>RD006869</Item><Item>RD006871</Item><Item>RD006872</Item><Item>RD006873</Item><Item>RD006491</Item><Item>RD006496</Item><Item>RD006503</Item><Item>RD006514</Item><Item>RD006516</Item><Item>RD006525</Item><Item>RD006528</Item><Item>RD006531</Item><Item>RD006534</Item><Item>RD006540</Item><Item>RD006541</Item><Item>RD006545</Item><Item>RD006529</Item><Item>RD006530</Item><Item>RD006536</Item><Item>RD006537</Item><Item>RD006343</Item><Item>RD006347</Item><Item>RD006354</Item><Item>RD006359</Item><Item>RD006621</Item><Item>RD006639</Item><Item>RD006645</Item><Item>RD006656</Item><Item>RD006666</Item><Item>RD006671</Item><Item>RD006687</Item><Item>RD006693</Item><Item>RD006699</Item><Item>RD006772</Item><Item>RD006926</Item><Item>RD006927</Item><Item>RD006285</Item><Item>RD006290</Item><Item>RD006297</Item><Item>RD006298</Item><Item>RD007036</Item><Item>RD007040</Item><Item>RD007045</Item><Item>RD007049</Item><Item>RD007057</Item><Item>RD007062</Item><Item>RD007098</Item><Item>RD007113</Item><Item>RD006931</Item><Item>RD006932</Item><Item>RD006936</Item><Item>RD006943</Item><Item>RD006950</Item><Item>RD007077</Item><Item>RD007078</Item><Item>RD007106</Item><Item>RD007130</Item><Item>RD006189</Item><Item>RD006191</Item><Item>RD006197</Item><Item>RD006202</Item><Item>RD006204</Item><Item>RD007134</Item><Item>RD007143</Item><Item>RD007146</Item><Item>RD007150</Item><Item>RD007152</Item><Item>RD007157</Item><Item>RD006972</Item><Item>RD007024</Item><Item>RD007082</Item><Item>RD007105</Item><Item>RD007122</Item><Item>RD007127</Item><Item>RD007133</Item><Item>RD007149</Item><Item>RD007174</Item><Item>RD007203</Item><Item>RD007206</Item><Item>RD007208</Item><Item>RD006462</Item><Item>RD006463</Item><Item>RD006466</Item><Item>RD006467</Item><Item>RD006470</Item><Item>RD006472</Item><Item>RD006473</Item><Item>RD006476</Item><Item>RD006477</Item><Item>RD006478</Item><Item>RD006479</Item><Item>RD006243</Item><Item>RD006780</Item><Item>RD006781</Item><Item>RD006782</Item><Item>RD006783</Item><Item>RD007089</Item><Item>RD007214</Item><Item>RD007199</Item><Item>RD007020</Item><Item>RD007101</Item><Item>RD007137</Item><Item>RD007142</Item><Item>RD007136</Item><Item>RD007145</Item><Item>RD007164</Item><Item>RD007229</Item><Item>RD007231</Item><Item>RD007030</Item><Item>RD007063</Item><Item>RD007197</Item><Item>RD007198</Item><Item>RD007230</Item><Item>RD007034</Item><Item>RD006784</Item><Item>RD006785</Item><Item>RD006786</Item><Item>RD006787</Item><Item>RD006788</Item><Item>RD006789</Item><Item>RD006791</Item><Item>RD006792</Item><Item>RD006793</Item><Item>RD006794</Item><Item>RD006795</Item><Item>RD006797</Item><Item>RD006236</Item><Item>RD006238</Item><Item>RD006500</Item><Item>RD006508</Item><Item>RD006512</Item><Item>RD007037</Item><Item>RD007042</Item><Item>RD007047</Item><Item>RD007050</Item><Item>RD007053</Item><Item>RD007058</Item><Item>RD007090</Item><Item>RD007162</Item><Item>RD007185</Item><Item>RD007025</Item><Item>RD007102</Item><Item>RD007124</Item><Item>RD007129</Item><Item>RD007147</Item><Item>RD007001</Item><Item>RD007011</Item><Item>RD007017</Item><Item>RD006990</Item><Item>RD006994</Item><Item>RD007000</Item><Item>RD007009</Item><Item>RD007018</Item><Item>RD007087</Item><Item>RD007151</Item><Item>RD007156</Item><Item>RD007161</Item><Item>RD006964</Item><Item>RD006978</Item><Item>RD006979</Item><Item>RD006982</Item><Item>RD006987</Item><Item>RD006991</Item><Item>RD007006</Item><Item>RD007016</Item><Item>RD007026</Item><Item>RD007169</Item><Item>RD007195</Item><Item>RD006965</Item><Item>RD006973</Item><Item>RD006560</Item><Item>RD006561</Item><Item>RD006568</Item><Item>RD006622</Item><Item>RD006773</Item><Item>RD006845</Item><Item>RD006857</Item><Item>RD006863</Item><Item>RD006870</Item><Item>RD006883</Item><Item>RD006888</Item><Item>RD006983</Item><Item>RD006992</Item><Item>RD006980</Item><Item>RD006993</Item><Item>RD007091</Item><Item>RD007117</Item><Item>RD007126</Item><Item>RD007148</Item><Item>RD006974</Item><Item>RD007211</Item><Item>RD007212</Item><Item>RD007213</Item><Item>RD006963</Item><Item>RD006967</Item><Item>RD006968</Item><Item>RD006995</Item><Item>RD007005</Item><Item>RD007021</Item><Item>RD007028</Item><Item>RD007052</Item><Item>RD007067</Item><Item>RD007100</Item><Item>RD007190</Item><Item>RD007191</Item><Item>RD006969</Item><Item>RD007204</Item><Item>RD007085</Item><Item>RD007094</Item><Item>RD007099</Item><Item>RD007104</Item><Item>RD007121</Item><Item>RD007135</Item><Item>RD007144</Item><Item>RD007187</Item><Item>RD007192</Item><Item>RD007010</Item><Item>RD007019</Item><Item>RD007033</Item><Item>RD007046</Item><Item>RD007076</Item><Item>RD007188</Item><Item>RD006985</Item><Item>RD007032</Item><Item>RD007056</Item><Item>RD007061</Item><Item>RD007071</Item><Item>RD007088</Item><Item>RD007110</Item><Item>RD007228</Item><Item>RD007114</Item><Item>RD007125</Item><Item>RD007170</Item><Item>RD007184</Item><Item>RD007193</Item><Item>RD007194</Item><Item>RD007222</Item><Item>RD007108</Item><Item>RD007201</Item><Item>RD007202</Item><Item>RD007218</Item><Item>RD007219</Item><Item>RD007084</Item><Item>RD007092</Item><Item>RD007210</Item><Item>RD006984</Item><Item>RD007074</Item><Item>RD007075</Item><Item>RD007079</Item><Item>RD007083</Item><Item>RD007107</Item><Item>RD007160</Item><Item>RD007182</Item><Item>RD007116</Item><Item>RD007158</Item><Item>RD007012</Item><Item>RD007043</Item><Item>RD007118</Item><Item>RD007140</Item><Item>RD007154</Item><Item>RD007216</Item><Item>RD007217</Item><Item>RD007051</Item><Item>RD007072</Item><Item>RD007086</Item><Item>RD007097</Item><Item>RD007112</Item><Item>RD007141</Item><Item>RD007155</Item><Item>RD007159</Item><Item>RD007215</Item><Item>RD007221</Item><Item>RD007223</Item><Item>RD007224</Item><Item>RD007226</Item><Item>RD007209</Item><Item>RD007200</Item><Item>RD007205</Item><Item>RD007080</Item><Item>RD007081</Item><Item>RD007138</Item><Item>RD007183</Item><Item>RD007189</Item><Item>RD007196</Item><Item>RD007220</Item><Item>RD007022</Item><Item>RD006966</Item><Item>RD006975</Item><Item>RD007103</Item><Item>RD007163</Item><Item>RD007168</Item><Item>RD007171</Item><Item>RD007175</Item><Item>RD007177</Item><Item>RD007181</Item><Item>RD007225</Item><Item>RD007227</Item><Item>RD006971</Item><Item>RD006976</Item><Item>RD006988</Item><Item>RD007008</Item><Item>RD007073</Item><Item>RD007115</Item><Item>RD007131</Item><Item>RD007132</Item><Item>RD007139</Item><Item>RD007153</Item><Item>RD007166</Item><Item>RD007007</Item><Item>RD007068</Item><Item>RD007165</Item><Item>RD007186</Item><Item>RD007064</Item><Item>RD007035</Item><Item>RD007109</Item><Item>RD007173</Item><Item>RD007179</Item><Item>RD006933</Item><Item>RD007002</Item><Item>RD007038</Item><Item>RD007054</Item><Item>RD007059</Item><Item>RD007060</Item><Item>RD007095</Item><Item>RD007167</Item><Item>RD007172</Item><Item>RD006193</Item><Item>RD006195</Item><Item>RD006200</Item><Item>RD006206</Item><Item>RD006207</Item><Item>RD006219</Item><Item>RD007180</Item><Item>RD006928</Item><Item>RD006934</Item><Item>RD006939</Item><Item>RD006945</Item><Item>RD006946</Item><Item>RD006952</Item><Item>RD006953</Item><Item>RD006959</Item><Item>RD006970</Item><Item>RD007031</Item><Item>RD007069</Item><Item>RD007096</Item><Item>RD007111</Item><Item>RD007119</Item><Item>RD007120</Item><Item>RD007123</Item><Item>RD006329</Item><Item>RD006438</Item><Item>RD006441</Item><Item>RD006444</Item><Item>RD006450</Item><Item>RD006453</Item><Item>RD006457</Item><Item>RD006458</Item><Item>RD006459</Item><Item>RD006461</Item><Item>RD006190</Item><Item>RD006208</Item><Item>RD006317</Item><Item>RD006318</Item><Item>RD006319</Item><Item>RD006763</Item><Item>RD007128</Item><Item>RD006937</Item><Item>RD006938</Item><Item>RD006944</Item><Item>RD006951</Item><Item>RD006957</Item><Item>RD006958</Item><Item>RD006962</Item><Item>RD007178</Item><Item>RD006977</Item><Item>RD006981</Item><Item>RD006986</Item><Item>RD007015</Item><Item>RD007029</Item><Item>RD007041</Item><Item>RD007093</Item><Item>RD006764</Item><Item>RD006765</Item><Item>RD006766</Item><Item>RD006767</Item><Item>RD006770</Item><Item>RD006771</Item><Item>RD006775</Item><Item>RD006776</Item><Item>RD006777</Item><Item>RD006778</Item><Item>RD006779</Item><Item>RD006188</Item><Item>RD006194</Item><Item>RD006196</Item><Item>RD006198</Item><Item>RD006210</Item><Item>RD006935</Item><Item>RD006954</Item><Item>RD006960</Item><Item>RD006961</Item><Item>RD006997</Item><Item>RD007003</Item><Item>RD007023</Item><Item>RD007207</Item><Item>RD006930</Item><Item>RD006941</Item><Item>RD006942</Item><Item>RD006948</Item><Item>RD006949</Item><Item>RD006955</Item><Item>RD006956</Item><Item>RD006998</Item><Item>RD007013</Item><Item>RD006213</Item><Item>RD006215</Item><Item>RD006305</Item><Item>RD006306</Item><Item>RD006308</Item><Item>RD006309</Item><Item>RD006310</Item><Item>RD006311</Item><Item>RD006312</Item><Item>RD006313</Item><Item>RD006575</Item><Item>RD007027</Item><Item>RD007039</Item><Item>RD007044</Item><Item>RD007048</Item><Item>RD007055</Item><Item>RD007065</Item><Item>RD007066</Item><Item>RD007070</Item><Item>RD006929</Item><Item>RD006940</Item><Item>RD006947</Item><Item>RD006989</Item><Item>RD006996</Item><Item>RD006999</Item><Item>RD007004</Item><Item>RD007014</Item></Root>";
			org.dom4j.Document documentEl = DocumentHelper.parseText(text);
			ExpertServiceImpl impl = new ExpertServiceImpl();
			//Object[] data = impl.GetDownloadSingleNodeFile("testFFFF64@izhong.com", "123456", "TF655AY9K3AR9L", "劳动法V11", "");
			Object[] data = impl.GetDocumentFiles("testTT@izhong.com", "123456", "TF655AY9K3AR9L", "劳动法V11", documentEl.getRootElement());			
//			boolean data = impl.IsNotOverdueUser("testFFFF64@izhong.com", "123456", "FF0BEC009A620DFFFF95&0");//, "劳动法", "劳动合同");
			int length = data.length;
			for(int i=0;i<length;i++)
			{
				System.out.println(data[i]);				
			}
			System.out.print("打印结束");	
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
