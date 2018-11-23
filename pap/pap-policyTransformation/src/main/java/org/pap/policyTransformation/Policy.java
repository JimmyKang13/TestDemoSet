package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Policy 
{
//	static JsonObject getPolicy(Document document, JsonObject policyinfo)
	
	//���룺��Ԫ��λ�á�json���飨Ԫ��Policy�µ���Ϣ���գ�
	//�����json���飨Ԫ��Policy�µ���Ϣ��
	static JsonArray getPolicy(Element policiesElement, JsonArray policies)
	{
//		Element policyElement = document.getRootElement();
//		JsonArray rules = null;
//		
//		String policyId = policyElement.attributeValue("PolicyId");
//		policyinfo.addProperty("PolicyId", policyId);
//		
//		String ruleCombiningAlgId = policyElement.attributeValue("RuleCombiningAlgId");
//		policyinfo.addProperty("RuleCombiningAlgId", ruleCombiningAlgId);
//		
//		if(policyElement.element("Rule") != null)
//		{
//			rules = new JsonArray();
//			
//			Rule.getRule(policyElement, rules);
//			
//			policyinfo.add("Rule", rules);
//		} else
//		{
//			System.out.println("element 'Rule' is null");
//		}
		
		//��λ����ǰλ���µ�PolicyԪ�أ�PolicyԪ�ؿ��ܴ��ڶ����ʹ���б���
		List<Element> policyElementList = policiesElement.elements("Policy");
		JsonObject policy = null;
		JsonArray rules = null;
		
		//����Ԫ���б�������PolicyԪ��
		for(Element policyElement : policyElementList) 
		{
			//Policy�¸���Ԫ�ػ�������Ϣ��Ϊjson������
			policy = new JsonObject();
			
			//��ȡ��ǰPolicyԪ��������PolicyId��ֵ�����ŵ���ǩPolicyId��
			String policyId = policyElement.attributeValue("PolicyId");
			policy.addProperty("PolicyId", policyId);
			
			//��ȡ��ǰPolicyԪ��������RuleCombiningAlgId��ֵ�����ŵ���ǩRuleCombiningAlgId��
			String ruleCombiningAlgId = policyElement.attributeValue("RuleCombiningAlgId");
			policy.addProperty("RuleCombiningAlgId", ruleCombiningAlgId);
			
			rules = new JsonArray();
			
			//�жϵ�ǰPolicyԪ���µ�RuleԪ���Ƿ�Ϊ��
			//�ǿգ�������һ���������գ����ش�����Ϣ
			if(policyElement.element("Rule") != null)
			{
				//Rule�µ���Ϣ��Ϊjson�����ţ���ȡ�����ݺ󣬷ŵ�Rule��ǩ��
				Rule.getRule(policyElement, rules);
				policy.add("Rule", rules);
			} else
			{
				System.out.println("element 'Rule' is null");
			}
			
			//��json������뵽json������
			policies.add(policy);
		}
		return policies;
	}
}
