package org.izhong.expert.dao;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.UserProficients;

public interface QATypeDao {
	
	/**
	 * 查询所有可用的类型
	 * @return
	 * @author whz
	 */
	public List<QATypes> qryQATypeValid();
	
	/**
	 * 查询类型父节点
	 * @return
	 * @author whz
	 */
	public List<QATypes> qryQATypeByParent();
	
	/**
	 * 查询类型子节点
	 * @return
	 * @author whz
	 */
	public List<QATypes> qryQATypesByChild();
	
	/**
	 * 新增擅长领域
	 * @param userId
	 * @param typeId
	 * @author whz
	 */
	public void addUserProfiType(String userId,String typeId);
	
	/**
	 * 删除擅长领域
	 * @param userId
	 * @param typeId
	 * @author whz
	 */
	public void delUserProfiType(String userId,String typeId);
	
	public List<UserProficients> qryUserProfiByUserID(String userId);
	/**
	 * 查询类型父节点
	 * @return
	 * @author whz
	 */
	public List<Map> getQATypeByParent();
	
	/**
	 * 查询类型子节点
	 * @return
	 * @author whz
	 */
	public List<Map> getQATypesByChild();
}
