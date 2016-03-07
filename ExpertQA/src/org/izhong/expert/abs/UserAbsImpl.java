package org.izhong.expert.abs;

import java.util.List;

import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;

public class UserAbsImpl extends UserAbs {

	@Override
	public List<QueryHotWords> findHotWordsAll() {
		return keyWordService.qryHotWordsAll();
	}

	@Override
	public LabUsers findTotalExpertInfo(String userId) {
		return expertService.getTotalExpertInfo(userId);
	}
}
