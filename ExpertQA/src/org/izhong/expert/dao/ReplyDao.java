package org.izhong.expert.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.model.Replys;

public interface ReplyDao {
	
	/**
	 * 新增回复
	 * @param reply
	 * @author whz
	 */
	public void addReply(Replys reply);
	/**
	 * 修改回复
	 * @param reply
	 * @author whz
	 */
	public void modReply(Replys reply);
	/**
	 * 审核回复
	 * @param reply
	 * @author whz
	 */
	public void verifyReply(int auditStatus,String replyID);
	/**
	 * 删除回复
	 * @param replyID
	 * @author whz
	 */
	public void delReply(String replyID);
	
	/**
	 * 查询是否有新回复
	 * @param userID
	 * @return
	 * @author whz
	 */
	public List<Replys> qryNewReplys(String userID,Date lastTime);
	
	/**
	 * 查询该用户回答列表
	 * @param userId
	 * @return
	 * @author whz
	 */
	public List<Replys> qryReplysByUserId(String userId);
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
	public abstract int addReplyContent(Map map);
	/**
	 * 根据问题的id获取回复问题的人的名称
	 * @param 
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
     * 查询所有未审核的回答
     * @return
     * @author whz
     */
    public List<Replys> qryReplysUnaudited();
    /**
     * 查询该问题所有已审核的回答
     * @param questionId
     * @return
     * @author whz
     */
    public List<Replys> qryReplysByQuestionId(String questionId);
    
    /**
     * 查询该问题的所有答案
     * @param questionId
     * @return
     * @author whz
     */
    public List<Replys> qryReplysAll(String questionId);
    /**
     * 设置为最佳答案
     * @param replyId
     * @author whz
     */
    public void optimalAnswer(String replyId);
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
    /**
     * 修改回答内容
     * @param replyId
     * @param replyContent
     * @author whz
     */
    public void modReplyForContent(Replys reply);
    /**
     * 回答计数
     * @author yxs
     */
    public void modReplyCount(String questionId);
}
