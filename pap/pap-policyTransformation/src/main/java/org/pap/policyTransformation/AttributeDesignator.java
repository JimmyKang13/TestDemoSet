package org.pap.policyTransformation;

import org.dom4j.Element;

import com.google.gson.JsonObject;

public class AttributeDesignator 
{
	//���룺MatchԪ��λ�á�json����Ԫ��AttributeDesignator�е�������Ϣ���գ�
	//�����json����Ԫ��AttributeDesignator�е�������Ϣ��
	static JsonObject getAttributeDesignator(Element matchElement, JsonObject match)
	{
		//��λ����ǰλ���µ�AttributeDesignatorԪ��
		Element designatorElement = matchElement.element("AttributeDesignator");
		
		//��ȡ��ǰAttributeDesignatorԪ��������Category��ֵ�����ŵ���ǩCategory��
		String category = designatorElement.attributeValue("Category");
		match.addProperty("Category", category);
		
		//��ȡ��ǰAttributeDesignatorԪ��������AttributeId��ֵ�����ŵ���ǩAttributeId��
		String attributeId = designatorElement.attributeValue("AttributeId");
		match.addProperty("AttributeId", attributeId);
		
		//��ȡ��ǰAttributeDesignatorԪ��������DataType��ֵ�����ŵ���ǩDataType��
		String dataType = designatorElement.attributeValue("DataType");
		match.addProperty("DataType", dataType);
		
		return match;
	}
}
