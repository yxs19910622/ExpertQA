package org.izhong.expert.abs;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.types.Schema;
import org.izhong.web.webservices.ToLDLocator;
import org.izhong.web.webservices.ToLDSoapStub;

public class OnlinePaymentRemoteWSImpl implements OnlinePaymentRemoteWS {

	public static String invoke(String parem, String remotemethod) {
		// String endpointURL =
		// "http://192.168.50.175/WebServiceStub/Service1.asmx?wsdl";
		String endpointURL = "http://192.168.40.111/IZWebService/WebService/toLD.asmx";
		String namespaceURI = "http://tempuri.org/";// 命名空间
		String soapactionURI = "http://tempuri.org/" + remotemethod; // soapactionURI
		// String remotemethod = "getOrderByCustomerID";//方法名
		Schema schema = null;
		String res = null;
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.addParameter(new QName(namespaceURI, "GoodsNO"),
					XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_SCHEMA);
			call.setUseSOAPAction(true);
			call.setSOAPActionURI(soapactionURI);
			call.setTargetEndpointAddress(new URL(endpointURL).toString());
			call.setOperationName(new QName(namespaceURI, remotemethod));
			schema = (Schema) call.invoke(new Object[] { parem });// 这里花费了9秒，效率太慢
			// by whz
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == schema.get_any() || "".equals(schema.get_any())) {
			return null;
		}
		res = schema.get_any()[0].toString();// .getAsString();
		return res;
	}

	public String getOrderByCustomerID(String customerId) {
		ToLDLocator locator = new ToLDLocator();
		ToLDSoapStub stub;
		try {
			stub = (ToLDSoapStub) locator.gettoLDSoap();
			String xml = stub.getOrderByCustomerID(customerId);
			return xml;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public boolean updateOrderData(String xmlData) {
		ToLDLocator locator = new ToLDLocator();
		ToLDSoapStub stub;
		try {
			stub = (ToLDSoapStub) locator.gettoLDSoap();
			boolean flag = stub.updateOrderData(xmlData);
			return flag;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(OnlinePaymentRemoteWSImpl.invoke("375224","GetOrderByCustomerID"));
		// System.out.println(OnlinePaymentRemoteWSImpl.invoke("11","updateOrderData"));
		
		OnlinePaymentRemoteWSImpl online = new OnlinePaymentRemoteWSImpl(); 
	    String xml = online.getOrderByCustomerID("804609");//  
		System.out.println(xml); 

		
        //String xml = "<Order><OrderMasterNo>2150570</OrderMasterNo><CustomerID>761819</CustomerID><ActualMoney>9990</ActualMoney><IsNeedInvoice>true</IsNeedInvoice><Notes>支付信息</Notes><PayType>100</PayType><PayBank>ICBCB2C</PayBank><TransactionNo>0924152435855632</TransactionNo><PayStatus>2</PayStatus><OrderStatus>J</OrderStatus><EmployeeID>804609</EmployeeID><LinkID>161228</LinkID><LinkName>刘丽</LinkName><Province>广东省</Province><PrefecturelevelCity>null</PrefecturelevelCity><Area></Area><Street></Street><FullAddress>深圳市</FullAddress><PostCode>300353</PostCode><Telephone>联系电话</Telephone><Mobile>手机号码</Mobile><Fax></Fax><QQ>Q123456</QQ><Msn></Msn><Department></Department><Position>总监</Position><FareMoney>70</FareMoney><TotalPayMoney>10060</TotalPayMoney><CreateTime></CreateTime><TitleType>公司</TitleType><InvoiceTitle>龙门尚天然度假有限公司</InvoiceTitle><InvoiceNotes>学习用品</InvoiceNotes><PostType></PostType><PostTime></PostTime><InvoiceCode></InvoiceCode><InvoiceNo></InvoiceNo><OrderDetails><OrderDetail><OrderDetailNo>4642957</OrderDetailNo><ProductNo>LDPBTZ</ProductNo><ProductPrice>2998</ProductPrice><ActualPrice>1998</ActualPrice><OrderAmount>3</OrderAmount><OrderMoney>5994</OrderMoney><FareMoney>30</FareMoney><LateFee>1</LateFee><SubTotal>6024</SubTotal><State>edit</State></OrderDetail><OrderDetail><OrderDetailNo>5065821</OrderDetailNo><ProductNo>LDPUTZ</ProductNo><ProductPrice>2998</ProductPrice><ActualPrice>1998</ActualPrice><OrderAmount>1</OrderAmount><OrderMoney>1998</OrderMoney><FareMoney>10</FareMoney><LateFee>1</LateFee><SubTotal>2008</SubTotal><State>edit</State></OrderDetail><OrderDetail><OrderDetailNo>0</OrderDetailNo><ProductNo>LDSBTZ</ProductNo><ProductPrice>2998</ProductPrice><ActualPrice>1998</ActualPrice><OrderAmount>1</OrderAmount><OrderMoney>1998</OrderMoney><FareMoney>30</FareMoney><LateFee>1</LateFee><SubTotal>2028</SubTotal><State>insert</State></OrderDetail></OrderDetails></Order>";
        // boolean flag = online.updateOrderData(xml);
		//System.out.println(flag);
	}

}
