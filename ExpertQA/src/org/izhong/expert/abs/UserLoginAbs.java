package org.izhong.expert.abs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.izhong.expert.model.Companys;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.service.KeyWordService;
import org.izhong.expert.service.RoleService;
import org.izhong.expert.service.UserInfoService;
import org.izhong.expert.service.UserRegisterService;

public abstract class UserLoginAbs{
	
	protected Logger log = Logger.getLogger(getClass());
	protected KeyWordService keyWordService;
	protected RoleService roleService;
	protected UserInfoService userInfoService;
	protected UserRegisterService userRegisterService;

	public abstract void updateSysUserName(SysUsers sysuser);
	public abstract void updateLabUser(LabUsers labuser);
	public abstract void updateCompany(Companys company);
	
	
	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	public abstract List<QueryHotWords> findHotWordsAll();
	
	public abstract SysUsers findSysUserInfo(String userId);
	
	public abstract boolean check(String email,String password);
	
	public abstract boolean reg_check(String email,String password);
	
	public abstract boolean toLogin(HttpServletResponse response, String email,String password);

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	/**
	 * 根据用户id获取该用户的角色信息
	 * @param userId
	 * @return
	 */
	public abstract HashMap getUserRoleByUserId(String userId);
	/**
	 * 根据角色id获取该按钮的操作信息
	 * @param roleId
	 * @return
	 */
	public abstract List<Map> getOperationByRoleId(String roleId);
	/**
	 * 根据用户id获取该用户的角色操作信息
	 * @param userId
	 * @return
	 */
	public abstract List<Map> getUserRoleOperationByUserId(String userId);
} 
