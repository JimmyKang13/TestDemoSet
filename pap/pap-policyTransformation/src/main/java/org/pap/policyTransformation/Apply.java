//18.11 Update owner: KHZN

package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Apply 
{
	//输入：AllOf元素位置、json数据（元素Apply下的信息，空）
	//输出：json数据（元素Apply下的信息）
	static JsonArray getApply(Element allofElement, JsonArray applies)
	{
		//定位到当前位置下的Apply元素，Apply元素可能存在多个，使用列表存放
		List<Element> applyElementList = allofElement.elements("Apply");
		JsonObject apply = null;
		
		//遍历元素列表中所有Apply元素
		for(Element applyElement : applyElementList)
		{
			//Apply下的各个元素或属性信息作为json对象存放
			apply = new JsonObject();
			
			//获取当前Apply元素中属性FunctionId的值，并放标签FunctionId下
			String functionId = applyElement.attributeValue("FunctionId");
			apply.addProperty("FunctionId", functionId);
			
			//获取Apply元素下AttributeValue元素的信息
			AttributeValue.getAttributeValue(applyElement, apply);
			
			//获取Apply元素下AttributeDesignator元素的信息
			AttributeDesignator.getAttributeDesignator(applyElement, apply);
			
			//整合AttributeValue和AttributeDesignator元素的信息，获取数据json对象
			apply = new JsonParser().parse(apply.toString()).getAsJsonObject();
			//将json对象加入到json数据中
			applies.add(apply);
		}
		return applies;
	}
}
