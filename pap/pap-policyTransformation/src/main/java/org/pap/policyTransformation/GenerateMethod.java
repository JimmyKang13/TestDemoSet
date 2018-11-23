package org.pap.policyTransformation;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.google.gson.JsonObject;

public class GenerateMethod 
{
	//输入：json对象（用于存放策略shuju）、策略文档路径
	//输出：策略数据块
	static JsonObject PolicyToJsonMethod(JsonObject object, String policyPath) throws DocumentException
	{
//		JsonObject policyinfo = new JsonObject();
		JsonObject policiesinfo = new JsonObject();
		
		//获取所给路径对应的文档
		SAXReader reader = new SAXReader();
		Document document = reader.read(policyPath);
		
//		Policy.getPolicy(document, policyinfo);
		Policies.getPolicies(document, policiesinfo);
		
		//将获得的数据存放到Policies标签下
//		object.add("Policy", policyinfo);
		object.add("Policies", policiesinfo);
		
		return object;
	}
}
