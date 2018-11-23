//18.11 Update owner: KHZN

package org.pap.policyTransformation;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Condition 
{
	//输入：Rule元素位置，json数据（元素Condition下的信息，空）
	//输出：json数据（元素Condition下的信息）
	static JsonArray getCondition(Element ruleElement, JsonArray conditions)
	{
		//定位到当前位置下的Condition元素，Condition元素在Rule下仅存在一个
		Element conditionElement = ruleElement.element("Condition");
		JsonObject condition = null;
		JsonArray anyofs = null;
		
		//Condition下的各个元素或属性信息作为json对象存放
		condition = new JsonObject();
		anyofs = new JsonArray();
		
		//判断当前Condition元素下的AnyOf元素是否为空
		//非空，进行下一步操作；空，返回错误信息
		if(conditionElement.element("AnyOf") != null)
		{
			//AnyOf下的信息作为json数组存放，获取完数据后，放到AnyOf标签下
			AnyOf.getAnyOf(conditionElement, anyofs);
			condition.add("AnyOf", anyofs);
		} else
		{
			System.out.println("element 'AnyOf' is null");
		}
		
		//将json对象加入到json数组中
		conditions.add(condition);
		
		return conditions;
	}
}
