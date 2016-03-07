package org.izhong.expert.dao;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Messages;


public interface MessageDao {
	
	public abstract List<Map<String,Object>> getAllMessageRecord();
	
	/**
	 * 新增公告
	 * @param message
	 * @author whz
	 */
	public void addMessage(Messages message);
	/**
	 * 删除公告
	 * @param tid
	 * @author whz
	 */
	public void delMessage(int tid);
	/**
	 * 公告是否在首页显示
	 * 1显示，0不显示
	 * @param tid
	 * @author whz
	 */
	public void modMessageStatus(int tid,int status);
	/**
	 * 查询所有公告
	 * @return
	 * @author whz
	 */
	public List<Messages> getAllMessage();

}
