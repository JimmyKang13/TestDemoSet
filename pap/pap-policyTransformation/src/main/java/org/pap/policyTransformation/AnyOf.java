package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AnyOf 
{
	//输入：Target元素位置、json数组（元素AnyOf下的信息，空）
	//输出：json数组（元素AnyOf下的信息
	static JsonArray getAnyOf(Element targetElement, JsonArray anyofs)
	{
		//定位到当前位置下的AnyOf元素，AnyOf元素可能存在多个，使用列表存放
		List<Element> anyofElementList = targetElement.elements("AnyOf");
		JsonObject anyof = null;
		JsonArray allofs = null;
		
		//遍历元素列表中所有AnyOf元素
		for(Element anyofElement : anyofElementList)
		{
			//判断当前AnyOf元素下的AllOf元素是否为空
			//非空，进行下一步操作；空。返回错误信息
			if(anyofElement.element("AllOf") != null)
			{
				//AnyOf下的元素信息作为json对象存放
				anyof = new JsonObject();
				allofs = new JsonArray();
				
				//AllOf下的信息作为json数组存放，获取完数据后，放到AllOf标签下
				AllOf.getAllOf(anyofElement, allofs);
				anyof.add("AllOf", allofs);
			} else
			{
				System.out.println("element 'AllOf' is null");
			}
			
			//将json对象加入到json数组中
			anyofs.add(anyof);
		}
		return anyofs;
	}
}
