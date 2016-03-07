package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.UserInfoDao;
import org.izhong.expert.model.Companys;
import org.izhong.expert.model.DeviceRegisters;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserFavorites;
import org.izhong.expert.model.UserProducts;

public class UserInfoServiceImpl implements UserInfoService {
	
	private UserInfoDao userInfoDao;
	
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void modSysUsers(SysUsers sysuser) {
		userInfoDao.modSysUsers(sysuser);
	}

	@Override
	public void modLabUsers(LabUsers labuser) {
		userInfoDao.modLabUsers(labuser);
	}

	@Override
	public void modCompanys(Companys company) {
		userInfoDao.modCompanys(company);
	}

	@Override
	public void modPassWord(SysUsers sysuser) {
		userInfoDao.modPassWord(sysuser);
	}

	@Override
	public void addUserFavorite(UserFavorites userFaviorite) {
		userInfoDao.addUserFavorite(userFaviorite);
	}

	@Override
	public void delUserFavorite(int uid) {
		userInfoDao.delUserFavorite(uid);
	}

	@Override
	public void modDevice(SysUsers sysuser) {
		userInfoDao.modDevice(sysuser);
	}

	@Override
	public LabUsers qryLabUserInfo(String userId) {
		return userInfoDao.qryLabUserInfo(userId);
	}

	@Override
	public SysUsers qrySysUserInfo(String userId) {
		return userInfoDao.qrySysUserInfo(userId);
	}

	@Override
	public void modSysUserName(SysUsers sysuser) {
		userInfoDao.modSysUserName(sysuser);
	}

	@Override
	public List<LabUsers> qryLabUserList(int status) {
		return userInfoDao.qryLabUserList(status);
	}

	@Override
	public void modAuditUser(String userId) {
		userInfoDao.modAuditUser(userId);
	}

	@Override
	public List<LabUsers> qryLabUsersAll(){
		return userInfoDao.qryLabUsersAll();
	}

	@Override
	public DeviceRegisters getDeviceInfo(String device) {
		return userInfoDao.getDeviceInfo(device);
	}

	@Override
	public void modSysUserServiceDate(SysUsers sysuser) {
		userInfoDao.modSysUserServiceDate(sysuser);
	}

	@Override
	public void modSysUserTryDate(SysUsers sysuser) {
		userInfoDao.modSysUserTryDate(sysuser);
	}

	@Override
	public SysUsers qrySysUserByCustomerId(String customerId) {
		return userInfoDao.qrySysUserByCustomerId(customerId);
	}

	@Override
	public void modSysUserCustomerID(String userId, String customerId) {
		userInfoDao.modSysUserCustomerID(userId, customerId);
	}
	
	@Override
	public List<SysUsers> qrySysUsersAll(Map<String, String> paramMap) {
		return userInfoDao.qrySysUsersAll(paramMap);
	}

	@Override
	public void resetPassword(SysUsers sysuser) {
		userInfoDao.resetPassword(sysuser);
	}

	@Override
	public List<LabUsers> qryActiveUser() {
		return userInfoDao.qryActiveUser();
	}
	
	@Override
	public SysUsers getSysUserByLogName(String username) {
		return userInfoDao.getSysUserByLogName(username);
	}

	@Override
	public SysUsers getSysUserByDevice(String deviceSN) {
		return userInfoDao.getSysUserByDevice(deviceSN);
	}
	
	@Override
	public void addUserProduct(UserProducts userProduct) {
		userInfoDao.addUserProduct(userProduct);
	}

	@Override
	public List<UserProducts> getUserProductByUserId(String userId) {
		return userInfoDao.getUserProductByUserId(userId);
	}

	@Override
	public List<UserProducts> getUserProductsByUserName(String userName) {
		return userInfoDao.getUserProductsByUserName(userName);
	}
	
	@Override
	public void updateUserProduct(UserProducts userProduct) {
		userInfoDao.updateUserProduct(userProduct);
	}
	
	@Override
	public UserProducts getUserProductByCode(String activateCode) {
		return userInfoDao.getUserProductByCode(activateCode);
	}
	
	@Override
	public List<UserProducts> getUserProductsByProNo(String productNo,
			String activaUser) {
		return userInfoDao.getUserProductsByProNo(productNo, activaUser);
	}
	
	@Override
	public void delUserAnnouncement(String userId, String type) {
		userInfoDao.delUserAnnouncement(userId, type);
	}

	@Override
	public SYS_CasualUser getCasual(String email) {
		return userInfoDao.getCasual(email);
	}

}
