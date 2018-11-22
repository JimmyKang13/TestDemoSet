package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Rule标签类
@SuppressWarnings("serial")
public class Rule implements Serializable
{
	private String Effect;
	private String RuleId;
	private List<Target> Target;
	
	//获取标签Effect的信息
	public String getEffect()	
	{
		return Effect;
	}
	
	//设置标签Effect
	public void setEffect(String Effect)
	{
		this.Effect = Effect;
	}
	
	//获取标签RuleId的信息
	public String getRuleId()
	{
		return RuleId;
	}
	
	//设置标签RuleId
	public void setRuleId(String RuleId)
	{
		this.RuleId = RuleId;
	}
	
	//获取标签Target中的所有信息，列表存储
	public List<Target> getTarget()
	{
		return Target;
	}
	
	//设置标签Target
	public void setTarget(List<Target> Target)
	{
		this.Target = Target;
	}
	
	//18.11 Update issuer: KHZN
	
	private List<Condition> Condition;
	
	//获取标签Condition中的所有信息，列表存储
	public List<Condition> getCondition()
	{
		return Condition;
	}
	
	//设置标签Condition
	public void setCondition(List<Condition> Condition)
	{
		this.Condition = Condition;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "Rule:[{" + "Effect:" + Effect + ",RuleId" + RuleId + "," + Target + "," + Condition + "}]";
	}
}
