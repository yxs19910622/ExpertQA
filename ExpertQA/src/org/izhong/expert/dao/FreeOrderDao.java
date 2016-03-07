package org.izhong.expert.dao;

import org.izhong.expert.model.UserTryInfos;

public interface FreeOrderDao {
	
	/**
	 * 新增免费试用订单
	 * @param userTryInfo
	 * @author whz
	 */
	public void addFreeOrder(UserTryInfos userTryInfo);
	/**
	 * 修改订单发送状态
	 * @param preOrderNo
	 * @param status
	 * @author whz
	 */
	public void updateFreeOrderStatus(String preOrderNo, String status);

}
