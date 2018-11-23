package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AnyOf 
{
	//���룺TargetԪ��λ�á�json���飨Ԫ��AnyOf�µ���Ϣ���գ�
	//�����json���飨Ԫ��AnyOf�µ���Ϣ
	static JsonArray getAnyOf(Element targetElement, JsonArray anyofs)
	{
		//��λ����ǰλ���µ�AnyOfԪ�أ�AnyOfԪ�ؿ��ܴ��ڶ����ʹ���б���
		List<Element> anyofElementList = targetElement.elements("AnyOf");
		JsonObject anyof = null;
		JsonArray allofs = null;
		
		//����Ԫ���б�������AnyOfԪ��
		for(Element anyofElement : anyofElementList)
		{
			//�жϵ�ǰAnyOfԪ���µ�AllOfԪ���Ƿ�Ϊ��
			//�ǿգ�������һ���������ա����ش�����Ϣ
			if(anyofElement.element("AllOf") != null)
			{
				//AnyOf�µ�Ԫ����Ϣ��Ϊjson������
				anyof = new JsonObject();
				allofs = new JsonArray();
				
				//AllOf�µ���Ϣ��Ϊjson�����ţ���ȡ�����ݺ󣬷ŵ�AllOf��ǩ��
				AllOf.getAllOf(anyofElement, allofs);
				anyof.add("AllOf", allofs);
			} else
			{
				System.out.println("element 'AllOf' is null");
			}
			
			//��json������뵽json������
			anyofs.add(anyof);
		}
		return anyofs;
	}
}
