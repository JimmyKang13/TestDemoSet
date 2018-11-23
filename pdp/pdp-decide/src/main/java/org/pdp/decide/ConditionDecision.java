//18.11 Update issuer: KHZN

package org.pdp.decide;

import org.api.policyApi.AnyOf;
import org.api.policyApi.Condition;
import org.api.requestApi.Requests;

public class ConditionDecision 
{
	//输入：Requests类的请求数据、Target类的策略数据
	//输出：boolean类型判断结果
	static boolean conditionDecide(Requests request, Condition condition)
	{
		int DECISION_NUM = 0;
		boolean decide = false;
		AnyOf anyof = null;
		
		//获取Condition标签下AnyOf标签的数量
		int ANYOF_NUM = condition.getAnyOfNum();
		//遍历Condition标签下所有AnyOf标签
		for(int i=0; i<ANYOF_NUM; i++)
		{
			//获取对应的AnyOf标签的信息
			anyof = new AnyOf();
			anyof = condition.getAnyOf().get(i);
			//获取AnyOf标签下信息与请求数据块的匹配结果
			boolean ANYOF_DECISION = AnyOfDecision.anyofDecide(request, anyof);
			
			//每当AnyOf标签匹配结果为true时，计数器+1
			if(ANYOF_DECISION)
				DECISION_NUM++;
		}
		
		//只有当Condition下的所有AnyOf标签都为true时，该Condition的判断结果为true
		if(DECISION_NUM==condition.getAnyOfNum())
			decide = true;
		
		return decide;
	}
}
