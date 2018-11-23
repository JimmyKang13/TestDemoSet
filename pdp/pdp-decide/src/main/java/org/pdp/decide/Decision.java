package org.pdp.decide;

import org.api.policyApi.Policys;
import org.api.requestApi.Requests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Decision 
{
//	public boolean decide(JsonObject requestjson, JsonObject policyjson)
//	{
//		boolean decide;
//		
//		String requestfile = requestjson.toString();
//		String policyfile = policyjson.toString();
//		
//		Requests request = new Gson().fromJson(requestfile, Requests.class);
//		Policys policys = new Gson().fromJson(policyfile, Policys.class);
//		
//		decide = Permission.getPermission(request, policys);
//		
//		return decide;
//	}
	
	//输入：请求数据块、策略数据块
	//输出：响应结果
	public String decide(JsonObject requestjson, JsonObject policyjson)
	{
		//将请求数据块和策略数据块中的信息转换成字符串
		String requestfile = requestjson.toString();
		String policyfile = policyjson.toString();
		
		//使用编写好的Requests类和Policy类分别对json格式的数据块定义
		Requests request = new Gson().fromJson(requestfile, Requests.class);
		Policys policys = new Gson().fromJson(policyfile, Policys.class);
		
		//调用获取响应信息的函数，获取响应
		String decide = Response.getResponse(request, policys);
		
		return decide;
	}
}
