package org.api.requestApi;

import java.io.Serializable;
import java.util.List;

//Request��ǩ��
@SuppressWarnings("serial")
public class Request implements Serializable
{
	private List<Attribute> Attribute;
	private int AttributeNum = 0;
	
	//��ȡ��ǩAttribute�е�������Ϣ���б�洢
	public List<Attribute> getAttribute()
	{
		return Attribute;
	}
	
	//���ñ�ǩAttribute
	public void setAttribute(List<Attribute> Attribute)
	{
		this.Attribute = Attribute;
	}
	
	//��ȡRequest��Attribute��ǩ������
	public int getAttributeNum()
	{
		AttributeNum = 0;
		for(Attribute attribute : Attribute)
		{
			AttributeNum++;
		}
		return AttributeNum;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "Request:{" + Attribute + "}";
	}
}
