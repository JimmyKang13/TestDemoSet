package org.pap.policySearcher;

import org.api.equalFunction.IntEqual;
import org.api.equalFunction.StringEqual;
import org.api.requestApi.Attribute;
import org.api.requestApi.Requests;
import org.dom4j.Element;

public class Match 
{
	//���룺Ԫ��λ�á��������ݿ�
	//�����Boolean�����жϽ��
	//�˺�����Ŀ�����ж�����Ԫ�������µ�TargetԪ���е������Ƿ��ܹ�ƥ�����������ݿ��е���Ϣ
	static boolean decide(Element policysetElement, Requests request)
	{
		boolean decision = false;
		
		//�ֽ׶�PolicySet�µ�TargetԪ����ֻ���һ��������Ϣ����ֱ�Ӷ�λ��MatchԪ��λ��
		Element matchElement = policysetElement.element("Target").element("AnyOf").element("AllOf").element("Match");
		
		//��ȡMatchԪ�ص�����MatchId��ֵ
		String matchId = matchElement.attributeValue("MatchId");
		
		//��λ��MatchԪ���µ�AttributeValueԪ�أ���ȡ�����ݣ�value��
		Element valueElement = matchElement.element("AttributeValue");
		String value = valueElement.getTextTrim();
		
		//��λ��MatchԪ���µ�AttributeDesignatorԪ�أ���ȡ������Category��AttributeId��DataType��ֵ
		Element designatorElement = matchElement.element("AttributeDesignator");
		String category = designatorElement.attributeValue("Category");
		String attributeId = designatorElement.attributeValue("AttributeId");
		String dataType = designatorElement.attributeValue("DataType");
		
		//��ȡ�������ݿ���Request��ǩ��Attribute��ǩ������
		int num = request.getRequest().getAttributeNum();
		//��������Attribute��ǩ��ѭ������ΪAttribute��ǩ������
		for(int i=0; i<num; i++)
		{
			//��ȡAttribute��ǩ����Ϣ
			Attribute attribute = new Attribute();
			attribute = request.getRequest().getAttribute().get(i);
			
			//��ȡAttribute��ǩ������Category��AttributeId��DataType��Value��ֵ
			String reqcategory = attribute.getCategory();
			String reqattributeId = attribute.getAttributeId();
			String reqdataType = attribute.getDataType();
			String reqvalue = attribute.getValue();
			
			//�ж�Category��ֵ�Ƿ�ƥ��
			if(reqcategory.equals(category))
			{
				//�ж�AttribtueId��ֵ�Ƿ�ƥ��
				if(reqattributeId.equals(attributeId))
				{
					//�ж�DataType��ֵ�Ƿ�ƥ��
					if(reqdataType.equals(dataType))
					{
						//����MatchId��ֵ��ѡ���Ӧ��ƥ�亯������ȡ�жϽ��
						switch(matchId)
						{
						case"string-equal":
							decision = new StringEqual().stringEqual(reqvalue, value);
							break;
						case"int-equal":
							decision = new IntEqual().intEqual(reqvalue, value);
							break;
						default:
							System.out.println("Wrong MatchId");
						}
					}
				}
			}
			//һ��ƥ��ɹ�������forѭ�����������ù���
			if(decision)
				break;
		}
		
		return decision;
	}
}
