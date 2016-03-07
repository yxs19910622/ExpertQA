package org.izhong.expert.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.OperationGroup;
import org.izhong.expert.model.Operations;
import org.izhong.expert.model.RoleOperations;
import org.izhong.expert.model.Roles;
import org.izhong.expert.model.UserRoles;

public interface RoleDao {
	
	/**
	 * 新增功能
	 * @param operation
	 * @author whz
	 */
	public void addOperation(Operations operation);
	
	/**
	 * 查询所有功能(包含已失效的)
	 * @return
	 * @author whz
	 */
	public List<Operations> qryOperationAll();
	
	/**
	 * 查询所有可用功能
	 * @return
	 * @author whz
	 */
	public List<Operations> qryOperationValid();
	
	/**
	 * 查询所有功能组
	 * @return
	 * @author whz
	 */
	public List<OperationGroup> qryOperationGroupAll();
	
	/**
	 * 根据角色ID查询该角色拥有的功能组
	 * @param roleId
	 * @return
	 * @author whz
	 */
	public List<OperationGroup> qryOperationGroupByRoleID(long roleId);
	
	/**
	 * 根据角色ID查询该角色拥有的功能
	 * @param roleID
	 * @return
	 * @author whz
	 */
	public List<Operations> qryOperationByRoleID(long roleId);
	
	/**
	 * 查询所有角色(包含已失效的)
	 * @return
	 * @author whz
	 */
	public List<Roles> qryRoleAll();
	
	/**
	 * 查询所有可用的角色
	 * @return
	 * @author whz
	 */
	public List<Roles> qryRoleAllValid();
	
	/**
	 * 新增角色
	 * @param role
	 * @author whz
	 */
	public void addRole(Roles role);
	
	/**
	 * 新增角色与功能关联
	 * @param roleOperation
	 * @author whz
	 */
	public void addRoleOperation(RoleOperations roleOperation);
	
	/**
	 * 根据用户ID查询角色ID
	 * @param userId
	 * @return
	 * @author whz
	 */
	public String qryUserRoleID(String userId);
	
	/**
	 * 用户与角色关联
	 * @param userId
	 * @param roleId
	 * @author whz
	 */
	public void addUserRole(UserRoles userRole);
	/**
	 * 修改用户角色
	 * @param userRole
	 * @author whz
	 */
	public void modUserRole(UserRoles userRole);
	/**
	 * 取默认权限
	 * @return
	 * @author whz
	 */
	public Roles qryRoleDefault();
	/**
	 * 根据用户id获取该用户的角色信息
	 * @param userId
	 * @return
	 */
	public HashMap getUserRoleByUserId(String userId);
	/**
	 * 根据用户id获取该用户的角色操作信息
	 * @param userId
	 * @return
	 */
	public List<Map> getUserRoleOperationByUserId(String userId);
	/**
	 * 根据角色id获取该按钮的操作信息
	 * @param roleId
	 * @return
	 */
	public List<Map> getOperationByRoleId(String roleId);
	
}
