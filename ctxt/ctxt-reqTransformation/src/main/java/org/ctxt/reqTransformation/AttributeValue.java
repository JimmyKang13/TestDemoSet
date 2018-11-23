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
		//Attribute元素下可能存在多个AttributeValue，使用列表存放AttributeValue元素
		List<Element> valueElementList = attelement.elements("AttributeValue");
		JsonObject valueinfo = null;
		
		//遍历所有AttributeValue元素
		for(Element valueelement : valueElementList)
		{
			valueinfo = new JsonObject();
			valueinfo = valueinfos;
			
			//获取AttributeValue元素中DataType属性的值，存放到DataType标签下
			String dataType = valueelement.attributeValue("DataType");
			valueinfo.addProperty("DataType", dataType);
			
			//获取AttributeValue元素的值，存放到Value标签下
			String value = valueelement.getTextTrim();
			valueinfo.addProperty("Value", value);
			
//			System.out.println(valueinfo.toString());	
			
			//将Category、AttributeId、DataType、Value整理合并，存放到JsonArray类的reqinfo中并返回
			valueinfo = new JsonParser().parse(valueinfo.toString()).getAsJsonObject();
			reqinfo.add(valueinfo);
		}
		return reqinfo;
	}
}
