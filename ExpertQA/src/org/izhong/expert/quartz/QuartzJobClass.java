package org.izhong.expert.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.TMPOrders;
import org.izhong.expert.model.UserRoles;
import org.izhong.expert.service.RoleService;
import org.izhong.expert.service.SyncCustomerService;
import org.izhong.expert.service.UserInfoService;
import org.izhong.expert.util.Constant;
import org.izhong.expert.util.DateUtil;
import org.izhong.web.services.InitDao;

public class QuartzJobClass {
	
	private Logger log = Logger.getLogger(getClass());
	private SyncCustomerService syncCustomerService = null;
	private UserInfoService userInfoService = null;
	private RoleService roleService = null;
	
	public void ProcessOrders()
	{
		System.out.println("ddd1");
		String currDate = DateUtil.getCurrDate();
		String startDate = currDate+" 00:00:00";
		String endDate = currDate+" 23:59:59";
		this.ProcessOrders(startDate, endDate);
	}
	
	public void ProcessOrders(String startDateString, String endDateString)
	{
		System.out.println("ddd2");
		syncCustomerService = InitDao.getInstance().getSyncCustomerService();
		userInfoService = InitDao.getInstance().getUserInfoService();
		roleService = InitDao.getInstance().getRoleService();
		List<TMPOrders> lstOrders = new ArrayList<TMPOrders>();
		lstOrders = syncCustomerService.getOrderByImportDate(startDateString, endDateString);
		if(lstOrders.size()==0)
		{
			log.info("今日没有要处理的数据");
			return;
		}
		for (int i = 0; i < lstOrders.size(); i++) {
			TMPOrders order = lstOrders.get(i);
			if("H".equals(order.getOrderStatus()))//处理已付款状态
			{
				SysUsers sysuser = userInfoService.qrySysUserByCustomerId(order.getUserID());
				if(sysuser!=null)
				{
					Date startDate = DateUtil.addDays(order.getDistributeDate(),7);
					Date endDate = DateUtil.addYears(startDate, 1);	
					sysuser.setServiceStartDate(startDate);
					sysuser.setServiceEndDate(endDate);
					userInfoService.modSysUserServiceDate(sysuser);
					log.info("客户号："+sysuser.getCustomerID()+"已付款处理成功!");
					
					UserRoles userRole = new UserRoles();
					userRole.setUserID(sysuser.getUserID());
					userRole.setRoleID(Constant.ATTESTUSER);
					roleService.modUserRole(userRole);
					log.info("用户ID："+sysuser.getUserID()+"付款成功，更新角色");
				}
			}else
			if("G".equals(order.getOrderStatus()))//处理已退货状态
			{
				SysUsers sysuser = userInfoService.qrySysUserByCustomerId(order.getUserID());
				if(sysuser!=null)
				{
					sysuser.setServiceStartDate(null);
					sysuser.setServiceEndDate(null);
					userInfoService.modSysUserServiceDate(sysuser);//更新服务日期，试用日期未做处理
					log.info("客户号："+sysuser.getCustomerID()+"已退货处理成功!");
					
					UserRoles userRole = new UserRoles();
					userRole.setUserID(sysuser.getUserID());
					userRole.setRoleID(Constant.NEWUSER);
					roleService.modUserRole(userRole);
					log.info("用户ID："+sysuser.getUserID()+"退货成功，更新角色");
				}
			}
		}
	}
}
