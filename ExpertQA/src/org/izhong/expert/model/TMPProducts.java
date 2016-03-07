package org.izhong.expert.model;

import java.io.Serializable;

public class TMPProducts implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productNo;
	private String productName;
	
	public TMPProducts() {
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
