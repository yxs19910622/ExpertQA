package org.izhong.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.izhong.expert.dao.OnlinePaymentDao;
import org.izhong.expert.model.online.OrderContact;
import org.izhong.expert.model.online.OrderInfo;
import org.izhong.expert.model.online.OrderOnlinePayRecord;
import org.izhong.expert.model.online.OrderProduction;
import org.izhong.expert.model.online.TempProduction;


public class OnlinePaymentServiceImpl implements OnlinePaymentService {

	private OnlinePaymentDao onlinePaymentDao;

	public String getUserIdByEmailAndPasswd(HashMap map){
		return this.onlinePaymentDao.getUserIdByEmailAndPasswd(map);
	}
	public String getCustomerIdByEmailAndPasswd(HashMap map){
		return this.onlinePaymentDao.getCustomerIdByEmailAndPasswd(map);
	}
	public boolean addOrderInfo(OrderInfo orderInfo){
		this.onlinePaymentDao.addOrderInfo(orderInfo);
		return true;
	}
	public boolean addOrderProduction(OrderProduction production){
		this.onlinePaymentDao.addOrderProduction(production);
		return true;
	}
	public OrderInfo selectOrderInfoById(String orderMasterno){
		return this.onlinePaymentDao.selectOrderInfoById(orderMasterno);
	}
	public OrderOnlinePayRecord selectOrderOnlinePayRecordById(String tid){
		return this.onlinePaymentDao.selectOrderOnlinePayRecordById(tid);
	}
	public Integer insertOrderOnlinePayRecord(OrderOnlinePayRecord payRecord){
		return this.onlinePaymentDao.insertOrderOnlinePayRecord(payRecord);
	}
	public Integer editOrderOnlinePaymentRecord(OrderOnlinePayRecord payRecord){
		return this.onlinePaymentDao.editOrderOnlinePaymentRecord(payRecord);
	}
	public Integer editOrderInfo(OrderInfo orderInfo){
		return this.onlinePaymentDao.editOrderInfo(orderInfo);
	}

	public List<Map<String,String>> getProductFareMoney(){
		return this.onlinePaymentDao.getProductFareMoney();
	}
	public OrderInfo selectOrderInfoByTransactionId(String transactionId){
		return this.onlinePaymentDao.selectOrderInfoByTransactionId(transactionId);
	}
	public OrderOnlinePayRecord selectOrderOnlinePayRecordByTransactionId(String transactionId){
		return this.onlinePaymentDao.selectOrderOnlinePayRecordByTransactionId(transactionId);
	}
	public Integer updateOrderProduction(OrderProduction production){
		return this.onlinePaymentDao.updateOrderProduction(production);
	}
	public Integer deleteOrderDetails(String orderMasterNo){
		return this.onlinePaymentDao.deleteOrderDetails(orderMasterNo);
	}
	public Integer insertOrderContact(OrderContact contact){
		return this.onlinePaymentDao.insertOrderContact(contact);
	}
	public OrderContact selectOrderContactByLinkId(String linkId){
		return this.onlinePaymentDao.selectOrderContactByLinkId(linkId);
	}
	public Integer updateOrderContact(OrderContact contact){
		return this.onlinePaymentDao.updateOrderContact(contact);
	}
	public List selectOrderProductionsByOrderId(String orderMasterNo){
		return this.onlinePaymentDao.selectOrderProductionsByOrderId(orderMasterNo);
	}
	public List<OrderOnlinePayRecord> selectOrderOnlinePayRecord(HashMap map){
		return this.onlinePaymentDao.selectOrderOnlinePayRecord(map);
	}
	
	
	public List<TempProduction> getTempProductList(){
		return this.onlinePaymentDao.getTempProductList();
	}
	public OnlinePaymentDao getOnlinePaymentDao() {
		return onlinePaymentDao;
	}

	public void setOnlinePaymentDao(OnlinePaymentDao onlinePaymentDao) {
		this.onlinePaymentDao = onlinePaymentDao;
	}



}
