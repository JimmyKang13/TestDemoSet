package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Target��ǩ��
@SuppressWarnings("serial")
public class Target implements Serializable
{
	private List<AnyOf> AnyOf;
	private int AnyOfNum = 0;
	
	//��ȡ��ǩAnyOf�е�������Ϣ���б�洢
	public List<AnyOf> getAnyOf()
	{
		return AnyOf;
	}
	
	//���ñ�ǩAnyOf
	public void setAnyOf(List<AnyOf> anyOf)
	{
		this.AnyOf = anyOf;
	}
	
	//��ȡ��ǰTarget��AnyOf��ǩ������
	public int getAnyOfNum()
	{
		AnyOfNum = 0;
		for(AnyOf anyof : AnyOf)
			AnyOfNum++;
		return AnyOfNum;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "Target:[{" + AnyOf + "}]";
	}
}
