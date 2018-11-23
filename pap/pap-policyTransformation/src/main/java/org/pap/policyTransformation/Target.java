package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Target
{
	//���룺RuleԪ��λ�á�json���飨Ԫ��Target�µ���Ϣ���գ�
	//�����json���飨Ԫ��Target�µ���Ϣ��
	static JsonArray getTarget(Element ruleElement, JsonArray targets)
	{
		//��λ����ǰλ���µ�TargetԪ�أ�TargetԪ����Rule�½�����һ��
		Element targetElement = ruleElement.element("Target");
		JsonObject target = null;
		JsonArray anyofs = null;

		//Target�µĸ���Ԫ�ػ�������Ϣ��Ϊjson������
		target = new JsonObject();
		anyofs = new JsonArray();
		
		//�жϵ�ǰTargetԪ���µ�AnyOfԪ���Ƿ�Ϊ��
		//�ǿգ�������һ���������գ����ش�����Ϣ
		if(targetElement.element("AnyOf") != null)
		{
			//AnyOf�µ���Ϣ��Ϊjson�����ţ���ȡ�����ݺ󣬷ŵ�AnyOf��ǩ��
			AnyOf.getAnyOf(targetElement, anyofs);
			target.add("AnyOf", anyofs);
		} else
		{
			System.out.println("element 'AnyOf' is null");
		}
		
		//��json������뵽json������
		targets.add(target);
		
		return targets;
	}
}
