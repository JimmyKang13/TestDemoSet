package org.pap.policySearcher;

import java.util.List;

import org.api.requestApi.Requests;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PolicySetData 
{
	//���룺�������ݿ飨.json����policyId�б��գ�
	//�����policyId�б�ƥ�䵽��Id��
	static List<String> getPolicySetData(Requests request, List<String> policyIdList) throws DocumentException
	{
		//��ȡ·����Ӧ���ĵ�����λ����Ԫ��
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/main/resources/policysetdata.xml");
		Element policysetdataElement = document.getRootElement();
		
		//�жϸ�Ԫ���µ�PolicySet�Ƿ�Ϊ��
		if(policysetdataElement.element("PolicySet") != null)
		{
			//����PolicySet���ݺ��������ݿ飬���ƥ���policyId�б����ܴ����ظ�ֵ��
			PolicySet.getPolicySet(policysetdataElement, request, policyIdList);
		}
		
		return policyIdList;
	}
}
