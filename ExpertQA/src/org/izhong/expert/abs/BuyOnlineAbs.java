package org.izhong.expert.abs;

import java.util.List;
//import java.util.logging.Logger;


import org.apache.log4j.Logger;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.order.Order;
import org.izhong.expert.model.order.OrderDetails;
import org.izhong.expert.model.order.OrderPayRecord;
import org.izhong.expert.model.order.OrderProducts;
import org.izhong.expert.service.OrderService;
import org.izhong.expert.service.UserInfoService;

public abstract class BuyOnlineAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected OrderService orderService;
	protected UserInfoService userInfoService;
	
	public abstract OrderProducts getOrderProductByNo(String productNo);
	public abstract void addOrder(Order order);
	public abstract void updateOrder(Order order);
	public abstract void updateOrderStatus(Order order);
	public abstract void addOrderDetails(OrderDetails orderDetails);
	public abstract void addOrderPayRecord(String orderNo,String userId);
	public abstract LabUsers findLabUserInfo(String userId);
	public abstract SysUsers findSysUserInfo(String userId);
	public abstract String orderPayment(String orderNo,String userId);
	public abstract Order getOrderByTransactionId(String transactionId);
	public abstract OrderPayRecord getPayRecordByTransactionId(String transactionId);
	public abstract void updateOrderPayRecord(OrderPayRecord orderPayRecord);
	public abstract List<Order> getOrderByUserId(String userId);
	public abstract Order getOrderByOrderMasterNo(String userId,String orderMasterNo);
	public abstract List<OrderDetails> getOrderDetailsByNo(String orderMasterNo);
	public abstract void GenerateActivation(String userId,String transNo);
	public abstract OrderDetails getMessage4Email(String orderMasterNo);
	
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
