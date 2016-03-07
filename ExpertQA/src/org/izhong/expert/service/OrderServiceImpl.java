package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.OrderDao;
import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.Code;
import org.izhong.expert.model.order.Order;
import org.izhong.expert.model.order.OrderDetails;
import org.izhong.expert.model.order.OrderPayRecord;
import org.izhong.expert.model.order.OrderProducts;

import sun.jdbc.odbc.OdbcDef;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public OrderProducts getOrderProductByNo(String productNo) {
		return orderDao.getOrderProductByNo(productNo);
	}

	@Override
	public void addOrder(Order order) {
		orderDao.addOrder(order);
	}
	@Override
	public void addOrderDetail(OrderDetails orderDetails) {
		orderDao.addOrderDetail(orderDetails);
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}

	@Override
	public void addOrderPayRecord(OrderPayRecord orderPayRecord) {
		orderDao.addOrderPayRecord(orderPayRecord);
	}

	@Override
	public Order getOrderByNo(String orderNo, String userId) {
		return orderDao.getOrderByNo(orderNo, userId);
	}

	@Override
	public Order getOrderByTransactionId(String transactionId) {
		return orderDao.getOrderByTransactionId(transactionId);
	}

	@Override
	public OrderPayRecord getPayRecordByTransactionId(String transactionId) {
		return orderDao.getPayRecordByTransactionId(transactionId);
	}

	@Override
	public void updateOrderPayRecord(OrderPayRecord orderPayRecord) {
		orderDao.updateOrderPayRecord(orderPayRecord);
	}

	@Override
	public void updateOrderStatus(Order order) {
		orderDao.updateOrderStatus(order);
	}

	@Override
	public List<Order> getOrderByUserId(String userId) {
		return orderDao.getOrderByUserId(userId);
	}

	@Override
	public List<OrderDetails> getOrderDetailsByNo(String orderMasterNo) {
		return orderDao.getOrderDetailsByNo(orderMasterNo);
	}

	@Override
	public Order getOrderByOrderMasterNo(String userId, String orderMasterNo) {
		return orderDao.getOrderByOrderMasterNo(userId, orderMasterNo);
	}
	
	@Override
	public List<OrderDetails> getPayHistory() {
		return orderDao.getPayHistory();
	}
	

	@Override
	public List<OrderDetails> getOrderDetailsInfo(String userId, String transNo) {
		return orderDao.getOrderDetailsInfo(userId, transNo);
	}

	@Override
	public void addCode(Code code) {
		orderDao.addCode(code);
	}

	@Override
	public List<Code> allCode() {
		return orderDao.allCode();
	}

	@Override
	public int verifiCode(String preferentialno) {
		return orderDao.verifiCode(preferentialno);
	}

	@Override
	public Map orderM(String ordermasterno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails getMessage4Email(String orderMasterNo) {
		return orderDao.getMessage4Email(orderMasterNo);
	}


	

}
