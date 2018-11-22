package org.api.requestApi;

import java.io.Serializable;

//Attribute类
@SuppressWarnings("serial")
public class Attribute implements Serializable
{
	private String Category;
	private String AttributeId;
	private String DataType;
	private String Value;
	
	//获取标签Category的信息
	public String getCategory()
	{
		return Category;
	}
	
	//设置标签Category
	public void setCategory(String Category)
	{
		this.Category = Category;
	}
	
	//获取标签AttributeId的信息
	public String getAttributeId()
	{
		return AttributeId;
	}
	
	//设置标签AttributeId
	public void setAttributeId(String AttributeId)
	{
		this.AttributeId = AttributeId;
	}
	
	//获取标签DataType的信息
	public String getDataType()
	{
		return DataType;
	}
	
	//设置标签DataType
	public void setDataType(String DataType)
	{
		this.DataType = DataType;
	}
	
	//获取标签Value的信息
	public String getValue() 
	{
		return Value;
	}
	
	//设置标签Value
	public void setValue(String Value)
	{
		this.Value = Value;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "Attribute:{" + "Category:" + Category + ",AttributeId:" + AttributeId + ",DataType:" + DataType + ",Value:" + Value + "}";
	}
}
