package org.pap.policySearcher;

import java.util.List;

import org.api.requestApi.Requests;
import org.dom4j.Element;

public class PolicySet 
{
	//���룺Ԫ��λ�á��������ݿ顢policyId�б�
	//�����policyId�б�
	//p.s.���ú������ڶ���������
	static List<String> getPolicySet(Element policysetdataElement, Requests request, List<String> policyIdList)
	{
		//�жϵ�ǰԪ�أ�policydataElement����PolicySetԪ���Ƿ�Ϊ��
		if(policysetdataElement.element("PolicySet") != null)
		{
			//��λ����ǰԪ���µ�PolicySetλ�ã����ڿ��ܴ��ڶ��PolicySetԪ�أ�ʹ���б���ʽ�洢
			List<Element> policysetElementList = policysetdataElement.elements("PolicySet");
			
			//�����б�������PolicySetԪ��
			for(Element policysetElement : policysetElementList)
			{
				//�жϵ�ǰλ��PolicySet�µ�Target�Ƿ�Ϊ��
				//��TargetΪ�ջ򲻴��ڣ���ʾֱ�ӽ�����һ��PolicySet��Policy������getPolicysetʵ��
				//��Target��Ϊ�գ���Ҫ����Match���decide���������жϣ����boolean���͵��жϽ������ȷ�����getPolicySet������һ������֮������ǰλ�ò���
				if(policysetElement.element("Target") == null)
				{
					PolicySet.getPolicySet(policysetElement, request, policyIdList);
				}
				
				boolean decision = Match.decide(policysetElement, request);
				
				if(decision)
				{
					PolicySet.getPolicySet(policysetElement, request, policyIdList);
				}
			}
		}
		
		//�жϵ�ǰԪ�أ�policydataElement����PolicyԪ���Ƿ�Ϊ��
		//��Policy����ʱ����Ҫ��ȡ���е�PolicyId������PolicyId�б���
		if(policysetdataElement.element("Policy") != null)
		{
			//��λ����ǰԪ���µ�Policyλ�ã�PolicyԪ�ؿ��ܴ��ڶ����ʹ���б�洢
			List<Element> policyElementList = policysetdataElement.elements("Policy");
			
			//�����б�������PolicyԪ��
			for(Element policyElement : policyElementList)
			{
				//��ȡPolicyԪ����PolicyId���Ե�ֵ��������PolicyIdList�б���
				String policyId = policyElement.attributeValue("PolicyId");
				policyIdList.add(policyId);
			}
		}
		
		return policyIdList;
	}
}
