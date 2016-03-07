package org.izhong.expert.abs;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.izhong.expert.model.Companys;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.service.KeyWordService;
import org.izhong.expert.service.RoleService;
import org.izhong.expert.service.SyncCustomerService;
import org.izhong.expert.service.UserInfoService;
import org.izhong.expert.service.UserRegisterService;

public abstract class UserRegisterAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected UserRegisterService userRegisterService;
	protected RoleService roleService;
	protected KeyWordService keyWordService;
	protected UserInfoService userInfoService;
	protected SyncCustomerService syncCustomerService;
	
	public void setUserRegisterService(UserRegisterService userRegisterService) {
		this.userRegisterService = userRegisterService;
	}
	
	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public void setSyncCustomerService(SyncCustomerService syncCustomerService) {
		this.syncCustomerService = syncCustomerService;
	}
	
	public abstract void AddUser(SysUsers sysuser,LabUsers labuser,Companys company);
	
	public abstract String AddCasualUser(HttpServletResponse response, SYS_CasualUser sys_CasualUser);
	
	public abstract String AddCasualUser1(HttpServletResponse response, SYS_CasualUser sys_CasualUser);
	
	public abstract String AddUser(HttpServletResponse response, SysUsers sysuser,LabUsers labuser,String customerId);
	
	public abstract List<QueryHotWords> findHotWordsAll();
	
	public abstract void verifiEmail(HttpServletResponse response, String email);
	
	public abstract void verifiMobile(HttpServletResponse response, String mobile);
	
	public abstract int email_reg(String email,String code);
	
	public abstract String getCode(String email);
	
	public abstract void delCasual(String email);
	
	public abstract SYS_CasualUser getCasual(String email);
	
	public abstract void verifiCustomerId(HttpServletResponse response, String customerId);
	
	public abstract boolean attestAccount(String userId,String customerId);

	public abstract SysUsers getSysUserByLogName(String email);
}
