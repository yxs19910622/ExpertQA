package org.izhong.expert.abs;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.izhong.expert.model.Companys;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.service.UserRegisterService;
import org.izhong.expert.util.BaseUtil;
import org.izhong.expert.util.CookieUtil;

public class UserLoginAbsImpl extends UserLoginAbs {

	@Override
	public void updateSysUserName(SysUsers sysuser) {
		userInfoService.modSysUserName(sysuser);
	}

	@Override
	public void updateLabUser(LabUsers labuser) {
		userInfoService.modLabUsers(labuser);
	}

	@Override
	public void updateCompany(Companys company) {
		userInfoService.modCompanys(company);
	}
	
	
	@Override
	public boolean check(String email, String password) {
		SysUsers sysuser = userInfoService.getSysUserByLogName(email);
		if(null!=sysuser)
		{
			if(BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
			{
				return true;
			}
		}
	
		return false;
	}
	
	@Override
	public boolean reg_check(String email, String password) {
		SYS_CasualUser user = null;
		user = userInfoService.getCasual(email);
		if(null!=user)
		{
			if(BaseUtil.Md5(password+user.getPasswordSalt()).equals(user.getPassword()))
			{
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean toLogin(HttpServletResponse response, String email,String password) {
		SysUsers sysuser = userInfoService.getSysUserByLogName(email);
		if(null!=sysuser)
		{
			if(BaseUtil.Md5(password+sysuser.getPasswordSalt()).equals(sysuser.getPassword()))
			{
				CookieUtil.addCookie(response, "EUserID", sysuser.getUserID());
				if(BaseUtil.isNotEmpty(sysuser.getUserName()))
				{
					try {
						CookieUtil.addCookie(response, "EUserName", URLEncoder.encode(sysuser.getUserName(),"UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				//此处添加用户权限信息到session中
				HashMap userMap = getUserRoleByUserId(sysuser.getUserID());
				if(userMap != null){
					CookieUtil.addCookie(response, "operate", userMap.get("operate")+"");
				}
				CookieUtil.addCookie(response, "Eemail", sysuser.getEmail());
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public List<QueryHotWords> findHotWordsAll() {
		return keyWordService.qryHotWordsAll();
	}
	/**
	 * 根据用户id获取该用户的角色信息
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public HashMap getUserRoleByUserId(String userId){
		//注掉代码是用户角色和操作分别获取的
//		HashMap userMap = this.roleService.getUserRoleByUserId(userId);
//		if(userMap == null){
//			return null;
//		}else{
//			if(userMap.get("ROLEID") != null){
//				List list = this.getOperationByRoleId(userMap.get("ROLEID")+"");
//				StringBuffer sb = new StringBuffer();
//				for(int i = 0;i < list.size(); i++){
//					Map map = (HashMap)list.get(i);
//					sb.append(map.get("URL")+"#");
//				}
//				userMap.put("operate", sb.toString());
//			}
//		}
		HashMap userMap = new HashMap();
		List list = this.getUserRoleOperationByUserId(userId);
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < list.size(); i++){
			Map map = (HashMap)list.get(i);
			sb.append(map.get("URL")+"#");
		}
		userMap.put("operate", sb.toString());
		return userMap;
	}
	/**
	 * 根据角色id获取该按钮的操作信息
	 * @param roleId
	 * @return
	 */
	public List<Map> getOperationByRoleId(String roleId){
		return this.roleService.getOperationByRoleId(roleId);
	}
	/**
	 * 根据用户id获取该用户的角色操作信息
	 * @param userId
	 * @return
	 */
	public List<Map> getUserRoleOperationByUserId(String userId){
		return this.roleService.getUserRoleOperationByUserId(userId);
	}

	@Override
	public SysUsers findSysUserInfo(String userId) {
		return userInfoService.qrySysUserInfo(userId);
	}
	


}
