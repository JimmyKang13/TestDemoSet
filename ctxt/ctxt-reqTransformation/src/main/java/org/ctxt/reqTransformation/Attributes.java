package org.ctxt.reqTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Attributes 
{
	static JsonArray getCategory(Element reqElement, JsonArray reqinfo)
	{
		//��Ԫ���¿��ܴ��ڶ��AttributesԪ�أ�ʹ���б���AttributesԪ��
		List<Element> attsElementList = reqElement.elements("Attributes");
		JsonObject attinfo = null;
		
		//��������AttributesԪ��
		for(Element attselement : attsElementList)
		{
			attinfo = new JsonObject();
			
			//��ȡAttributesԪ����Category���Ե�ֵ����ŵ�Category��ǩ��
			String category = attselement.attributeValue("Category");
			attinfo.addProperty("Category", category);
			
			//�ж�AttributesԪ���µ�AttributeԪ���Ƿ�Ϊ��
			//�ǿգ�������һ���������գ����ش�����Ϣ
			if(attselement.element("Attribute") != null)
			{	
				//��ȡAttributeԪ���е�����
				Attribute.getAttributeId(attselement, attinfo, reqinfo);
			} else
			{
				System.out.println("element 'Attribute' is null");
			}
		}
		return reqinfo;
	}
}
