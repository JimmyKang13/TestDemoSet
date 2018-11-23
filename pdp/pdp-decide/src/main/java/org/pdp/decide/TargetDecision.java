package org.pdp.decide;

import org.api.policyApi.AnyOf;
import org.api.policyApi.Target;
import org.api.requestApi.Requests;

public class TargetDecision 
{
	//输入：Requests类的请求数据、Target类的策略数据
	//输出：boolean类型判断结果
	static boolean targetDecide(Requests request, Target target)
	{
		int d = 0;
		boolean decide = false;
		AnyOf anyof = null;
		
		//获取Target标签下AnyOf标签的数量
		int num = target.getAnyOfNum();
		//遍历Target标签下所有AnyOf标签
		for(int i=0; i<num; i++) 
		{
			//获取对应的AnyOf标签的信息
			anyof = new AnyOf();
			anyof = target.getAnyOf().get(i);
			//获取AnyOf标签下信息与请求数据块的匹配结果
			boolean adecide = AnyOfDecision.anyofDecide(request, anyof);
			
			//每当AnyOf标签匹配结果为true时，计数器+1
			if(adecide)
				d++;
		}
		
		//Target's AnyOfs should be all true, the decide could return true;
		if(d==target.getAnyOfNum())
			decide = true;
		
		return decide;
	}
}
