package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.dao.ExpertDao;
import org.izhong.expert.model.ExpertReport;
import org.izhong.expert.model.LabUsers;

public class ExpertServiceImpl implements ExpertService {

	private ExpertDao expertDao;
	
	public void setExpertDao(ExpertDao expertDao) {
		this.expertDao = expertDao;
	}

	@Override
	public void addExpertReport(ExpertReport expertReport) {
		expertDao.addExpertReport(expertReport);
	}

	@Override
	public List<LabUsers> getTotalExpertAll() {
		return expertDao.getTotalExpertAll();
	}

	@Override
	public LabUsers getTotalExpertInfo(String userId) {
		return expertDao.getTotalExpertInfo(userId);
	}
}
