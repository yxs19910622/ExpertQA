package org.izhong.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.UpdateServiceDao;
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

public class UpdateServiceImpl implements UpdateService {
	private UpdateServiceDao updateServiceDao;

	public void setUpdateServiceDao(UpdateServiceDao updateServiceDao) {
		this.updateServiceDao = updateServiceDao;
	}
	//查询接口方法
	@Override
	public List<RES_UpdateTableInfo> qryRES_UpdateTableInfos(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRES_UpdateTableInfos(map);
	}
	@Override
	public List<RES_UseTechniqueinfo> qryRES_UseTechniqueinfos(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRES_UseTechniqueinfos(map);
	}
	@Override
	public List<RESUDP_Catalog> qryRESUDP_Catalogs(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_Catalogs(map);
	}
	@Override
	public List<RESUDP_CatalogFullTree> qryRESUDP_CatalogFullTree(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_CatalogFullTree(map);
	}
	@Override
	public List<RESUDP_DocumentInfo> qryRESUDP_DocumentInfos(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_DocumentInfos(map);
	}
	@Override
	public List<RESUDP_SystemInfo> qryRESUDP_SystemInfos(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_SystemInfos(map);
	}
	@Override
	public List<RESUDP_Question> qryRESUDP_Questions(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_Questions(map);
	}
	@Override
	public List<RESUDP_QuestionLawRef> qryRESUDP_QuestionLawRefs(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_QuestionLawRefs(map);
	}
	@Override
	public List<RESUDP_QuestionExample> qryRESUDP_QuestionExamples(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_QuestionExamples(map);
	}	
	@Override
	public List<RESUDP_LawExample> qryRESUDP_LawExamples(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_LawExamples(map);
	}		
	@Override
	public List<RESUDP_UserInfo> qryRESUDP_UserInfos(String whereClause, String orderbyClause)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.updateServiceDao.qryRESUDP_UserInfos(map);
	}
	//添加、修改接口方法
	@Override
	public void updateRES_UpdateTableInfo(RES_UpdateTableInfo updateTableInfo)
	{
		this.updateServiceDao.updateRES_UpdateTableInfo(updateTableInfo);
	}
	@Override
	public int addRES_UseTechniqueinfo(RES_UseTechniqueinfo useTechniqueinfo)
	{
		this.updateServiceDao.addRES_UseTechniqueinfo(useTechniqueinfo);
		return useTechniqueinfo.getTid();
	}
	@Override
	public void updateRES_UseTechniqueinfo(RES_UseTechniqueinfo useTechniqueinfo)
	{
		this.updateServiceDao.updateRES_UseTechniqueinfo(useTechniqueinfo);
	}
	@Override
	public void deleteRES_UseTechniqueinfoAll()
	{
		this.updateServiceDao.deleteRES_UseTechniqueinfoAll();
	}
	@Override
	public String addRESUDP_Catalog(RESUDP_Catalog catalog)
	{
		this.updateServiceDao.addRESUDP_Catalog(catalog);
		return catalog.getCatalogid();
	}
	@Override
	public void updateRESUDP_Catalog(RESUDP_Catalog catalog)
	{
		this.updateServiceDao.updateRESUDP_Catalog(catalog);
	}
	@Override
	public void updateRESUDP_CatalogGroup()
	{
		this.updateServiceDao.updateRESUDP_CatalogGroup();
	}
	@Override
	public void updateRESUDP_CatalogNULL() {
		this.updateServiceDao.updateRESUDP_CatalogNULL();
	}
	@Override
	public void deleteRESUDP_Catalog(String catalogid)
	{
		this.updateServiceDao.deleteRESUDP_Catalog(catalogid);
	}
	@Override
	public void notinDeleteRESUDP_Catalogs(String catalogid)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("catalogid", catalogid);
		this.updateServiceDao.notinDeleteRESUDP_Catalogs(map);
	}
	@Override
	public String addRESUDP_CatalogFullTree(RESUDP_CatalogFullTree catalogFullTree)
	{
		this.updateServiceDao.addRESUDP_CatalogFullTree(catalogFullTree);
		return catalogFullTree.getCatalognodeid();
	}
	@Override
	public void updateRESUDP_CatalogFullTree(RESUDP_CatalogFullTree catalogFullTree)
	{
		this.updateServiceDao.updateRESUDP_CatalogFullTree(catalogFullTree);
	}
	@Override
	public void deleteRESUDP_CatalogFullTree(String catalognodeid)
	{
		this.updateServiceDao.deleteRESUDP_CatalogFullTree(catalognodeid);
	}
	@Override
	public String addRESUDP_DocumentInfo(RESUDP_DocumentInfo documentInfo)
	{
		this.updateServiceDao.addRESUDP_DocumentInfo(documentInfo);
		return documentInfo.getDocumentid();
	}
	@Override
	public void updateRESUDP_DocumentInfo(RESUDP_DocumentInfo documentInfo)
	{
		this.updateServiceDao.updateRESUDP_DocumentInfo(documentInfo);
	}
	@Override
	public void deleteRESUDP_DocumentInfo(String documentID)
	{
		this.updateServiceDao.deleteRESUDP_DocumentInfo(documentID);
	}
	@Override
	public String addRESUDP_SystemInfo(RESUDP_SystemInfo documentInfo)
	{
		this.updateServiceDao.addRESUDP_SystemInfo(documentInfo);
		return documentInfo.getDocumentid();
	}
	@Override
	public void updateRESUDP_SystemInfo(RESUDP_SystemInfo documentInfo)
	{
		this.updateServiceDao.updateRESUDP_SystemInfo(documentInfo);
	}
	@Override
	public void deleteRESUDP_SystemInfo(String documentID)
	{
		this.updateServiceDao.deleteRESUDP_SystemInfo(documentID);
	}
	@Override
	public String addRESUDP_Question(RESUDP_Question question)
	{
		updateServiceDao.addRESUDP_Question(question);
		return question.getQuestionid();
	}
	@Override
	public void updateRESUDP_Question(RESUDP_Question question)
	{
		this.updateServiceDao.updateRESUDP_Question(question);
	}
	@Override
	public void deleteRESUDP_Question(String questionID)
	{
		this.updateServiceDao.deleteRESUDP_Question(questionID);
	}
	@Override
	public int addRESUDP_QuestionLawRef(RESUDP_QuestionLawRef questionLawRef)
	{
		this.updateServiceDao.addRESUDP_QuestionLawRef(questionLawRef);
		return questionLawRef.getTid();
	}
	@Override
	public void deleteRESUDP_QuestionLawRef(String questionID)
	{
		this.updateServiceDao.deleteRESUDP_QuestionLawRef(questionID);
	}
	@Override
	public int addRESUDP_QuestionExample(RESUDP_QuestionExample questionExample)
	{
		this.updateServiceDao.addRESUDP_QuestionExample(questionExample);
		return questionExample.getTid();
	}
	@Override
	public void deleteRESUDP_QuestionExample(String questionID)
	{
		this.updateServiceDao.deleteRESUDP_QuestionExample(questionID);
	}
	@Override
	public String addRESUDP_LawExample(RESUDP_LawExample question)
	{
		updateServiceDao.addRESUDP_LawExample(question);
		return question.getExampleid();
	}
	@Override
	public void updateRESUDP_LawExample(RESUDP_LawExample question)
	{
		this.updateServiceDao.updateRESUDP_LawExample(question);
	}
	@Override
	public void deleteRESUDP_LawExample(String exampleID)
	{
		this.updateServiceDao.deleteRESUDP_LawExample(exampleID);
	}
	@Override
	public void distributeUpdateRES_CATALOGFULLTREE()
	{
		this.updateServiceDao.truncateRES_CATALOGFULLTREE();
		this.updateServiceDao.batchInsertRES_CATALOGFULLTREE();
	}
	@Override
	public void distributeUpdateRES_CATALOGS()
	{
		this.updateServiceDao.truncateRES_CATALOGS();
		this.updateServiceDao.batchInsertRES_CATALOGS();
	}
	@Override
	public void distributeUpdateSYS_DOCUMENTINFOS()
	{
		this.updateServiceDao.truncateSYS_DOCUMENTINFOS();
		this.updateServiceDao.batchInsertSYS_DOCUMENTINFOS();
	}
	@Override
	public void distributeUpdateRES_QUESTIONS()
	{
		this.updateServiceDao.truncateRES_QUESTIONS();
		this.updateServiceDao.batchInsertRES_QUESTIONS();
	}	
	@Override
	public void distributeUpdateRES_QUESTIONLAWREFS()
	{
		this.updateServiceDao.truncateRES_QUESTIONLAWREFS();
		this.updateServiceDao.batchInsertRES_QUESTIONLAWREFS();
	}
	@Override
	public void distributeUpdateRES_QUESTIONEXAMPLES()
	{
		this.updateServiceDao.truncateRES_QUESTIONEXAMPLES();
		this.updateServiceDao.batchInsertRES_QUESTIONEXAMPLES();
	}	
	@Override
	public void distributeUpdateRES_LAWEXAMPLES()
	{
		this.updateServiceDao.truncateRES_LAWEXAMPLES();
		this.updateServiceDao.batchInsertRES_LAWEXAMPLES();
	}
	@Override
	public void distributeUpdateSYS_SYSTEMINFOS()
	{
		this.updateServiceDao.truncateSYS_SYSTEMINFOS();
		this.updateServiceDao.batchInsertSYS_SYSTEMINFOS();
	}
}
