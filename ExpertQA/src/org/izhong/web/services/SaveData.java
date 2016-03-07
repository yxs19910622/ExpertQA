package org.izhong.web.services;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.izhong.expert.model.OperationLogs;
import org.izhong.expert.model.TMPCompanys;
import org.izhong.expert.model.TMPOrders;
import org.izhong.expert.model.TMPUsers;
import org.izhong.expert.service.LogsService;
import org.izhong.expert.service.SyncCustomerService;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.DateUtil;
import org.izhong.web.util.Tools;

public class SaveData {
	
	protected Logger log = Logger.getLogger(getClass());
	private SyncCustomerService syncCustomerService = InitDao.getInstance().getSyncCustomerService();
	private LogsService logsService = InitDao.getInstance().getLogsService();
	
	public boolean addCompanys(List<Element> lstCompanys)
	{
		int tmp = 0;
		int stat = 0;
		int success = 0;
		int failure = 0;
		log.info("收到["+lstCompanys.size()+"]条公司数据");
		StringBuilder sb = new StringBuilder();
		sb.append("失败的数据分别为：");
		for (int i = 0; i < lstCompanys.size(); i++) {
			Element element = lstCompanys.get(i);
			TMPCompanys company = new TMPCompanys();
			company.setCompanyID(element.elementText("CompanyID"));
			company.setCompanyName(element.elementText("CompanyName"));
			company.setIncorporator(element.elementText("Incorporator"));
			company.setProvince(element.elementText("Province"));
			company.setPrefecturelevelCity(element.elementText("PrefecturelevelCity"));
			company.setArea(element.elementText("Area"));
			company.setStreet(element.elementText("Street"));
			company.setPostcode(element.elementText("Postcode"));
			company.setTelephone(element.elementText("Telephone"));
			company.setFax(element.elementText("Fax"));
			company.setNotes(element.elementText("Notes"));
			company.setSummary(element.elementText("Notes"));
			tmp = syncCustomerService.getCompanyByCompanyId(company.getCompanyID());
//			try {
				if(tmp==0)
				{
					stat = syncCustomerService.addCompanys(company);
				}else{
					stat = syncCustomerService.updateCompanys(company);
				}
				stat = syncCustomerService.addCompanys(company);
				if(stat==0)
				{
					failure++;
					sb.append((tmp==0?"[更新]":"[新增]")+"CompanyID:"+company.getCompanyID()+",");
				}else{
					success++;
				}
//			} catch (Exception e) {
//				log.error(e.getMessage());
//				sb.append((tmp==0?"[更新]":"[新增]")+"CompanyID:"+company.getCompanyID()+",");
//				failure++;
//				//e.printStackTrace();
//			}
		}
		OperationLogs logs = new OperationLogs();
		logs.setOperationText("同步数据");
		logs.setOperator("ICream");
		logs.setOperationTime(DateUtil.getCurrTime());
		logs.setOperationNotes("同步[公司]表，收到"+lstCompanys.size()+"条,操作成功:"+success+"条,失败:"+failure+"条,"+sb.toString());
		logs.setIpAddress(Tools.getIp());
		logsService.addOperation(logs);
		
		return (failure==0?true:false);
	}
	
