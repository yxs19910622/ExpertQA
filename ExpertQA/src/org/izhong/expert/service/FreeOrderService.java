package org.izhong.expert.service;

import org.izhong.expert.model.UserTryInfos;

public interface FreeOrderService {
	
	public void addFreeOrder(UserTryInfos userTryInfo);
	
	public void updateFreeOrderStatus(String preOrderNo, String status);

}
