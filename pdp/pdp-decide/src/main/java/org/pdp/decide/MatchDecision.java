package org.pdp.decide;

import org.api.policyApi.Match;
import org.api.requestApi.Attribute;
import org.api.requestApi.Requests;
import org.api.equalFunction.*;


public class MatchDecision 
{
	//输入：Requests类的请求数据、Match类的策略数据
	//输出：boolean类型判断结果
	static boolean matchDecide(Requests request, Match match)
	{
		boolean decide = false;
		//获取Match标签下Category、AttributeId、DataType、MatchId、Value标签的值
		String category = match.getCategory();
		String attributeId = match.getAttributeId();
		String dataType = match.getDataType();
		String matchId = match.getMatchId();
		String value = match.getValue();
		
		//获取Request标签下Attribute标签的数量
		int num = request.getRequest().getAttributeNum();
		//遍历Request标签下所有Attribute标签
		for(int i=0; i<num; i++)
		{
			//获取对应的Attribute标签的信息
			Attribute attribute = new Attribute();
			attribute = request.getRequest().getAttribute().get(i);
			
			//获取Attribute标签下Category、AttributeId、DataType、Value标签的值
			String reqcategory = attribute.getCategory();
			String reqattributeId = attribute.getAttributeId();
			String reqdataType = attribute.getDataType();
			String reqvalue = attribute.getValue();
			
			//判断Category标签的值是否匹配
			if(reqcategory.equals(category))
			{
				//判断AttributeId标签的值是否匹配
				if(reqattributeId.equals(attributeId)) 
				{
					//判断DataType标签的值是否匹配
					if(reqdataType.equals(dataType))
					{
						//根据MatchId标签的值，选择对应的匹配函数，获取判断结果
						switch(matchId)
						{
						case"string-equal":
							decide = new StringEqual().stringEqual(reqvalue, value);
							break;
						case"int-equal":
							decide = new IntEqual().intEqual(reqvalue, value);
							break;
						default:
							System.out.println("Wrong MatchId");
						}
					}
				}
			}
			//一旦匹配成功，跳出for循环，避免无用过程
			if(decide)
				break;
		}
		//System.out.println(result);
		return decide;
	}
}
