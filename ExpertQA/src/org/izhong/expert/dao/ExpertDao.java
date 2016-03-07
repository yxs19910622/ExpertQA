package org.izhong.expert.dao;

import java.util.List;

import org.izhong.expert.model.ExpertReport;
import org.izhong.expert.model.LabUsers;

public interface ExpertDao {
	
	/**
	 * 初始化专家统计信息
	 * @param expertReport
	 * @author whz
	 */
	public void addExpertReport(ExpertReport expertReport);
	
	/**
	 * 取推荐专家的数据
	 * @return
	 * @author whz
	 */
	public List<LabUsers> getTotalExpertAll();
	/**
	 * 根据用户ID取当前推荐专家详细信息
	 * @param userId
	 * @return
	 * @author whz
	 */
	public LabUsers getTotalExpertInfo(String userId);

}
