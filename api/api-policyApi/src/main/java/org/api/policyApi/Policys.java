package org.api.policyApi;

import java.io.Serializable;

//policy���ݿ�Ķ�����
@SuppressWarnings("serial")
public class Policys implements Serializable
{
	private Policies Policies;
	
	//��ȡ��ǩPolicies�е�������Ϣ
	public Policies getPolicies()
	{
		return Policies;
	}
	
	//���ñ�ǩPolicies
	public void setPolicies(Policies Policies)
	{
		this.Policies = Policies;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "{" + Policies + "}";
	}
}
