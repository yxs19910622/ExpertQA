package org.izhong.web.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.izhong.expert.util.BaseUtil;

public class ResolveData {
	
	protected Logger log = Logger.getLogger(getClass());
	
	public boolean resolveOrderData(String xmlOrderData)
	{
		if(BaseUtil.isEmpty(xmlOrderData))
		{
			log.error("没有收到数据:"+xmlOrderData);
			return false;
		}
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(new ByteArrayInputStream(xmlOrderData.getBytes("UTF-8")));
		} catch (Exception e) {
			log.error("解析报文出现异常:"+e.getMessage());
			log.error("收到的报文为："+xmlOrderData);
			return false;
 		}
		boolean result = false;
		SaveData saveData = new SaveData();
		
		Element root = doc.getRootElement();
		
		Element company = root.element("Companys");
		Element user = root.element("Users");
		Element order = root.element("Orders");
		
		List<Element> lstCompanys = company.elements("Company");
		List<Element> lstUsers = user.elements("User");
		List<Element> lstOrders = order.elements("Order");
		
		result = saveData.addOrders(lstOrders);
		result = saveData.addUsers(lstUsers);
		result = saveData.addCompanys(lstCompanys);
		return result;
	}
}
