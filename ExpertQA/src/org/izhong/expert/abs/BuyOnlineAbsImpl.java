package org.izhong.expert.abs;

import java.util.List;

import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserProducts;
import org.izhong.expert.model.order.Order;
import org.izhong.expert.model.order.OrderDetails;
import org.izhong.expert.model.order.OrderPayRecord;
import org.izhong.expert.model.order.OrderProducts;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.Payment;

public class BuyOnlineAbsImpl extends BuyOnlineAbs {

	@Override
	public OrderProducts getOrderProductByNo(String productNo) {
		return orderService.getOrderProductByNo(productNo);
	}

	@Override
	public void addOrder(Order order) {
		orderService.addOrder(order);
	}

	@Override
	public void addOrderDetails(OrderDetails orderDetails) {
		orderService.addOrderDetail(orderDetails);
	}

	@Override
	public LabUsers findLabUserInfo(String userId) {
		return userInfoService.qryLabUserInfo(userId);
	}

	@Override
	public SysUsers findSysUserInfo(String userId) {
		return userInfoService.qrySysUserInfo(userId);
	}

	@Override
	public void updateOrder(Order order) {
		orderService.updateOrder(order);
	}

	@Override
	public void addOrderPayRecord(String orderNo,String userId) {
		Order order = orderService.getOrderByNo(orderNo, userId);
		if(order.getPayStatus().equals("1"))
		{
			OrderPayRecord opr = new OrderPayRecord();
			if(BaseUtil.isNotEmpty(order.getPayType()))
			{
				if(order.getPayType().equals("100") || order.getPayType().equals("1000"))
				{
					opr.setCreateTime(DateUtil.getCurrTimeStr());
					opr.setOrderMasterNo(order.getOrderMasterNo());
					opr.setTransactionNo(order.getTransactionNo());
					opr.setTid(BaseUtil.generateIdentifier());
					opr.setTransactionMoney(order.getActualMoney());
					opr.setTransactionStatus("1");
					opr.setSubmitData(
							"sub_data{orderCode:" + order.getTransactionNo() + 
							",orderStatus:" + order.getOrderStatus() + ",payType:" + order.getPayType() +
							",payStatus:" + order.getPayStatus() + ",orderMoney:" + order.getActualMoney() + 
							",payMoney:" + order.getPayMoney() +
							",isNeedInvoice:" + order.getIsNeedInvoice() + 
							",notes:" + (order.getNotes() == null ? "" : order.getNotes()) + 
							",createTime:" + order.getCreateTime() +"}\n"
							);
					orderService.addOrderPayRecord(opr);
				}
			}
		}
	}

	@Override
	public String orderPayment(String orderNo,String userId) {
		String returl = null;
		Order order = orderService.getOrderByNo(orderNo, userId);
		if(order==null){
			return null;
		}
		if(order.getPayType().equals("100") || order.getPayType().equals("1000"))
		{
			if(order.getPayType().equals("1000"))
			{
				returl = Payment.CreateUrl_Get_3(order.getOrderMasterNo(), order.getTransactionNo(), order.getNotes(), 
						String.valueOf(order.getTotalPayMoney()), order.getNotes(),"bankPay",order.getPayBank());
			}else if(order.getPayType().equals("100")){
				returl = Payment.CreateUrl_Get_2(order.getOrderMasterNo(), order.getTransactionNo(), order.getNotes(), 
						String.valueOf(order.getTotalPayMoney()), order.getNotes());	//order.getTotalPayMoney()
			}
		}
		return returl;
	}
	
	@Override
	public Order getOrderByTransactionId(String transactionId) {
		return orderService.getOrderByTransactionId(transactionId);
	}
	
	@Override
	public OrderPayRecord getPayRecordByTransactionId(String transactionId) {
		return orderService.getPayRecordByTransactionId(transactionId);
	}

	@Override
	public void updateOrderPayRecord(OrderPayRecord orderPayRecord) {
		orderService.updateOrderPayRecord(orderPayRecord);
	}
	
	@Override
	public void updateOrderStatus(Order order) {
		orderService.updateOrderStatus(order);
	}

	@Override
	public List<Order> getOrderByUserId(String userId) {
		return orderService.getOrderByUserId(userId);
	}

	@Override
	public Order getOrderByOrderMasterNo(String userId, String orderMasterNo) {
		return orderService.getOrderByOrderMasterNo(userId, orderMasterNo);
	}

	@Override
	public List<OrderDetails> getOrderDetailsByNo(String orderMasterNo) {
		return orderService.getOrderDetailsByNo(orderMasterNo);
	}
	
	@Override
	public void GenerateActivation(String userId, String transNo) {
		if(BaseUtil.isEmpty(userId) || BaseUtil.isEmpty(transNo)){
			return;
		}
		List<OrderDetails> lstod = orderService.getOrderDetailsInfo(userId, transNo);
		if(lstod!=null){
			UserProducts userProduct = null;
			for (int i = 0; i < lstod.size(); i++) {
				OrderDetails od = lstod.get(i);
				userProduct = new UserProducts(od.getUserId(), od.getProductNo(), od.getProductAlias(), BaseUtil.getActivation());
				userInfoService.addUserProduct(userProduct);
			}
		}
	}

	@Override
	public OrderDetails getMessage4Email(String orderMasterNo) {
		return orderService.getMessage4Email(orderMasterNo);
	}
}
