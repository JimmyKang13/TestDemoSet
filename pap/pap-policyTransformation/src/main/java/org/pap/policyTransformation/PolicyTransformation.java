package org.pap.policyTransformation;

import java.io.IOException;
import java.io.PrintWriter;

import org.dom4j.DocumentException;

import com.google.gson.JsonObject;

public class PolicyTransformation 
{
	//输入：策略文档的路径
	//输出：策略数据块（.json）
	public static JsonObject transformPolicy(String policyPath) throws IOException, DocumentException
	{
		JsonObject object = new JsonObject();
		GenerateMethod.PolicyToJsonMethod(object, policyPath);
		
//		String policyjson = object.toString();
//		
//		PrintWriter pw = new PrintWriter("src/main/resources/policy-condition.json");
//		pw.print(policyjson);
//		pw.flush();
//		pw.close();
		return object;
	}
}
