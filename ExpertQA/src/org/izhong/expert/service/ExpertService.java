package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.model.ExpertReport;
import org.izhong.expert.model.LabUsers;

public interface ExpertService {
	
	public void addExpertReport(ExpertReport expertReport);
	
	public List<LabUsers> getTotalExpertAll();
	
	public LabUsers getTotalExpertInfo(String userId);
}
