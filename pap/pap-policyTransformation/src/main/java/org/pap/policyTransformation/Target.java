package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Target
{
	//输入：Rule元素位置、json数组（元素Target下的信息，空）
	//输出：json数组（元素Target下的信息）
	static JsonArray getTarget(Element ruleElement, JsonArray targets)
	{
		//定位到当前位置下的Target元素，Target元素在Rule下仅存在一个
		Element targetElement = ruleElement.element("Target");
		JsonObject target = null;
		JsonArray anyofs = null;

		//Target下的各个元素或属性信息作为json对象存放
		target = new JsonObject();
		anyofs = new JsonArray();
		
		//判断当前Target元素下的AnyOf元素是否为空
		//非空，进行下一步操作；空，返回错误信息
		if(targetElement.element("AnyOf") != null)
		{
			//AnyOf下的信息作为json数组存放，获取完数据后，放到AnyOf标签下
			AnyOf.getAnyOf(targetElement, anyofs);
			target.add("AnyOf", anyofs);
		} else
		{
			System.out.println("element 'AnyOf' is null");
		}
		
		//将json对象加入到json数组中
		targets.add(target);
		
		return targets;
	}
}
