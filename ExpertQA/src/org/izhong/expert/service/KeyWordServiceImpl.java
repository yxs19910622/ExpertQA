package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.dao.KeyWordDao;
import org.izhong.expert.model.QueryHotWords;

public class KeyWordServiceImpl implements KeyWordService {

	private KeyWordDao keyWordDao;
	
	public void setKeyWordDao(KeyWordDao keyWordDao) {
		this.keyWordDao = keyWordDao;
	}

	@Override
	public List<QueryHotWords> qryHotWordsAll() {
		return keyWordDao.qryHotWordsAll();
	}

	@Override
	public void addQueryHotWord(String keyword) {
		keyWordDao.addQueryHotWord(keyword);
	}

	@Override
	public void delQueryHotWord(String keyword) {
		keyWordDao.delQueryHotWord(keyword);
	}
}
