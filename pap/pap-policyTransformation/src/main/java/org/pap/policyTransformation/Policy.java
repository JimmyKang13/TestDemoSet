package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Policy 
{
//	static JsonObject getPolicy(Document document, JsonObject policyinfo)
	
	//输入：根元素位置、json数组（元素Policy下的信息，空）
	//输出：json数组（元素Policy下的信息）
	static JsonArray getPolicy(Element policiesElement, JsonArray policies)
	{
//		Element policyElement = document.getRootElement();
//		JsonArray rules = null;
//		
//		String policyId = policyElement.attributeValue("PolicyId");
//		policyinfo.addProperty("PolicyId", policyId);
//		
//		String ruleCombiningAlgId = policyElement.attributeValue("RuleCombiningAlgId");
//		policyinfo.addProperty("RuleCombiningAlgId", ruleCombiningAlgId);
//		
//		if(policyElement.element("Rule") != null)
//		{
//			rules = new JsonArray();
//			
//			Rule.getRule(policyElement, rules);
//			
//			policyinfo.add("Rule", rules);
//		} else
//		{
//			System.out.println("element 'Rule' is null");
//		}
		
		//定位到当前位置下的Policy元素，Policy元素可能存在多个，使用列表存放
		List<Element> policyElementList = policiesElement.elements("Policy");
		JsonObject policy = null;
		JsonArray rules = null;
		
		//遍历元素列表中所有Policy元素
		for(Element policyElement : policyElementList) 
		{
			//Policy下各个元素或属性信息作为json对象存放
			policy = new JsonObject();
			
			//获取当前Policy元素中属性PolicyId的值，并放到标签PolicyId下
			String policyId = policyElement.attributeValue("PolicyId");
			policy.addProperty("PolicyId", policyId);
			
			//获取当前Policy元素中属性RuleCombiningAlgId的值，并放到标签RuleCombiningAlgId下
			String ruleCombiningAlgId = policyElement.attributeValue("RuleCombiningAlgId");
			policy.addProperty("RuleCombiningAlgId", ruleCombiningAlgId);
			
			rules = new JsonArray();
			
			//判断当前Policy元素下的Rule元素是否为空
			//非空，进行下一步操作；空，返回错误信息
			if(policyElement.element("Rule") != null)
			{
				//Rule下的信息作为json数组存放，获取完数据后，放到Rule标签下
				Rule.getRule(policyElement, rules);
				policy.add("Rule", rules);
			} else
			{
				System.out.println("element 'Rule' is null");
			}
			
			//将json对象加入到json数组中
			policies.add(policy);
		}
		return policies;
	}
}
