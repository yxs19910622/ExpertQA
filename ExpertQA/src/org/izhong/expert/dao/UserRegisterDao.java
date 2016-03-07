package org.izhong.expert.dao;

import org.izhong.expert.model.Companys;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserAnnouncements;

public interface UserRegisterDao {
	
	/**
	 * 新增系统用户
	 * @param sysuser
	 * @author whz
	 */
	public void addSysUser(SysUsers sysuser);
	
	/**
	 * 新增公司
	 * @param company
	 * @author whz
	 */
	public void addCompany(Companys company);
	
	/**
	 * 新增劳动法用户
	 * @param labuser
	 * @author whz
	 */
	public void addLabUser(LabUsers labuser);
	
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return
	 * @author whz
	 */
	public int verifiEmail(String email);
	
	/**
	 * 验证手机号码是否存在
	 * @param phone
	 * @return
	 * @author whz
	 */
	public int verifiMobile(String mobile);
	
	/**
	 * 
	 * @param ua
	 * @author whz
	 */
	public void addUserAnnouncements(UserAnnouncements ua);

	
	
	/**
	 * 新增未验证
	 * @param sys_CasualUser
	 * @author yxs
	 */
	public void addCasualUser(SYS_CasualUser sys_CasualUser);

	public int email_reg(String email, String code);

	public SYS_CasualUser getCasual(String email);
	

	public String getCode(String email);

	public void delCasual(String email);
	

}
