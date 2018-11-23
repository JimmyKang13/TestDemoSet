package org.ctxt.reqTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Attribute 
{
	static JsonArray getAttributeId(Element attselement, JsonObject attinfo, JsonArray reqinfo)
	{
		//Attributes元素下可能存在多个Attribute，使用列表存放Attribute元素
		List<Element> attElementList = attselement.elements("Attribute");
		JsonObject valueinfo = null;
		
		//遍历所有Attribute元素
		for(Element attelement : attElementList)
		{
			valueinfo = new JsonObject();
			valueinfo = attinfo;
			
			//获取Attribute元素中AttributeId属性的值，存放到AttributeId标签下
			String attributeId = attelement.attributeValue("AttributeId");
			valueinfo.addProperty("AttributeId", attributeId);
			
			//判断Attribute元素下的AttributeValue元素是否为空
			//非空，进行下一步操作；空，返回错误信息
			if(attelement.element("AttributeValue") != null)
			{
				//获取AttributeValue元素中的数据
				AttributeValue.getValueInfo(attelement, valueinfo, reqinfo);	
			} else
			{
				System.out.println("element 'AttributeValue' is null");
			}		
		}
		return reqinfo;
	}
}
