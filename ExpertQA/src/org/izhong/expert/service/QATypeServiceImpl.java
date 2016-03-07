package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.QATypeDao;
import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.UserProficients;

public class QATypeServiceImpl implements QATypeService {

	private QATypeDao qatypeDao;

	public void setQatypeDao(QATypeDao qatypeDao) {
		this.qatypeDao = qatypeDao;
	}

	@Override
	public List<QATypes> qryQATypeValid() {
		return qatypeDao.qryQATypeValid();
	}

	@Override
	public List<QATypes> qryQATypeByParent() {
		return qatypeDao.qryQATypeByParent();
	}

	@Override
	public List<QATypes> qryQATypesByChild() {
		return qatypeDao.qryQATypesByChild();
	}
	
	@Override
	public List<Map> getQATypeByParent() {
		return qatypeDao.getQATypeByParent();
	}

	@Override
	public List<Map> getQATypesByChild() {
		return qatypeDao.getQATypesByChild();
	}

	@Override
	public void addUserProfiType(String userId, String typeId) {
		qatypeDao.addUserProfiType(userId, typeId);
	}

	@Override
	public void delUserProfiType(String userId, String typeId) {
		qatypeDao.delUserProfiType(userId, typeId);
	}

	@Override
	public List<UserProficients> qryUserProfiByUserID(String userId) {
		return qatypeDao.qryUserProfiByUserID(userId);
	}
}
