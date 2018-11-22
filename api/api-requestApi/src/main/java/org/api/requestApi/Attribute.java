package org.api.requestApi;

import java.io.Serializable;

//Attribute��
@SuppressWarnings("serial")
public class Attribute implements Serializable
{
	private String Category;
	private String AttributeId;
	private String DataType;
	private String Value;
	
	//��ȡ��ǩCategory����Ϣ
	public String getCategory()
	{
		return Category;
	}
	
	//���ñ�ǩCategory
	public void setCategory(String Category)
	{
		this.Category = Category;
	}
	
	//��ȡ��ǩAttributeId����Ϣ
	public String getAttributeId()
	{
		return AttributeId;
	}
	
	//���ñ�ǩAttributeId
	public void setAttributeId(String AttributeId)
	{
		this.AttributeId = AttributeId;
	}
	
	//��ȡ��ǩDataType����Ϣ
	public String getDataType()
	{
		return DataType;
	}
	
	//���ñ�ǩDataType
	public void setDataType(String DataType)
	{
		this.DataType = DataType;
	}
	
	//��ȡ��ǩValue����Ϣ
	public String getValue() 
	{
		return Value;
	}
	
	//���ñ�ǩValue
	public void setValue(String Value)
	{
		this.Value = Value;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "Attribute:{" + "Category:" + Category + ",AttributeId:" + AttributeId + ",DataType:" + DataType + ",Value:" + Value + "}";
	}
}
