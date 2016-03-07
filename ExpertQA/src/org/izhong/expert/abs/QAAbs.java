package org.izhong.expert.abs;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.Questions;
import org.izhong.expert.service.KeyWordService;
import org.izhong.expert.service.QATypeService;
import org.izhong.expert.service.QuestionsService;
import org.izhong.expert.service.ReplysService;
import org.izhong.expert.util.Page;

public abstract class QAAbs {
	
	protected Logger log = Logger.getLogger(getClass());
	protected QuestionsService questionService;
	protected ReplysService replysService;
	protected QATypeService qatypeService;

	protected Page page;

	protected KeyWordService keyWordService;

	
	public void setQuestionService(QuestionsService questionService) {
		this.questionService = questionService;
	}

	public void setReplysService(ReplysService replysService) {
		this.replysService = replysService;
	}

	/**
	 * 获取问题列表
	 * @param map
	 * @return
	 */
	public abstract List<Map> getQuestionsList(Map<String,String> map);
	public abstract long getQuestionsListCount(Map<String,String> map);
	public abstract void addQuestion(Questions question);
	public abstract HashMap<String,String> getOneQuestion(String questionId);
	public abstract List<Map> getQaTypeParent();
	public abstract List<Map> getQaTypeChild();
	/**
	 * 添加一条收藏记录
	 * @param map
	 * @return
	 */
	public abstract long addFavorite(HashMap favorite);
	/**
	 * 根据问题id查询所有对该问题的回复
	 * @param userID
	 * @return
	 * @author fwy
	 */
	public abstract List<Map> getAllReplysByQuestionId(HashMap map);
	/**
	 * 添加一条专家回复数据
	 * @param map
	 * @return
	 * @author fwy
	 */
	public abstract boolean addReplyContent(Map map);
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public QuestionsService getQuestionService() {
		return questionService;
	}

	public ReplysService getReplysService() {
		return replysService;
	}
	


	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}
	
	public abstract List<QueryHotWords> findHotWordsAll();
	
	public abstract int updatePollCount(String replyId);
	
	/**
	 * 获取提问问题最多的前10个用户
	 * 
	 * @param 
	 * @return
	 */
	public abstract List<Map> getActiveUser();
	/**
	 * 根据问题的类型获取所有问题
	 * @param String typeId
	 * @return List<Map>
	 */
	public abstract List<Map> getQuestionListByTypeId(String typeId);
	public abstract List<Map> getQuestionListByTypeIdCopy(String typeId);

	public QATypeService getQatypeService() {
		return qatypeService;
	}

	public void setQatypeService(QATypeService qatypeService) {
		this.qatypeService = qatypeService;
	}
	/**
	 * 根据问题id修改该问题
	 * @param questionId
	 */
	public abstract boolean upateQuestion(HashMap map);
	/**
     * 根据回复id获取改回复记录
     * @param replyId
     * @return
     */
    public abstract HashMap getOneReply(String replyId);
    /**
     * 根据回复id修改回复内容
     * @param map
     */
    public abstract boolean updateReply(HashMap map);
    /**
     * 根据userid和questionid获取回复内容
     * @param map
     * @return
     */
    public abstract HashMap getReplyContentByUserIdAndQuestionId(HashMap map);
}
