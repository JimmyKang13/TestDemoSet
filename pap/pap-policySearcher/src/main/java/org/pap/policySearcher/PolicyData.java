package org.pap.policySearcher;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PolicyData 
{
	//���룺PolicyId�б����ԼĴ������գ�
	//�����������Policy��Ϣ�������˱�ǩpolicies��
	static StringBuffer getPolicyData(List<String> policyIdList, StringBuffer policy) throws DocumentException
	{
		//��ȡ·����Ӧ���ĵ�����λ����Ԫ��
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/main/resources/policydata.xml");
		Element policydataElement = document.getRootElement();
		
		//����һ�������ǩPolicies����ɾ�������޸�api�е�Policies�༴��
		policy.append("<Policies>" + "\n");
		
		//�жϸ�Ԫ���µ�PolicyԪ���Ƿ�Ϊ��
		if(policydataElement.element("Policy") != null)
		{
			Policy.getPolicy(policydataElement, policyIdList, policy);
		}
		
		policy.append("</Policies>");
		
		return policy;
	}
}
