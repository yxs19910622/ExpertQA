package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.dao.SearchDao;
import org.izhong.expert.model.Questions;

public class SearchServiceImpl implements SearchService {
	
	private SearchDao searchDao;

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@Override
	public List<Questions> waitReplyQuestion() {
		return searchDao.waitReplyQuestion();
	}
}
