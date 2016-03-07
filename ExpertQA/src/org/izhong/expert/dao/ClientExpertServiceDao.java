package org.izhong.expert.dao;

import java.util.List;

import org.izhong.expert.model.CatalogFullTree;
import org.izhong.expert.model.Catalogs;
import org.izhong.expert.model.ClientAccessLogs;
import org.izhong.expert.model.DocumentInfos;
import org.izhong.expert.model.HypertextLinkExtends;
import org.izhong.expert.model.HypertextLinks;
import org.izhong.expert.model.QuestionLawRefs;
import org.izhong.expert.model.QuestionQueryResultObj;
import org.izhong.expert.model.RES_LawExample;
import org.izhong.expert.model.RES_QuestionExample;
import org.izhong.expert.model.ResQuestions;
import org.izhong.expert.model.SystemInfos;
import org.izhong.expert.model.UpdateTableInfos;
import org.izhong.expert.model.UseTechniqueInfos;

public interface ClientExpertServiceDao {
	
	/**
	 * 新增U盘客户端访问日志
	 * @param clientAccessLogs
	 * @author whz
	 */
	public void addClientAccessLogs(ClientAccessLogs clientAccessLogs);
	
	//系统文件
	public List<SystemInfos> qrySystemInfoAll();
	
	public List<SystemInfos> qrySystemInfoListByProjectName(String projectName);
	
	public List<SystemInfos> qrySystemInfoListByIDs(List<String> documentIds);
	
	//资源文件
	public List<DocumentInfos> qryDocumentInfoAll();

	public List<DocumentInfos> qryDocumentInfoListByProjectName(String projectName);
	
	public List<DocumentInfos> qryDocumentInfoListByIDs(List<String> documentIds);
	
	public List<DocumentInfos> qryDocumentInfoListByCatalogNodeID(String catalogNodeID);
	
	public List<DocumentInfos> qryDocumentInfoListByCatalogNodeIDs(List<String> catalogNodeIDs);
	
	public List<DocumentInfos> qryDocumentInfoListByLawXmlDocuments(String deviceSN);

	public List<DocumentInfos> qryDocumentInfoListByTryDocuments(String deviceSN);
	
	//其他表内容	
	// {{ 此部分实际功能已经作废，不可删除
	public List<HypertextLinkExtends> qryHypertextLinkExtendsAll(String projectName);	
		
	public List<UseTechniqueInfos> qryUserTechniqueInfosAll(String projectName);
	
	public List<HypertextLinks> qryHypertextLinksAll(String projectName);	
	// }}
	
	public List<Catalogs> qryCatalogsAll(String projectName);
	
	public List<CatalogFullTree> qryCatalogFullTreeAll(String projectName);
	
	public List<ResQuestions> qryResQuestionsAll(String projectName);
	
	public List<ResQuestions> qryResQuestionsByIDs(String projectName, String questionIDs);	
	
	public List<QuestionLawRefs> qryQuestionLawRefsAll(String projectName);
	
	public List<RES_LawExample> qryRES_LawExamplesAll(String projectName);

	public List<RES_QuestionExample> qryRES_QuestionExamplesAll(String projectName);
	
	//更新表列表	
	public List<UpdateTableInfos> qryUpdateTableInfosAll(String projectName);
	
	//用户问答
	public List<QuestionQueryResultObj> qryOnlineQuestions(String questionkey);
	
}
