package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.dao.ClientExpertServiceDao;
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

public class ClientExpertServiceImpl implements ClientExpertService {

	
	private ClientExpertServiceDao serviceDao;

	public void setClientExpertServiceDao(ClientExpertServiceDao ServiceDao) {
		this.serviceDao = ServiceDao;
	}

	@Override
	public void addClientAccessLogs(ClientAccessLogs clientAccessLogs) {
		serviceDao.addClientAccessLogs(clientAccessLogs);
	}
		
	@Override
	public List<SystemInfos> qrySystemInfoAll() {
		return this.serviceDao.qrySystemInfoAll();
	}

	@Override
	public List<SystemInfos> qrySystemInfoListByProjectName(String projectName) {
		return this.serviceDao.qrySystemInfoListByProjectName(projectName);
	}

	@Override
	public List<SystemInfos> qrySystemInfoListByIDs(List<String> documentIds) {
		return this.serviceDao.qrySystemInfoListByIDs(documentIds);
	}

	@Override
	public List<DocumentInfos> qryDocumentInfoAll() {
		return this.serviceDao.qryDocumentInfoAll();
	}

	@Override
	public List<DocumentInfos> qryDocumentInfoListByProjectName(String projectName) {
		return this.serviceDao.qryDocumentInfoListByProjectName(projectName);
	}

	@Override
	public List<DocumentInfos> qryDocumentInfoListByIDs(List<String> documentIds) {
		return this.serviceDao.qryDocumentInfoListByIDs(documentIds);
	}	

	@Override
	public List<DocumentInfos> qryDocumentInfoListByCatalogNodeID(
			String catalogNodeID) {
		return this.serviceDao.qryDocumentInfoListByCatalogNodeID(catalogNodeID);
	}

	@Override
	public List<DocumentInfos> qryDocumentInfoListByCatalogNodeIDs(List<String> catalogNodeIDs) {
		return this.serviceDao.qryDocumentInfoListByCatalogNodeIDs(catalogNodeIDs);
	}
	
	@Override	
	public List<DocumentInfos> qryDocumentInfoListByLawXmlDocuments(String deviceSN)
	{
		return this.serviceDao.qryDocumentInfoListByLawXmlDocuments(deviceSN);
	}
	
	@Override
	public List<DocumentInfos> qryDocumentInfoListByTryDocuments(String deviceSN) {
		return this.serviceDao.qryDocumentInfoListByTryDocuments(deviceSN);
	}	
	
	@Override
	public List<UseTechniqueInfos> qryUserTechniqueInfosAll(String projectName) {
		return this.serviceDao.qryUserTechniqueInfosAll(projectName);
	}

	@Override
	public List<HypertextLinkExtends> qryHypertextLinkExtendsAll(String projectName) {
		return this.serviceDao.qryHypertextLinkExtendsAll(projectName);
	}

	@Override
	public List<HypertextLinks> qryHypertextLinksAll(String projectName) {
		return this.serviceDao.qryHypertextLinksAll(projectName);
	}

	@Override
	public List<CatalogFullTree> qryCatalogFullTreeAll(String projectName) {
		return this.serviceDao.qryCatalogFullTreeAll(projectName);
	}

	@Override
	public List<Catalogs> qryCatalogsAll(String projectName) {
		return this.serviceDao.qryCatalogsAll(projectName);
	}

	@Override
	public List<ResQuestions> qryResQuestionsAll(String projectName) {
		return this.serviceDao.qryResQuestionsAll(projectName);
	}

	@Override
	public List<ResQuestions> qryResQuestionsByIDs(String projectName, String questionIDs) {
		return this.serviceDao.qryResQuestionsByIDs(projectName, questionIDs);
	}

	@Override
	public List<RES_LawExample> qryRES_LawExamplesAll(String projectName) {
		return this.serviceDao.qryRES_LawExamplesAll(projectName);
	}

	@Override
	public List<RES_QuestionExample> qryRES_QuestionExamplesAll(String projectName) {
		return this.serviceDao.qryRES_QuestionExamplesAll(projectName);
	}

	@Override
	public List<QuestionLawRefs> qryQuestionLawRefsAll(String projectName) {
		return this.serviceDao.qryQuestionLawRefsAll(projectName);
	}
	
	@Override
	public List<UpdateTableInfos> qryUpdateTableInfosAll(String projectName) {
		return this.serviceDao.qryUpdateTableInfosAll(projectName);
	}
	
	@Override
	public List<QuestionQueryResultObj> qryOnlineQuestions(String questionkey) {
		return this.serviceDao.qryOnlineQuestions(questionkey);
	}
}
