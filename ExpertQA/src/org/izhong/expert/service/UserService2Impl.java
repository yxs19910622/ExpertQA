package org.izhong.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.UserService2Dao;
import org.izhong.expert.model.RES_UserAnnouncement;
import org.izhong.expert.model.SYS_KeyData;
import org.izhong.expert.model.SYS_TryDocument;
import org.izhong.expert.model.SYS_TryUserDocument;
import org.izhong.expert.model.SYS_UserLoginRecord;

public class UserService2Impl implements UserService2 {
	private UserService2Dao userService2Dao;

	public void setUserService2Dao(UserService2Dao userService2Dao) {
		this.userService2Dao = userService2Dao;
	}

	@Override
	public List<RES_UserAnnouncement> qryRES_UserAnnouncements(String projectname, String userid) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("projectname", projectname);
		return this.userService2Dao.qryRES_UserAnnouncements(map);
	}
	
	@Override
	public void addSYS_KeyData(SYS_KeyData keydata) {
		this.userService2Dao.addSYS_KeyData(keydata);
	}

	@Override
	public void updateSYS_KeyData(SYS_KeyData keydata) {
		this.userService2Dao.updateSYS_KeyData(keydata);
	}

	@Override
	public List<SYS_KeyData> qrySYS_KeyDatas(String whereClause, String orderbyClause) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.userService2Dao.qrySYS_KeyDatas(map);
	}

	@Override
	public void addSYS_TryDocument(SYS_TryDocument tryDocument) {
		this.userService2Dao.addSYS_TryDocument(tryDocument);
	}

	@Override
	public void updateSYS_TryDocument(SYS_TryDocument tryDocument) {
		this.userService2Dao.updateSYS_TryDocument(tryDocument);
	}

	@Override
	public List<SYS_TryDocument> qrySYS_TryDocuments(String whereClause, String orderbyClause) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.userService2Dao.qrySYS_TryDocuments(map);
	}
	
	@Override
	public List<SYS_TryDocument> qrySYS_TryDocumentAll(String deviceserialnumber)
	{
		return this.userService2Dao.qrySYS_TryDocumentAll(deviceserialnumber);
	}
	
	@Override
	public void addSYS_TryUserDocument(SYS_TryUserDocument tryUserDocument) {
		this.userService2Dao.addSYS_TryUserDocument(tryUserDocument);
	}

	@Override
	public void updateSYS_TryUserDocument(SYS_TryUserDocument tryUserDocument) {
		this.userService2Dao.updateSYS_TryUserDocument(tryUserDocument);
	}

	@Override
	public List<SYS_TryUserDocument> qrySYS_TryUserDocumentAll() {
		return this.userService2Dao.qrySYS_TryUserDocumentAll();
	}

	@Override
	public List<SYS_TryUserDocument> qrySYS_TryUserDocuments(String whereClause, String orderbyClause) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("whereClause", whereClause);
		map.put("orderbyClause", orderbyClause);	
		return this.userService2Dao.qrySYS_TryUserDocuments(map);
	}
	@Override	
	public int countTryDocumentCount(String deviceSerialNumber, String projectName)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("deviceserialnumber", deviceSerialNumber);
		map.put("projectname", projectName);	
		return this.userService2Dao.countTryDocumentCount(map);
	}

	@Override
	public void addSYS_UserLoginRecord(SYS_UserLoginRecord userloginRecord) {
		this.userService2Dao.addSYS_UserLoginRecord(userloginRecord);
	}

	@Override
	public void updateSYS_UserLoginRecord(SYS_UserLoginRecord userloginRecord) {
		this.userService2Dao.updateSYS_UserLoginRecord(userloginRecord);
	}

	@Override
	public void deleteSYS_UserLoginRecord(String userid) {
		this.userService2Dao.deleteSYS_UserLoginRecord(userid);
	}

	@Override
	public List<SYS_UserLoginRecord> qrySYS_UserLoginRecords(String userid) {
		return this.userService2Dao.qrySYS_UserLoginRecords(userid);
	}
	
}
