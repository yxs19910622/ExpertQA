package org.izhong.web.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hsqldb.lib.StringUtil;
import org.izhong.expert.model.RESUDP_Catalog;
import org.izhong.expert.model.RESUDP_CatalogFullTree;
import org.izhong.expert.model.RESUDP_DocumentInfo;
import org.izhong.expert.model.RESUDP_LawDocumentEntity;
import org.izhong.expert.model.RESUDP_LawExample;
import org.izhong.expert.model.RESUDP_Question;
import org.izhong.expert.model.RESUDP_QuestionExample;
import org.izhong.expert.model.RESUDP_QuestionLawRef;
import org.izhong.expert.model.RESUDP_SystemInfo;
import org.izhong.expert.model.RESUDP_UserInfo;
import org.izhong.expert.model.RES_UpdateTableInfo;
import org.izhong.expert.model.RES_UseTechniqueinfo;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.service.UpdateService;
import org.izhong.expert.service.UserInfoService;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.DateUtil;
import org.izhong.web.model.Condition;
import org.izhong.web.model.DownloadPackage;
import org.izhong.web.model.ICondition;
import org.izhong.web.model.InArrayCondition;
import org.izhong.web.model.Operators;
import org.izhong.web.model.OrderbyClause;
import org.izhong.web.util.ObjectFormatUtil;
import org.izhong.web.util.StaticTable;
import org.izhong.web.util.XmlSerializer;

public class UpdateServiceRealImpl {
	private UpdateService updateServiceImpl = InitDao.getInstance().getUpdateService();
	private UserInfoService userLoginService = InitDao.getInstance().getUserInfoService();
	protected Logger log = Logger.getLogger(getClass());
	
	public UpdateServiceRealImpl(){ }
	
