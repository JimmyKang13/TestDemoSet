package org.pdp.decide;

import java.util.List;

import org.api.policyApi.Policies;
import org.api.policyApi.Policys;
import org.api.requestApi.Requests;

public class Response 
{
	//输入：Requests类的请求数据、Policys类的策略数据
	//输出：响应结果
	static String getResponse(Requests request, Policys policys)
	{
		//获取请求下的Policies标签的信息
		Policies policies = policys.getPolicies();
		
		//所要进项判断的策略中可能存在多个策略，所以使用列表存放判断结果
		List<String> decidelist = Permission.getPermission(request, policies);
		
		//将响应结果所在的列表转换为字符串
		String decide = decidelist.toString();

		return decide;
	}
}
