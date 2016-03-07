package org.izhong.expert.abs;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.izhong.expert.model.Companys;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.Roles;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.TMPOrders;
import org.izhong.expert.model.UserAnnouncements;
import org.izhong.expert.model.UserRoles;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.Constant;
import org.izhong.expert.util.CookieUtil;
import org.izhong.expert.util.DateUtil;
import org.izhong.expert.util.ServletUtil;

public class UserRegisterAbsImpl extends UserRegisterAbs {

	@Override
	public void AddUser(SysUsers sysuser, LabUsers labuser, Companys company) {
		sysuser.setUserID(BaseUtil.generateIdentifier());
		sysuser.setPasswordSalt(BaseUtil.getPasswordSalt());
		sysuser.setPassword(BaseUtil.Md5(sysuser.getPassword()+sysuser.getPasswordSalt()));
		sysuser.setActiveStatus("1");//新注册用户不用审核
		
		company.setCompanyID(BaseUtil.generateIdentifier());
		
		labuser.setUserID(sysuser.getUserID());
		labuser.setCompanyID(company.getCompanyID());
		labuser.setRegisterDate(DateUtil.getCurrTime());
		labuser.setMobile(sysuser.getMobile());
		labuser.setEmail(sysuser.getEmail());
		
		userRegisterService.addSysUser(sysuser);
		userRegisterService.addCompany(company);
		userRegisterService.addLabUser(labuser);
	}

	@Override
	public List<QueryHotWords> findHotWordsAll() {
		return keyWordService.qryHotWordsAll();
	}

	@Override
	public String AddCasualUser(HttpServletResponse response, SYS_CasualUser sys_CasualUser) {
		int result = userRegisterService.verifiEmail(sys_CasualUser.getEmail());
		int isMobile = userRegisterService.verifiMobile(sys_CasualUser.getMobile());
		if(result>0 || isMobile>0)
		{
			return Constant.REGISTER_FAILURE_EMAIL+"&&false";
		}
		sys_CasualUser.setPasswordSalt(BaseUtil.getPasswordSalt());
		sys_CasualUser.setPassword(BaseUtil.Md5(sys_CasualUser.getPassword()+sys_CasualUser.getPasswordSalt()));
		sys_CasualUser.setStatus("0");
		
		userRegisterService.addCasualUser(sys_CasualUser);
		return Constant.REGISTER_SUCCESS+"&&true";
	}
	
