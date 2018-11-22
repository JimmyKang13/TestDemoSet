package org.api.requestApi;

import java.io.Serializable;
import java.util.List;

//Request标签类
@SuppressWarnings("serial")
public class Request implements Serializable
{
	private List<Attribute> Attribute;
	private int AttributeNum = 0;
	
	//获取标签Attribute中的所有信息，列表存储
	public List<Attribute> getAttribute()
	{
		return Attribute;
	}
	
	//设置标签Attribute
	public void setAttribute(List<Attribute> Attribute)
	{
		this.Attribute = Attribute;
	}
	
	//获取Request下Attribute标签的数量
	public int getAttributeNum()
	{
		AttributeNum = 0;
		for(Attribute attribute : Attribute)
		{
			AttributeNum++;
		}
		return AttributeNum;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "Request:{" + Attribute + "}";
	}
}
