package org.izhong.expert.abs;

import java.util.List;

import org.apache.log4j.Logger;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.UserTryInfos;
import org.izhong.expert.service.FreeOrderService;
import org.izhong.expert.service.KeyWordService;
import org.izhong.expert.service.LogsService;
import org.izhong.expert.service.UserInfoService;

public abstract class FreeOrderAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected FreeOrderService freeOrderService;
	protected KeyWordService keyWordService;
	protected UserInfoService userInfoService;
	protected LogsService logsService;
	
	public void setFreeOrderService(FreeOrderService freeOrderService) {
		this.freeOrderService = freeOrderService;
	}

	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public void setLogsService(LogsService logsService) {
		this.logsService = logsService;
	}
	
	public abstract List<QueryHotWords> findHotWordsAll();
	
	public abstract void addFreeOrder(UserTryInfos userTryInfo);
	
	public abstract LabUsers findLabUser(String userId);
}
