package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//AnyOf标签类
@SuppressWarnings("serial")
public class AnyOf implements Serializable
{
	private List<AllOf> AllOf;
	private int AllOfNum = 0;
	
	//获取标签AllOf中的所有信息，列表存储
	public List<AllOf> getAllOf()
	{
		return AllOf;
	}
	
	//设置标签AllOf
	public void setAllOf(List<AllOf> allOf)
	{
		this.AllOf = allOf;
	}
	
	//获取当前AnyOf下AllOf标签的数量
	public int getAllOfNum()
	{
		AllOfNum = 0;
		for(AllOf allof : AllOf)
			AllOfNum++;
		return AllOfNum;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "AnyOf:[{" + AllOf + "}]";
	}
}
