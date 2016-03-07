package org.izhong.web.expert;

import java.util.List;

import org.dom4j.DocumentException;
import org.izhong.expert.model.RESUDP_Catalog;
import org.izhong.expert.model.RESUDP_Question;
import org.izhong.expert.model.RESUDP_QuestionLawRef;
import org.izhong.web.services.UpdateServiceRealImpl;

public class UpdateServiceImpl implements UpdateService {
	private UpdateServiceRealImpl impl;
	
	public UpdateServiceImpl() {
		this.impl = new UpdateServiceRealImpl();
	}
	@Override
	public boolean testConnection() {
		return true;
	}
	@Override
	public boolean checkUser(String loginName, String passWord)
	{
		return impl.checkUser(loginName, passWord);
	}
	@Override
	public String getUserInfo(String loginName, String passWord)
	{
		return impl.getUserInfo(loginName, passWord);
	}
	@Override
	public long GetSystemDateTime(String loginName, String passWord)
	{
		return impl.getSystemDateTime(loginName, passWord);
	}
	@Override
	public String queryData(String loginName, String passWord, String typeName, String xmlCondition, String xmlOrderbys) throws DocumentException
	{
		return impl.queryData(loginName, passWord, typeName, xmlCondition, xmlOrderbys);
	}
	@Override
	public boolean updateRES_UpdateTableInfos(String loginName, String passWord, String xmlupdateTableInfo)
	{
		return impl.updateRES_UpdateTableInfos(loginName, passWord, xmlupdateTableInfo);
	}
	@Override
	public boolean updateRES_UseTechniqueinfos(String loginName, String passWord, String xmluseTechiqueinfos)
	{
		return impl.updateRES_UseTechniqueinfos(loginName, passWord, xmluseTechiqueinfos);
	}
	@Override
	public String addRESUDP_Catalog(String loginName, String passWord, String xmlcatalog)
	{
		return impl.addRESUDP_Catalog(loginName, passWord, xmlcatalog);
	}
	@Override
	public List<String> addRESUDP_Catalogs(String loginName, String passWord, String xmlcatalogs)
	{
		return impl.addRESUDP_Catalogs(loginName, passWord, xmlcatalogs);
	}
	@Override
	public boolean updateRESUDP_Catalogs(String loginName, String passWord, String xmlcatalogs)
	{
		return impl.updateRESUDP_Catalogs(loginName, passWord, xmlcatalogs);
	}
	@Override
	public boolean deleteRESUDP_Catalog(String loginName, String passWord, String catalogid)
	{
		return impl.deleteRESUDP_Catalog(loginName, passWord, catalogid);
	}
	@Override
	public List<String> addRESUDP_CatalogFullTree(String loginName, String passWord, String xmlcatalogFullTree)
	{
		return impl.addRESUDP_CatalogFullTree(loginName, passWord, xmlcatalogFullTree);
	}
	@Override
	public boolean updateRESUDP_CatalogFullTree(String loginName, String passWord, String xmlcatalogFullTree)
	{
		return impl.updateRESUDP_CatalogFullTree(loginName, passWord, xmlcatalogFullTree);
	}
	@Override
	public boolean deleteRESUDP_CatalogFullTree(String loginName, String passWord, String catalogNodeID)
	{
		return impl.deleteRESUDP_CatalogFullTree(loginName, passWord, catalogNodeID);
	}
	@Override
	public List<String> addRESUDP_DocumentInfos(String loginName, String passWord, String xmldocumentInfos)
	{
		return impl.addRESUDP_DocumentInfos(loginName, passWord, xmldocumentInfos);
	}
	@Override
	public boolean updateRESUDP_DocumentInfos(String loginName, String passWord, String xmldocumentInfos)
	{
		return impl.updateRESUDP_DocumentInfos(loginName, passWord, xmldocumentInfos);
	}
	@Override
	public boolean deleteRESUPD_DocumentInfo(String loginName, String passWord, String documentID)
	{
		return impl.deleteRESUDP_DocumentInfo(loginName, passWord, documentID);
	}
	@Override
	public List<String> addRESUDP_SystemInfos(String loginName, String passWord, String xmlsystemInfos)
	{
		return impl.addRESUDP_SystemInfos(loginName, passWord, xmlsystemInfos);
	}
	@Override
	public boolean updateRESUDP_SystemInfos(String loginName, String passWord, String xmlsystemInfos)
	{
		return impl.updateRESUDP_SystemInfos(loginName, passWord, xmlsystemInfos);
	}
	@Override
	public boolean deleteRESUPD_SystemInfo(String loginName, String passWord, String documentID) {
		return impl.deleteRESUPD_SystemInfo(loginName, passWord, documentID);
	}
	@Override
	public String addRESUDP_Question(String loginName, String passWord, String xmlquestion)
	{
		return impl.addRESUDP_Question(loginName, passWord, xmlquestion);
	}
	@Override
	public List<String> addRESUDP_Questions(String loginName, String passWord, String xmlquestions)
	{
		return impl.addRESUDP_Questions(loginName, passWord, xmlquestions);
	}
	@Override
	public boolean updateRESUDP_Questions(String loginName, String passWord, String xmlquestions)
	{
		return impl.updateRESUDP_Questions(loginName, passWord, xmlquestions);
	}
	@Override
	public boolean updateRESUDP_QuestionLawRefs(String loginName, String passWord, String questionID, String xmlQuestionLawRefs)
	{
		return impl.updateRESUDP_QuestionLawRefs(loginName, passWord, questionID, xmlQuestionLawRefs);
	}
	@Override
	public boolean updateRESUDP_QuestionExamples(String loginName, String passWord, String questionID, String xmlQuestionExamples)
	{
		return impl.updateRESUDP_QuestionExamples(loginName, passWord, questionID, xmlQuestionExamples);
	}	
	@Override
	public String addRESUDP_LawExample(String loginName, String passWord, String xmllawexample)
	{
		return impl.addRESUDP_LawExample(loginName, passWord, xmllawexample);
	}
	@Override
	public List<String> addRESUDP_LawExamples(String loginName, String passWord, String xmllawexamples)
	{
		return impl.addRESUDP_LawExamples(loginName, passWord, xmllawexamples);
	}
	@Override
	public boolean updateRESUDP_LawExamples(String loginName, String passWord, String xmllawexamples)
	{
		return impl.updateRESUDP_LawExamples(loginName, passWord, xmllawexamples);
	}	
	@Override
	public String getLawDocumentEntities(String loginName, String passWord, String documentID)
	{
		return impl.getLawDocumentEntities(loginName, passWord, documentID);
	}
	@Override
	public boolean uploadSystemFile(String loginName, String passWord, String documentID, byte[] bytes)
	{
		return impl.uploadSystemFile(loginName, passWord, documentID, bytes);
	}
	@Override
	public boolean uploadDocumentFile(String loginName, String passWord, String documentID, byte[] bytes)
	{
		return impl.uploadDocumentFile(loginName, passWord, documentID, bytes);
	}
	@Override
	public byte[] downloadSystemFile(String loginName, String passWord, String documentID)
	{
		return impl.downloadSystemFile(loginName, passWord, documentID);
	}
	@Override
	public byte[] downloadDocumentFile(String loginName, String passWord, String documentID)
	{
		return impl.downloadDocumentFile(loginName, passWord, documentID);
	}
	@Override
	public boolean distributeUpdateTables(String loginName, String passWord, String xmlupdateTableInfo)
	{
		return impl.distributeUpdateTables(loginName, passWord, xmlupdateTableInfo);
	}
}
