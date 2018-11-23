package org.pdp.decide;

import org.api.policyApi.AllOf;
import org.api.policyApi.Match;
import org.api.requestApi.Requests;

public class AllOfDecision 
{
	//输入：Requests类的请求数据、AllOf类的策略数据
	//输出：boolean类型判断结果
	static boolean allofDecide(Requests request, AllOf allof)
	{	
		int d = 0;
		boolean decide = false;
		Match match = null;
		
		//获取AllOf标签下Match标签的数量
		int num = allof.getMatchNum();
//		System.out.println(num);
		//遍历AllOf标签下所有Match标签
		for(int i=0; i<num; i++)
		{
			//获取对应的Match标签的信息
			match = new Match();
			match = allof.getMatch().get(i);
			//获取Match标签下信息与请求数据块的匹配结果
			boolean adecide = MatchDecision.matchDecide(request, match);
			
			//每当Match标签匹配结果为true时，计数器+1
			if(adecide)
				d++;
		}
		
		//only all Match elements under AllOf have matched and return true, that AllOf element returns true;
		if(d==allof.getMatchNum())
			decide = true;
		//System.out.println(decide);
		return decide;
	}
}
