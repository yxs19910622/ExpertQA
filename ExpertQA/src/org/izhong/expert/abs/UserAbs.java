package org.izhong.expert.abs;

import java.util.List;

import org.apache.log4j.Logger;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.service.ExpertService;
import org.izhong.expert.service.KeyWordService;

public abstract class UserAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected KeyWordService keyWordService;
	protected ExpertService expertService;
	
	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}

	public void setExpertService(ExpertService expertService) {
		this.expertService = expertService;
	}
	
	public abstract List<QueryHotWords> findHotWordsAll();
	
	public abstract LabUsers findTotalExpertInfo(String userId);
}
