package org.izhong.expert.model;

import java.io.Serializable;

public class FilterWords implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long filterWordID;
	private String filterWord;
	private String replaceWord;
	private String matchingPattern;
	private String creater;
	
	public FilterWords() {
	}

	public long getFilterWordID() {
		return filterWordID;
	}

	public void setFilterWordID(long filterWordID) {
		this.filterWordID = filterWordID;
	}

	public String getFilterWord() {
		return filterWord;
	}

	public void setFilterWord(String filterWord) {
		this.filterWord = filterWord;
	}

	public String getReplaceWord() {
		return replaceWord;
	}

	public void setReplaceWord(String replaceWord) {
		this.replaceWord = replaceWord;
	}

	public String getMatchingPattern() {
		return matchingPattern;
	}

	public void setMatchingPattern(String matchingPattern) {
		this.matchingPattern = matchingPattern;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}
}
