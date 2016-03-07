package org.izhong.expert.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Replys;

public interface ReplysService {
	
	public void addReply(Replys reply);
	
	public void modReply(Replys reply);
	
	public void verifyReply(int auditStatus,String replyID);
	
	public void delReply(String replyID);
	
	public List<Replys> qryNewReplys(String userID,Date lastTime);
	
	public List<Replys> qryReplysByUserId(String userId);
	
	public List<Replys> qryReplysUnaudited();
	
	public List<Replys> qryReplysByQuestionId(String questionId);
	
	public List<Replys> qryReplysAll(String questionId);
	
	public void modReplyForContent(Replys reply);
	
	public void optimalAnswer(String replyId);
	/**
	 * 根据问题id查询所有对该问题的回复
	 * @param userID
	 * @return
	 * @author whz
	 */
	public List<Map> getAllReplysByQuestionId(HashMap map);
	/**
	 * 添加一条专家回复数据
	 * @param map
	 * @return
	 * @author fwy
	 */
	public int addReplyContent(Map map);
	/**
	 * 根据问题的id获取回复问题的人的名称
	 * @param map
	 * @return
	 */
	public List<Map<String,String>> getUserNameByQuestionId();
	/**
	 * 修改赞同次数
	 * @param tring replyId
	 * @return
	 */
    public int updatePollCount(String replyId);
    /**
     * 根据回复id获取改回复记录
     * @param replyId
     * @return
     */
    public HashMap getOneReply(String replyId);
    /**
     * 根据回复id修改回复内容
     * @param map
     */
    public void updateReply(HashMap map);
    /**
     * 根据userid和questionid获取回复内容
     * @param map
     * @return
     */
    public HashMap getReplyContentByUserIdAndQuestionId(HashMap map);
    public void modReplyCount(String questionId);
    
}
