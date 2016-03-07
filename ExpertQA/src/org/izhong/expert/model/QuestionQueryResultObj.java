package org.izhong.expert.model;

import java.io.Serializable;

public class QuestionQueryResultObj  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String questionid;
	private String captiontext;
	
	public QuestionQueryResultObj()
	{
	}
	
	public String getQuestionID() {
		return questionid;
	}
	public void setQuestionID(String QuestionID) {
		this.questionid = QuestionID;
	}
	
	public String getCaptiontext() {
		return captiontext;
	}
	public void setCaptiontext(String Captiontext) {
		this.captiontext = Captiontext;
	}
	
}
