package org.izhong.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.izhong.expert.dao.QuestionDao;
import org.izhong.expert.model.Questions;

public class QuestionsServiceImpl implements QuestionsService {
	
	private QuestionDao questionDao;

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public void addQuestion(Questions question) {
		questionDao.addQuestion(question);
	}

	@Override
	public void modQuestion(Questions question) {
		questionDao.modQuestion(question);
	}

	@Override
	public void delQuestion(String questionID) {
		questionDao.delQuestion(questionID);
	}

	@Override
	public void verifyQuestion(int auditStatus,String questionID) {
		questionDao.verifyQuestion(auditStatus,questionID);
	}

	@Override
	public void topQuestion(String questionID) {
		questionDao.topQuestion(questionID);
	}

	@Override
	public void swithQuestion(int isClosed, String questionId) {
		questionDao.swithQuestion(isClosed, questionId);
	}

	@Override
	public void replyCount(String questionID) {
		questionDao.replyCount(questionID);
	}
	/**
	 * 获取问题列表
	 * @param map
	 * @return
	 */
	public  List<Map> getQuestionsList(Map<String,String> map){

		return this.questionDao.getQuestionsList(map);
	}
	
	public  long getQuestionsListCount(Map<String,String> map){
		
		return this.questionDao.getQuestionsListCount(map);
	}
	public HashMap<String,String> getOneQuestion(String questionId){
		
		return this.questionDao.getOneQuestion(questionId);
	}
	public long getFavoritesCountByQuestionId(String questionId){
		return this.questionDao.getFavoritesCountByQuestionId(questionId);
	}
	public long addFavorite(HashMap favorite){
		return this.questionDao.addFavorite(favorite);
	}

	@Override
	public List<Questions> qryQuestionUnaudited() {
		return questionDao.qryQuestionUnaudited();
	}

	@Override
	public List<Questions> qryQuestionByUserId(String userId) {
		return questionDao.qryQuestionByUserId(userId);
	}

	@Override
	public List<Questions> qryUserFavorite(String userId) {
		return questionDao.qryUserFavorite(userId);
	}
		/**
	 * 根据用户名和问题编号查看改问题是否收藏
	 * @param map
	 * @return
	 */
	public long checkFavorite(HashMap map){
		return this.questionDao.checkFavorite(map);
	}
	/**
	 * 获取提问问题最多的前10个用户
	 * @param 
	 * @return
	 */
	public List<Map> getActiveUser(){
		return this.questionDao.getActiveUser();
	}
	/**
	 * 根据问题的类型获取所有问题
	 * @param String typeId
	 * @return List<Map>
	 */
	public List<Map> getQuestionListByTypeId(HashMap map){
		
		return this.questionDao.getQuestionListByTypeId(map);
	}
	
	@Override
	public List<Questions> qryQuestionPending() {
		return questionDao.qryQuestionPending();
	}

	@Override
	public Questions qryQuestionById(String questionId) {
		return questionDao.qryQuestionById(questionId);
	}
	/**
	 * 根据问题id修改该问题回复的次数
	 * @param questionId
	 */
	public void updateReplyCount(String questionId){
		this.questionDao.updateReplyCount(questionId);
	}
	/**
	 * 根据问题id修改该问题
	 * @param questionId
	 */
	public void upateQuestion(HashMap map){
		this.questionDao.upateQuestion(map);
	}

	@Override
	public void modQuestionType(String qaType, String questionId) {
		questionDao.modQuestionType(qaType, questionId);
	}

	@Override
	public void modReplyCount(String questionId) {
		questionDao.modReplyCount(questionId);
	}
	
	public void  insertRes_Question(Map<String,String> map){
//		List list = test.readtxt();
//		for(int i = 0;i < list.size();i++){
//			HashMap maps = (HashMap)list.get(i);
////			System.out.println(maps.get("questionid").toString().length());
////			System.out.println(maps.get("subject").toString().length());
////			System.out.println(maps.get("title").toString().length());
////			System.out.println(maps.get("description").toString().length());
////			System.out.println(maps.get("answer").toString());
////			System.out.println(maps.get("referencenotes").toString().length());
////			System.out.println(maps.get("example").toString());
////			System.out.println(maps.get("interpretation").toString());
////			System.out.println(maps.get("notes").toString());
////			System.out.println("==========================================================================================");
//
//				this.questionDao.insertRes_Question(maps);//vpn 数据传输太慢 需要debug
//		
//		}
		
	}

	public List getAllRes_Questions(){
//		List list = this.questionDao.getAllRes_Questions();
//		test.DateSourceWriteToTxtFile(list);
		return null;
	}

	@Override
	public String getEmailByquestionId(String questionId) {
		// TODO Auto-generated method stub
		return this.questionDao.getEmailByquestionId(questionId);
	}
}
