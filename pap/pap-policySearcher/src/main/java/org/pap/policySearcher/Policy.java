package org.pap.policySearcher;

import java.util.List;

import org.dom4j.Element;

public class Policy 
{
	//���룺Ԫ��λ�á�PolicyId�б����ԼĴ����������˱�ǩpolicies��
	//���������PolicyId��ȡ��Ӧ��Policy��Ϣ����βδ���policies��ǩ��ֹ����
	static StringBuffer getPolicy(Element policydataElement, List<String> policyIdList, StringBuffer policy)
	{
		//��λ����ǰԪ���µ�Policyλ�ã����ڿ��ܴ��ڶ��PolicyԪ�أ�ʹ���б���ʽ�洢
		List<Element> policyElementList = policydataElement.elements("Policy");
		
		//����PolicyId�б�������PolicyId
		for(String policyId : policyIdList)
		{
			//����Ԫ���б�������PolicyԪ��
			for(Element policyElement : policyElementList)
			{
				//��ȡ��ǰPolicyԪ�ص�����PolicyId��ֵ
				String id = policyElement.attributeValue("PolicyId");
				
				//�ж�PolicyId�Ƿ�ƥ��
				//ƥ��ɹ�����ȡ��ǰPolicyԪ��������Ϣ��ʹ��asXML����ת��Ϊxml��ʽ���ַ������ݣ�������ԼĴ�����
				if(id.equals(policyId))
				{
					policy.append(policyElement.asXML() + "\n\t");
				}
			}
		}
		return policy;
	}
}
