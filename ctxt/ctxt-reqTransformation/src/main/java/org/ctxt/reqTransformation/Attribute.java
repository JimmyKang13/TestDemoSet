package org.ctxt.reqTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Attribute 
{
	static JsonArray getAttributeId(Element attselement, JsonObject attinfo, JsonArray reqinfo)
	{
		//AttributesԪ���¿��ܴ��ڶ��Attribute��ʹ���б���AttributeԪ��
		List<Element> attElementList = attselement.elements("Attribute");
		JsonObject valueinfo = null;
		
		//��������AttributeԪ��
		for(Element attelement : attElementList)
		{
			valueinfo = new JsonObject();
			valueinfo = attinfo;
			
			//��ȡAttributeԪ����AttributeId���Ե�ֵ����ŵ�AttributeId��ǩ��
			String attributeId = attelement.attributeValue("AttributeId");
			valueinfo.addProperty("AttributeId", attributeId);
			
			//�ж�AttributeԪ���µ�AttributeValueԪ���Ƿ�Ϊ��
			//�ǿգ�������һ���������գ����ش�����Ϣ
			if(attelement.element("AttributeValue") != null)
			{
				//��ȡAttributeValueԪ���е�����
				AttributeValue.getValueInfo(attelement, valueinfo, reqinfo);	
			} else
			{
				System.out.println("element 'AttributeValue' is null");
			}		
		}
		return reqinfo;
	}
}
