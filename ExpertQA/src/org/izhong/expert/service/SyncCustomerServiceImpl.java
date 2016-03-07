package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.dao.SyncCustomerDao;
import org.izhong.expert.model.TMPCompanys;
import org.izhong.expert.model.TMPOrders;
import org.izhong.expert.model.TMPProducts;
import org.izhong.expert.model.TMPUsers;

public class SyncCustomerServiceImpl implements SyncCustomerService {

	private SyncCustomerDao syncCustomerDao;
	
	public void setSyncCustomerDao(SyncCustomerDao syncCustomerDao) {
		this.syncCustomerDao = syncCustomerDao;
	}

	@Override
	public int addUpdateCompany(TMPCompanys company) {
		return syncCustomerDao.addUpdateCompany(company);
	}
	
	@Override
	public int addUpdateOrder(TMPOrders order) {
		return syncCustomerDao.addOrders(order);
	}
	
	@Override
	public int addUpdateUser(TMPUsers user) {
		return syncCustomerDao.addUsers(user);
	}
	
	
	
	
	@Override
	public int addCompanys(TMPCompanys company) {
		return syncCustomerDao.addCompanys(company);
	}

	@Override
	public int addOrders(TMPOrders order) {
		return syncCustomerDao.addOrders(order);
	}

	@Override
	public int addProducts(TMPProducts product) {
		return syncCustomerDao.addProducts(product);
	}

	@Override
	public int addUsers(TMPUsers user) {
		return syncCustomerDao.addUsers(user);
	}

	@Override
	public int updateCompanys(TMPCompanys company) {
		return syncCustomerDao.updateCompanys(company);
	}

	@Override
	public int updateOrders(TMPOrders order) {
		return syncCustomerDao.updateOrders(order);
	}

	@Override
	public int updateProducts(TMPProducts product) {
		return syncCustomerDao.updateProducts(product);
	}

	@Override
	public int updateUsers(TMPUsers user) {
		return syncCustomerDao.updateUsers(user);
	}

	@Override
	public int getCompanyByCompanyId(String companyId) {
		return syncCustomerDao.getCompanyByCompanyId(companyId);
	}

	@Override
	public int getOrderByDetailOrderNo(String detailOrderNo) {
		return syncCustomerDao.getOrderByDetailOrderNo(detailOrderNo);
	}

	@Override
	public int getProductByProductNo(String productNo) {
		return syncCustomerDao.getProductByProductNo(productNo);
	}

	@Override
	public int getUserByUserId(String userId) {
		return syncCustomerDao.getUserByUserId(userId);
	}

	@Override
	public TMPOrders getOrderByUserId(String userId) {
		return syncCustomerDao.getOrderByUserId(userId);
	}

	@Override
	public List<TMPOrders> getOrderByImportDate(String startTime,String endTime) {
		return syncCustomerDao.getOrderByImportDate(startTime,endTime);
	}
	
}