	@Override
	public String AddCasualUser1(HttpServletResponse response,
			SYS_CasualUser sys_CasualUser) {
		// TODO Auto-generated method stub
		sys_CasualUser.setPasswordSalt(BaseUtil.getPasswordSalt());
		sys_CasualUser.setPassword(BaseUtil.Md5(sys_CasualUser.getPassword()+sys_CasualUser.getPasswordSalt()));
		sys_CasualUser.setStatus("0");
		
		userRegisterService.addCasualUser(sys_CasualUser);
		return "";
	}

	
	@Override
	public String AddUser(HttpServletResponse response, SysUsers sysuser, LabUsers labuser,String customerId) {
		int result = userRegisterService.verifiEmail(sysuser.getEmail());
		int isMobile = userRegisterService.verifiMobile(sysuser.getMobile());
		if(result>0 || isMobile>0)
		{
			return Constant.REGISTER_FAILURE_EMAIL+"&&false";
		}
		sysuser.setUserID(BaseUtil.generateIdentifier());
		//sysuser.setPasswordSalt(BaseUtil.getPasswordSalt());
		//sysuser.setPassword(BaseUtil.Md5(sysuser.getPassword()+sysuser.getPasswordSalt()));
		sysuser.setExpireRemindDays(7);
		sysuser.setTryStartDate(DateUtil.getCurrentDay());
		sysuser.setTryEndDate(DateUtil.addDays(sysuser.getTryStartDate(), 7));
		sysuser.setActiveStatus("1");//新注册用户不用审核
		
		Companys company = new Companys();
		company.setCompanyID(BaseUtil.generateIdentifier());
		company.setStatus("1");
		
		labuser.setUserID(sysuser.getUserID());
		labuser.setRegisterDate(DateUtil.getCurrTime());
		labuser.setMobile(sysuser.getMobile());
		labuser.setEmail(sysuser.getEmail());
		labuser.setCompanyID(company.getCompanyID());
		
		userRegisterService.addSysUser(sysuser);
		userRegisterService.addLabUser(labuser);
		userRegisterService.addCompany(company);
		
		/**
		 * 授权
		 */
		Roles roles = roleService.qryRoleDefault();
		UserRoles userRole = new UserRoles();
		userRole.setUserID(sysuser.getUserID());
		userRole.setRoleID(roles.getRoleID());
		roleService.addUserRole(userRole);
		
		//如果验证成功，则修改权限
//		boolean flag = this.attestAccount(sysuser.getUserID(), customerId);
//		if(flag)
//		{
//			UserRoles ur = new UserRoles();
//			ur.setUserID(sysuser.getUserID());
//			ur.setRoleID(Constant.ATTESTUSER);
//			roleService.modUserRole(ur);
//			//userInfoService.modSysUserCustomerID(sysuser.getUserID(), customerId);
//		}
		SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日");
		String strDate = df.format(DateUtil.addDays(labuser.getRegisterDate(), sysuser.getExpireRemindDays()));
		String messageText = "试用期截止到"+strDate+" <a href=\"http://zhuanjia.haufe.cn/BuyOnline\" target=\"_blank\">我要付款</a>";
		UserAnnouncements ua = new UserAnnouncements();
		ua.setMessageText(messageText);
		ua.setUserId(sysuser.getUserID());
		ua.setIndexNo(1);
		ua.setMessageType("USERTRYTYPE");
		ua.setProjectName("劳动法V11");
		userRegisterService.addUserAnnouncements(ua);
		
		//注册成功之后自动登录系统
		SysUsers user = userInfoService.qrySysUserInfo(sysuser.getUserID());
		if(user!=null)
		{
			CookieUtil.addCookie(response, "EUserID", user.getUserID());
			if(BaseUtil.isNotEmpty(user.getAliasName()))
			{
				try {
					CookieUtil.addCookie(response, "EUserName", URLEncoder.encode(user.getAliasName(),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			CookieUtil.addCookie(response, "Eemail", user.getEmail());
			/*UserLoginAbsImpl userLoginAbsImpl = new UserLoginAbsImpl();
			HashMap userMap = userLoginAbsImpl.getUserRoleByUserId(user.getUserID());
			if(userMap != null){
				CookieUtil.addCookie(response, "operate", userMap.get("operate")+"");
			}
			CookieUtil.addCookie(response, "Eemail", sysuser.getEmail());*/
		}
		return Constant.REGISTER_SUCCESS+"&&true";
	}

	@Override
	public void verifiEmail(HttpServletResponse response, String email) {
		int count = userRegisterService.verifiEmail(email);
		ServletUtil.writerToClient(response, Boolean.toString((count==0?true:false)));
	}
	
	@Override
	public void verifiMobile(HttpServletResponse response, String mobile) {
		int count = userRegisterService.verifiMobile(mobile);
		ServletUtil.writerToClient(response, Boolean.toString(count==0?true:false));
	}

	@Override
	public void verifiCustomerId(HttpServletResponse response, String customerId) {
		TMPOrders tmpOrder =  syncCustomerService.getOrderByUserId(customerId);
		SysUsers sysuser = userInfoService.qrySysUserByCustomerId(customerId);
		if(tmpOrder!=null)
		{
			if(sysuser==null)
			{
				ServletUtil.writerToClient(response, Boolean.toString(true));
			}
		}else{
			ServletUtil.writerToClient(response, Boolean.toString(false));
		}
	}

	@Override
	public boolean attestAccount(String userId,String customerId) {
		if(BaseUtil.isEmpty(customerId))
		{
			return false;
		}
		SysUsers user = userInfoService.qrySysUserByCustomerId(customerId);
		if(user!=null)
		{
			return false;
		}
		TMPOrders order = syncCustomerService.getOrderByUserId(customerId);

		if(order!=null)
		{
			//获取用户信息，如果用户的试看日期或服务日期已经不为空，则无须重复验证。
			//由试看用户转为付费用户的操作，则由每晚的批处理作业处理，此处不处理。
//			SysUsers user = userInfoService.qrySysUserInfo(userId);
//			if((user.getTryStartDate() != null) || (user.getServiceStartDate() != null))
//			{
//				return false;
//			}
			//当OrderStatus为（H 已付款,J 先款待发货）则直接注册为正式用户。其中“H”的服务日期区间为：发货日期+7+365；“J”的服务日期区间为：当前日期+365；
			//当OrderStatus为（I 已发货,E 等待到款,F 包裹查询中,L 先款未付款发货）时，注册为：试看用户；试看日期区间：发货日期+7+28；
			//当OrderStatus为（B 待发货,C 先款等待到款）时暂不允许注册。
			//当OrderStatus为（A 未核实,D 取消,K 已退订,Z 已删除, G 已退货）不允许注册。
			boolean saved = false;
			String orderStatus = order.getOrderStatus();
			
			SysUsers sysuser = new SysUsers();
			sysuser.setUserID(userId);
			sysuser.setCustomerID(customerId);
			if("H".equals(orderStatus))
			{
				Date startDate = DateUtil.addDays(order.getDistributeDate(),7);
				Date endDate = DateUtil.addYears(startDate, 1);	
				sysuser.setServiceStartDate(startDate);
				sysuser.setServiceEndDate(endDate);
				userInfoService.modSysUserServiceDate(sysuser);
				saved = true;
			}
			else if("J".equals(orderStatus))
			{
				Date startDate = DateUtil.getCurrentDay();
				Date endDate = DateUtil.addYears(startDate, 1);	
				sysuser.setServiceStartDate(startDate);
				sysuser.setServiceEndDate(endDate);
				userInfoService.modSysUserServiceDate(sysuser);
				
				saved = true;
			}
			else if(("I".equals(orderStatus))||("E".equals(orderStatus))||("F".equals(orderStatus))||("L".equals(orderStatus)))
			{
				Date startDate = DateUtil.addDays(order.getDistributeDate(),7);
				Date endDate = DateUtil.addDays(startDate, 28);	
				sysuser.setTryStartDate(startDate);
				sysuser.setTryEndDate(endDate);
				userInfoService.modSysUserTryDate(sysuser);
					
				saved = true;
			}
			return saved;
		}
		return false;
	}
//	public  void addCompany(Companys company){
//		this.userRegisterService.addCompany(company);
//	}

	@Override
	public int email_reg(String email, String code) {
		return userRegisterService.email_reg(email, code);
	}

	@Override
	public SYS_CasualUser getCasual(String email) {
		return userRegisterService.getCasual(email);
	}

	@Override
	public String getCode(String email) {
		return userRegisterService.getCode(email);
	}

	@Override
	public void delCasual(String email) {
		userRegisterService.delCasual(email);
	}

	@Override
	public SysUsers getSysUserByLogName(String email) {
		return userInfoService.getSysUserByLogName(email);
	}


	
}
