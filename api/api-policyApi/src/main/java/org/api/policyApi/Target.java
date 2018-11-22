package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Target标签类
@SuppressWarnings("serial")
public class Target implements Serializable
{
	private List<AnyOf> AnyOf;
	private int AnyOfNum = 0;
	
	//获取标签AnyOf中的所有信息，列表存储
	public List<AnyOf> getAnyOf()
	{
		return AnyOf;
	}
	
	//设置标签AnyOf
	public void setAnyOf(List<AnyOf> anyOf)
	{
		this.AnyOf = anyOf;
	}
	
	//获取当前Target下AnyOf标签的数量
	public int getAnyOfNum()
	{
		AnyOfNum = 0;
		for(AnyOf anyof : AnyOf)
			AnyOfNum++;
		return AnyOfNum;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "Target:[{" + AnyOf + "}]";
	}
}
