package org.izhong.web.model;

import java.io.Serializable;

public class DownloadFileItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目名称
	 */
	public String itemName;
	/**
	 * 压缩之前长度
	 */
	public int beforeLength;
	/**
	 * 压缩之后长度
	 */
	public int afterLength;
	/**
	 * 经过压缩的字节流
	 */
	public byte[] bytes;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getBeforeLength() {
		return beforeLength;
	}
	public void setBeforeLength(int beforeLength) {
		this.beforeLength = beforeLength;
	}
	public int getAfterLength() {
		return afterLength;
	}
	public void setAfterLength(int afterLength) {
		this.afterLength = afterLength;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}
