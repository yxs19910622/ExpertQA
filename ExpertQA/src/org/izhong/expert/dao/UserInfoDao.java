package org.izhong.expert.dao;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Companys;
import org.izhong.expert.model.DeviceRegisters;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.SYS_CasualUser;
import org.izhong.expert.model.SysUsers;
import org.izhong.expert.model.UserFavorites;
import org.izhong.expert.model.UserProducts;

public interface UserInfoDao {
	
	/**
	 * 修改系统用户
	 * @param sysuser
	 * @author whz
	 */
	public void modSysUsers(SysUsers sysuser);
	/**
	 * 修改劳动法用户
	 * @param labuser
	 * @author whz
	 */
	public void modLabUsers(LabUsers labuser);
	/**
	 * 修改公司信息
	 * @param company
	 * @author whz
	 */
	public void modCompanys(Companys company);
	/**
	 * 修改密码
	 * @param sysuser
	 * @author whz
	 */
	public void modPassWord(SysUsers sysuser);
	/**
	 * 新增用户收藏
	 * @param userFaviorite
	 * @author whz
	 */
	public void addUserFavorite(UserFavorites userFaviorite);
	/**
	 * 删除用户收藏
	 * @param tid
	 * @author whz
	 */
	public void delUserFavorite(int tid);
	
	/**
	 * 修改设备信息
	 * @param sysuser
	 * @author whz
	 */
	public void modDevice(SysUsers sysuser);
	
	/**
	 * 根据用户ID查询该用户所有信息
	 * (包含所属公司信息)
	 * @param userID
	 * @return
	 * @author whz
	 */
	public LabUsers qryLabUserInfo(String userId);
	
	/**
	 * 根据用户ID查询系统用户信息
	 * @param userId
	 * @return
	 * @author whz
	 */
	public SysUsers qrySysUserInfo(String userId);
	
	/**
	 * 修改系统用户真实姓名
	 * @param username
	 * @param userId
	 * @author whz
	 */
	public void modSysUserName(SysUsers sysuser);
	
	/**
	 * 查询所有用户列表
	 * @param status
	 * @return
	 * @author whz
	 */
	public List<LabUsers> qryLabUserList(int status);
	
	/**
	 * 审核用户
	 * @param userId
	 * @author whz
	 */
	public void modAuditUser(String userId);
	
	/**
	 * 查询所有用户信息
	 * @return
	 * @author whz
	 */
	public List<LabUsers> qryLabUsersAll();
	
	/**
	 * 查询设备编号
	 * @param device
	 * @return
	 * @author whz
	 */
	public DeviceRegisters getDeviceInfo(String device);
	/**
	 * 修改用户服务日期
	 * @param sysuser
	 * @author whz
	 */
	public void modSysUserServiceDate(SysUsers sysuser);
	/**
	 * 修改用户试用日期
	 * @param sysuser
	 * @author whz
	 */
	public void modSysUserTryDate(SysUsers sysuser);
	/**
	 * 根据客户号查询用户信息
	 * @param customerId
	 * @return
	 * @author whz
	 */
	public SysUsers qrySysUserByCustomerId(String customerId);
	/**
	 * 修改用户的客户ID
	 * @param userId
	 * @param customerId
	 * @author whz
	 */
	public void modSysUserCustomerID(String userId,String customerId);
	/**
	 * 查询所有用户信息(包含用户昵称，用户所属角色名称)
	 * 用于帐号管理列表展示
	 * @param paramMap
	 * @return
	 * @author whz
	 */
	public List<SysUsers> qrySysUsersAll(Map<String,String> paramMap);
	/**
	 * 重置密码
	 * @param sysuser
	 * @author whz
	 */
	public void resetPassword(SysUsers sysuser);
	
	/**
	 * 获取活跃用户排名数据
	 * 替换questionDao中的getActiveUser方法 
	 * 2012.11.08
	 * @return
	 * @author whz
	 */
	public List<LabUsers> qryActiveUser();
	
	/**
	 * 按登录名称查询系统用户信息
	 * @param username
	 * @return
	 * @author whz
	 */
	public SysUsers getSysUserByLogName(String username);
	
	/**
	 * 按设备序列号查询系统用户信息
	 * @param deviceSN
	 * @return
	 * @author whz
	 */
	public SysUsers getSysUserByDevice(String deviceSN);
	
	/**
	 * 新增用户激活信息
	 * @param userProduct
	 * @author whz
	 */
	public void addUserProduct(UserProducts userProduct);
	
	/**
	 * 按照用户ID查询激活码信息
	 * @param userId
	 * @author whz
	 */
	public List<UserProducts> getUserProductByUserId(String userId);
	/**
	 * 按照激活者用户名称查询激活码信息
	 * @param userName
	 */
	public List<UserProducts> getUserProductsByUserName(String userName);
	/**
	 * 更新激活码信息
	 * @param userProduct
	 * @author whz
	 */
	public void updateUserProduct(UserProducts userProduct);
	
	/**
	 * 根据激活码查询相关信息
	 * @param activateCode
	 * @author whz
	 */
	public UserProducts getUserProductByCode(String activateCode);
	
	/**
	 * 查询要激活用户的信息
	 * @param productNo
	 * @param activaUser
	 * @return
	 * @author whz
	 */
	public List<UserProducts> getUserProductsByProNo(String productNo,String activaUser);
	
	/**
	 * 删除用户公告
	 * @param userId
	 * @param type
	 * @author whz
	 */
	public void delUserAnnouncement(String userId,String type);
	public SYS_CasualUser getCasual(String email);
	
}
