package org.izhong.expert.action;

import java.util.List;
import java.util.UUID;


import org.izhong.expert.abs.UserLoginAbs;
import org.izhong.expert.abs.UserRegisterAbs;
import org.izhong.expert.dao.UserRegisterDao;
import org.izhong.expert.model.Companys;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.service.UserInfoService;
import org.izhong.expert.service.UserRegisterService;
import org.izhong.expert.util.BaseUtil;
import org.izhong.web.util.SendMail;

public class UserRegisterAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserRegisterAbs userRegisterAbs;
	private List<QueryHotWords> lstqhw;
	private SysUsers sysuser;
	private LabUsers labuser;
	private Companys company;
	private SendMail mail;
	private String email;
	private SYS_CasualUser sys_CasualUser;

	
	/**
	 * 密码找回时发送邮件
	 * @author yxs
	 */
	public String password_email(){
		String email = getParameter("email");
		mail = new SendMail();
		
		SYS_CasualUser casual = userRegisterAbs.getCasual(email);
		if(casual==null){
			String code = UUID.randomUUID().toString();
			sys_CasualUser = new SYS_CasualUser();
			sys_CasualUser.setEmail(getParameter("email"));
			sys_CasualUser.setCode(code);
			sys_CasualUser.setUserName("123");
			sys_CasualUser.setPassword("123456");
			sys_CasualUser.setMobile("11111111111");
			sys_CasualUser.setAliasName("123");
			sys_CasualUser.setPassword("");
			sys_CasualUser.setPasswordSalt("");
			sys_CasualUser.setStatus("0");
			userRegisterAbs.AddCasualUser1(getResponse(), sys_CasualUser);
			try {
				mail.send_psw(email, code);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			String code2 = casual.getCode();
			try {
				mail.send_psw(email, code2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getRequest().setAttribute("email",email);
		return SUCCESS;
	}
	
	
	/**
	 * 点击链接后跳转到修改页面
	 * @author yxs
	 */
	public String password_page(){
		String email = getParameter("email");
		SysUsers sysUsers = userRegisterAbs.getSysUserByLogName(email);
		String code = getParameter("code");
		String code1 = userRegisterAbs.getCode(email);
		if(code1.equals(code)){
			getRequest().setAttribute("email",email);
			return INPUT;
		}
		return SUCCESS;
	}
	
	public String initRegister()
	{
		lstqhw = userRegisterAbs.findHotWordsAll();
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		
		sys_CasualUser = new SYS_CasualUser();
		sys_CasualUser.setEmail(getParameter("email"));
		sys_CasualUser.setUserName(getParameter("userName"));
		sys_CasualUser.setPassword(getParameter("password"));
		sys_CasualUser.setMobile(getParameter("mobile"));
		sys_CasualUser.setAliasName(getParameter("aliasName"));
		String code = UUID.randomUUID().toString();
		sys_CasualUser.setCode(code);
		String result = userRegisterAbs.AddCasualUser(getResponse(), sys_CasualUser);
		mail= new SendMail();
		mail.send_reg(getParameter("email"),code);
		String[] strTmp = result.split("&&");
		errmsg = strTmp[0];
		
		/*sysuser = new SysUsers();
		labuser = new LabUsers();
		sysuser.setEmail(getParameter("email"));
		getRequest().setAttribute("eamil",getParameter("email"));
		sysuser.setPassword(getParameter("password"));
		sysuser.setUserName(getParameter("userName"));
		sysuser.setMobile(getParameter("mobile"));
		labuser.setAliasName(getParameter("aliasName"));
		String customerId = getParameter("customerId");
		
		String result = userRegisterAbs.AddUser(getResponse(), sysuser, labuser,customerId);
		String[] strTmp = result.split("&&");
		errmsg = strTmp[0];
		boolean flag = Boolean.valueOf(strTmp[1]);
		if(flag)
		{
			errurl = "index";
		}else{
			errurl = "register";
		}*/
		return SUCCESS;
	}
	/**
	 * 点击链接后激活邮箱操作
	 * @author yxs
	 */
	public String email_reg()
	{
		String email = getParameter("email");
		SysUsers sysUsers = userRegisterAbs.getSysUserByLogName(email);
		if(sysUsers!=null){
			return "error_reg";
		}
		String code = getParameter("code");
		String code1 = userRegisterAbs.getCode(email);
		if(code1.equals(code)){
			SYS_CasualUser casual = userRegisterAbs.getCasual(email);
			String username = casual.getUserName();
			String mobile = casual.getMobile();
			if(casual.getUserName()==null){
				username=casual.getAliasName();
			}
			if(casual.getMobile()==null){
				mobile="";
			}
			sysuser = new SysUsers();
			labuser = new LabUsers();
			sysuser.setEmail(email);
			getRequest().setAttribute("eamil",email);
			sysuser.setPassword(casual.getPassword());
			sysuser.setPasswordSalt(casual.getPasswordSalt());
			sysuser.setUserName(username);
			//sysuser.setAliasName(casual.getAliasName());
			sysuser.setMobile(mobile);
			labuser.setAliasName(casual.getAliasName());
			String customerId = getParameter("customerId");
			
			String result = userRegisterAbs.AddUser(getResponse(), sysuser,labuser, customerId);
			userRegisterAbs.delCasual(email);
			String[] strTmp = result.split("&&");
			errmsg = strTmp[0];
			boolean flag = Boolean.valueOf(strTmp[1]);
			if(flag)
			{
				errurl = "index";
			}else{
				errurl = "register";
			}
			return SUCCESS;
		}else{
			return "error_code";
		}
	}
	
	public String email_ag() 
	{
		String email = getParameter("email");
		SYS_CasualUser casual = userRegisterAbs.getCasual(email);
		mail= new SendMail();
		try {
			mail.send_reg(getParameter("email"),casual.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getRequest().setAttribute("email", email);
		return SUCCESS;
	}
	
	public void userRegister()
	{
		String email = getParameter("email");
		userRegisterAbs.verifiEmail(getResponse(),email);
	}
	public void verifiEmail()
	{
		String email = getParameter("email");
		userRegisterAbs.verifiEmail(getResponse(),email);
	}
	
	public void verifiCustomerId()
	{
		String customerId = getParameter("customerId");
		userRegisterAbs.verifiCustomerId(getResponse(), customerId);
	}
	
	/**
	 * 验证手机号是否存在
	 * @author whz
	 */
	public void verifiMobile()
	{
		String mobile = getParameter("mobile");
		if(BaseUtil.isNotEmpty(mobile))
		{
			userRegisterAbs.verifiMobile(getResponse(), mobile);
		}
	}
	
	public String terms()
	{
		lstqhw = userRegisterAbs.findHotWordsAll();
		return SUCCESS;
	}

	public void setUserRegisterAbs(UserRegisterAbs userRegisterAbs) {
		this.userRegisterAbs = userRegisterAbs;
	}

	public SysUsers getSysuser() {
		return sysuser;
	}

	public void setSysuser(SysUsers sysuser) {
		this.sysuser = sysuser;
	}

	public LabUsers getLabuser() {
		return labuser;
	}

	public void setLabuser(LabUsers labuser) {
		this.labuser = labuser;
	}

	public Companys getCompany() {
		return company;
	}

	public void setCompany(Companys company) {
		this.company = company;
	}
	public List<QueryHotWords> getLstqhw() {
		return lstqhw;
	}
	public void setLstqhw(List<QueryHotWords> lstqhw) {
		this.lstqhw = lstqhw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
