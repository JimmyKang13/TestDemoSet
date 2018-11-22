package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Rule��ǩ��
@SuppressWarnings("serial")
public class Rule implements Serializable
{
	private String Effect;
	private String RuleId;
	private List<Target> Target;
	
	//��ȡ��ǩEffect����Ϣ
	public String getEffect()	
	{
		return Effect;
	}
	
	//���ñ�ǩEffect
	public void setEffect(String Effect)
	{
		this.Effect = Effect;
	}
	
	//��ȡ��ǩRuleId����Ϣ
	public String getRuleId()
	{
		return RuleId;
	}
	
	//���ñ�ǩRuleId
	public void setRuleId(String RuleId)
	{
		this.RuleId = RuleId;
	}
	
	//��ȡ��ǩTarget�е�������Ϣ���б�洢
	public List<Target> getTarget()
	{
		return Target;
	}
	
	//���ñ�ǩTarget
	public void setTarget(List<Target> Target)
	{
		this.Target = Target;
	}
	
	//18.11 Update issuer: KHZN
	
	private List<Condition> Condition;
	
	//��ȡ��ǩCondition�е�������Ϣ���б�洢
	public List<Condition> getCondition()
	{
		return Condition;
	}
	
	//���ñ�ǩCondition
	public void setCondition(List<Condition> Condition)
	{
		this.Condition = Condition;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "Rule:[{" + "Effect:" + Effect + ",RuleId" + RuleId + "," + Target + "," + Condition + "}]";
	}
}
