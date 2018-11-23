package org.pap.policySearcher;

import java.util.List;

import org.api.requestApi.Requests;
import org.dom4j.Element;

public class PolicySet 
{
	//输入：元素位置、请求数据块、policyId列表
	//输出：policyId列表
	//p.s.：该函数存在多次自身调用
	static List<String> getPolicySet(Element policysetdataElement, Requests request, List<String> policyIdList)
	{
		//判断当前元素（policydataElement）下PolicySet元素是否为空
		if(policysetdataElement.element("PolicySet") != null)
		{
			//定位到当前元素下的PolicySet位置，由于可能存在多个PolicySet元素，使用列表形式存储
			List<Element> policysetElementList = policysetdataElement.elements("PolicySet");
			
			//遍历列表中所有PolicySet元素
			for(Element policysetElement : policysetElementList)
			{
				//判断当前位置PolicySet下的Target是否为空
				//若Target为空或不存在，表示直接进入下一级PolicySet或Policy，调用getPolicyset实现
				//若Target不为空，需要调用Match类的decide函数进行判断，获得boolean类型的判断结果，正确则调用getPolicySet进入下一级，反之结束当前位置操作
				if(policysetElement.element("Target") == null)
				{
					PolicySet.getPolicySet(policysetElement, request, policyIdList);
				}
				
				boolean decision = Match.decide(policysetElement, request);
				
				if(decision)
				{
					PolicySet.getPolicySet(policysetElement, request, policyIdList);
				}
			}
		}
		
		//判断当前元素（policydataElement）下Policy元素是否为空
		//当Policy存在时，需要获取其中的PolicyId并存入PolicyId列表中
		if(policysetdataElement.element("Policy") != null)
		{
			//定位到当前元素下的Policy位置，Policy元素可能存在多个，使用列表存储
			List<Element> policyElementList = policysetdataElement.elements("Policy");
			
			//遍历列表中所有Policy元素
			for(Element policyElement : policyElementList)
			{
				//获取Policy元素下PolicyId属性的值，并存入PolicyIdList列表中
				String policyId = policyElement.attributeValue("PolicyId");
				policyIdList.add(policyId);
			}
		}
		
		return policyIdList;
	}
}
