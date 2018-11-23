package org.pap.policyTransformation;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.google.gson.JsonObject;

public class GenerateMethod 
{
	//���룺json�������ڴ�Ų���shuju���������ĵ�·��
	//������������ݿ�
	static JsonObject PolicyToJsonMethod(JsonObject object, String policyPath) throws DocumentException
	{
//		JsonObject policyinfo = new JsonObject();
		JsonObject policiesinfo = new JsonObject();
		
		//��ȡ����·����Ӧ���ĵ�
		SAXReader reader = new SAXReader();
		Document document = reader.read(policyPath);
		
//		Policy.getPolicy(document, policyinfo);
		Policies.getPolicies(document, policiesinfo);
		
		//����õ����ݴ�ŵ�Policies��ǩ��
//		object.add("Policy", policyinfo);
		object.add("Policies", policiesinfo);
		
		return object;
	}
}
