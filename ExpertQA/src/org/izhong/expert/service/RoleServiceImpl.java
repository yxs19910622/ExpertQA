package org.izhong.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.RoleDao;
import org.izhong.expert.model.Code;
import org.izhong.expert.model.OperationGroup;
import org.izhong.expert.model.Operations;
import org.izhong.expert.model.RoleOperations;
import org.izhong.expert.model.Roles;
import org.izhong.expert.model.UserRoles;

public class RoleServiceImpl implements RoleService {
	
	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void addOperation(Operations operation) {
		roleDao.addOperation(operation);
	}

	@Override
	public List<Operations> qryOperationAll() {
		return roleDao.qryOperationAll();
	}

	@Override
	public List<Roles> qryRoleAll() {
		return roleDao.qryRoleAll();
	}

	@Override
	public void addRole(Roles role) {
		roleDao.addRole(role);
	}

	@Override
	public List<Operations> qryOperationValid() {
		return roleDao.qryOperationValid();
	}

	@Override
	public void addRoleOperation(RoleOperations roleOperation) {
		roleDao.addRoleOperation(roleOperation);
	}

	@Override
	public List<Operations> qryOperationByRoleID(long roleId) {
		return roleDao.qryOperationByRoleID(roleId);
	}

	@Override
	public String qryUserRoleID(String userId) {
		return roleDao.qryUserRoleID(userId);
	}

	@Override
	public List<OperationGroup> qryOperationGroupAll() {
		return roleDao.qryOperationGroupAll();
	}

	@Override
	public List<OperationGroup> qryOperationGroupByRoleID(long roleId) {
		return roleDao.qryOperationGroupByRoleID(roleId);
	}

	@Override
	public List<Roles> qryRoleAllValid() {
		return roleDao.qryRoleAllValid();
	}

	@Override
	public void addUserRole(UserRoles userRole) {
		roleDao.addUserRole(userRole);
	}

	@Override
	public Roles qryRoleDefault() {
		return roleDao.qryRoleDefault();
	}
		/**
	 * 根据用户id获取该用户的角色信息
	 * @param userId
	 * @return
	 */
	public HashMap getUserRoleByUserId(String userId){
		return this.roleDao.getUserRoleByUserId(userId);
	}
	/**
	 * 根据角色id获取该按钮的操作信息
	 * @param roleId
	 * @return
	 */
	public List<Map> getOperationByRoleId(String roleId){
		return this.roleDao.getOperationByRoleId(roleId);
	}
	/**
	 * 根据用户id获取该用户的角色操作信息
	 * @param userId
	 * @return
	 */
	public List<Map> getUserRoleOperationByUserId(String userId){
		return this.roleDao.getUserRoleOperationByUserId(userId);
	}

	@Override
	public void modUserRole(UserRoles userRole) {
		roleDao.modUserRole(userRole);
	}

}
