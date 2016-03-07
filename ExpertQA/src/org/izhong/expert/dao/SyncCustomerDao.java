package org.izhong.expert.dao;

import java.util.List;

import org.izhong.expert.model.TMPCompanys;
import org.izhong.expert.model.TMPOrders;
import org.izhong.expert.model.TMPProducts;
import org.izhong.expert.model.TMPUsers;

public interface SyncCustomerDao {
	
	public int addUpdateCompany(TMPCompanys company);
	
	public int addUpdateOrder(TMPOrders order);
	
	public int addUpdateUser(TMPUsers user);
	
	/**
	 * 新增客户公司信息
	 * @param company
	 * @author whz
	 */
	public int addCompanys(TMPCompanys company);
	/**
	 * 新增客户订单信息
	 * @param order
	 * @author whz
	 */
	public int addOrders(TMPOrders order);
	/**
	 * 新增商品信息
	 * @param product
	 * @author whz
	 */
	public int addProducts(TMPProducts product);
	/**
	 * 新增客户信息
	 * @param user
	 * @author whz
	 */
	public int addUsers(TMPUsers user);
	/**
	 * 修改客户信息
	 * @param company
	 * @author whz
	 */
	public int updateCompanys(TMPCompanys company);
	/**
	 * 修改客户订单信息
	 * @param order
	 * @author whz
	 */
	public int updateOrders(TMPOrders order);
	/**
	 * 修改商品信息
	 * @param product
	 * @author whz
	 */
	public int updateProducts(TMPProducts product);
	/**
	 * 修改客户信息
	 * @param user
	 * @author whz
	 */
	public int updateUsers(TMPUsers user);
	/**
	 * 查询该公司是否已存在
	 * @param companyId
	 * @return
	 * @author whz
	 */
	public int getCompanyByCompanyId(String companyId);
	/**
	 * 查询该订单是否已存在
	 * @param detailOrderNo
	 * @return
	 * @author whz
	 */
	public int getOrderByDetailOrderNo(String detailOrderNo);
	/**
	 * 查询该商品是否已存在
	 * @param productNo
	 * @return
	 * @author whz
	 */
	public int getProductByProductNo(String productNo);
	/**
	 * 查询该用户是否已存在
	 * @param userId
	 * @return
	 * @author whz
	 */
	public int getUserByUserId(String userId);
	/**
	 *  根据客户ID查询订单信息
	 * @param userId
	 * @return
	 * @author whz
	 */
	public TMPOrders getOrderByUserId(String userId);
	/**
	 * 按照导入时间取订单数据
	 * @return
	 * @author whz
	 */
	public List<TMPOrders> getOrderByImportDate(String startTime,String endTime);
	
}
