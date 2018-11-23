package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Match 
{
	//输入：AllOf元素位置、json数组（元素Match下的信息，空）
	//输出：json数组（元素Match下的信息）
	static JsonArray getMatch(Element allofElement, JsonArray matchs)
	{
		//定位到当前位置下的Match元素，Match元素可能存在多个，使用列表存放
		List<Element> matchElementList = allofElement.elements("Match");
		JsonObject match = null;
		
		//遍历元素列表中所有Match元素
		for(Element matchElement : matchElementList)
		{
			//Match下的各个元素或属性信息作为json对象存放
			match = new JsonObject();
			
			//获取当前Match元素中属性MatchId的值，并放标签MatchId下
			String matchId = matchElement.attributeValue("MatchId");
			match.addProperty("MatchId", matchId);

			//获取Match元素下AttributeValue元素的信息
			AttributeValue.getAttributeValue(matchElement, match);
			
			//获取Match元素下AttributeDesignator元素的信息
			AttributeDesignator.getAttributeDesignator(matchElement, match);
			
			//整合AttributeValue元素和AttributeDesignator元素的信息，获取数据json对象
			match = new JsonParser().parse(match.toString()).getAsJsonObject();
			//将json对象加入到json数组中
			matchs.add(match);
		}
		return matchs;
	}
}
