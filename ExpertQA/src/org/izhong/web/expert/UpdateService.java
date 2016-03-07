package org.izhong.web.expert;

import java.util.List;

import org.dom4j.DocumentException;
import org.izhong.expert.model.RESUDP_Catalog;
import org.izhong.expert.model.RESUDP_Question;
import org.izhong.expert.model.RESUDP_QuestionLawRef;

public interface UpdateService {
	public boolean testConnection();
	public boolean checkUser(String loginName, String passWord);
	public String getUserInfo(String loginName, String passWord);
	public long GetSystemDateTime(String loginName, String passWord);
	
	public String queryData(String loginName, String passWord, String typeName, String xmlCondition, String xmlOrderbys) throws DocumentException;
	
	public boolean updateRES_UpdateTableInfos(String loginName, String passWord, String xmlupdateTableInfo);
	public boolean updateRES_UseTechniqueinfos(String loginName, String passWord, String xmluseTechiqueinfos);
	public String addRESUDP_Catalog(String loginName, String passWord, String xmlcatalog);
	public List<String> addRESUDP_Catalogs(String loginName, String passWord, String xmlcatalogs);
	public boolean updateRESUDP_Catalogs(String loginName, String passWord, String xmlcatalogs);
	public boolean deleteRESUDP_Catalog(String loginName, String passWord, String catalogid);
	public List<String> addRESUDP_CatalogFullTree(String loginName, String passWord, String xmlcatalogFullTree);
	public boolean updateRESUDP_CatalogFullTree(String loginName, String passWord, String xmlcatalogFullTree);
	public boolean deleteRESUDP_CatalogFullTree(String loginName, String passWord, String catalogNodeID);
	public List<String> addRESUDP_DocumentInfos(String loginName, String passWord, String xmldocumentInfos);
	public boolean updateRESUDP_DocumentInfos(String loginName, String passWord, String xmldocumentInfos);
	public boolean deleteRESUPD_DocumentInfo(String loginName, String passWord, String documentID);
	public List<String> addRESUDP_SystemInfos(String loginName, String passWord, String xmlsystemInfos);
	public boolean updateRESUDP_SystemInfos(String loginName, String passWord, String xmlsystemInfos);
	public boolean deleteRESUPD_SystemInfo(String loginName, String passWord, String documentID);
	public String addRESUDP_Question(String loginName, String passWord, String xmlquestion);
	public List<String> addRESUDP_Questions(String loginName, String passWord, String xmlquestions);
	public boolean updateRESUDP_Questions(String loginName, String passWord, String xmlquestions);
	public boolean updateRESUDP_QuestionLawRefs(String loginName, String passWord, String questionID, String xmlQuestionLawRefs);
	public boolean updateRESUDP_QuestionExamples(String loginName, String passWord, String questionID, String xmlQuestionExamples);	
	public String addRESUDP_LawExample(String loginName, String passWord, String xmllawexample);
	public List<String> addRESUDP_LawExamples(String loginName, String passWord, String xmllawexamples);
	public boolean updateRESUDP_LawExamples(String loginName, String passWord, String xmllawexamples);	
	public String getLawDocumentEntities(String loginName, String passWord, String documentID);
	public boolean uploadSystemFile(String loginName, String passWord, String documentID, byte[] bytes);
	public boolean uploadDocumentFile(String loginName, String passWord, String documentID, byte[] bytes);
	public byte[] downloadSystemFile(String loginName, String passWord, String documentID);
	public byte[] downloadDocumentFile(String loginName, String passWord, String documentID);
	
	public boolean distributeUpdateTables(String loginName, String passWord, String xmlupdateTableInfo);
}
