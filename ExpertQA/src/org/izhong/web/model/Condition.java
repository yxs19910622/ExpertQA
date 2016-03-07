package org.izhong.web.model;

import org.izhong.web.util.ObjectFormatUtil;

public class Condition implements ICondition {
	private String _memberName;
	private Operators _operater;
	private Object _valuex;

	public Condition(String memberName, Operators operater, Object value) {
		this._memberName = memberName;
		this._operater = operater;
		this._valuex = value;
	}

	/*
	 * 获取条件成员名称
	 */
	public String getMemberName() {
		return this._memberName;
	}

	/*
	 * 获取条件连接符
	 */
	public Operators getOperator() {
		return this._operater;
	}

	/*
	 * 获取条件值
	 */
	public Object getValue() {
		return this._valuex;
	}

	@Override
	public String getScript() {
		boolean mustbeFix = ObjectFormatUtil.mustbeFix(this._valuex);
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		builder.append(this._memberName);
		switch (this._operater) {
		case Equals:
			builder.append("=");
			builder.append(mustbeFix ? "'" : "");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append(mustbeFix ? "'" : "");
			break;
		case NotEquals:
			builder.append("<>");
			builder.append(mustbeFix ? "'" : "");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append(mustbeFix ? "'" : "");
			break;
		case GreaterThan:
			builder.append(">");
			builder.append(mustbeFix ? "'" : "");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append(mustbeFix ? "'" : "");
			break;
		case GreaterThanOrEqual:
			builder.append(">=");
			builder.append(mustbeFix ? "'" : "");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append(mustbeFix ? "'" : "");
		case LessThan:
			builder.append(">");
			builder.append(mustbeFix ? "'" : "");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append(mustbeFix ? "'" : "");
			break;
		case LessThanOrEqual:
			builder.append(">=");
			builder.append(mustbeFix ? "'" : "");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append(mustbeFix ? "'" : "");
			break;
		case Like:
			builder.append(" like '%");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append("%'");
			break;
		case NotLike:
			builder.append(" not like '%");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append("%'");
			break;
		case StartsWith:
			builder.append(" like '");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append("%'");
			break;
		case NotStartsWith:
			builder.append(" not like '");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append("%'");
			break;
		case EndsWith:
			builder.append(" like '%");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append("'");
			break;
		case NotEndsWith:
			builder.append(" not like '%");
			builder.append(ObjectFormatUtil.formatObject(this._valuex));
			builder.append("'");
			break;

		default:
			break;
		}
		builder.append(")");
		return builder.toString();
	}

}
