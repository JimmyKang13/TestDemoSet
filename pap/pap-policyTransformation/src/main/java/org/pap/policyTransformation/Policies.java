package org.pap.policyTransformation;

import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Policies 
{
	//输入：策略文档、json对象（元素policies下的信息，空）
	//输出：json对象（元素policies下的信息）
	static JsonObject getPolicies(Document document, JsonObject policiesinfo)
	{
		//定位到文档根元素
		Element policiesElement = document.getRootElement();
		JsonArray policies = null;
		
		//判断根元素下Policy元素是否为空
		//非空，进行下一步操作；空，返回错误信息
		if(policiesElement.element("Policy") != null)
		{
			//Policy下的信息使用json数组存放，获取完数据后，将数据数组放到Policy标签下
			policies = new JsonArray();
			
			Policy.getPolicy(policiesElement, policies);
			policiesinfo.add("Policy", policies);
		} else
		{
			System.out.println("element 'Policy' is null");
		}
		return policiesinfo;
	}
}
