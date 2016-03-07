package org.izhong.expert.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.abs.MemberAbs;
import org.izhong.expert.dao.ReplyDao;
import org.izhong.expert.model.Replys;
import org.izhong.web.util.SendMail;;

public class ReplysServiceImpl implements ReplysService {
	
	SendMail s = new SendMail();
	
	private ReplyDao replyDao;
	//private MemberAbs memberAbs;

	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public void addReply(Replys reply) {
		replyDao.addReply(reply);
		//s.send(email);
	}

	@Override
	public void modReply(Replys reply) {
		replyDao.modReply(reply);
	}

	@Override
	public void verifyReply(int auditStatus,String replyID) {
		replyDao.verifyReply(auditStatus,replyID);
	}

	@Override
	public void delReply(String replyID) {
		replyDao.delReply(replyID);
	}

	@Override
	public List<Replys> qryNewReplys(String userID, Date lastTime) {
		return replyDao.qryNewReplys(userID, lastTime);
	}
	/**
	 * 根据问题id查询所有对该问题的回复
	 * @param userID
	 * @return
	 * @author whz
	 */
	public List<Map> getAllReplysByQuestionId(HashMap map){
		
		return this.replyDao.getAllReplysByQuestionId(map);
	}
	/**
	 * 添加一条专家回复数据
	 * @param map
	 * @return
	 * @author fwy
	 */
	public int addReplyContent(Map map){
		//memberAbs.updateReplyCount((String)map.get("questionId"));
		this.replyDao.modReplyCount((String)map.get("questionId"));
		return this.replyDao.addReplyContent(map);
	}
	
	@Override
	public List<Replys> qryReplysByUserId(String userId) {
		return replyDao.qryReplysByUserId(userId);
	}
	/**
	 * 根据问题的id获取回复问题的人的名称
	 * @param map
	 * @return
	 */
	public List<Map<String,String>> getUserNameByQuestionId(){
		return this.replyDao.getUserNameByQuestionId();
	}
	/**
	 * 修改赞同次数
	 * @param tring replyId
	 * @return
	 */
    public int updatePollCount(String replyId){
    	return this.replyDao.updatePollCount(replyId);
    }

	@Override
	public List<Replys> qryReplysUnaudited() {
		return replyDao.qryReplysUnaudited();
	}

	@Override
	public List<Replys> qryReplysByQuestionId(String questionId) {
		return replyDao.qryReplysByQuestionId(questionId);
	}

	@Override
	public void optimalAnswer(String replyId) {
		replyDao.optimalAnswer(replyId);
	}
	/**
     * 根据回复id获取改回复记录
     * @param replyId
     * @return
     */
    public HashMap getOneReply(String replyId){
    	return this.replyDao.getOneReply(replyId);
    }
    /**
     * 根据回复id修改回复内容
     * @param map
     */
    public void updateReply(HashMap map){
    	this.replyDao.updateReply(map);
    }
    /**
     * 根据userid和questionid获取回复内容
     * @param map
     * @return
     */
    public HashMap getReplyContentByUserIdAndQuestionId(HashMap map){
    	return this.replyDao.getReplyContentByUserIdAndQuestionId(map);
    }

	@Override
	public List<Replys> qryReplysAll(String questionId) {
		return replyDao.qryReplysAll(questionId);
	}

	@Override
	public void modReplyForContent(Replys reply) {
		replyDao.modReplyForContent(reply);
	}

	@Override
	public void modReplyCount(String questionId) {
		replyDao.modReplyCount(questionId);
		
	}
}
