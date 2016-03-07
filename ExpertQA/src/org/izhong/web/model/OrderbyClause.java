package org.izhong.web.model;

import java.io.Serializable;

public class OrderbyClause implements Serializable {
	/*
	 * 排序的成员名称
	 */
	private String _memberName;
	/*
	 * 是否升序
	 */
	private boolean _ascend;
	
	/*
	 * 构造器
	 */
	public OrderbyClause(String memberName, boolean ascend)
	{
		this._memberName = memberName;
		this._ascend = ascend;
	}
	/*
	 * 获取排序成员名称
	 */
	public String getMemberName()
	{
		return this._memberName;
	}
	/*
	 * 获取是否升序排列
	 */
	public boolean getAscend()
	{
		return this._ascend;
	}
	
	public String getScript()
	{
		return this._memberName + (this._ascend ? "" : " desc");
	}
}
