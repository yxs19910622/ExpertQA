package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.model.RES_UserAnnouncement;
import org.izhong.expert.model.SYS_KeyData;
import org.izhong.expert.model.SYS_TryDocument;
import org.izhong.expert.model.SYS_TryUserDocument;
import org.izhong.expert.model.SYS_UserLoginRecord;

public interface UserService2 {
	/*
	 * 
	 */
	public List<RES_UserAnnouncement> qryRES_UserAnnouncements(String projectname, String userid);
	
	/*
	 * 添加、修改、查询SYS_KeyData表
	 */
	public void addSYS_KeyData(SYS_KeyData keydata);
	public void updateSYS_KeyData(SYS_KeyData keydata);
	public List<SYS_KeyData> qrySYS_KeyDatas(String whereClause, String orderbyClause);	
	
	/*
	 * 添加、修改、查询SYS_TRYDOCUMENTS表
	 */
	public void addSYS_TryDocument(SYS_TryDocument tryDocument);
	public void updateSYS_TryDocument(SYS_TryDocument tryDocument);
	public List<SYS_TryDocument> qrySYS_TryDocuments(String whereClause, String orderbyClause);
	public List<SYS_TryDocument> qrySYS_TryDocumentAll(String deviceserialnumber);	
	/*
	 * 添加、修改、查询用户SYS_TRYUSERDOCUMENTS表
	 */
	public void addSYS_TryUserDocument(SYS_TryUserDocument tryUserDocument);
	public void updateSYS_TryUserDocument(SYS_TryUserDocument tryUserDocument);
	public List<SYS_TryUserDocument> qrySYS_TryUserDocumentAll();
	public List<SYS_TryUserDocument> qrySYS_TryUserDocuments(String whereClause, String orderbyClause);
	
	public int countTryDocumentCount(String deviceSerialNumber, String projectName);
	
	/*
	 * 
	 */
	public void addSYS_UserLoginRecord(SYS_UserLoginRecord userloginRecord);
	public void updateSYS_UserLoginRecord(SYS_UserLoginRecord userloginRecord);
	public void deleteSYS_UserLoginRecord(String userid);
	public List<SYS_UserLoginRecord> qrySYS_UserLoginRecords(String userid);
}
