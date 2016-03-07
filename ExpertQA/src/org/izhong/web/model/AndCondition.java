package org.izhong.web.model;

public class AndCondition implements ICondition {
	private ICondition _leftCondition;
	private ICondition _rightCondition;
	public AndCondition(ICondition leftCondition, ICondition rightCondition)
	{
		this._leftCondition = leftCondition;
		this._rightCondition = rightCondition;
	}
	/*
	 * 获取左条件表达式
	 */
	public ICondition getLeft()
	{
		return this._leftCondition;
	}
	/*
	 * 获取右条件表达式
	 */
	public ICondition getRight()
	{
		return this._rightCondition;
	}
	
	@Override
	public String getScript() {
		String leftString = this._leftCondition.getScript();
		String rightString = this._rightCondition.getScript();
		return "(" + leftString + " And " + rightString + ")";
	}
}
