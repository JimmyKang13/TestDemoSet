package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Policy标签类
@SuppressWarnings("serial")
public class Policy implements Serializable 
{
	private String PolicyId;
	private String RuleCombiningAlgId;
	private List<Rule> Rule;
	private int RuleNum;
	
	//获取标签PolicyId的信息
	public String getPolicyId()
	{
		return PolicyId;
	}
	
	//设置标签PolicyId
	public void setPolicyId(String PolicyId)
	{
		this.PolicyId = PolicyId;
	}
	
	//获取标签RuleCombiningAlgId的信息
	public String getRuleCombiningAlgId()
	{
		return RuleCombiningAlgId;
	}
	
	//设置标签RuleCombiningAlgId
	public void setRuleCombiningAlgId(String RuleCombiningAlgId)
	{
		this.RuleCombiningAlgId = RuleCombiningAlgId;
	}
	
	//获取标签Rule中的所有信息，列表存储
	public List<Rule> getRule()
	{
		return Rule;
	}
	
	//设置标签Rule
	public void setRule(List<Rule> Rule)
	{
		this.Rule = Rule;
	}
	
	//获取当前Policy下Rule标签的数量
	public int getRuleNum()
	{
		RuleNum = 0;
		for(Rule rule : Rule)
			RuleNum++;
		return RuleNum;
	}
	
	//重定义toString函数，目的是检测数据完整性（仅用于单元测试阶段）
	@Override
	public String toString()
	{
		return "Policy:{" + "PolicyId:" + PolicyId + ", RuleCombiningAlgId:" + RuleCombiningAlgId + ", " + Rule + "}";
	}
}
