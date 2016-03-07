package org.izhong.expert.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.izhong.expert.model.Analyze;
import org.izhong.expert.model.Code;
import org.izhong.expert.model.order.Order;
import org.izhong.expert.model.order.OrderDetails;
import org.izhong.expert.model.order.OrderPayRecord;
import org.izhong.expert.model.order.OrderProducts;

public interface OrderDao {
	
	/**
	 * 根据产品编号获得产品信息
	 * @param productNo
	 * @return
	 * @author whz
	 */
	public OrderProducts getOrderProductByNo(String productNo);
	
	/**
	 * 根据订单ID和用户ID查询订单
	 * @param orderNo
	 * @param userId
	 * @return
	 * @author whz
	 */
	public Order getOrderByNo(String orderNo,String userId);
	/**
	 * 根据交易号查询订单数据
	 * @param transactionId
	 * @return
	 * @author whz
	 */
	public Order getOrderByTransactionId(String transactionId);
	/**
	 * 根据交易号查询订单记录
	 * @param transactionId
	 * @return
	 * @author whz
	 */
	public OrderPayRecord getPayRecordByTransactionId(String transactionId);
	
	/**
	 * 新增订单
	 * @param order
	 * @author whz
	 */
	public void addOrder(Order order);
	/**
	 * 修改订单
	 * @param order
	 * @author whz
	 */
	public void updateOrder(Order order);
	public void updateOrderStatus(Order order);
	/**
	 *  新增订单明细
	 * @param orderDetails
	 * @author whz
	 */
	public void addOrderDetail(OrderDetails orderDetails);
	/**
	 * 新增一条交易记录
	 * @param orderPayRecord
	 * @author whz
	 */
	public void addOrderPayRecord(OrderPayRecord orderPayRecord);
	/**
	 * 修改交易记录
	 * @param orderPayRecord
	 * @author whz
	 */
	public void updateOrderPayRecord(OrderPayRecord orderPayRecord);
	
	/**
	 * 根据用户编号查询对应订单
	 * @param userId
	 * @return
	 * @author whz
	 */
	public List<Order> getOrderByUserId(String userId);
	/**
	 * 根据用户编号和订单号查询该订单信息
	 * @param userId
	 * @param orderMasterNo
	 * @return
	 * @author whz
	 */
	public Order getOrderByOrderMasterNo(String userId,String orderMasterNo);
	/**
	 *  根据订单号查询订单明细
	 * @param orderMasterNo
	 * @return
	 * @author whz
	 */
	public List<OrderDetails> getOrderDetailsByNo(String orderMasterNo);
	
	/**
	 * 获得付款记录
	 * @return
	 * @author whz
	 */
	public List<OrderDetails> getPayHistory();
	
	
	/**
	 * 根据用户ID和交易号码查询订单详情
	 * @param userId
	 * @param transNo
	 * @return
	 * @author whz
	 */
	public List<OrderDetails> getOrderDetailsInfo(String userId,String transNo);
	
	/**
	 * 新增优惠码
	 * @return
	 * @author yxs
	 */
	public void addCode(Code code);

	/**
	 * 获取所有优惠码
	 * @return
	 * @author yxs
	 */
	public List<Code> allCode();
	
	/**
	 * 判断优惠码是否存在
	 * @return boolean
	 * @author yxs
	 */
	public int verifiCode(String preferentialno);

	/**
	 * 根据订单号查询信息，用作付款成功邮件
	 * @return OrderDetails
	 * @author yxs
	 */
	public OrderDetails getMessage4Email(String orderMasterNo);
}
