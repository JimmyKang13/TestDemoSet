package org.api.policyApi;

import java.io.Serializable;

//Match��
@SuppressWarnings("serial")
public class Match implements Serializable
{
	private String MatchId;
	private String Value;
	private String Category;
	private String AttributeId;
	private String DataType;
	
	//��ȡ��ǩMatchId����Ϣ
	public String getMatchId()
	{
		return MatchId;
	}
	
	//���ñ�ǩMatchId
	public void setMatchId(String MatchId) 
	{
		this.MatchId = MatchId;
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
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "Match:{" + "MatchId:" + MatchId + ",Value:" + Value + ",Category:" + Category + ",AttributeId:" + AttributeId + ",DataType:" + DataType +"}";
	}
}