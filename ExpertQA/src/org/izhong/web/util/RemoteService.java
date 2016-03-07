package org.izhong.web.util;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.types.Schema;
import org.izhong.expert.model.UserTryInfos;
import org.izhong.expert.util.DateUtil;

public class RemoteService {
	
	/**
	 * 免费试用申请数据发送到ICream
	 * @param userTryInfo
	 * @return
	 * @author whz
	 */
	public static String tWebLPORDER(UserTryInfos userTryInfo)
	{
		String endpointURL = "http://icreambak.izhong.com/WebService/izhongService.asmx?WSDL";
//		String endpointURL = "http://192.168.40.111/IZWebService/WebService/izhongService.asmx?wsdl";  
		String namespaceURI = "http://izhong.com/" ;
		String soapactionURI = "http://izhong.com/t_Web_LP_ORDER"; //soapactionURI
		String remotemethod = "t_Web_LP_ORDER";
		Schema schema = null;
		String res = null;
		try {
			Service service = new Service();
			Call call=(Call) service.createCall();
			call.addParameter(new QName(namespaceURI,"LP_ORDER_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"LP_CODE"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"PRODUCT_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"PRODUCT_NAME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"PRODUCT_CODE_NAME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"VISITOR_IP"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"PORDER_CODE"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"GIFT"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"SOURCE_URL"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"IS_AGREE_TO_MAIL"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"REMARK"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"CREATE_TIME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"EDIT_TIME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"EDITOR_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"EDITOR_NAME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"CUSTOMER_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"ORDER_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"PRODUCT_BUY_TYPE"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"LP_ORDER_STATUS"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"ORDER_REMARK"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.setReturnType(XMLType.XSD_SCHEMA);
			call.setUseSOAPAction(true); 
			call.setSOAPActionURI(soapactionURI); 
			call.setTargetEndpointAddress(new URL(endpointURL).toString());
			call.setOperationName(new QName(namespaceURI, remotemethod));
			schema = (Schema) call.invoke(new Object[]{
					userTryInfo.getPreOrderNo(),
					"1",								
					userTryInfo.getTryProductNo(),
					userTryInfo.getTryProductName(),
					userTryInfo.getTryProductNo(),
					userTryInfo.getVisitorIP(),
					"",								//订单类别
					"",								//赠品
					"",								//来源
					"",								//是否同意发邮件
					userTryInfo.getNotes(),			//备注
					DateUtil.getCurrTimeStr(),		//创建日期
					"",								//	
					"",								//
					"",								//
					"",								//客户号
					"",								//订单ID
					"",								//产品购买类别
					"",								//订单状态
					userTryInfo.getNotes()});		//订单备注
		}  catch (Exception e) {
			e.printStackTrace();
		}
		if(null==schema || "".equals(schema)){return null;}
		if(null==schema.get_any() || "".equals(schema.get_any())){return null;}
		res = schema.get_any()[0].toString();//.getAsString();
		return res;
	}
	
	/**
	 * 免费试用申请联系人数据发送到ICream
	 * @param userTryInfo
	 * @return
	 * @author whz
	 */
	public static String tWebLPCONTACT(UserTryInfos userTryInfo)
	{
		String endpointURL = "http://icreambak.izhong.com/WebService/izhongService.asmx?WSDL";
//		String endpointURL = "http://192.168.40.111/IZWebService/WebService/izhongService.asmx?wsdl";  
		String namespaceURI = "http://izhong.com/" ;
		String soapactionURI = "http://izhong.com/t_Web_LP_CONTACT"; //soapactionURI
		String remotemethod = "t_Web_LP_CONTACT";
		Schema schema = null;
		String res = null;
		try {
			Service service = new Service();
			Call call=(Call) service.createCall();
			call.addParameter(new QName(namespaceURI,"LP_CONTACT_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"LP_ORDER_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"LINKMAN_NAME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"PROVINCE"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"CITY"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"SECTION"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"STREET_ADDRESS"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"POST_CODE"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"PHONE"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"MOBILE_PHONE"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"FAXES"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"QQ"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"MSN"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"COMPANY_NAME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"COMPANY_INDUSTRY"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"DEPARTMENT"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"POSITION"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"REMARK"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"CREATE_TIME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"EDIT_TIME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"EDITOR_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"EDITOR_NAME"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"FATHER_ID"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.addParameter(new QName(namespaceURI,"IS_FATHER"),XMLType.XSD_STRING ,ParameterMode.IN);
			call.setReturnType(XMLType.XSD_SCHEMA);
			call.setUseSOAPAction(true); 
			call.setSOAPActionURI(soapactionURI); 
			call.setTargetEndpointAddress(new URL(endpointURL).toString());
			call.setOperationName(new QName(namespaceURI, remotemethod));
			schema = (Schema) call.invoke(new Object[]{
					"",
					userTryInfo.getPreOrderNo(),								
					userTryInfo.getConsigneeName(),
					userTryInfo.getProvince(),
					userTryInfo.getPrefectureLevelCity(),
					userTryInfo.getArea(),
					userTryInfo.getStreet(),
					userTryInfo.getPostCode(),								
					"",						
					userTryInfo.getMobile(),			
					"",										//传真	
					"",										//QQ		
					"",										//MSN
					"",										//企业名称
					"",										//企业所属行业
					"",										//部门							
					"",										//职位
					"",										//备注
					DateUtil.getCurrTimeStr(),
					"",
					"",
					"",
					"",										//推荐人ID
					""});									//是否推荐人
		}  catch (Exception e) {
			e.printStackTrace();
		}
		if(null==schema || "".equals(schema)){return null;}
		if(null==schema.get_any() || "".equals(schema.get_any())){return null;}
		res = schema.get_any()[0].toString();//.getAsString();
		return res;
	}
	
	public static void main(String[] args) {
		UserTryInfos userTryInfo = new UserTryInfos();
		userTryInfo.setPreOrderNo("123456");								
		userTryInfo.setTryProductNo("123456");
		userTryInfo.setConsigneeName("易中员工测试");
		userTryInfo.setProvince("北京市");
		userTryInfo.setPrefectureLevelCity("市辖区");
		userTryInfo.setArea("海淀区");
		userTryInfo.setStreet("花园东路xx号");
		userTryInfo.setPostCode("100191");								
		userTryInfo.setMobile("135218195");
//		userTryInfo.setEmail("wanghz@izhong.com");
		
		userTryInfo.setPreOrderNo("201209141");
		userTryInfo.setTryProductNo("LDPUTZ");
//		userTryInfo.setProductName("劳动法UPAN套装");
		userTryInfo.setVisitorIP("192.168.0.0");
		userTryInfo.setNotes("");
		//userTryInfo.setApplyTryDate(DateUtil.getCurrTime());
//		System.out.println(RemoteService.tWebLPORDER(userTryInfo));
		System.out.println(RemoteService.tWebLPCONTACT(userTryInfo));
	}
}
