package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Policies标签类
@SuppressWarnings("serial")
public class Policies implements Serializable
{
	private List<Policy> Policy;
	private int PolicyNum;
	
	//获取标签Policy中所有信息，列表存储
	public List<Policy> getPolicy()
	{
		return Policy;
	}
	
	//设置标签Policy
	public void setPolicy(List<Policy> Policy)
	{
		this.Policy = Policy;
	}
	
	//获取当前Policies下Policy标签的数量
	public int getPolicyNum()
	{
		PolicyNum = 0;
		for(Policy policy : Policy)
			PolicyNum++;
		return PolicyNum;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "{" + Policy + "}";
	}
}
