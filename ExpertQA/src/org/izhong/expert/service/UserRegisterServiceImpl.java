package org.izhong.expert.service;

import org.izhong.expert.dao.UserRegisterDao;
import org.izhong.expert.model.Companys;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserAnnouncements;

public class UserRegisterServiceImpl implements UserRegisterService {
	
	private UserRegisterDao userRegisterDao;

	public void setUserRegisterDao(UserRegisterDao userRegisterDao) {
		this.userRegisterDao = userRegisterDao;
	}

	@Override
	public void addSysUser(SysUsers sysuser) {
		userRegisterDao.addSysUser(sysuser);
	}
	
	@Override
	public void addCasualUser(SYS_CasualUser sys_CasualUser) {
		userRegisterDao.addCasualUser(sys_CasualUser);
		
	}

	@Override
	public void addCompany(Companys company) {
		userRegisterDao.addCompany(company);
	}

	@Override
	public void addLabUser(LabUsers labuser) {
		userRegisterDao.addLabUser(labuser);
	}

	@Override
	public int verifiEmail(String email) {
		return userRegisterDao.verifiEmail(email);
	}
	
	@Override
	public int verifiMobile(String mobile) {
		return userRegisterDao.verifiMobile(mobile);
	}

	@Override
	public void addUserAnnouncements(UserAnnouncements ua) {
		userRegisterDao.addUserAnnouncements(ua);
	}

	@Override
	public int email_reg(String email,String code) {
		return userRegisterDao.email_reg(email,code);
	}

	@Override
	public SYS_CasualUser getCasual(String email) {
		return userRegisterDao.getCasual(email);
	}

	@Override
	public String getCode(String email) {
		return userRegisterDao.getCode(email);
	}

	@Override
	public void delCasual(String email) {
		userRegisterDao.delCasual(email);
	}

	
}
