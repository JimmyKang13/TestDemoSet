package org.ctxt.reqTransformation;

import java.io.StringReader;
import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AttributeValue 
{
	static JsonArray getValueInfo(Element attelement, JsonObject valueinfos, JsonArray reqinfo)
	{
		//AttributeԪ���¿��ܴ��ڶ��AttributeValue��ʹ���б���AttributeValueԪ��
		List<Element> valueElementList = attelement.elements("AttributeValue");
		JsonObject valueinfo = null;
		
		//��������AttributeValueԪ��
		for(Element valueelement : valueElementList)
		{
			valueinfo = new JsonObject();
			valueinfo = valueinfos;
			
			//��ȡAttributeValueԪ����DataType���Ե�ֵ����ŵ�DataType��ǩ��
			String dataType = valueelement.attributeValue("DataType");
			valueinfo.addProperty("DataType", dataType);
			
			//��ȡAttributeValueԪ�ص�ֵ����ŵ�Value��ǩ��
			String value = valueelement.getTextTrim();
			valueinfo.addProperty("Value", value);
			
//			System.out.println(valueinfo.toString());	
			
			//��Category��AttributeId��DataType��Value����ϲ�����ŵ�JsonArray���reqinfo�в�����
			valueinfo = new JsonParser().parse(valueinfo.toString()).getAsJsonObject();
			reqinfo.add(valueinfo);
		}
		return reqinfo;
	}
}
