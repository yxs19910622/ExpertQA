package org.izhong.expert.dao;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.RESUDP_Catalog;
import org.izhong.expert.model.RESUDP_CatalogFullTree;
import org.izhong.expert.model.RESUDP_DocumentInfo;
import org.izhong.expert.model.RESUDP_LawExample;
import org.izhong.expert.model.RESUDP_Question;
import org.izhong.expert.model.RESUDP_QuestionExample;
import org.izhong.expert.model.RESUDP_QuestionLawRef;
import org.izhong.expert.model.RESUDP_SystemInfo;
import org.izhong.expert.model.RESUDP_UserInfo;
import org.izhong.expert.model.RES_UpdateTableInfo;
import org.izhong.expert.model.RES_UseTechniqueinfo;

public interface UpdateServiceDao {
	//查询接口方法
	public List<RES_UpdateTableInfo> qryRES_UpdateTableInfos(Map<String, String> map);
	public List<RES_UseTechniqueinfo> qryRES_UseTechniqueinfos(Map<String, String> map);
	public List<RESUDP_Catalog> qryRESUDP_Catalogs(Map<String, String> map);
	public List<RESUDP_CatalogFullTree> qryRESUDP_CatalogFullTree(Map<String, String> map);	
	public List<RESUDP_DocumentInfo> qryRESUDP_DocumentInfos(Map<String, String> map);
	public List<RESUDP_SystemInfo> qryRESUDP_SystemInfos(Map<String, String> map);
	public List<RESUDP_Question> qryRESUDP_Questions(Map<String, String> map);
	public List<RESUDP_QuestionLawRef> qryRESUDP_QuestionLawRefs(Map<String, String> map);
	public List<RESUDP_QuestionExample> qryRESUDP_QuestionExamples(Map<String, String> map);
	public List<RESUDP_LawExample> qryRESUDP_LawExamples(Map<String, String> map);
	public List<RESUDP_UserInfo> qryRESUDP_UserInfos(Map<String, String> map);

	//添加、修改接口方法
	public void updateRES_UpdateTableInfo(RES_UpdateTableInfo updateTableInfo);
	
	public void addRES_UseTechniqueinfo(RES_UseTechniqueinfo useTechniqueinfo);
	public void updateRES_UseTechniqueinfo(RES_UseTechniqueinfo useTechniqueinfo);
	public void deleteRES_UseTechniqueinfoAll();
	
	public void addRESUDP_Catalog(RESUDP_Catalog catalog);
	public void updateRESUDP_Catalog(RESUDP_Catalog catalog);
	public void updateRESUDP_CatalogGroup();
	public void updateRESUDP_CatalogNULL();
	public void deleteRESUDP_Catalog(String catalogid);
	public void notinDeleteRESUDP_Catalogs(Map<String, String> catalogid);
	
	public void addRESUDP_CatalogFullTree(RESUDP_CatalogFullTree catalogFullTree);
	public void updateRESUDP_CatalogFullTree(RESUDP_CatalogFullTree catalogFullTree);
	public void deleteRESUDP_CatalogFullTree(String catalognodeid);
	
	public void addRESUDP_DocumentInfo(RESUDP_DocumentInfo documentInfo);
	public void updateRESUDP_DocumentInfo(RESUDP_DocumentInfo documentInfo);
	public void deleteRESUDP_DocumentInfo(String documentID);	
	
	public void addRESUDP_SystemInfo(RESUDP_SystemInfo documentInfo);
	public void updateRESUDP_SystemInfo(RESUDP_SystemInfo documentInfo);
	public void deleteRESUDP_SystemInfo(String documentID);
	
	public void addRESUDP_Question(RESUDP_Question question);
	public void updateRESUDP_Question(RESUDP_Question question);
	public void deleteRESUDP_Question(String questionID);
		
	public void addRESUDP_QuestionLawRef(RESUDP_QuestionLawRef questionLawRef);
	public void deleteRESUDP_QuestionLawRef(String questionID);
	
	public void addRESUDP_QuestionExample(RESUDP_QuestionExample questionExample);
	public void deleteRESUDP_QuestionExample(String questionID);	
	
	public void addRESUDP_LawExample(RESUDP_LawExample lawExample);
	public void updateRESUDP_LawExample(RESUDP_LawExample lawExample);
	public void deleteRESUDP_LawExample(String exampleID);	
		
	//发布更新操作
	public void truncateRES_CATALOGFULLTREE();
	public void batchInsertRES_CATALOGFULLTREE();
	public void truncateRES_CATALOGS();
	public void batchInsertRES_CATALOGS();
	public void truncateSYS_DOCUMENTINFOS();
	public void batchInsertSYS_DOCUMENTINFOS();
	public void truncateRES_QUESTIONS();
	public void batchInsertRES_QUESTIONS();
	public void truncateRES_QUESTIONLAWREFS();
	public void batchInsertRES_QUESTIONLAWREFS();
	public void truncateRES_QUESTIONEXAMPLES();
	public void batchInsertRES_QUESTIONEXAMPLES();
	public void truncateRES_LAWEXAMPLES();
	public void batchInsertRES_LAWEXAMPLES();
	public void truncateSYS_SYSTEMINFOS();
	public void batchInsertSYS_SYSTEMINFOS();
}
