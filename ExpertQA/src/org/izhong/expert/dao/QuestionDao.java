package org.izhong.expert.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Questions;

public interface QuestionDao {
	
	/**
	 * 新增提问
	 * @param question
	 * @author whz
	 */
	public void addQuestion(Questions question);
	/**
	 * 修改提问
	 * @param question
	 * @author whz
	 */
	public void modQuestion(Questions question);
	/**
	 * 删除提问
	 * @param questionID
	 * @author whz
	 */
	public void delQuestion(String questionID);
	/**
	 * 审核提问
	 * @param questionID
	 * @author whz
	 */
	public void verifyQuestion(int auditStatus,String questionID);
	/**
	 * 置顶提问
	 * @param questionID
	 * @author whz
	 */
	public void topQuestion(String questionID);
	/**
	 * 提问的开启和关闭
	 * @param isClosed
	 * @param questionId
	 * @author whz
	 */
	public void swithQuestion(int isClosed,String questionId);
	/**
	 * 修改回复次数
	 * @param questionID
	 * @author whz
	 */
	public void replyCount(String questionID);
	/**
	 * 查询所有未审核的提问
	 * @return
	 * @author whz
	 */
	public List<Questions> qryQuestionUnaudited();
	/**
	 * 查询该用户所有提问
	 * @param userId
	 * @return
	 * @author whz
	 */
	public List<Questions> qryQuestionByUserId(String userId);
	/**
	 * 查询该用户所有收藏提问
	 * @param userId
	 * @return
	 * @author whz
	 */
	public List<Questions> qryUserFavorite(String userId);
	/**
	 * 取所有没有最佳答案的问题
	 * @return
	 * @author whz
	 */
	public List<Questions> qryQuestionPending();
	/**
	 * @param map
	 * @return
	 */
	public List<Map> getQuestionsList(Map<String,String> map);
	/**
	 * 获取问题数量
	 * @param map
	 * @return
	 */
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
	public int addFavorite(HashMap favorite);
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
	public List<Map> getQuestionListByTypeId(HashMap typeId);
	/**
	 * 根据编号查询问题相关信息
	 * @param questionId
	 * @return
	 * @author whz
	 */
	public Questions qryQuestionById(String questionId);
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
	/**
	 * 修改问题类型
	 * @param qaType
	 * @param questionId
	 * @author whz
	 */
	public void modQuestionType(String qaType,String questionId);
	/**
	 * 修改问题的回答数量
	 * @param questionId
	 * @author whz
	 */
	public void modReplyCount(String questionId);
	
	/**
	 * 通过用户id取email
	 * @param userId
	 * @author yxs
	 */
	public String getEmailByquestionId(String questionId);
	
}
