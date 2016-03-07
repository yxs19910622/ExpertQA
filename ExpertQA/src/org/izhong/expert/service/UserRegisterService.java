package org.izhong.expert.service;

import org.izhong.expert.model.Companys;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserAnnouncements;

public interface UserRegisterService {
	
	public void addSysUser(SysUsers sysuser);
	
	public void addCasualUser(SYS_CasualUser sys_CasualUser);
	
	public void addCompany(Companys company);
	
	public void addLabUser(LabUsers labuser);
	
	public int verifiEmail(String email);
	
	public int verifiMobile(String mobile);
	
	public void addUserAnnouncements(UserAnnouncements ua);
	
	public int email_reg(String email,String code);
	
	public String getCode(String email);

	public SYS_CasualUser getCasual(String email);

	public void delCasual(String email);
}
