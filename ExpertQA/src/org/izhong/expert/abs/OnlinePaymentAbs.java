package org.izhong.expert.abs;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.izhong.expert.model.online.OrderContact;
import org.izhong.expert.model.online.OrderInfo;
import org.izhong.expert.model.online.OrderOnlinePayRecord;
import org.izhong.expert.model.online.OrderProduction;
import org.izhong.expert.model.online.TempProduction;
import org.izhong.expert.service.OnlinePaymentService;

public abstract class OnlinePaymentAbs {

	protected Logger log = Logger.getLogger(getClass());
	protected OnlinePaymentService onlinePaymentService;
	protected OnlinePaymentRemoteWS onlinePaymentRemoteWS;



	/*
	 * ===========================================================================
	 * 在线支付交易记录模块应用基础设施层操作
	 * ===========================================================================
	 */

	public abstract HashMap<String,String> manageUrlData(String value);

	public abstract String getUserIdByEmailAndPasswd(HashMap map);
	public abstract String getCustomerIdByEmailAndPasswd(HashMap map);
	public abstract Map getOrderByCustomerId(String userId);
	public abstract boolean updateOrderData(String orderId);

	public abstract boolean addOrderInfo(OrderInfo orderInfo);
	public abstract boolean addOrderProduction(OrderProduction production);
	public abstract boolean updateOrderProduction(OrderProduction production);
	public abstract OrderInfo queryOrderInfo(String orderId);
	public abstract boolean editOrderInfo(OrderInfo order);
	public abstract List queryOrderProductionsByOrderId(String orderId);
	public abstract OrderInfo selectOrderInfoByTransactionId(String transactionId);
	public abstract OrderOnlinePayRecord selectOrderOnlinePayRecordByTransactionId(String transactionId);


	public abstract boolean addOrderOnlinePayRecord(OrderOnlinePayRecord onlinepayRecord);

	public abstract OrderOnlinePayRecord queryOrderOnlinePayRecordByOrderId(String orderId);

	public abstract boolean deleteOrderDetails(String orderMasterNo);

	public abstract List<Map<String,String>> getProductFareMoney();

	public abstract boolean insertOrderContact(OrderContact contact);
	public abstract OrderContact selectOrderContactByLinkId(String linkId);
	public abstract boolean updateOrderContact(OrderContact contact);
	public abstract List<TempProduction> getTempProductList();

	public abstract boolean editOrderOnlinePaymentRecord(OrderOnlinePayRecord payRecord);
	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public OnlinePaymentRemoteWS getOnlinePaymentRemoteWS() {
		return onlinePaymentRemoteWS;
	}

	public void setOnlinePaymentRemoteWS(OnlinePaymentRemoteWS onlinePaymentRemoteWS) {
		this.onlinePaymentRemoteWS = onlinePaymentRemoteWS;
	}



}
