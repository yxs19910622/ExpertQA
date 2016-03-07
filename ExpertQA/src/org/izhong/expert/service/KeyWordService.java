package org.izhong.expert.service;

import java.util.List;

import org.izhong.expert.model.QueryHotWords;

public interface KeyWordService {

	public List<QueryHotWords> qryHotWordsAll();

	public void addQueryHotWord(String keyword);

	public void delQueryHotWord(String keyword);

}
