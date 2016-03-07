package org.izhong.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Code;
import org.izhong.expert.model.OperationGroup;
import org.izhong.expert.model.Operations;
import org.izhong.expert.model.RoleOperations;
import org.izhong.expert.model.Roles;
import org.izhong.expert.model.UserRoles;

public interface RoleService {

	public void addOperation(Operations operation);

	public List<Operations> qryOperationAll();

	public List<Operations> qryOperationValid();
	
	public List<Operations> qryOperationByRoleID(long roleId);

	public List<OperationGroup> qryOperationGroupAll();
	
	public List<OperationGroup> qryOperationGroupByRoleID(long roleId);
	
	public List<Roles> qryRoleAll();
	
	public List<Roles> qryRoleAllValid();
	
	public String qryUserRoleID(String userId);

	public void addRole(Roles role);

	public void addRoleOperation(RoleOperations roleOperation);

	public void addUserRole(UserRoles userRole);
	
	public void modUserRole(UserRoles userRole);
	
	public Roles qryRoleDefault();
		/**
	 * 根据用户id获取该用户的角色信息
	 * @param userId
	 * @return
	 */
	public HashMap getUserRoleByUserId(String userId);
	/**
	 * 根据角色id获取该按钮的操作信息
	 * @param roleId
	 * @return
	 */
	public List<Map> getOperationByRoleId(String roleId);
	/**
	 * 根据用户id获取该用户的角色操作信息
	 * @param userId
	 * @return
	 */
	public List<Map> getUserRoleOperationByUserId(String userId);

}
