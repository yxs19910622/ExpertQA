package org.izhong.expert.dao;

import java.util.List;

import org.izhong.expert.model.QueryHotWords;

public interface KeyWordDao {
	
	/**
	 * 查询所有热门关键字
	 * @return
	 * @author whz
	 */
	public List<QueryHotWords> qryHotWordsAll();
	
	/**
	 * 新增热门关键字
	 * @param keyword
	 * @author whz
	 */
	public void addQueryHotWord(String keyword);
	
	/**
	 * 删除热门关键字
	 * @param keyword
	 * @author whz
	 */
	public void delQueryHotWord(String wordId);

}
