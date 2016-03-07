package org.izhong.expert.abs;

public interface OnlinePaymentRemoteWS {

	public String getOrderByCustomerID(String customerId);
	public boolean updateOrderData(String xmlData);
	

}