	public boolean addUsers(List<Element> lstUsers)
	{
		int tmp = 0;
		int stat = 0;
		int success = 0;
		int failure = 0;
		log.info("收到["+lstUsers.size()+"]条用户数据");
		StringBuilder sb = new StringBuilder();
		sb.append("失败的数据分别为：");
		for (int i = 0; i < lstUsers.size(); i++) {
			Element element = lstUsers.get(i);
			TMPUsers user = new TMPUsers();
			user.setUserID(element.elementText("UserID"));
			user.setCompanyID(element.elementText("CompanyID"));
			user.setUserName(element.elementText("UserName"));
			user.setPosition(element.elementText("Position"));
			user.setMobile(element.elementText("Mobile"));
			tmp = syncCustomerService.getUserByUserId(user.getUserID());
//			try {
				if(tmp==0)
				{
					stat = syncCustomerService.addUsers(user);
				}else{
					stat = syncCustomerService.updateUsers(user);
				}
				stat = syncCustomerService.addUsers(user);
				if(stat==0)
				{
					failure++;
					sb.append((tmp==0?"[更新]":"[新增]")+"UserID:"+user.getUserID()+",");
				}else{
					success++;
				}
//			} catch (Exception e) {
//				log.error(e.getMessage());
//				sb.append((tmp==0?"[更新]":"[新增]")+"UserID:"+user.getUserID()+",");
//				failure++;
//				//e.printStackTrace();
//			}
		}
		OperationLogs logs = new OperationLogs();
		logs.setOperationText("同步数据");
		logs.setOperator("ICream");
		logs.setOperationTime(DateUtil.getCurrTime());
		logs.setOperationNotes("同步[用户]表，收到"+lstUsers.size()+"条,操作成功:"+success+"条,失败:"+failure+"条,"+sb.toString());
		logs.setIpAddress(Tools.getIp());
		logsService.addOperation(logs);
		
		return (failure==0?true:false);
	}
	
	public boolean addOrders(List<Element> lstOrders)
	{
		int tmp = 0;
		int stat = 0;
		int success = 0;
		int failure = 0;
		log.info("收到["+lstOrders.size()+"]条订单数据");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuilder sb = new StringBuilder();
		sb.append("失败的数据分别为：");
		for (int i = 0; i < lstOrders.size(); i++) {
			Element element = lstOrders.get(i);
			TMPOrders order = new TMPOrders();
			order.setOrderDetailNo(element.elementText("OrderDetailNo"));
			order.setOrderMasterNo(element.elementText("OrderMasterNo"));
			order.setUserID(element.elementText("UserID"));
			order.setProductNo(element.elementText("ProductNo"));
			order.setInvoiceNo(element.elementText("InvoiceNo"));
			order.setImportDate(DateUtil.getCurrTime());
			try {
			if(BaseUtil.isNotEmpty(element.elementText("DistributeDate").trim()))
			{
				order.setDistributeDate(sdf.parse(element.elementText("DistributeDate")));
			}
			if(BaseUtil.isNotEmpty(element.elementText("PaymentDate").trim()))
			{
				order.setPaymentDate(sdf.parse(element.elementText("PaymentDate")));
			}
			if(BaseUtil.isNotEmpty(element.elementText("ServiceStartDate").trim()))
			{
				order.setServiceStartDate(sdf.parse(element.elementText("ServiceStartDate")));
			}
			if(BaseUtil.isNotEmpty(element.elementText("ServiceEndDate").trim()))
			{
				order.setServiceEndDate(sdf.parse(element.elementText("ServiceEndDate")));
			}	
			order.setOrderStatus(element.elementText("OrderStatus"));

			tmp = syncCustomerService.getOrderByDetailOrderNo(order.getOrderDetailNo());
			
				if(tmp==0)
				{
					stat = syncCustomerService.addOrders(order);
				}else{
					stat = syncCustomerService.updateOrders(order);
				}
//			stat = syncCustomerService.addOrders(order);
				if(stat==0)
				{
					failure++;
					sb.append((tmp==0?"[更新]":"[新增]")+"UserID:"+order.getOrderDetailNo()+",");
				}else{
					success++;
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				sb.append((tmp==0?"[更新]":"[新增]")+"UserID:"+order.getOrderDetailNo()+",");
				failure++;
				//e.printStackTrace();
			}
		}
		
		OperationLogs logs = new OperationLogs();
		logs.setOperationText("同步数据");
		logs.setOperator("ICream");
		logs.setOperationTime(DateUtil.getCurrTime());
		logs.setOperationNotes("同步[订单]表，收到"+lstOrders.size()+"条,操作成功:"+success+"条,失败:"+failure+"条,"+sb.toString());
		logs.setIpAddress(Tools.getIp());
		logsService.addOperation(logs);
		
		return (failure==0?true:false);
	}
}
