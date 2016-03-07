package org.izhong.expert.service;

import java.util.List;
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

public interface UpdateService {
	//查询接口方法
	public List<RES_UpdateTableInfo> qryRES_UpdateTableInfos(String whereClause, String orderbyClause);
	public List<RES_UseTechniqueinfo> qryRES_UseTechniqueinfos(String whereClause, String orderbyClause);
	public List<RESUDP_Catalog> qryRESUDP_Catalogs(String whereClause, String orderbyClause);
	public List<RESUDP_CatalogFullTree> qryRESUDP_CatalogFullTree(String whereClause, String orderbyClause);	
	public List<RESUDP_DocumentInfo> qryRESUDP_DocumentInfos(String whereClause, String orderbyClause);
	public List<RESUDP_SystemInfo> qryRESUDP_SystemInfos(String whereClause, String orderbyClause);
	public List<RESUDP_Question> qryRESUDP_Questions(String whereClause, String orderbyClause);
	public List<RESUDP_LawExample> qryRESUDP_LawExamples(String whereClause, String orderbyClause);
	public List<RESUDP_QuestionLawRef> qryRESUDP_QuestionLawRefs(String whereClause, String orderbyClause);
	public List<RESUDP_QuestionExample> qryRESUDP_QuestionExamples(String whereClause, String orderbyClause);
	public List<RESUDP_UserInfo> qryRESUDP_UserInfos(String whereClause, String orderbyClause);	

	//添加、修改接口方法
	public void updateRES_UpdateTableInfo(RES_UpdateTableInfo updateTableInfo);
	
	public int addRES_UseTechniqueinfo(RES_UseTechniqueinfo useTechniqueinfo);
	public void updateRES_UseTechniqueinfo(RES_UseTechniqueinfo useTechniqueinfo);
	public void deleteRES_UseTechniqueinfoAll();
	
	public String addRESUDP_Catalog(RESUDP_Catalog catalog);
	public void updateRESUDP_Catalog(RESUDP_Catalog catalog);
	public void updateRESUDP_CatalogGroup();
	public void updateRESUDP_CatalogNULL();
	public void notinDeleteRESUDP_Catalogs(String catalogid);
	public void deleteRESUDP_Catalog(String catalogid);
	
	public String addRESUDP_CatalogFullTree(RESUDP_CatalogFullTree catalogFullTree);
	public void updateRESUDP_CatalogFullTree(RESUDP_CatalogFullTree catalogFullTree);
	public void deleteRESUDP_CatalogFullTree(String catalogNodeID);
	
	public String addRESUDP_DocumentInfo(RESUDP_DocumentInfo documentInfo);
	public void updateRESUDP_DocumentInfo(RESUDP_DocumentInfo documentInfo);
	public void deleteRESUDP_DocumentInfo(String documentID);	
	
	public String addRESUDP_SystemInfo(RESUDP_SystemInfo documentInfo);
	public void updateRESUDP_SystemInfo(RESUDP_SystemInfo documentInfo);
	public void deleteRESUDP_SystemInfo(String documentID);
	
	public String addRESUDP_Question(RESUDP_Question question);
	public void updateRESUDP_Question(RESUDP_Question question);
	public void deleteRESUDP_Question(String questionID);
		
	public int addRESUDP_QuestionLawRef(RESUDP_QuestionLawRef questionLawRef);
	public void deleteRESUDP_QuestionLawRef(String questionID);
	
	public int addRESUDP_QuestionExample(RESUDP_QuestionExample questionExample);
	public void deleteRESUDP_QuestionExample(String questionID);	
	
	public String addRESUDP_LawExample(RESUDP_LawExample question);
	public void updateRESUDP_LawExample(RESUDP_LawExample question);
	public void deleteRESUDP_LawExample(String exampleID);

	//发布更新操作
	public void distributeUpdateRES_CATALOGFULLTREE();
	public void distributeUpdateRES_CATALOGS();
	public void distributeUpdateSYS_DOCUMENTINFOS();
	public void distributeUpdateRES_QUESTIONS();
	public void distributeUpdateRES_QUESTIONLAWREFS();
	public void distributeUpdateRES_QUESTIONEXAMPLES();	
	public void distributeUpdateRES_LAWEXAMPLES();	
	public void distributeUpdateSYS_SYSTEMINFOS();
	
}
