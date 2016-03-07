package org.izhong.web.model;

import org.izhong.web.util.ObjectFormatUtil;

public class InArrayCondition implements ICondition {
	private String _memberName;
	private boolean _inData;
	private Object[] _valuex;
	
	public InArrayCondition(String memberName, boolean inData, Object[] values)
	{
		this._memberName = memberName;
		this._inData = inData;
		this._valuex = values;
	}
	/*
	 * 获取条件成员名称
	 */
	public String getMemberName()
	{
		return this._memberName;
	}
	/*
	 * 获取条件连接符
	 */
	public boolean getInData()
	{
		return this._inData;
	}
	/*
	 * 获取条件值
	 */
	public Object[] getValues()
	{
		return this._valuex;
	}
	
	@Override
	public String getScript() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(this._memberName);
		builder.append(this._inData ? " In (" : " not In (");
		for(int i=0;i<this._valuex.length;i++)
		{
			boolean mustbeFix = ObjectFormatUtil.mustbeFix(this._valuex[i]);
			builder.append(mustbeFix ? "'" : "");
			builder.append(ObjectFormatUtil.formatObject(this._valuex[i]));
			builder.append(mustbeFix ? "'" : "");
			if(i < this._valuex.length-1) builder.append(",");
		}
		builder.append("))");
		return builder.toString();
	}
}
