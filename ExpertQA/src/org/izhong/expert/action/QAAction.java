package org.izhong.expert.action;

import java.util.List;

import net.sf.json.JSONObject;

import org.izhong.expert.abs.IndexAbs;
import org.izhong.expert.abs.QAAbs;
import org.izhong.expert.model.LabUsers;
import org.izhong.expert.model.QATypes;
import org.izhong.expert.model.QueryHotWords;
import org.izhong.expert.model.Questions;
import org.izhong.expert.util.BaseUtil;

public class QAAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QAAbs qaAbs;
	private IndexAbs indexAbs;
	private List<QATypes> lstTypeParent;
	private List<QATypes> lstTypeChild;
	private List<QueryHotWords> lstqhw;
	private LabUsers labuser;
	private String isClosed;
	private String questionId;
	private String replyId;
	private String questionTitle;
	
	private Questions question;
	
	
	public String initQuestion()
	{
		lstTypeParent = indexAbs.findQATypeByParent();
		lstTypeChild = indexAbs.findQATypesByChild();
		lstqhw = qaAbs.findHotWordsAll();
		labuser = indexAbs.findRecommendExpert();
		return SUCCESS;
	}
	public String initQuestion_mirror()
	{
		lstTypeParent = indexAbs.findQATypeByParent();
		lstTypeChild = indexAbs.findQATypesByChild();
		lstqhw = qaAbs.findHotWordsAll();
		labuser = indexAbs.findRecommendExpert();
		return SUCCESS;
	}
	//专家问答
	public String expertAnswer_mirror()
	{
		lstqhw = qaAbs.findHotWordsAll();
		isClosed = "0";
		questionTitle = "";
		labuser = indexAbs.findRecommendExpert();
		return SUCCESS;
	}
	//专家问答
	public String expertAnswer()
	{
		lstqhw = qaAbs.findHotWordsAll();
		isClosed = "0";
		questionTitle = "";
		labuser = indexAbs.findRecommendExpert();
		return SUCCESS;
	}
	//搜索问答
	public String searchAnswer_mirror(){
		lstqhw = qaAbs.findHotWordsAll();
		isClosed = "1";
		labuser = indexAbs.findRecommendExpert();
		if(this.getRequest().getParameter("flag")=="1"||"1".equals(this.getRequest().getParameter("flag"))){
			return SUCCESS;
		}
		try {
			String str = this.getRequest().getParameter("questionTitle");
			if(BaseUtil.isNotEmpty(str))
			{
				questionTitle = new String(str.getBytes("ISO-8859-1"),"UTF-8");
			}
			this.getRequest().setAttribute("kwd", questionTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//搜索问答
	public String searchAnswer(){
		lstqhw = qaAbs.findHotWordsAll();
		isClosed = "1";
		labuser = indexAbs.findRecommendExpert();
		System.out.println(this.getRequest().getParameter("flag"));
		if(this.getRequest().getParameter("flag")=="1"||"1".equals(this.getRequest().getParameter("flag"))){
			return SUCCESS;
		}
		try {
			String str = this.getRequest().getParameter("questionTitle");
			if(BaseUtil.isNotEmpty(str))
			{
				questionTitle = new String(str.getBytes("ISO-8859-1"),"UTF-8");
			}
			this.getRequest().setAttribute("kwd", questionTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//专家回家问题界面
	public String answerQuestion(){
		questionId = this.getRequest().getParameter("questionid");
		labuser = indexAbs.findRecommendExpert();
		lstqhw = qaAbs.findHotWordsAll();
		return SUCCESS;
	}
	//专家回家问题界面镜像
		public String answerQuestion_mirror(){
			questionId = this.getRequest().getParameter("questionid");
			labuser = indexAbs.findRecommendExpert();
			lstqhw = qaAbs.findHotWordsAll();
			return SUCCESS;
		}
	//查看问题
	public String checkQuestion(){
		questionId = this.getRequest().getParameter("questionid");
		labuser = indexAbs.findRecommendExpert();
		lstqhw = qaAbs.findHotWordsAll();
		return SUCCESS;
	}
	//查看问题回复
	public String checkQuestionReply(){
		replyId = this.getRequest().getParameter("replyid");
		labuser = indexAbs.findRecommendExpert();
		lstqhw = qaAbs.findHotWordsAll();
		return SUCCESS;
	}
	
	public String addQuestionSave()
	{
		question.setUserID(getUserID());
		qaAbs.addQuestion(question);
		return SUCCESS;
	}
	
	public void setQaAbs(QAAbs qaAbs) {
		this.qaAbs = qaAbs;
	}
   
	public List<QueryHotWords> getLstqhw() {
		return lstqhw;
	}

	public void setLstqhw(List<QueryHotWords> lstqhw) {
		this.lstqhw = lstqhw;
	}
	public List<QATypes> getLstTypeParent() {
		return lstTypeParent;
	}
	public void setLstTypeParent(List<QATypes> lstTypeParent) {
		this.lstTypeParent = lstTypeParent;
	}
	public List<QATypes> getLstTypeChild() {
		return lstTypeChild;
	}
	public void setLstTypeChild(List<QATypes> lstTypeChild) {
		this.lstTypeChild = lstTypeChild;
	}
	public IndexAbs getIndexAbs() {
		return indexAbs;
	}
	public void setIndexAbs(IndexAbs indexAbs) {
		this.indexAbs = indexAbs;
	}
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public LabUsers getLabuser() {
		return labuser;
	}
	public void setLabuser(LabUsers labuser) {
		this.labuser = labuser;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
}
