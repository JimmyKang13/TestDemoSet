package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Rule 
{
	//输入：Policy元素位置、json数组（元素Rule下的信息，空）
	//输出：json数组（元素Rule下的信息）
	static JsonArray getRule(Element policyElement, JsonArray rules)
	{
		//定位到当前位置下的Rule元素，Rule元素可能存在多个，使用列表存放
		List<Element> ruleElementList = policyElement.elements("Rule");
		JsonObject rule = null;
		JsonArray targets = null;
		//18.11.7 Update owner: KHZN
		JsonArray conditions = null;
		
		//遍历元素列表中所有Rule元素
		for(Element ruleElement : ruleElementList)
		{
			//Rule下各个元素或属性信息作为json对象存放
			rule = new JsonObject();
			
			//获取当前Rule元素中属性Effect的值，并放到标签Effect下
			String effect = ruleElement.attributeValue("Effect");
			rule.addProperty("Effect", effect);
			
			//获取当前Rule元素中属性RuleId的值，并放到标签RuleId下
			String ruleId = ruleElement.attributeValue("RuleId");
			rule.addProperty("RuleId", ruleId);
			
			targets = new JsonArray();
			
			//判断当前Rule元素下的Target元素是否为空
			//非空，进行下一步操作；空，返回错误信息
			if(ruleElement.element("Target") != null)
			{
				//Target下的信息作为json数组存放，获取完数据后，放到Target标签下
				Target.getTarget(ruleElement, targets);
				rule.add("Target", targets);
			} else
			{
				System.out.println("element 'Target' is null");
			}
			
			//18.11 Update owner: KHZN
			
			conditions = new JsonArray();
			
			//判断当前Rule元素下的Condition元素是否为空
			//非空，进行下一步操作；空，返回错误信息
			if(ruleElement.element("Condition") != null)
			{
				//Condition下的信息作为json数组存放，获取完数据后，放到Condition标签下
				Condition.getCondition(ruleElement, conditions);
				rule.add("Condition", conditions);
			} else
			{
				System.out.println("element 'Condition' is null");
			}
			
			//将json对象加入到json数组中
			rules.add(rule);
		}
		return rules;
	}
}
