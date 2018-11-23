package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AllOf 
{
	//输入：AnyOf元素位置、json数组（元素AllOf下的信息，空）
	//输出：json数组（元素AllOf下的信息）
	static JsonArray getAllOf(Element anyofElement, JsonArray allofs)
	{
		//定位到当前位置下的AllOf元素，AllOf元素可能存在多个，使用列表存放
		List<Element> allofElementList = anyofElement.elements("AllOf");
		JsonObject allof = null;
		JsonArray matchs = null;
//		//18.11 Update owner: KHZN
//		JsonArray applies = null;
		
		//遍历元素列表中所有AllOf元素
		for(Element allofElement : allofElementList)
		{
			//判断当前Allof元素下的Match元素是否为空
			//非空，进行下一步操作；空，返回错误信息
			if(allofElement.element("Match") != null)
			{
				//AllOf下各个元素信息作为json对象存放
				allof = new JsonObject();
				matchs = new JsonArray();
				
				//Match下的信息作为json数组存放，获取完数据后，放到Match标签下
				Match.getMatch(allofElement, matchs);
				allof.add("Match", matchs);
			} else
			{
				System.out.println("element 'Match' is null");
			}
			
//			//18.11 Update owner: KHZN
//			
//			//判断当前AllOf元素下的Apply元素是否为空
//			//非空，进行下一步操作；空，返回错误信息
//			if(allofElement.element("Apply") != null)
//			{
//				//AllOf下各个元素信息作为json对象存放
//				allof = new JsonObject();
//				applies = new JsonArray();
//				
//				//Apply下的信息作为json数据存放，获取完数据后，放到Apply标签下
//				Apply.getApply(allofElement, applies);
//				allof.add("Apply", applies);
//			}else 
//			{
//				//System.out.println("element 'Apply' is null");
//			}
			
			//将json对象加入到json数组中
			allofs.add(allof);
		}
		return allofs;
	}
}