	public boolean checkUser(String loginName, String passWord)
	{
		return this.validateUserInfo(loginName, passWord);
	}
	public String getUserInfo(String loginName, String passWord)
	{
		SysUsers user = this.validateAndGetUserInfo(loginName, passWord);
		if(user != null)
		{
			Element element = DocumentHelper.createElement("USERINFO");
			element.addElement("USERID").addText(user.getUserID());
			element.addElement("USERNAME").addText(user.getUserName());
			element.addElement("LOGINNAME").addText(user.getEmail());
			return element.asXML();
		}
		return null;
	}
	public long getSystemDateTime(String loginName, String passWord)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return 0;
		return DateUtil.clientTime();
	}
	//公共查询接口
	public String queryData(String loginName, String passWord, String typeName, String xmlCondition, String xmlOrderbys) throws DocumentException
	{
		ICondition condition = ObjectFormatUtil.ParserCondition(xmlCondition);
		OrderbyClause[] orderbyClause = ObjectFormatUtil.ParserOrderbys(xmlOrderbys);		
		return this.QueryData(loginName, passWord, typeName, condition, orderbyClause);
	}
	
	private String QueryData(String loginName, String passWord, String typeName, ICondition condition, OrderbyClause[] orderbyClause) throws DocumentException
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		//注意：此处直接将条件变成查询字符串，
		//如果实体成员名称与数据库字段名称不一致，则此处还需要替换为最终字段名称s
		String conditionScript = (condition != null) ? condition.getScript() : "";
		String orderbyScript ="";
		if(orderbyClause != null)
		{
			for(int i=0;i<orderbyClause.length;i++)
			{
				orderbyScript += orderbyClause[i].getScript();
				if(i < orderbyClause.length-1) orderbyScript += ",";
			}
		}//
		if(typeName.equalsIgnoreCase("RES_UpdateTableInfo"))
		{
			List<RES_UpdateTableInfo> result = this.updateServiceImpl.qryRES_UpdateTableInfos(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRES_UpdateTableInfos(result);
			return dataEl.asXML();
		} 
		else if(typeName.equalsIgnoreCase("RES_UseTechniqueinfo"))
		{
			List<RES_UseTechniqueinfo> result = this.updateServiceImpl.qryRES_UseTechniqueinfos(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRES_UseTechniqueinfos(result);
			return dataEl.asXML();
		} 
		else if(typeName.equalsIgnoreCase("RESUDP_Catalog"))
		{
			List<RESUDP_Catalog> result = this.updateServiceImpl.qryRESUDP_Catalogs(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_Catalogs(result);
			return dataEl.asXML();
		} else if(typeName.equalsIgnoreCase("RESUDP_CatalogFullTree"))
		{
			List<RESUDP_CatalogFullTree> result = this.updateServiceImpl.qryRESUDP_CatalogFullTree(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_CatalogFullTree(result);
			return dataEl.asXML();
		}
		else if(typeName.equalsIgnoreCase("RESUDP_DocumentInfo"))
		{
			List<RESUDP_DocumentInfo> result = this.updateServiceImpl.qryRESUDP_DocumentInfos(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_DocumentInfos(result);
			return dataEl.asXML();
		}
		else if(typeName.equalsIgnoreCase("RESUDP_SystemInfo"))
		{
			List<RESUDP_SystemInfo> result = this.updateServiceImpl.qryRESUDP_SystemInfos(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_SystemInfos(result);
			return dataEl.asXML();
		}		
		else if(typeName.equalsIgnoreCase("RESUDP_Question"))
		{
			List<RESUDP_Question> result = this.updateServiceImpl.qryRESUDP_Questions(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_Questions(result);
			return dataEl.asXML();
		}
		else if(typeName.equalsIgnoreCase("RESUDP_QuestionLawRef"))
		{
			List<RESUDP_QuestionLawRef> result = this.updateServiceImpl.qryRESUDP_QuestionLawRefs(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_QuestionLawRefs(result);
			return dataEl.asXML();
		}
		else if(typeName.equalsIgnoreCase("RESUDP_QuestionExample"))
		{
			List<RESUDP_QuestionExample> result = this.updateServiceImpl.qryRESUDP_QuestionExamples(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_QuestionExamples(result);
			return dataEl.asXML();
		}
		else if(typeName.equalsIgnoreCase("RESUDP_LawExample"))
		{
			List<RESUDP_LawExample> result = this.updateServiceImpl.qryRESUDP_LawExamples(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_LawExamples(result);
			return dataEl.asXML();
		}
		else if(typeName.equalsIgnoreCase("RESUDP_UserInfo"))
		{
			List<RESUDP_UserInfo> result = this.updateServiceImpl.qryRESUDP_UserInfos(conditionScript, orderbyScript);
			Element dataEl = XmlSerializer.SerializeRESUDP_UserInfos(result);
			return dataEl.asXML();
		}
		else return null;
	}
	
	//添加、更新、删除操作
	public boolean updateRES_UpdateTableInfos(String loginName, String passWord, String xmlupdateTableInfo)
	{
		if(StringUtil.isEmpty(xmlupdateTableInfo) == true) return false;
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlupdateTableInfo).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		List<RES_UpdateTableInfo> infolist = XmlSerializer.DeserializeRES_UpdateTableInfos(root);
		int size = infolist.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.updateRES_UpdateTableInfo(infolist.get(i));
		}
		return true;
	}
	
	public boolean updateRES_UseTechniqueinfos(String loginName, String passWord, String xmluseTechiqueinfos)
	{
		if(StringUtil.isEmpty(xmluseTechiqueinfos) == true) return false;
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmluseTechiqueinfos).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		this.updateServiceImpl.deleteRES_UseTechniqueinfoAll();
		List<RES_UseTechniqueinfo> infolist = XmlSerializer.DeserializeRES_UseTechniqueinfos(root);
		int size = infolist.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.addRES_UseTechniqueinfo(infolist.get(i));
		}
		return true;
	}
	
	public String addRESUDP_Catalog(String loginName, String passWord, String xmlcatalog)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlcatalog).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		List<RESUDP_Catalog> values = XmlSerializer.DeserializeRESUDP_Catalogs(root);
		if(values.size() != 1) return "";
		else return this.updateServiceImpl.addRESUDP_Catalog(values.get(0));
	}
	
	public List<String> addRESUDP_Catalogs(String loginName, String passWord, String xmlcatalogs)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlcatalogs).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		List<RESUDP_Catalog> values = XmlSerializer.DeserializeRESUDP_Catalogs(root);
		List<String> tids = new ArrayList<String>();
		int size = values.size();
		for(int i=0;i<size;i++)
		{
			tids.add(this.updateServiceImpl.addRESUDP_Catalog(values.get(i)));
		}
		return tids;
	}
	
	public boolean updateRESUDP_Catalogs(String loginName, String passWord, String xmlcatalogs)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlcatalogs).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		List<RESUDP_Catalog> values = XmlSerializer.DeserializeRESUDP_Catalogs(root);
		int size = values.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.updateRESUDP_Catalog(values.get(i));
		}
		return true;
	}
	
	public boolean deleteRESUDP_Catalog(String loginName, String passWord, String catalogid)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;

		this.updateServiceImpl.deleteRESUDP_Catalog(catalogid);
		return true;
	}
	
