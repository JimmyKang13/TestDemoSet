package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//AnyOf��ǩ��
@SuppressWarnings("serial")
public class AnyOf implements Serializable
{
	private List<AllOf> AllOf;
	private int AllOfNum = 0;
	
	//��ȡ��ǩAllOf�е�������Ϣ���б�洢
	public List<AllOf> getAllOf()
	{
		return AllOf;
	}
	
	//���ñ�ǩAllOf
	public void setAllOf(List<AllOf> allOf)
	{
		this.AllOf = allOf;
	}
	
	//��ȡ��ǰAnyOf��AllOf��ǩ������
	public int getAllOfNum()
	{
		AllOfNum = 0;
		for(AllOf allof : AllOf)
			AllOfNum++;
		return AllOfNum;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "AnyOf:[{" + AllOf + "}]";
	}
}
