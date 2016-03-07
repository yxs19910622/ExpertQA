package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.model.TMPCompanys;
import org.izhong.expert.model.TMPOrders;
import org.izhong.expert.model.TMPProducts;
import org.izhong.expert.model.TMPUsers;

public interface SyncCustomerService {

	public int addUpdateCompany(TMPCompanys company);
	public int addUpdateOrder(TMPOrders order);
	public int addUpdateUser(TMPUsers user);
	
	public int addCompanys(TMPCompanys company);
	public int addOrders(TMPOrders order);
	public int addProducts(TMPProducts product);
	public int addUsers(TMPUsers user);
	
	public int updateCompanys(TMPCompanys company);
	public int updateOrders(TMPOrders order);
	public int updateProducts(TMPProducts product);
	public int updateUsers(TMPUsers user);
	
	public int getCompanyByCompanyId(String companyId);
	public int getOrderByDetailOrderNo(String detailOrderNo);
	public int getProductByProductNo(String productNo);
	public int getUserByUserId(String userId);
	
	public TMPOrders getOrderByUserId(String userId);
	public List<TMPOrders> getOrderByImportDate(String startTime,String endTime);
}
