package org.izhong.expert.abs;

import java.util.ArrayList;
import java.util.List;

import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.OperationLogs;
import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.util.DateUtil;

public class IndexAbsImpl extends IndexAbs {

	@Override
	public List<QATypes> findQATypeByParent() {
		return qatypeService.qryQATypeByParent();
	}

	@Override
	public List<QATypes> findQATypesByChild() {
		return qatypeService.qryQATypesByChild();
	}

	@Override
	public List<QueryHotWords> findHotWordsAll() {
		return keyWordService.qryHotWordsAll();
	}

	@Override
	public LabUsers findRecommendExpert() {
		LabUsers labuser = null;
		List<LabUsers> lstUser = new ArrayList<LabUsers>();
		lstUser = expertService.getTotalExpertAll();
		if(lstUser.size()>0)
		{
			int i = (int)DateUtil.getTotalDays()%lstUser.size();
			labuser = lstUser.get(i);
		}
		return labuser;
	}

	@Override
	public void milieuCollect(String ip, String milieu) {
		OperationLogs logs = new OperationLogs("客户环境", "自动收集", DateUtil.getCurrTime(), "客户访问环境："+milieu, ip);
		logsService.addOperation(logs);
	}

	@Override
	public List<LabUsers> getActiveUser() {
		return userInfoService.qryActiveUser();
	}
}
