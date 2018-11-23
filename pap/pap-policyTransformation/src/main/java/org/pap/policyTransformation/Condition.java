//18.11 Update owner: KHZN

package org.pap.policyTransformation;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Condition 
{
	//���룺RuleԪ��λ�ã�json���ݣ�Ԫ��Condition�µ���Ϣ���գ�
	//�����json���ݣ�Ԫ��Condition�µ���Ϣ��
	static JsonArray getCondition(Element ruleElement, JsonArray conditions)
	{
		//��λ����ǰλ���µ�ConditionԪ�أ�ConditionԪ����Rule�½�����һ��
		Element conditionElement = ruleElement.element("Condition");
		JsonObject condition = null;
		JsonArray anyofs = null;
		
		//Condition�µĸ���Ԫ�ػ�������Ϣ��Ϊjson������
		condition = new JsonObject();
		anyofs = new JsonArray();
		
		//�жϵ�ǰConditionԪ���µ�AnyOfԪ���Ƿ�Ϊ��
		//�ǿգ�������һ���������գ����ش�����Ϣ
		if(conditionElement.element("AnyOf") != null)
		{
			//AnyOf�µ���Ϣ��Ϊjson�����ţ���ȡ�����ݺ󣬷ŵ�AnyOf��ǩ��
			AnyOf.getAnyOf(conditionElement, anyofs);
			condition.add("AnyOf", anyofs);
		} else
		{
			System.out.println("element 'AnyOf' is null");
		}
		
		//��json������뵽json������
		conditions.add(condition);
		
		return conditions;
	}
}
