package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.Code;
import org.izhong.expert.model.order.Order;
import org.izhong.expert.model.order.OrderDetails;
import org.izhong.expert.model.order.OrderPayRecord;
import org.izhong.expert.model.order.OrderProducts;

public interface OrderService {
	
	public OrderProducts getOrderProductByNo(String productNo);
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public void updateOrderStatus(Order order);
	public void addOrderDetail(OrderDetails orderDetails);
	public void addOrderPayRecord(OrderPayRecord orderPayRecord);
	public Order getOrderByNo(String orderNo,String userId);
	public Order getOrderByTransactionId(String transactionId);
	public OrderPayRecord getPayRecordByTransactionId(String transactionId);
	public void updateOrderPayRecord(OrderPayRecord orderPayRecord);
	public List<Order> getOrderByUserId(String userId);
	public Order getOrderByOrderMasterNo(String userId,String orderMasterNo);
	public List<OrderDetails> getOrderDetailsByNo(String orderMasterNo);
	public List<OrderDetails> getPayHistory();
	public List<OrderDetails> getOrderDetailsInfo(String userId,String transNo);
	public void addCode(Code code);
	public List<Code> allCode();
	public int verifiCode(String preferentialno);
	public Map orderM(String ordermasterno);
	public OrderDetails getMessage4Email(String orderMasterNo);
}
