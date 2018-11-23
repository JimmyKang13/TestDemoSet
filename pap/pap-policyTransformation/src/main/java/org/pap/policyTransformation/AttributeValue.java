package org.pap.policyTransformation;

import org.dom4j.Element;

import com.google.gson.JsonObject;

public class AttributeValue 
{
	//���룺MatchԪ��λ�á�json����Ԫ��AttributeValue�����ݣ��գ�
	//�����json����Ԫ��AttributeValue�����ݣ�
	static JsonObject getAttributeValue(Element matchElement, JsonObject match)
	{
		//��λ����ǰλ���µ�AttributeValueԪ��
		Element valueElement = matchElement.element("AttributeValue");
		
//		String dataType = valueElement.attributeValue("DataType");
//		match.addProperty("DataType", dataType);
		
		//��ȡ��ǰAttributeValueԪ�ص����ݣ����ŵ���ǩValue��
		String value = valueElement.getTextTrim();
		match.addProperty("Value", value);
		
		return match;
	}
}
