package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Match 
{
	//���룺AllOfԪ��λ�á�json���飨Ԫ��Match�µ���Ϣ���գ�
	//�����json���飨Ԫ��Match�µ���Ϣ��
	static JsonArray getMatch(Element allofElement, JsonArray matchs)
	{
		//��λ����ǰλ���µ�MatchԪ�أ�MatchԪ�ؿ��ܴ��ڶ����ʹ���б���
		List<Element> matchElementList = allofElement.elements("Match");
		JsonObject match = null;
		
		//����Ԫ���б�������MatchԪ��
		for(Element matchElement : matchElementList)
		{
			//Match�µĸ���Ԫ�ػ�������Ϣ��Ϊjson������
			match = new JsonObject();
			
			//��ȡ��ǰMatchԪ��������MatchId��ֵ�����ű�ǩMatchId��
			String matchId = matchElement.attributeValue("MatchId");
			match.addProperty("MatchId", matchId);

			//��ȡMatchԪ����AttributeValueԪ�ص���Ϣ
			AttributeValue.getAttributeValue(matchElement, match);
			
			//��ȡMatchԪ����AttributeDesignatorԪ�ص���Ϣ
			AttributeDesignator.getAttributeDesignator(matchElement, match);
			
			//����AttributeValueԪ�غ�AttributeDesignatorԪ�ص���Ϣ����ȡ����json����
			match = new JsonParser().parse(match.toString()).getAsJsonObject();
			//��json������뵽json������
			matchs.add(match);
		}
		return matchs;
	}
}
