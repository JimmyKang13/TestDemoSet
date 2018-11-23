package org.pap.policyTransformation;

import org.dom4j.Element;

import com.google.gson.JsonObject;

public class AttributeValue 
{
	//输入：Match元素位置、json对象（元素AttributeValue的内容，空）
	//输出：json对象（元素AttributeValue的内容）
	static JsonObject getAttributeValue(Element matchElement, JsonObject match)
	{
		//定位到当前位置下的AttributeValue元素
		Element valueElement = matchElement.element("AttributeValue");
		
//		String dataType = valueElement.attributeValue("DataType");
//		match.addProperty("DataType", dataType);
		
		//获取当前AttributeValue元素的内容，并放到标签Value下
		String value = valueElement.getTextTrim();
		match.addProperty("Value", value);
		
		return match;
	}
}
