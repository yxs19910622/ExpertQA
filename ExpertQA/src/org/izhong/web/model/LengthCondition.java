package org.izhong.web.model;

public class LengthCondition implements ICondition {
	private String _memberName;
	private Operators _operater;
	private int _length;
	
	public LengthCondition(String memberName, Operators operater, int length)
	{
		this._memberName = memberName;
		this._operater = operater;
		this._length = length;
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
	public Operators getOperator()
	{
		return this._operater;
	}
	/*
	 * 获取条件值
	 */
	public int getLength()
	{
		return this._length;
	}
	
	@Override
	public String getScript()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("(Length(");
		builder.append(this._memberName);
		builder.append(")");
		switch(this._operater)
		{
		case Equals:
			builder.append("=");
			break;
		case NotEquals:
			builder.append("<>");
			break;
		case GreaterThan:
			builder.append(">");
			break;
		case GreaterThanOrEqual:
			builder.append(">=");
			break;
		case LessThan:
			builder.append("<");
			break;
		case LessThanOrEqual:
			builder.append("<=");
			break;
		
			default:
				builder.append("=");
				break;
		}
		builder.append(this._length);
		builder.append(")");
		return builder.toString();
	}
}