package org.pdp.decide;

import org.api.policyApi.AllOf;
import org.api.policyApi.AnyOf;
import org.api.requestApi.Requests;


public class AnyOfDecision 
{
	//输入：Requests类的请求数据、AnyOf类的策略数据
	//输出：boolean类型判断结果
	static boolean anyofDecide(Requests request, AnyOf anyof)
	{
		int d = 0;
		boolean decide = false;
		AllOf allof = null;
		
		//获取AnyOf标签下AllOf标签的数量
		int num = anyof.getAllOfNum();
		//遍历AnyOf标签下所有AllOf标签
		for(int i=0; i<num; i++)
		{
			//获取对应的AllOf标签的信息
			allof = new AllOf();
			allof = anyof.getAllOf().get(i);
			//获取AllOf标签下信息与请求数据块的匹配结果
			boolean adecide = AllOfDecision.allofDecide(request, allof);
			
			//每当AllOf标签匹配结果为true时，计数器+1
			if(adecide)
				d++;
		}
		
		//if the AllOf elements under AnyOf  have one element returns true, that AnyOf returns true;
		if(d>0)
			decide = true;
		//System.out.println(decide);
		return decide;
	}
}
