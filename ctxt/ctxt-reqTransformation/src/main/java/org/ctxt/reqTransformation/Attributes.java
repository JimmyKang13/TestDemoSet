package org.ctxt.reqTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Attributes 
{
	static JsonArray getCategory(Element reqElement, JsonArray reqinfo)
	{
		//根元素下可能存在多个Attributes元素，使用列表存放Attributes元素
		List<Element> attsElementList = reqElement.elements("Attributes");
		JsonObject attinfo = null;
		
		//遍历所有Attributes元素
		for(Element attselement : attsElementList)
		{
			attinfo = new JsonObject();
			
			//获取Attributes元素中Category属性的值，存放到Category标签下
			String category = attselement.attributeValue("Category");
			attinfo.addProperty("Category", category);
			
			//判断Attributes元素下的Attribute元素是否为空
			//非空，进行下一步操作；空，返回错误信息
			if(attselement.element("Attribute") != null)
			{	
				//获取Attribute元素中的数据
				Attribute.getAttributeId(attselement, attinfo, reqinfo);
			} else
			{
				System.out.println("element 'Attribute' is null");
			}
		}
		return reqinfo;
	}
}
