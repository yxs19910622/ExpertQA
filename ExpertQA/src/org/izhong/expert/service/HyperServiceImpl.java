package org.izhong.expert.service;

import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.HyperDao;
import org.izhong.expert.model.HypertextLinkExtends;

public class HyperServiceImpl implements HyperService {

	private HyperDao hyperDao;
	@Override
	public boolean addHyperRecord(Map map) {
		// TODO Auto-generated method stub
		int num = this.hyperDao.addHyperRecord(map);
		return num > 0?true:false;
	}

	@Override
	public boolean deleteHyperRecord(long id) {
		// TODO Auto-generated method stub 
		int num = this.hyperDao.deleteHyperRecord(id);
		return num > 0?true:false;
	}

	@Override
	public List<Map<String, Object>> getAllHyperRecord() {
		// TODO Auto-generated method stub
		return this.hyperDao.getAllHyperRecord();
	}

	@Override
	public boolean updateHyperRecord(Map map) {
		// TODO Auto-generated method stub
		int num = this.hyperDao.updateHyperRecord(map);
		return num > 0?true:false;
	}

	public HyperDao getHyperDao() {
		return hyperDao;
	}

	public void setHyperDao(HyperDao hyperDao) {
		this.hyperDao = hyperDao;
	}

	@Override
	public List<HypertextLinkExtends> getAllHyper() {
		return hyperDao.getAllHyper();
	}

	@Override
	public void addHyper(HypertextLinkExtends hyper) {
		hyperDao.addHyper(hyper);
	}

	@Override
	public void modHyper(HypertextLinkExtends hyper) {
		hyperDao.modHyper(hyper);
	}

	@Override
	public void delHyper(int tid) {
		hyperDao.delHyper(tid);
	}
}
