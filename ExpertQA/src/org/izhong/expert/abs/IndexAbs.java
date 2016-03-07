package org.izhong.expert.abs;

import java.util.List;

import org.apache.log4j.Logger;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.service.ExpertService;
import org.izhong.expert.service.KeyWordService;
import org.izhong.expert.service.LogsService;
import org.izhong.expert.service.QATypeService;
import org.izhong.expert.service.UserInfoService;

public abstract class IndexAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected QATypeService qatypeService;
	protected KeyWordService keyWordService;
	protected ExpertService expertService;
	protected LogsService logsService;
	protected UserInfoService userInfoService;
	
	public abstract List<QATypes> findQATypeByParent();
	
	public abstract List<QATypes> findQATypesByChild();
	
	public abstract List<QueryHotWords> findHotWordsAll();
	
	public abstract LabUsers findRecommendExpert();
	
	public abstract void milieuCollect(String ip,String milieu);
	
	public abstract List<LabUsers> getActiveUser();
	
	public void setQatypeService(QATypeService qatypeService) {
		this.qatypeService = qatypeService;
	}
	
	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}
	
	public void setExpertService(ExpertService expertService) {
		this.expertService = expertService;
	}
	
	public void setLogsService(LogsService logsService) {
		this.logsService = logsService;
	}
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
