package org.pap.policyTransformation;

import org.dom4j.Element;

import com.google.gson.JsonObject;

public class AttributeDesignator 
{
	//输入：Match元素位置、json对象（元素AttributeDesignator中的属性信息，空）
	//输出：json对象（元素AttributeDesignator中的属性信息）
	static JsonObject getAttributeDesignator(Element matchElement, JsonObject match)
	{
		//定位到当前位置下的AttributeDesignator元素
		Element designatorElement = matchElement.element("AttributeDesignator");
		
		//获取当前AttributeDesignator元素中属性Category的值，并放到标签Category下
		String category = designatorElement.attributeValue("Category");
		match.addProperty("Category", category);
		
		//获取当前AttributeDesignator元素中属性AttributeId的值，并放到标签AttributeId下
		String attributeId = designatorElement.attributeValue("AttributeId");
		match.addProperty("AttributeId", attributeId);
		
		//获取当前AttributeDesignator元素中属性DataType的值，并放到标签DataType下
		String dataType = designatorElement.attributeValue("DataType");
		match.addProperty("DataType", dataType);
		
		return match;
	}
}
