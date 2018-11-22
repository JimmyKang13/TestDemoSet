//18.11 Update owner: KHZN

package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Condition��ǩ��
@SuppressWarnings("serial")
public class Condition implements Serializable
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
	
	//��ȡ��ǰCondition��AnyOf��ǩ������
	public int getAnyOfNum()
	{
		AnyOfNum = 0;
		for(AnyOf anyOf : AnyOf)
			AnyOfNum++;
		return AnyOfNum;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "Condition:[{" + AnyOf + "}]";
	}
}
