package org.izhong.web.model;

import java.io.Serializable;

public class DownloadPackage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 数量
	 */
	public  int count;
	
	/**
	 * 项目数组
	 */
	 public DownloadFileItem[] items;
	
	/**
	 * 
	 */

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public DownloadFileItem[] getItems() {
		return items;
	}

	public void setItems(DownloadFileItem[] items) {
		this.items = items;
	}
}
