package org.izhong.expert.model;

import java.io.Serializable;

public class QueryHotWords implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long wordID;
	private String word;
	private String matchingPattern;
	
	public QueryHotWords() {
	}

	public long getWordID() {
		return wordID;
	}

	public void setWordID(long wordID) {
		this.wordID = wordID;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMatchingPattern() {
		return matchingPattern;
	}

	public void setMatchingPattern(String matchingPattern) {
		this.matchingPattern = matchingPattern;
	}
	
}
