package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Rule 
{
	//���룺PolicyԪ��λ�á�json���飨Ԫ��Rule�µ���Ϣ���գ�
	//�����json���飨Ԫ��Rule�µ���Ϣ��
	static JsonArray getRule(Element policyElement, JsonArray rules)
	{
		//��λ����ǰλ���µ�RuleԪ�أ�RuleԪ�ؿ��ܴ��ڶ����ʹ���б���
		List<Element> ruleElementList = policyElement.elements("Rule");
		JsonObject rule = null;
		JsonArray targets = null;
		//18.11.7 Update owner: KHZN
		JsonArray conditions = null;
		
		//����Ԫ���б�������RuleԪ��
		for(Element ruleElement : ruleElementList)
		{
			//Rule�¸���Ԫ�ػ�������Ϣ��Ϊjson������
			rule = new JsonObject();
			
			//��ȡ��ǰRuleԪ��������Effect��ֵ�����ŵ���ǩEffect��
			String effect = ruleElement.attributeValue("Effect");
			rule.addProperty("Effect", effect);
			
			//��ȡ��ǰRuleԪ��������RuleId��ֵ�����ŵ���ǩRuleId��
			String ruleId = ruleElement.attributeValue("RuleId");
			rule.addProperty("RuleId", ruleId);
			
			targets = new JsonArray();
			
			//�жϵ�ǰRuleԪ���µ�TargetԪ���Ƿ�Ϊ��
			//�ǿգ�������һ���������գ����ش�����Ϣ
			if(ruleElement.element("Target") != null)
			{
				//Target�µ���Ϣ��Ϊjson�����ţ���ȡ�����ݺ󣬷ŵ�Target��ǩ��
				Target.getTarget(ruleElement, targets);
				rule.add("Target", targets);
			} else
			{
				System.out.println("element 'Target' is null");
			}
			
			//18.11 Update owner: KHZN
			
			conditions = new JsonArray();
			
			//�жϵ�ǰRuleԪ���µ�ConditionԪ���Ƿ�Ϊ��
			//�ǿգ�������һ���������գ����ش�����Ϣ
			if(ruleElement.element("Condition") != null)
			{
				//Condition�µ���Ϣ��Ϊjson�����ţ���ȡ�����ݺ󣬷ŵ�Condition��ǩ��
				Condition.getCondition(ruleElement, conditions);
				rule.add("Condition", conditions);
			} else
			{
				System.out.println("element 'Condition' is null");
			}
			
			//��json������뵽json������
			rules.add(rule);
		}
		return rules;
	}
}
