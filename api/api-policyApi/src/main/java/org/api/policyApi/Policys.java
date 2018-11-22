package org.api.policyApi;

import java.io.Serializable;

//policy数据块的顶层类
@SuppressWarnings("serial")
public class Policys implements Serializable
{
	private Policies Policies;
	
	//获取标签Policies中的所有信息
	public Policies getPolicies()
	{
		return Policies;
	}
	
	//设置标签Policies
	public void setPolicies(Policies Policies)
	{
		this.Policies = Policies;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "{" + Policies + "}";
	}
}
