package org.izhong.expert.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class Test {
	
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
		
		//����
		//UserLoginService userService = (UserLoginService)context.getBean("userService");
		//System.out.println(userService.getAccountByUsername("1")); 
		
	//UserLoginService userLoginService = (UserLoginService) context.getBean("userLoginService");
//		SysUsers user = userLoginService.verifiUserLogin("zhangsan");
//		System.out.println("����:"+user.getUserName());
		//�����û�ע��
//		UserRegisterService userRegisterService = (UserRegisterService) context.getBean("userRegisterService");
//		SysUsers sysuser = new SysUsers();
//		sysuser.setUserID(BaseUtil.generateIdentifier());
//		sysuser.setUserName("����");
//		sysuser.setLoginName("zhangsan");
//		sysuser.setPasswordSalt(BaseUtil.getPasswordSalt());
//		sysuser.setPassword(BaseUtil.Md5("123456"+sysuser.getPasswordSalt()));
//		sysuser.setEmail("zhangsan@izhong.com");
//		sysuser.setMobile("1311414141");
//		sysuser.setTryStartDate(DateUtil.getCurrTime());
//		sysuser.setTryEndDate(DateUtil.getTryEndTime());
//		
//		userRegisterService.addSysUser(sysuser);
//		System.out.println("ע�����..");\
		try {
			String url = new String(Base64.decode("DcZNZ70kUR94a63y96dwW5pPXClIOT83WrKWYuodlSeFAAAAAA="));
			System.out.println(url);
		} catch (Base64DecodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
