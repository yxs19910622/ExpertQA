package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Companys;
import org.izhong.expert.model.DeviceRegisters;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserFavorites;
import org.izhong.expert.model.UserProducts;

public interface UserInfoService {
	
	public void modSysUsers(SysUsers sysuser);
	public void modLabUsers(LabUsers labuser);
	public void modCompanys(Companys company);
	public void modPassWord(SysUsers sysuser);
	public void addUserFavorite(UserFavorites userFaviorite);
	public void delUserFavorite(int uid);
	public void modDevice(SysUsers sysuser);
	public LabUsers qryLabUserInfo(String userId);
	public SysUsers qrySysUserInfo(String userId);
	public void modSysUserName(SysUsers sysuser);
	public List<LabUsers> qryLabUserList(int status);
	public void modAuditUser(String userId);
	public List<LabUsers> qryLabUsersAll();
	public DeviceRegisters getDeviceInfo(String device);
	public void modSysUserServiceDate(SysUsers sysuser);
	public void modSysUserTryDate(SysUsers sysuser);
	public SysUsers qrySysUserByCustomerId(String customerId);
	public void modSysUserCustomerID(String userId,String customerId);
	public List<SysUsers> qrySysUsersAll(Map<String,String> paramMap);
	public void resetPassword(SysUsers sysuser);
	public List<LabUsers> qryActiveUser();
	public SysUsers getSysUserByLogName(String username);
	public SysUsers getSysUserByDevice(String deviceSN);
	public void addUserProduct(UserProducts userProduct);
	public List<UserProducts> getUserProductByUserId(String userId);
	public List<UserProducts> getUserProductsByUserName(String userName);
	public void updateUserProduct(UserProducts userProduct);
	public UserProducts getUserProductByCode(String activateCode);
	public List<UserProducts> getUserProductsByProNo(String productNo,String activaUser);
	public void delUserAnnouncement(String userId,String type);
	public SYS_CasualUser getCasual(String email);
}
