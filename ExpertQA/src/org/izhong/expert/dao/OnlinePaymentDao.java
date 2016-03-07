package org.izhong.expert.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.online.OrderContact;
import org.izhong.expert.model.online.OrderInfo;
import org.izhong.expert.model.online.OrderOnlinePayRecord;
import org.izhong.expert.model.online.OrderProduction;
import org.izhong.expert.model.online.TempProduction;

public interface OnlinePaymentDao {

	public String getUserIdByEmailAndPasswd(HashMap map);
	public String getCustomerIdByEmailAndPasswd(HashMap map);

	public Integer addOrderInfo(OrderInfo orderInfo);
	public Integer editOrderInfo(OrderInfo orderInfo);
	public Integer addOrderProduction(OrderProduction production);
	public Integer updateOrderProduction(OrderProduction production);
	public OrderInfo selectOrderInfoById(String orderMasterno);
	public OrderInfo selectOrderInfoByTransactionId(String transactionId);
	public OrderOnlinePayRecord selectOrderOnlinePayRecordById(String orderMasterno);
	public OrderOnlinePayRecord selectOrderOnlinePayRecordByTransactionId(String transactionId);
	public Integer insertOrderOnlinePayRecord(OrderOnlinePayRecord payRecord);

	public Integer editOrderOnlinePaymentRecord(OrderOnlinePayRecord payRecord);

	public List<Map<String,String>> getProductFareMoney();

	public Integer deleteOrderDetails(String orderMasterNo);
	//联系地址
	public Integer insertOrderContact(OrderContact contact);
	public OrderContact selectOrderContactByLinkId(String linkId);
	public Integer updateOrderContact(OrderContact contact);

	public List selectOrderProductionsByOrderId(String orderMasterNo);

	public List<OrderOnlinePayRecord> selectOrderOnlinePayRecord(HashMap map);
	
	public List<TempProduction> getTempProductList();

}
