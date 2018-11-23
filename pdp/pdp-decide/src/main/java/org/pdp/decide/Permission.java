package org.pdp.decide;

import java.util.ArrayList;
import java.util.List;

import org.api.policyApi.Policies;
import org.api.policyApi.Policy;
import org.api.requestApi.Requests;

public class Permission 
{
//	static boolean getPermission(Requests request, Policies policies)
//	{
//		boolean decide;
//		
//		Policy policy = policies.getPolicy();
//		
//		switch(policy.getRuleCombiningAlgId()) 
//		{
//		case "deny-overrides":
//			decide = Overrides.denyFunction(request, policy);
//			break;
//		
//		case "permit-overrides":
//			decide = Overrides.permitFunction(request, policy);
//			break;
//		
//		default:
//			decide = false;
//			System.out.println("Wrong RuleCombiningAlgId");
//		}
//
//		return decide;
//	}
	
	//输入：Requests类的请求数据、Policies类的策略数据
	//输出：响应结果（list）
	static List<String> getPermission(Requests request, Policies policies)
	{
		boolean decide;
		//获取Policies标签下Policy标签的数量
		int num = policies.getPolicyNum();
		List<String> decidelist = new ArrayList<>();
		
		//遍历Policies标签下所有Policy标签
		for(int i=0; i<num; i++)
		{
			//获取对应的Policy标签的信息
			Policy policy = policies.getPolicy().get(i);
			
			//根据当前Policy标签下的RuleCombiningAlgId标签的值，选择对应的覆盖函数
			switch(policy.getRuleCombiningAlgId()) 
			{
			//拒绝优先覆盖
			case "deny-overrides":
				decide = Overrides.denyFunction(request, policy);
				break;
			
			//允许优先覆盖
			case "permit-overrides":
				decide = Overrides.permitFunction(request, policy);
				break;
			
			//当不满足上述值时，说明RuleCombiningAlgId的值存在错误，判断结果为拒绝并输出错误信息
			default:
				decide = false;
				System.out.println("Wrong RuleCombiningAlgId");
			}
	
			//响应结果为【PolicyId+Boolean类型判断结果】的格式，由于存在多个策略进行判断，存放到列表中
			String decidestring = policy.getPolicyId() + "\t" +decide;
			decidelist.add(decidestring);
		}
		return decidelist;
	}
}
