package org.api.policyApi;

import java.io.Serializable;
import java.util.List;

//Policies��ǩ��
@SuppressWarnings("serial")
public class Policies implements Serializable
{
	private List<Policy> Policy;
	private int PolicyNum;
	
	//��ȡ��ǩPolicy��������Ϣ���б�洢
	public List<Policy> getPolicy()
	{
		return Policy;
	}
	
	//���ñ�ǩPolicy
	public void setPolicy(List<Policy> Policy)
	{
		this.Policy = Policy;
	}
	
	//��ȡ��ǰPolicies��Policy��ǩ������
	public int getPolicyNum()
	{
		PolicyNum = 0;
		for(Policy policy : Policy)
			PolicyNum++;
		return PolicyNum;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "{" + Policy + "}";
	}
}
