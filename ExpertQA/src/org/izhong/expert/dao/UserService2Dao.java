package org.izhong.expert.dao;

import java.util.List;
import java.util.Map;

import org.izhong.expert.model.RES_UserAnnouncement;
import org.izhong.expert.model.SYS_KeyData;
import org.izhong.expert.model.SYS_TryDocument;
import org.izhong.expert.model.SYS_TryUserDocument;
import org.izhong.expert.model.SYS_UserLoginRecord;

public interface UserService2Dao {
	/*
	 * 查询用户相关公告信息
	 */
	public List<RES_UserAnnouncement> qryRES_UserAnnouncements(Map<String, String> map);
	
	/*
	 * 添加、修改、查询SYS_KeyData表
	 */
	public void addSYS_KeyData(SYS_KeyData keydata);
	public void updateSYS_KeyData(SYS_KeyData keydata);
	public List<SYS_KeyData> qrySYS_KeyDatas(Map<String, String> map);	
	
	/*
	 * 添加、修改、查询SYS_TRYDOCUMENTS表
	 */
	public void addSYS_TryDocument(SYS_TryDocument tryDocument);
	public void updateSYS_TryDocument(SYS_TryDocument tryDocument);
	public List<SYS_TryDocument> qrySYS_TryDocuments(Map<String, String> map);
	public List<SYS_TryDocument> qrySYS_TryDocumentAll(String deviceserialnumber);
	/*
	 * 添加、修改、查询用户SYS_TRYUSERDOCUMENTS表
	 */
	public void addSYS_TryUserDocument(SYS_TryUserDocument tryUserDocument);
	public void updateSYS_TryUserDocument(SYS_TryUserDocument tryUserDocument);
	public List<SYS_TryUserDocument> qrySYS_TryUserDocumentAll();
	public List<SYS_TryUserDocument> qrySYS_TryUserDocuments(Map<String, String> map);
	
	public int countTryDocumentCount(Map<String, String> map);
	
	/*
	 * 添加、查询用户登录状态
	 */
	public void addSYS_UserLoginRecord(SYS_UserLoginRecord userloginRecord);
	public void updateSYS_UserLoginRecord(SYS_UserLoginRecord userloginRecord);
	public void deleteSYS_UserLoginRecord(String userid);
	public List<SYS_UserLoginRecord> qrySYS_UserLoginRecords(String userid);
}
