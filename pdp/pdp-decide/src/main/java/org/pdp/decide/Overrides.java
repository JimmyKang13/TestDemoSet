package org.pdp.decide;

import org.api.policyApi.Condition;
import org.api.policyApi.Policy;
import org.api.policyApi.Target;
import org.api.requestApi.Requests;

public class Overrides 
{
	//输入：Requests类的请求数据、Policy类的策略数据
	//输出：boolean类型判断结果
	static boolean permitFunction(Requests request, Policy policy)
	{ 
		int d = 0;
		//permitoverrides's default decide is true;
		boolean decide = true;
		boolean tdecide = false;
		Target target = null;
		Condition condition = null;
		
		//获取Policy标签下Rule标签的数量
		int num = policy.getRuleNum();
		//遍历Policy标签下所有Rule标签
		for(int i = 0;i < num;i++) 
		{
			//18.11 Update issuer: KHZN 增加Condition先决判断
			
			condition = new Condition();
			try {
				condition = policy.getRule().get(i).getCondition().get(0);
				boolean CONDITION_DECISION = ConditionDecision.conditionDecide(request, condition);
				
				if(CONDITION_DECISION)
				{
					//获取对应的Rule标签下Target标签的信息
					target = new Target();
					target = policy.getRule().get(i).getTarget().get(0);
					
					//根据Target标签下的信息判断是否匹配请求数据块中的信息，匹配成功返回true，反之false
					tdecide = TargetDecision.targetDecide(request, target);
				}
			}catch(Exception NullPointerException) {
				//获取对应的Rule标签下Target标签的信息
				target = new Target();
				target = policy.getRule().get(i).getTarget().get(0);
				
				//根据Target标签下的信息判断是否匹配请求数据块中的信息，匹配成功返回true，反之false
				tdecide = TargetDecision.targetDecide(request, target);
			}
			
			//18.11 End
			
//			//获取对应的Rule标签下Target标签的信息
//			target = new Target();
//			target = policy.getRule().get(i).getTarget().get(0);
//			
//			//根据Target标签下的信息判断是否匹配请求数据块中的信息，匹配成功返回true，反之false
//			boolean tdecide = TargetDecision.targetDecide(request, target);
//			
//			//根据Rule标签下的Effect标签的信息，选择对应的判断函数
			switch(policy.getRule().get(i).getEffect())
			{
			//当Effect值为Permit时
			case "Permit":
				tdecide = Effect.permitFunction(tdecide);
				break;
			//当Effect值为Deny时
			case "Deny":
				tdecide = Effect.denyFunction(tdecide);
				break;
			default:
				System.out.println("Wrong Effect");
			}
			//每当Rule判断结果为Permit时（tedecide==true），计数器+1
			if(tdecide)
				d++;
		}
		
		//only if all tdecide are false, the final decide returns false;
		if(d==0)
			decide = false;
		
		return decide;
	}
	
	
	
	//输入：Requests类的请求数据、Policy类的策略数据
	//输出：boolean类型判断结果
	static boolean denyFunction(Requests request, Policy policy)
	{
		int d = 0;
		//denyoverrides's default decide is false;
		boolean decide = false;
		boolean tdecide = false;
		Target target = null;
		Condition condition = null;
		
		//获取Policy标签下Rule标签的数量
		int num = policy.getRuleNum();
		//遍历Policy标签下所有Rule标签
		for(int i=0; i<num; i++) 
		{
			//18.11 Update issuer: KHZN 增加Condition先决判断
			
			condition = new Condition();
			try {
				condition = policy.getRule().get(i).getCondition().get(0);
				boolean CONDITION_DECISION = ConditionDecision.conditionDecide(request, condition);
				
				if(CONDITION_DECISION)
				{
					//获取对应的Rule标签下Target标签的信息
					target = new Target();
					target = policy.getRule().get(i).getTarget().get(0);
					
					//根据Target标签下的信息判断是否匹配请求数据块中的信息，匹配成功返回true，反之false
					tdecide = TargetDecision.targetDecide(request, target);
				}
			}catch(Exception NullPointerException) {
				//获取对应的Rule标签下Target标签的信息
				target = new Target();
				target = policy.getRule().get(i).getTarget().get(0);
				
				//根据Target标签下的信息判断是否匹配请求数据块中的信息，匹配成功返回true，反之false
				tdecide = TargetDecision.targetDecide(request, target);
			}
			
			//18.11 End
			
//			//获取对应的Rule标签下Target标签的信息
//			target = new Target();
//			target = policy.getRule().get(i).getTarget().get(0);
//			
//			//根据Target标签下的信息判断是否匹配请求数据块中的信息，匹配成功返回true，反之false
//			boolean tdecide = TargetDecision.targetDecide(request, target);
			
			//根据Rule标签下的Effect标签的信息，选择对应的判断函数
			switch(policy.getRule().get(i).getEffect())
			{
			//当Effect值为Permit时
			case "Permit":
				tdecide = Effect.permitFunction(tdecide);
				break;
			//当Effect值为Deny时
			case "Deny":
				tdecide = Effect.denyFunction(tdecide);
				break;
			default:
				System.out.println("Wrong Effect");
			}
			//每当Rule判断结果为Deny时（tedecide==false），计数器+1
			if(!tdecide)
				d++;
		}
		
		//only if all tdecide are true, the final decide returns true;
		if(d==0)
			decide = true;
		
		return decide;
	}
}
