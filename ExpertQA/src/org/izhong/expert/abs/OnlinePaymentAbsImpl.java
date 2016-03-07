package org.izhong.expert.abs;


import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.online.OrderContact;
import org.izhong.expert.model.online.OrderInfo;
import org.izhong.expert.model.online.OrderOnlinePayRecord;
import org.izhong.expert.model.online.OrderProduction;
import org.izhong.expert.model.online.TempProduction;
import org.izhong.expert.util.Base64Helper;
import org.izhong.expert.util.BaseUtil;
import org.izhong.web.util.SevenZipCompression;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


public class OnlinePaymentAbsImpl extends OnlinePaymentAbs {


	/*
	 * ===========================================================================
	 * 在线支付交易记录模块应用基础设施层操作
	 * ===========================================================================
	 */

	public HashMap<String,String> manageUrlData(String value){
		HashMap<String,String> map = new HashMap<String,String>();
		try {
			byte[] bt = Base64Helper.getFromBASE64(value.replace(" ", "+"));
			String str = SevenZipCompression.Decompression(bt);
			String urlData = str.substring(0, str.indexOf("}") + 1);
			String[] arrs = urlData.split(",");
			map.put("LoginName", arrs[0].split(":")[1].replace("\"", ""));
			map.put("PassWord", arrs[1].split(":")[1].replace("\"", ""));
			map.put("DeviceSN", arrs[3].split(":")[1].replace("\"", ""));
			return map;
		} catch (Exception ex) {
			ex.toString();
		}
		return map;
	}
	public String getUserIdByEmailAndPasswd(HashMap map){
		String passwd = map.get("passWord")+"";
		map.put("passWord", BaseUtil.Md5(passwd));
		return this.onlinePaymentService.getUserIdByEmailAndPasswd(map);
	}
	public String getCustomerIdByEmailAndPasswd(HashMap map){
		String passwd = map.get("passWord")+"";
		map.put("passWord", BaseUtil.Md5(passwd));
		return this.onlinePaymentService.getCustomerIdByEmailAndPasswd(map);
	}
	//通过用户号 获取用户的订单信息
	public Map getOrderByCustomerId(String userId){
		Map orderInfo = new HashMap();
		String xmldata = this.onlinePaymentRemoteWS.getOrderByCustomerID(userId);
		//System.out.println(xmldata);
		if(xmldata != null && xmldata.length() > 50){
		try {
			Document document = new SAXBuilder().build(new StringReader(xmldata));
			Element orderElement = document.getRootElement();
			orderInfo.put("OrderMasterNo", orderElement.getChildText("OrderMasterNo"));
			orderInfo.put("CustomerID", orderElement.getChildText("CustomerID"));
			orderInfo.put("ActualMoney", orderElement.getChildText("ActualMoney"));
			orderInfo.put("IsNeedInvoice", orderElement.getChildText("IsNeedInvoice"));
			orderInfo.put("Notes", orderElement.getChildText("Notes"));
			orderInfo.put("PayType", orderElement.getChildText("PayType"));
			orderInfo.put("PayBank", orderElement.getChildText("PayBank"));
			orderInfo.put("PayStatus", orderElement.getChildText("PayStatus"));
			orderInfo.put("OrderStatus", orderElement.getChildText("OrderStatus"));
			orderInfo.put("EmployeeID", orderElement.getChildText("EmployeeID"));
			orderInfo.put("LinkID", orderElement.getChildText("LinkID"));
			orderInfo.put("LinkName", orderElement.getChildText("LinkName"));
			orderInfo.put("Province", orderElement.getChildText("Province"));
			orderInfo.put("PrefecturelevelCity", orderElement.getChildText("PrefecturelevelCity"));
			orderInfo.put("Area", orderElement.getChildText("Area"));
			orderInfo.put("Street", orderElement.getChildText("Street"));
			orderInfo.put("FullAddress", orderElement.getChildText("FullAddress"));
			orderInfo.put("PostCode", orderElement.getChildText("PostCode"));
			orderInfo.put("Telephone", orderElement.getChildText("Telephone"));
			orderInfo.put("Mobile", orderElement.getChildText("Mobile"));
			orderInfo.put("Fax", orderElement.getChildText("Fax"));
			orderInfo.put("QQ", orderElement.getChildText("QQ"));
			orderInfo.put("Msn", orderElement.getChildText("Msn"));
			orderInfo.put("Department", orderElement.getChildText("Department"));
			orderInfo.put("Position", orderElement.getChildText("Position"));
			orderInfo.put("Notes", orderElement.getChildText("Notes"));
			orderInfo.put("FareMoney", orderElement.getChildText("FareMoney"));
			orderInfo.put("TotalPayMoney", orderElement.getChildText("TotalPayMoney"));
			orderInfo.put("CreateTime", orderElement.getChildText("CreateTime"));
			orderInfo.put("TitleType", orderElement.getChildText("TitleType"));
			orderInfo.put("InvoiceTitle", orderElement.getChildText("InvoiceTitle"));
			orderInfo.put("InvoiceNotes", orderElement.getChildText("InvoiceNotes"));
			orderInfo.put("PostType", orderElement.getChildText("PostType"));
			orderInfo.put("PostTime", orderElement.getChildText("PostTime"));
			orderInfo.put("InvoiceCode", orderElement.getChildText("InvoiceCode"));
			orderInfo.put("InvoiceNo", orderElement.getChildText("InvoiceNo"));

			List orderDetailList = orderElement.getChild("OrderDetails").getChildren();
			List detials = new ArrayList();
			for(int i = 0;i < orderDetailList.size(); i++){
				Map detail = new HashMap();
				Element orderDetail = (Element)orderDetailList.get(i);
				detail.put("OrderDetailNo", orderDetail.getChildText("OrderDetailNo"));
				detail.put("ProductNo", orderDetail.getChildText("ProductNo"));
				detail.put("ProductPrice", orderDetail.getChildText("ProductPrice"));
				detail.put("ActualPrice", orderDetail.getChildText("ActualPrice"));
				detail.put("OrderAmount", orderDetail.getChildText("OrderAmount"));
				detail.put("OrderMoney", orderDetail.getChildText("OrderMoney"));
				detail.put("FareMoney", orderDetail.getChildText("FareMoney"));
				detail.put("LateFee", orderDetail.getChildText("LateFee"));
				detail.put("SubTotal", orderDetail.getChildText("SubTotal"));
				detials.add(detail);
			}
			orderInfo.put("orderDetail", detials);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		this.addOrderData(orderInfo);
		}
		return orderInfo;
	}

	public boolean updateOrderData(String orderId){
		//组装xml
		StringBuffer xmlData = new StringBuffer();
		OrderInfo orderInfo = this.queryOrderInfo(orderId);//订单发票信息
		OrderContact contact = this.selectOrderContactByLinkId(orderInfo.getLinkId());//地址信息
		List orderDetails = this.queryOrderProductionsByOrderId(orderId);//订单明细
		xmlData.append("<Order>");
		xmlData.append("<OrderMasterNo>"+orderInfo.getOrderMasterno()+"</OrderMasterNo>");
		xmlData.append("<CustomerID>"+orderInfo.getCustomerId()+"</CustomerID>");
		xmlData.append("<ActualMoney>"+(orderInfo.getActualMoney()!=null?orderInfo.getActualMoney():"")+"</ActualMoney>");
		xmlData.append("<IsNeedInvoice>"+(orderInfo.getIsNeedInvoice()!=null?orderInfo.getIsNeedInvoice():"")+"</IsNeedInvoice>");
		xmlData.append("<Notes>"+(orderInfo.getNotes()!=null?orderInfo.getNotes():"")+"</Notes>");
		xmlData.append("<PayType>"+(orderInfo.getPayType()!=null?orderInfo.getPayType():"")+"</PayType>");
		xmlData.append("<PayBank>"+(orderInfo.getPayBank()!=null?orderInfo.getPayBank():"")+"</PayBank>");
		xmlData.append("<TransactionNo>"+orderInfo.getTransactionNo()+"</TransactionNo>");
		xmlData.append("<PayStatus>"+orderInfo.getPayStatus()+"</PayStatus>");
		xmlData.append("<OrderStatus>"+(orderInfo.getOrderStatus()!=null?orderInfo.getOrderStatus():"")+"</OrderStatus>");
		xmlData.append("<EmployeeID>"+(orderInfo.getEmployeeId()!=null?orderInfo.getEmployeeId():"")+"</EmployeeID>");
		xmlData.append("<LinkID>"+(orderInfo.getLinkId()!=null?orderInfo.getLinkId():"")+"</LinkID>");
		xmlData.append("<LinkName>"+(contact.getLinkName()!=null?contact.getLinkName():"")+"</LinkName>");
		xmlData.append("<Province>"+(contact.getProvince()!=null?contact.getProvince():"")+"</Province>");
		xmlData.append("<PrefecturelevelCity>"+(contact.getPrefeCtureLevelCity()!=null?contact.getPrefeCtureLevelCity():"")+"</PrefecturelevelCity>");
		xmlData.append("<Area>"+(contact.getArea()!=null?contact.getArea():"")+"</Area>");
		xmlData.append("<Street>"+(contact.getStreet()!=null?contact.getStreet():"")+"</Street>");
		xmlData.append("<FullAddress>"+(contact.getFullAddress()!=null?contact.getFullAddress():"")+"</FullAddress>");
		xmlData.append("<PostCode>"+(contact.getPostCode()!=null?contact.getPostCode():"")+"</PostCode>");
		xmlData.append("<Telephone>"+(contact.getTelephone()!=null?contact.getTelephone():"")+"</Telephone>");
		xmlData.append("<Mobile>"+(contact.getMobile()!=null?contact.getMobile():"")+"</Mobile>");
		xmlData.append("<Fax>"+(contact.getFax()!=null?contact.getFax():"")+"</Fax>");
		xmlData.append("<QQ>"+(contact.getQq()!=null?contact.getQq():"")+"</QQ>");
		xmlData.append("<Msn>"+(contact.getMsn()!=null?contact.getMsn():"")+"</Msn>");
		xmlData.append("<Department>"+(contact.getDepartment()!=null?contact.getDepartment():"")+"</Department>");
		xmlData.append("<Position>"+(contact.getPosition()!=null?contact.getPosition():"")+"</Position>");
		xmlData.append("<FareMoney>"+(orderInfo.getFareMoney()!=null?orderInfo.getFareMoney():"")+"</FareMoney>");
		xmlData.append("<TotalPayMoney>"+(orderInfo.getTotalPayMoney()!=null?orderInfo.getTotalPayMoney():"")+"</TotalPayMoney>");
		xmlData.append("<CreateTime>"+(orderInfo.getCreateTime()!=null?"":"")+"</CreateTime>");
		xmlData.append("<TitleType>"+(orderInfo.getTitleType()!=null?orderInfo.getTitleType():"")+"</TitleType>");
		xmlData.append("<InvoiceTitle>"+(orderInfo.getInvoiceTitle()!=null?orderInfo.getInvoiceTitle():"")+"</InvoiceTitle>");
		xmlData.append("<InvoiceNotes>"+(orderInfo.getInvoiceNotes()!=null?orderInfo.getInvoiceNotes():"")+"</InvoiceNotes>");
		xmlData.append("<PostType>"+(orderInfo.getPostType()!=null?orderInfo.getPostType():"")+"</PostType>");	
		xmlData.append("<PostTime>"+(orderInfo.getPostTime()!=null?orderInfo.getPostTime():"")+"</PostTime>");
		xmlData.append("<InvoiceCode>"+(orderInfo.getInvoiceCode()!=null?orderInfo.getInvoiceCode():"")+"</InvoiceCode>");
		xmlData.append("<InvoiceNo>"+(orderInfo.getInvoiceNo()!=null?orderInfo.getInvoiceNo():"")+"</InvoiceNo>");
		xmlData.append("<OrderDetails>");
		for(int i = 0;i < orderDetails.size(); i++){
			OrderProduction product = (OrderProduction)orderDetails.get(i);
			xmlData.append("<OrderDetail>");
			xmlData.append("<OrderDetailNo>"+product.getOrderDetailno()+"</OrderDetailNo>");
			xmlData.append("<ProductNo>"+product.getProductNo()+"</ProductNo>");
			xmlData.append("<ProductPrice>"+product.getProductPrice()+"</ProductPrice>");
			xmlData.append("<ActualPrice>"+product.getActualPrice()+"</ActualPrice>");
			xmlData.append("<OrderAmount>"+product.getOrderAmount()+"</OrderAmount>");
			xmlData.append("<OrderMoney>"+product.getOrderMoney()+"</OrderMoney>");
			xmlData.append("<FareMoney>"+product.getFareMoney()+"</FareMoney>");
			xmlData.append("<LateFee>"+product.getLatefee()+"</LateFee>");
			xmlData.append("<SubTotal>"+product.getSubTotal()+"</SubTotal>");
			xmlData.append("<State>"+product.getState()+"</State>");
			xmlData.append("</OrderDetail>");
		}
		xmlData.append("</OrderDetails>");
		xmlData.append("</Order>");
		//System.out.println("xmlData----"+xmlData);
		return this.onlinePaymentRemoteWS.updateOrderData(xmlData.toString());
	}
	//添加订单的基本信息
	public boolean addOrderData(Map map){
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setActualMoney(map.get("ActualMoney")!=null?Integer.parseInt(map.get("ActualMoney")+""):0);
		orderInfo.setCreateTime(map.get("CreateTime")+"");
		orderInfo.setCustomerId(map.get("CustomerID")+"");
		orderInfo.setFareMoney(map.get("FareMoney")!=null?Integer.parseInt(map.get("FareMoney")+""):0);
		orderInfo.setInvoiceCode(map.get("InvoiceCode")+"");
		orderInfo.setInvoiceNo(map.get("InvoiceNo")+"");
		orderInfo.setInvoiceNotes(map.get("InvoiceNotes")+"");
		orderInfo.setInvoiceTitle(map.get("InvoiceTitle")+"");
		orderInfo.setIsNeedInvoice(map.get("IsNeedInvoice")+"");
		orderInfo.setLateFee(map.get("LateFee")!=null?Integer.parseInt(map.get("LateFee")+""):0);
		orderInfo.setLinkId(map.get("LinkID")+"");
		orderInfo.setNotes(map.get("Notes")+"");
		orderInfo.setOrderMasterno(map.get("OrderMasterNo")+"");
		orderInfo.setOrderStatus(map.get("OrderStatus")+"");
		orderInfo.setEmployeeId(map.get("EmployeeID")+"");
		orderInfo.setPayBank(map.get("PayBank")+"");
		orderInfo.setPayMoney(0);
		orderInfo.setPayStatus(map.get("PayStatus")+"");
		orderInfo.setPayType(map.get("PayType")+"");
		orderInfo.setPostTime(map.get("PostTime")+"");
		orderInfo.setPostType(map.get("PostType")+"");
		orderInfo.setProductMoney(0);
		orderInfo.setTitleType(map.get("TitleType")+"");
		orderInfo.setTotalPayMoney(map.get("TotalPayMoney")!=null?Integer.parseInt(map.get("TotalPayMoney")+""):0);
		orderInfo.setTransactionNo(map.get("TransactionNo")+"");
		OrderInfo info = this.queryOrderInfo(map.get("OrderMasterNo")+"");
		if(info == null){
			boolean orderBoolean = this.addOrderInfo(orderInfo);
			if(orderBoolean){//添加订单的明细
				List details = (ArrayList)map.get("orderDetail");
				for(int i = 0;i < details.size();i++){
					HashMap detail = (HashMap)details.get(i);
					OrderProduction production = new OrderProduction();
					production.setTid(BaseUtil.generateIdentifier());
					production.setActualPrice(detail.get("ActualPrice")!=null?(int)Double.parseDouble(detail.get("ActualPrice").toString()):0);
					production.setFareMoney(detail.get("FareMoney")!=null?(int)Double.parseDouble(detail.get("FareMoney")+""):0);
					production.setLatefee(detail.get("LateFee")!=null?(int)Double.parseDouble(detail.get("LateFee")+""):0);
					production.setOrderAmount(detail.get("OrderAmount")!=null?(int)Double.parseDouble(detail.get("OrderAmount")+""):0);
					production.setOrderDetailno(detail.get("OrderDetailNo")+"");
					production.setOrderMasterno(map.get("OrderMasterNo")+"");
					production.setOrderMoney(detail.get("OrderMoney")!=null?(int)Double.parseDouble(detail.get("OrderMoney")+""):0);
					production.setPayPrice(0);
					production.setProductNo(detail.get("ProductNo")+"");
					production.setProductPrice(detail.get("ProductPrice")!=null?(int)Double.parseDouble(detail.get("ProductPrice")+""):0);
					production.setSubTotal(detail.get("SubTotal")!=null?(int)Double.parseDouble(detail.get("SubTotal")+""):0);

					this.addOrderProduction(production);
				}
			}
		}
		//添加订单的地址
		OrderContact contact = new OrderContact();
		contact.setArea(map.get("Area")+"");
		contact.setCreateTime(map.get("CreateTime")+"");
		contact.setCustomerId(map.get("CustomerID")+"");
		contact.setDepartment(map.get("Department")+"");
		contact.setFax(map.get("Fax")+"");
		contact.setLinkId(map.get("LinkID")+"");
		contact.setLinkName(map.get("LinkName")+"");
		contact.setMsn(map.get("Msn")+"");
		contact.setNotes(map.get("Notes")+"");
		contact.setPosition(map.get("Position")+"");
		contact.setPostCode(map.get("PostCode")+"");
		contact.setPrefeCtureLevelCity(map.get("PrefecturelevelCity")+"");
		contact.setProvince(map.get("Province")+"");
		contact.setQq(map.get("QQ")+"");
		contact.setStreet(map.get("Street")+"");
		contact.setTelephone(map.get("Telephone")+"");
		contact.setUserId(map.get("CustomerID")+"");
		contact.setFullAddress(map.get("FullAddress")+"");
		contact.setMobile(map.get("Mobile")+"");
		OrderContact orderCon = this.selectOrderContactByLinkId(map.get("LinkID")+"");
		if(orderCon == null){
			this.insertOrderContact(contact);
		}else{
			this.updateOrderContact(contact);
		}

		return true;
	}
	public boolean addOrderInfo(OrderInfo orderInfo){

		return this.onlinePaymentService.addOrderInfo(orderInfo);
	}
	public  OrderInfo queryOrderInfo(String orderId){
		return this.onlinePaymentService.selectOrderInfoById(orderId);
	}
	public List queryOrderProductionsByOrderId(String orderId){
		return this.onlinePaymentService.selectOrderProductionsByOrderId(orderId);
	}
	public boolean editOrderInfo(OrderInfo order){
		this.onlinePaymentService.editOrderInfo(order);
		return true;
	}
	public boolean addOrderProduction(OrderProduction production){

		return this.onlinePaymentService.addOrderProduction(production);
	}
	public boolean updateOrderProduction(OrderProduction production){

		int num = this.onlinePaymentService.updateOrderProduction(production);
		if(num > 0){
			return true;
		}else{
			return false;
		}
	}
	public boolean addOrderOnlinePayRecord(OrderOnlinePayRecord onlinepayRecord){
		this.onlinePaymentService.insertOrderOnlinePayRecord(onlinepayRecord);
		return true;
	}
	public OrderOnlinePayRecord queryOrderOnlinePayRecordByOrderId(String orderId){
		return this.onlinePaymentService.selectOrderOnlinePayRecordById(orderId);
	}
	public boolean editOrderOnlinePaymentRecord(OrderOnlinePayRecord payRecord){
		this.onlinePaymentService.editOrderOnlinePaymentRecord(payRecord);
		return true;
	}
	public OrderInfo selectOrderInfoByTransactionId(String transactionId){
		return this.onlinePaymentService.selectOrderInfoByTransactionId(transactionId);
	}
	public OrderOnlinePayRecord selectOrderOnlinePayRecordByTransactionId(String transactionId){
		return this.onlinePaymentService.selectOrderOnlinePayRecordByTransactionId(transactionId);
	}
	public List<Map<String,String>> getProductFareMoney(){
		return this.onlinePaymentService.getProductFareMoney();
	}
	public boolean deleteOrderDetails(String orderMasterNo){
		int num = this.onlinePaymentService.deleteOrderDetails(orderMasterNo);
		if(num > 0){
			return true;
		}
		return false;
	}
	public boolean insertOrderContact(OrderContact contact){
		int num = this.onlinePaymentService.insertOrderContact(contact);
		if(num > 0) return true;
		return false;
	}
	public OrderContact selectOrderContactByLinkId(String linkId){
		return this.onlinePaymentService.selectOrderContactByLinkId(linkId);
	}
	public boolean updateOrderContact(OrderContact contact){
		Integer num = this.onlinePaymentService.updateOrderContact(contact);
		if(num > 0){
			return true;
		}
		return false;
	}
	public List<TempProduction> getTempProductList(){
		List<TempProduction> temp = this.onlinePaymentService.getTempProductList();
		for(int i = 0;i < temp.size(); i++){
			TempProduction pro = temp.get(i);//
			pro.setIndex(i+1);
			pro.setProductVersion(pro.getProductVersion()+"   ");
			pro.setProductService(pro.getProductService()+"   ");
		}
		return temp;
	}
}
