package org.izhong.expert.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.online.OrderContact;
import org.izhong.expert.model.online.OrderInfo;
import org.izhong.expert.model.online.OrderOnlinePayRecord;
import org.izhong.expert.model.online.OrderProduction;
import org.izhong.expert.model.online.TempProduction;


public interface OnlinePaymentService {

	public String getUserIdByEmailAndPasswd(HashMap map);
	public String getCustomerIdByEmailAndPasswd(HashMap map);
	public boolean addOrderInfo(OrderInfo orderInfo);
	public boolean addOrderProduction(OrderProduction production);
	public Integer updateOrderProduction(OrderProduction production);
	public OrderInfo selectOrderInfoById(String orderMasterno);
	public OrderInfo selectOrderInfoByTransactionId(String transactionId);
	public OrderOnlinePayRecord selectOrderOnlinePayRecordByTransactionId(String transactionId);
	public OrderOnlinePayRecord selectOrderOnlinePayRecordById(String tid);
	public Integer insertOrderOnlinePayRecord(OrderOnlinePayRecord payRecord);

	public Integer editOrderOnlinePaymentRecord(OrderOnlinePayRecord payRecord);
	public Integer editOrderInfo(OrderInfo orderInfo);

	public List<Map<String,String>> getProductFareMoney();
	public Integer deleteOrderDetails(String orderMasterNo);

	public Integer insertOrderContact(OrderContact contact);
	public OrderContact selectOrderContactByLinkId(String linkId);
	public Integer updateOrderContact(OrderContact contact);

	public List selectOrderProductionsByOrderId(String orderMasterNo);

	public List<OrderOnlinePayRecord> selectOrderOnlinePayRecord(HashMap map);
	
	public List<TempProduction> getTempProductList();

}
