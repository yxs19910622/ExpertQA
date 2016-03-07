package org.izhong.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Questions;

public interface QuestionsService {
	
	public void addQuestion(Questions question);
	
	public void modQuestion(Questions question);
	
	public void delQuestion(String questionID);
	
	public void verifyQuestion(int auditStatus,String questionID);
	
	public void topQuestion(String questionID);
	
	public void swithQuestion(int isClosed,String questionId);
	
	public void replyCount(String questionID);
	
	public List<Questions> qryQuestionUnaudited();
	
	public List<Questions> qryQuestionByUserId(String userId);
	
	public List<Questions> qryUserFavorite(String userId);
	
	public List<Questions> qryQuestionPending();
	
	public Questions qryQuestionById(String questionId);
	
	public void modQuestionType(String qaType,String questionId);
	
	public void modReplyCount(String questionId);
	
	public String getEmailByquestionId(String questionId);
	
	/**
	 * 获取问题列表
	 * @param map
	 * @return
	 */
	public List<Map> getQuestionsList(Map<String,String> map);
	public long getQuestionsListCount(Map<String,String> map);
	/**
	 * 获取单个问题记录
	 * @param map
	 * @return
	 */
	public HashMap<String,String> getOneQuestion(String questionId);
	/**
	 * 根据问题类型和问题id获取被收藏的次数
	 * @param map
	 * @return
	 */
	public long getFavoritesCountByQuestionId(String questionId);
	/**
	 * 添加一条收藏记录
	 * @param map
	 * @return
	 */
	public long addFavorite(HashMap favorite);
		/**
	 * 根据用户名和问题编号查看改问题是否收藏
	 * @param map
	 * @return
	 */
	public long checkFavorite(HashMap map);
	/**
	 * 获取提问问题最多的前10个用户
	 * @param 
	 * @return
	 */
	public List<Map> getActiveUser();
	/**
	 * 根据问题的类型获取所有问题
	 * @param String typeId
	 * @return List<Map>
	 */
	public List<Map> getQuestionListByTypeId(HashMap map);
	/**
	 * 根据问题id修改该问题回复的次数
	 * @param questionId
	 */
	public void updateReplyCount(String questionId);
	/**
	 * 根据问题id修改该问题
	 * @param questionId
	 */
	public void upateQuestion(HashMap map);


}
