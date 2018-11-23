package org.pap.policyTransformation;

import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Policies 
{
	//���룺�����ĵ���json����Ԫ��policies�µ���Ϣ���գ�
	//�����json����Ԫ��policies�µ���Ϣ��
	static JsonObject getPolicies(Document document, JsonObject policiesinfo)
	{
		//��λ���ĵ���Ԫ��
		Element policiesElement = document.getRootElement();
		JsonArray policies = null;
		
		//�жϸ�Ԫ����PolicyԪ���Ƿ�Ϊ��
		//�ǿգ�������һ���������գ����ش�����Ϣ
		if(policiesElement.element("Policy") != null)
		{
			//Policy�µ���Ϣʹ��json�����ţ���ȡ�����ݺ󣬽���������ŵ�Policy��ǩ��
			policies = new JsonArray();
			
			Policy.getPolicy(policiesElement, policies);
			policiesinfo.add("Policy", policies);
		} else
		{
			System.out.println("element 'Policy' is null");
		}
		return policiesinfo;
	}
}
