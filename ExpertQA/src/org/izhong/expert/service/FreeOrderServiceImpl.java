package org.izhong.expert.service;

import org.izhong.expert.dao.FreeOrderDao;
import org.izhong.expert.model.UserTryInfos;

public class FreeOrderServiceImpl implements FreeOrderService {
	
	private FreeOrderDao freeOrderDao;
	
	public void setFreeOrderDao(FreeOrderDao freeOrderDao) {
		this.freeOrderDao = freeOrderDao;
	}

	@Override
	public void addFreeOrder(UserTryInfos userTryInfo) {
		freeOrderDao.addFreeOrder(userTryInfo);
	}

	@Override
	public void updateFreeOrderStatus(String preOrderNo, String status) {
		freeOrderDao.updateFreeOrderStatus(preOrderNo, status);
	}

}
