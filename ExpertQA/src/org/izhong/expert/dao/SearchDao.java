package org.izhong.expert.dao;

import java.util.List;

import org.izhong.expert.model.Questions;

public interface SearchDao {
	
	/**
	 * 查询待回复的提问
	 * @return
	 * @author whz
	 */
	public List<Questions> waitReplyQuestion();

}
