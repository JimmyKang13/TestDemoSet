package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Policy��ǩ��
@SuppressWarnings("serial")
public class Policy implements Serializable 
{
	private String PolicyId;
	private String RuleCombiningAlgId;
	private List<Rule> Rule;
	private int RuleNum;
	
	//��ȡ��ǩPolicyId����Ϣ
	public String getPolicyId()
	{
		return PolicyId;
	}
	
	//���ñ�ǩPolicyId
	public void setPolicyId(String PolicyId)
	{
		this.PolicyId = PolicyId;
	}
	
	//��ȡ��ǩRuleCombiningAlgId����Ϣ
	public String getRuleCombiningAlgId()
	{
		return RuleCombiningAlgId;
	}
	
	//���ñ�ǩRuleCombiningAlgId
	public void setRuleCombiningAlgId(String RuleCombiningAlgId)
	{
		this.RuleCombiningAlgId = RuleCombiningAlgId;
	}
	
	//��ȡ��ǩRule�е�������Ϣ���б�洢
	public List<Rule> getRule()
	{
		return Rule;
	}
	
	//���ñ�ǩRule
	public void setRule(List<Rule> Rule)
	{
		this.Rule = Rule;
	}
	
	//��ȡ��ǰPolicy��Rule��ǩ������
	public int getRuleNum()
	{
		RuleNum = 0;
		for(Rule rule : Rule)
			RuleNum++;
		return RuleNum;
	}
	
	//�ض���toString������Ŀ���Ǽ�����������ԣ������ڵ�Ԫ���Խ׶Σ�
	@Override
	public String toString()
	{
		return "Policy:{" + "PolicyId:" + PolicyId + ", RuleCombiningAlgId:" + RuleCombiningAlgId + ", " + Rule + "}";
	}
}
