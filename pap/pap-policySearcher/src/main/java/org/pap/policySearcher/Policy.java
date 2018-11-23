package org.pap.policySearcher;

import java.util.List;

import org.dom4j.Element;

public class Policy 
{
	//输入：元素位置、PolicyId列表、策略寄存器（增加了标签policies）
	//输出：根据PolicyId获取对应的Policy信息（结尾未添加policies标签终止符）
	static StringBuffer getPolicy(Element policydataElement, List<String> policyIdList, StringBuffer policy)
	{
		//定位到当前元素下的Policy位置，由于可能存在多个Policy元素，使用列表形式存储
		List<Element> policyElementList = policydataElement.elements("Policy");
		
		//遍历PolicyId列表中所有PolicyId
		for(String policyId : policyIdList)
		{
			//遍历元素列表中所有Policy元素
			for(Element policyElement : policyElementList)
			{
				//获取当前Policy元素的属性PolicyId的值
				String id = policyElement.attributeValue("PolicyId");
				
				//判断PolicyId是否匹配
				//匹配成功，获取当前Policy元素所有信息，使用asXML函数转换为xml格式的字符串数据，存入策略寄存器中
				if(id.equals(policyId))
				{
					policy.append(policyElement.asXML() + "\n\t");
				}
			}
		}
		return policy;
	}
}