//	public boolean mergeUpdateRESUDP_Catalogs(String loginName, String passWord, String xmlcatalogs) {
//		if(this.validateUserInfo(loginName, passWord) == false) return false;
//		
//		Element root = null;
//		try {
//			root = DocumentHelper.parseText(xmlcatalogs).getRootElement();
//		} catch (DocumentException e) {
//			e.printStackTrace();
//			return false;
//		}
//		//添加、修改结果数据
//		StringBuilder builder = new StringBuilder();
//		builder.append(" CATALOGID not in (");
//		List<String> catalogIDs = new ArrayList<String>();
//		List<RESUDP_Catalog> values = XmlSerializer.DeserializeRESUDP_Catalogs(root);
//		int size = values.size();
//		for(int i=0;i<size;i++)
//		{
//			RESUDP_Catalog current = values.get(i);
//			if(BaseUtil.isEmpty(current.getCatalogid()))
//			{
//				this.updateServiceImpl.addRESUDP_Catalog(current);
//			}
//			else
//			{
//				this.updateServiceImpl.updateRESUDP_Catalog(current);
//			}
//			catalogIDs.add(current.getCatalogid());
//			builder.append("'" + current.getCatalogid() + "'");
//			if(i < size-1) builder.append(",");
//		}
//		builder.append(")");
//		//删除不在指定范围内的数据
//		String catalogid = builder.toString();
//		this.updateServiceImpl.notinDeleteRESUDP_Catalogs(catalogid);
//		//更新树状关系
//		this.updateServiceImpl.updateRESUDP_CatalogGroup();
//		this.updateServiceImpl.updateRESUDP_CatalogNULL();
//		return true;
//	}
	
	public List<String> addRESUDP_CatalogFullTree(String loginName, String passWord, String xmlcatalogFullTree)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlcatalogFullTree).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		List<RESUDP_CatalogFullTree> values = XmlSerializer.DeserializeRESUDP_CatalogFullTree(root);
		List<String> tids = new ArrayList<String>();
		int size = values.size();
		for(int i=0;i<size;i++)
		{
			tids.add(this.updateServiceImpl.addRESUDP_CatalogFullTree(values.get(i)));
		}
		return tids;
	}
	
	public boolean updateRESUDP_CatalogFullTree(String loginName, String passWord, String xmlcatalogFullTree)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlcatalogFullTree).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		List<RESUDP_CatalogFullTree> values = XmlSerializer.DeserializeRESUDP_CatalogFullTree(root);
		int size = values.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.updateRESUDP_CatalogFullTree(values.get(i));
		}
		return true;
	}
	
	public boolean deleteRESUDP_CatalogFullTree(String loginName, String passWord, String catalogNodeID) {
		if(this.validateUserInfo(loginName, passWord) == false) return false;

		this.updateServiceImpl.deleteRESUDP_CatalogFullTree(catalogNodeID);
		return true;
	}
	
	public List<String> addRESUDP_DocumentInfos(String loginName, String passWord, String xmldocumentInfos)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmldocumentInfos).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		List<RESUDP_DocumentInfo> values = XmlSerializer.DeserializeRESUDP_DocumentInfos(root);
		List<String> tids = new ArrayList<String>();
		int size = values.size();
		for(int i=0;i<size;i++)
		{
			tids.add(this.updateServiceImpl.addRESUDP_DocumentInfo(values.get(i)));
		}
		return tids;
	}
	
	public boolean updateRESUDP_DocumentInfos(String loginName, String passWord, String xmldocumentInfos)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmldocumentInfos).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		List<RESUDP_DocumentInfo> values = XmlSerializer.DeserializeRESUDP_DocumentInfos(root);
		int size = values.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.updateRESUDP_DocumentInfo(values.get(i));
		}
		return true;
	}

	public boolean deleteRESUDP_DocumentInfo(String loginName, String passWord, String documentID)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;

		this.updateServiceImpl.deleteRESUDP_DocumentInfo(documentID);
		return true;
	}
	
	public List<String> addRESUDP_SystemInfos(String loginName, String passWord, String xmlsystemInfos)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlsystemInfos).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		List<RESUDP_SystemInfo> values = XmlSerializer.DeserializeRESUDP_SystemInfos(root);
		List<String> tids = new ArrayList<String>();
		int size = values.size();
		for(int i=0;i<size;i++)
		{
			tids.add(this.updateServiceImpl.addRESUDP_SystemInfo(values.get(i)));
		}
		return tids;
	}
	
	public boolean updateRESUDP_SystemInfos(String loginName, String passWord, String xmlsystemInfos)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlsystemInfos).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		List<RESUDP_SystemInfo> values = XmlSerializer.DeserializeRESUDP_SystemInfos(root);
		int size = values.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.updateRESUDP_SystemInfo(values.get(i));
		}
		return true;
	}
	
	public boolean deleteRESUPD_SystemInfo(String loginName, String passWord, String documentID)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;

		this.updateServiceImpl.deleteRESUDP_SystemInfo(documentID);
		return true;
	}
	
	public String addRESUDP_Question(String loginName, String passWord, String xmlquestion)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return "";
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlquestion).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		List<RESUDP_Question> questions = XmlSerializer.DeserializeRESUDP_Questions(root);
		if(questions.size() != 1) return "";
		else return this.updateServiceImpl.addRESUDP_Question(questions.get(0));
	}
	
	public List<String> addRESUDP_Questions(String loginName, String passWord, String xmlquestions)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlquestions).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		List<RESUDP_Question> quesetions = XmlSerializer.DeserializeRESUDP_Questions(root);
		List<String> qids = new ArrayList<String>();
		int size = quesetions.size();
		for(int i=0;i<size;i++)
		{
			qids.add(this.updateServiceImpl.addRESUDP_Question(quesetions.get(i)));
		}
		return qids;
	}
	
	public boolean updateRESUDP_Questions(String loginName, String passWord, String xmlquestions)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlquestions).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		List<RESUDP_Question> quesetions = XmlSerializer.DeserializeRESUDP_Questions(root);
		int size = quesetions.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.updateRESUDP_Question(quesetions.get(i));
		}
		return true;
	}

	public boolean updateRESUDP_QuestionLawRefs(String loginName, String passWord, String questionID, String xmlQuestionLawRefs)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlQuestionLawRefs).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		this.updateServiceImpl.deleteRESUDP_QuestionLawRef(questionID);
		
		List<RESUDP_QuestionLawRef> questionLawRefs = XmlSerializer.DeserializeRESUDP_QuestionLawRefs(root);
		int size = questionLawRefs.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.addRESUDP_QuestionLawRef(questionLawRefs.get(i));
		}
		return true;
	}
	
	public boolean updateRESUDP_QuestionExamples(String loginName, String passWord, String questionID, String xmlQuestionExamples)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlQuestionExamples).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		this.updateServiceImpl.deleteRESUDP_QuestionExample(questionID);
		
		List<RESUDP_QuestionExample> questionExamples = XmlSerializer.DeserializeRESUDP_QuestionExamples(root);
		int size = questionExamples.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.addRESUDP_QuestionExample(questionExamples.get(i));
		}
		return true;
	}	
	
	public String addRESUDP_LawExample(String loginName, String passWord, String xmllawexample)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return "";
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmllawexample).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		List<RESUDP_LawExample> questions = XmlSerializer.DeserializeRESUDP_LawExamples(root);
		if(questions.size() != 1) return "";
		else return this.updateServiceImpl.addRESUDP_LawExample(questions.get(0));
	}
	
	public List<String> addRESUDP_LawExamples(String loginName, String passWord, String xmllawexamples)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmllawexamples).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		List<RESUDP_LawExample> quesetions = XmlSerializer.DeserializeRESUDP_LawExamples(root);
		List<String> qids = new ArrayList<String>();
		int size = quesetions.size();
		for(int i=0;i<size;i++)
		{
			qids.add(this.updateServiceImpl.addRESUDP_LawExample(quesetions.get(i)));
		}
		return qids;
	}
	
	public boolean updateRESUDP_LawExamples(String loginName, String passWord, String xmllawexamples)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmllawexamples).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		List<RESUDP_LawExample> quesetions = XmlSerializer.DeserializeRESUDP_LawExamples(root);
		int size = quesetions.size();
		for(int i=0;i<size;i++)
		{
			this.updateServiceImpl.updateRESUDP_LawExample(quesetions.get(i));
		}
		return true;
	}
	
	public String getLawDocumentEntities(String loginName, String passWord, String documentID)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		if(BaseUtil.isEmpty(documentID) == true) return null;
		
		ICondition condition = new Condition("documentid", Operators.Equals, documentID);
		List<RESUDP_DocumentInfo> result = this.updateServiceImpl.qryRESUDP_DocumentInfos(condition.getScript(), null);
		if(result == null || result.size() == 0) return null;
		RESUDP_DocumentInfo documentInfo = result.get(0);
		Document document = null; 
		  try 
		   { 
			  String fullName = this.getFullDocumentFileName(documentInfo.getLocation());
		       SAXReader saxReader = new SAXReader(); 
		       document = saxReader.read(new File(fullName)); 
			  Element root = document.getRootElement();
			List<RESUDP_LawDocumentEntity> values = new ArrayList<RESUDP_LawDocumentEntity>();
			this.parserDocumentEntities(documentInfo.getDocumentid(),documentInfo.getTitle(), values, root);
			return XmlSerializer.SerializeRESUDP_LawDocumentEntities(values).asXML();		       
		   } 
		  catch (Exception ex){ 
		       ex.printStackTrace(); 
		   }
		  return "";
	}
	
	public boolean uploadSystemFile(String loginName, String passWord, String documentID, byte[] bytes)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		if((BaseUtil.isEmpty(documentID) == true)||(bytes == null)) return false;
		
		ICondition condition = new Condition("documentid", Operators.Equals, documentID);
		List<RESUDP_SystemInfo> result = this.updateServiceImpl.qryRESUDP_SystemInfos(condition.getScript(), null);
		if(result == null || result.size() == 0) return false;
		RESUDP_SystemInfo documentInfo = result.get(0);
		String fullName = this.getFullDocumentFileName(documentInfo.getLocation());
		
		try {
			FileOutputStream fo = new FileOutputStream(fullName);
			fo.write(bytes);
			fo.close();
			return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
		
	public boolean uploadDocumentFile(String loginName, String passWord, String documentID, byte[] bytes)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		if((BaseUtil.isEmpty(documentID) == true)||(bytes == null)) return false;
		
		ICondition condition = new Condition("documentid", Operators.Equals, documentID);
		List<RESUDP_DocumentInfo> result = this.updateServiceImpl.qryRESUDP_DocumentInfos(condition.getScript(), null);
		if(result == null || result.size() == 0) return false;
		RESUDP_DocumentInfo documentInfo = result.get(0);
		String fullName = this.getFullDocumentFileName(documentInfo.getLocation());
		try {
			FileOutputStream fo = new FileOutputStream(fullName);
			fo.write(bytes);
			fo.close();
			return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	public byte[] downloadSystemFile(String loginName, String passWord, String documentID)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		if(BaseUtil.isEmpty(documentID) == true) return null;
		
		ICondition condition = new Condition("documentid", Operators.Equals, documentID);
		List<RESUDP_SystemInfo> result = this.updateServiceImpl.qryRESUDP_SystemInfos(condition.getScript(), null);
		if(result == null || result.size() == 0) return null;
		RESUDP_SystemInfo documentInfo = result.get(0);
		String fullName = this.getFullDocumentFileName(documentInfo.getLocation());
		
		byte[] bytes = null;
		try {
			FileInputStream fo = new FileInputStream(fullName);
			bytes = new byte[fo.available()];
			fo.read(bytes);
			fo.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bytes;
	}
	
	public byte[] downloadDocumentFile(String loginName, String passWord, String documentID)
	{
		if(this.validateUserInfo(loginName, passWord) == false) return null;
		if(BaseUtil.isEmpty(documentID) == true) return null;
		
		ICondition condition = new Condition("documentid", Operators.Equals, documentID);
		List<RESUDP_DocumentInfo> result = this.updateServiceImpl.qryRESUDP_DocumentInfos(condition.getScript(), null);
		if(result == null || result.size() == 0) return null;
		RESUDP_DocumentInfo documentInfo = result.get(0);
		String fullName = this.getFullDocumentFileName(documentInfo.getLocation());
		
		byte[] bytes = null;
		try {
			FileInputStream fo = new FileInputStream(fullName);
			bytes = new byte[fo.available()];
			fo.read(bytes);
			fo.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bytes;
	}
	//发布更新操作
	public boolean distributeUpdateTables(String loginName, String passWord, String xmlupdateTableInfo)
	{
		if(StringUtil.isEmpty(xmlupdateTableInfo) == true) return false;
		if(this.validateUserInfo(loginName, passWord) == false) return false;
		
		Element root = null;
		try {
			root = DocumentHelper.parseText(xmlupdateTableInfo).getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Date currentDate = DateUtil.getCurrTime();
		List<RES_UpdateTableInfo> infolist = XmlSerializer.DeserializeRES_UpdateTableInfos(root);
		int size = infolist.size();
		for(int i=0;i<size;i++)
		{
			RES_UpdateTableInfo table = infolist.get(i);
			if("CatalogFullTree".equals(table.getTablename()))
			{
				this.updateServiceImpl.distributeUpdateRES_CATALOGFULLTREE();
			}
			else if("Catalogs".equals(table.getTablename()))
			{
				this.updateServiceImpl.distributeUpdateRES_CATALOGS();
			}
			else if("QuestionLawRefs".equals(table.getTablename()))
			{
				this.updateServiceImpl.distributeUpdateRES_QUESTIONLAWREFS();
			}
			else if("Questions".equals(table.getTablename()))
			{
				this.updateServiceImpl.distributeUpdateRES_QUESTIONS();
			}
			else if("ResourceDocuments".equals(table.getTablename()))
			{
				this.updateServiceImpl.distributeUpdateSYS_DOCUMENTINFOS();
			}
			else if("SystemDocuments".equals(table.getTablename()))
			{
				this.updateServiceImpl.distributeUpdateSYS_SYSTEMINFOS();
			}
			table.setLastdate(currentDate);
			this.updateServiceImpl.updateRES_UpdateTableInfo(table);
		}
		return true;
	}
    
    private boolean validateUserInfo(String loginName, String passWord)
    {
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(passWord))
		{
			//用户名和密码不能为空
			return false;
		}
		SysUsers sysuser = userLoginService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			//用户名不存在
			return false;
		}
		if(!BaseUtil.Md5(passWord+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			//密码不正确
			return false;
		}
    	return true;
    }
    
    private SysUsers validateAndGetUserInfo(String loginName, String passWord)
    {
		if(BaseUtil.isEmpty(loginName) || BaseUtil.isEmpty(passWord)) //?
		{
			return null;
		}
		SysUsers sysuser = userLoginService.getSysUserByLogName(loginName);
		if(sysuser==null)
		{
			return null;
		}
		if(!BaseUtil.Md5(passWord+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
		{
			return null;
		}
    	return sysuser;
    }
    
    private String getFullDocumentFileName(String fileLocation)
    {
		String rootpath = StaticTable.ROOTPATH;
		if(!System.getProperty("os.name").contains("Windows"))
		{
			rootpath = StaticTable.LINXROOTPATH;
		}
		String fullName = rootpath + fileLocation;
		String separator = System.getProperty("file.separator");
		if("\\".equals(separator) == false)
		{
			while(fullName.indexOf("\\") >= 0)
			{
				fullName = fullName.replace("\\", separator);
			}			
		}
		log.info(fullName);
		return fullName;
    }
    
    private void parserDocumentEntities(String documentID, String titleName, List<RESUDP_LawDocumentEntity> entites, Element element)
    {
    	if("Entity".equalsIgnoreCase(element.getName()) == true)
    	{
    		RESUDP_LawDocumentEntity entity = new RESUDP_LawDocumentEntity();
    		entity.setDocumentID(documentID);
    		entity.setDocumentName(titleName);
    		entity.setEntityNo(element.element("IndexNo").getText());
    		entity.setDescription(element.element("Description").getText());
    		entites.add(entity);
    		return;
    	}
    	else
    	{
    		Element subEl = element.element("LawEntities");
    		if(subEl == null)
    		{
    			RESUDP_LawDocumentEntity entity = new RESUDP_LawDocumentEntity();
        		entity.setDocumentID(documentID);
        		entity.setDocumentName(titleName);
        		entity.setEntityNo("");
        		entity.setDescription("");
        		entites.add(entity);
        		return;
    		}
    		else
    		{
    			List<Element> subEls = subEl.elements();
    			int size = subEls.size();
    			for(int i=0;i<size;i++) {
    				this.parserDocumentEntities(documentID, titleName, entites, subEls.get(i));
    			}
    		}
    	}
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
	public DownloadPackage DownloadSingleFile(DownloadPackage connectParamPack)
	{
		return null;
	}
	/*
	 * 首次登录之后下载试看文件（当前为劳动合同部分的问答及法规类文件）
	 * 
	 */
	public DownloadPackage DownloadTryDocuments(DownloadPackage connectParamPack)
	{
		return null;
	}
	
	/*
	 * 批量下载指资源编号组的文件组
	 */
	public DownloadPackage DownloadMultiFiles(DownloadPackage connectParamPack)
	{
		return null;
	}
	
	/*
	 * 依指定关键字获取专家问答部分的问题列表
	 */
	public DownloadPackage GetLABQAQuestionList(DownloadPackage connectParamPack)
	{
		return null;
	}

    public static void main(String[] args)
    {
//    	String whereClause = "(title like '%招聘%')";
//    	String orderbyClause = "title";
//    	try {
//    		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
//   		 	UpdateService updateService = (UpdateService) ac.getBean("updateService");
//   		 	
//   		 	List<RESUDP_Question> queryData = updateService.qryRESUDP_Questions(whereClause, orderbyClause);
//    		System.out.println("UpdateServiceRealImpl.main()"+queryData.size());
//    		Element root = XmlSerializer.SerializeRESUDP_Questions(queryData);
//	    	System.out.print(root.asXML());
//    	}catch(Exception ex)
//    	{
//    		ex.printStackTrace();
//    	}
    }
}
