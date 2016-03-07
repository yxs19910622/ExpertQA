package org.izhong.web.services;

import org.apache.log4j.Logger;
import org.izhong.expert.service.AccessLogService;
import org.izhong.expert.service.ClientExpertService;
import org.izhong.expert.service.LogsService;
import org.izhong.expert.service.UserService2;
import org.izhong.expert.service.ReplysService;
import org.izhong.expert.service.RoleService;
import org.izhong.expert.service.SyncCustomerService;
import org.izhong.expert.service.UpdateService;
import org.izhong.expert.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDao {
	
	protected Logger log = Logger.getLogger(getClass());
	private static InitDao initDao = null;
	private ApplicationContext ac = null;
	private AccessLogService accessLogService;
	private UserInfoService userInfoService;
	private LogsService logsService;
	private ReplysService replysService; 
	private ClientExpertService clientExpertService;
	private SyncCustomerService syncCustomerService;
	private RoleService roleService;
	private UpdateService updateService;
	private UserService2 userService2;
	
	public InitDao() {
		init();
	}
	
	public static synchronized InitDao getInstance() {
		if(initDao == null) {
			initDao = new InitDao();
		}
		return initDao;
	}
	
	public void init(){
		 ac = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
		 accessLogService = (AccessLogService) ac.getBean("accessLogService");		 
		 userInfoService = (UserInfoService) ac.getBean("userInfoService");
		 logsService = (LogsService) ac.getBean("logsService");
		 replysService = (ReplysService) ac.getBean("replysService");
		 clientExpertService = (ClientExpertService) ac.getBean("clientExpertService");
		 syncCustomerService = (SyncCustomerService) ac.getBean("syncCustomerService");
		 roleService = (RoleService) ac.getBean("roleService");
		 updateService = (UpdateService)ac.getBean("updateService");
		 userService2 = (UserService2)ac.getBean("userService2");
	}

	public AccessLogService getAccessLogService() {
		return accessLogService;
	}

	public void setAccessLogService(AccessLogService accessLogService) {
		this.accessLogService = accessLogService;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public LogsService getLogsService() {
		return logsService;
	}

	public void setLogsService(LogsService logsService) {
		this.logsService = logsService;
	}
	
	public ReplysService getReplysService() {
		return replysService;
	}

	public void setReplysService(ReplysService replysService) {
		this.replysService = replysService;
	}

	public ClientExpertService getClientExpertService() {
		return clientExpertService;
	}

	public void setClientExpertService(ClientExpertService clientExpertService) {
		this.clientExpertService = clientExpertService;
	}

	public SyncCustomerService getSyncCustomerService() {
		return syncCustomerService;
	}

	public void setSyncCustomerService(SyncCustomerService syncCustomerService) {
		this.syncCustomerService = syncCustomerService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UpdateService getUpdateService() {
		return updateService;
	}

	public void setUpdateService(UpdateService updateService) {
		this.updateService = updateService;
	}

	public UserService2 getUserService2() {
		return userService2;
	}

	public void setUserService2(UserService2 userService2) {
		this.userService2 = userService2;
	}

}
