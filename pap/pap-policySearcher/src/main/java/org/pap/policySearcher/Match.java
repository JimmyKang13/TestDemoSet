package org.pap.policySearcher;

import org.api.equalFunction.IntEqual;
import org.api.equalFunction.StringEqual;
import org.api.requestApi.Attribute;
import org.api.requestApi.Requests;
import org.dom4j.Element;

public class Match 
{
	//输入：元素位置、请求数据块
	//输出：Boolean类型判断结果
	//此函数的目标是判断输入元素坐标下的Target元素中的数据是否能够匹配上请求数据块中的信息
	static boolean decide(Element policysetElement, Requests request)
	{
		boolean decision = false;
		
		//现阶段PolicySet下的Target元素下只存放一个属性信息，故直接定位到Match元素位置
		Element matchElement = policysetElement.element("Target").element("AnyOf").element("AllOf").element("Match");
		
		//获取Match元素的属性MatchId的值
		String matchId = matchElement.attributeValue("MatchId");
		
		//定位到Match元素下的AttributeValue元素，获取其内容（value）
		Element valueElement = matchElement.element("AttributeValue");
		String value = valueElement.getTextTrim();
		
		//定位到Match元素下的AttributeDesignator元素，获取其属性Category、AttributeId和DataType的值
		Element designatorElement = matchElement.element("AttributeDesignator");
		String category = designatorElement.attributeValue("Category");
		String attributeId = designatorElement.attributeValue("AttributeId");
		String dataType = designatorElement.attributeValue("DataType");
		
		//获取请求数据块中Request标签下Attribute标签的数量
		int num = request.getRequest().getAttributeNum();
		//遍历所有Attribute标签，循环次数为Attribute标签的数量
		for(int i=0; i<num; i++)
		{
			//获取Attribute标签的信息
			Attribute attribute = new Attribute();
			attribute = request.getRequest().getAttribute().get(i);
			
			//获取Attribute标签的属性Category、AttributeId、DataType和Value的值
			String reqcategory = attribute.getCategory();
			String reqattributeId = attribute.getAttributeId();
			String reqdataType = attribute.getDataType();
			String reqvalue = attribute.getValue();
			
			//判断Category的值是否匹配
			if(reqcategory.equals(category))
			{
				//判断AttribtueId的值是否匹配
				if(reqattributeId.equals(attributeId))
				{
					//判断DataType的值是否匹配
					if(reqdataType.equals(dataType))
					{
						//根据MatchId的值，选择对应的匹配函数，获取判断结果
						switch(matchId)
						{
						case"string-equal":
							decision = new StringEqual().stringEqual(reqvalue, value);
							break;
						case"int-equal":
							decision = new IntEqual().intEqual(reqvalue, value);
							break;
						default:
							System.out.println("Wrong MatchId");
						}
					}
				}
			}
			//一旦匹配成功，跳出for循环，避免无用过程
			if(decision)
				break;
		}
		
		return decision;
	}
}
