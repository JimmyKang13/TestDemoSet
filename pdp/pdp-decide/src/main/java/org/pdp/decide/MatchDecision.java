package org.pdp.decide;

import org.api.policyApi.Match;
import org.api.requestApi.Attribute;
import org.api.requestApi.Requests;
import org.api.equalFunction.*;


public class MatchDecision 
{
	//���룺Requests����������ݡ�Match��Ĳ�������
	//�����boolean�����жϽ��
	static boolean matchDecide(Requests request, Match match)
	{
		boolean decide = false;
		//��ȡMatch��ǩ��Category��AttributeId��DataType��MatchId��Value��ǩ��ֵ
		String category = match.getCategory();
		String attributeId = match.getAttributeId();
		String dataType = match.getDataType();
		String matchId = match.getMatchId();
		String value = match.getValue();
		
		//��ȡRequest��ǩ��Attribute��ǩ������
		int num = request.getRequest().getAttributeNum();
		//����Request��ǩ������Attribute��ǩ
		for(int i=0; i<num; i++)
		{
			//��ȡ��Ӧ��Attribute��ǩ����Ϣ
			Attribute attribute = new Attribute();
			attribute = request.getRequest().getAttribute().get(i);
			
			//��ȡAttribute��ǩ��Category��AttributeId��DataType��Value��ǩ��ֵ
			String reqcategory = attribute.getCategory();
			String reqattributeId = attribute.getAttributeId();
			String reqdataType = attribute.getDataType();
			String reqvalue = attribute.getValue();
			
			//�ж�Category��ǩ��ֵ�Ƿ�ƥ��
			if(reqcategory.equals(category))
			{
				//�ж�AttributeId��ǩ��ֵ�Ƿ�ƥ��
				if(reqattributeId.equals(attributeId)) 
				{
					//�ж�DataType��ǩ��ֵ�Ƿ�ƥ��
					if(reqdataType.equals(dataType))
					{
						//����MatchId��ǩ��ֵ��ѡ���Ӧ��ƥ�亯������ȡ�жϽ��
						switch(matchId)
						{
						case"string-equal":
							decide = new StringEqual().stringEqual(reqvalue, value);
							break;
						case"int-equal":
							decide = new IntEqual().intEqual(reqvalue, value);
							break;
						default:
							System.out.println("Wrong MatchId");
						}
					}
				}
			}
			//һ��ƥ��ɹ�������forѭ�����������ù���
			if(decide)
				break;
		}
		//System.out.println(result);
		return decide;
	}
}
