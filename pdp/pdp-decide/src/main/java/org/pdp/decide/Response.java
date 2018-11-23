package org.pdp.decide;

import java.util.List;

import org.api.policyApi.Policies;
import org.api.policyApi.Policys;
import org.api.requestApi.Requests;

public class Response 
{
	//���룺Requests����������ݡ�Policys��Ĳ�������
	//�������Ӧ���
	static String getResponse(Requests request, Policys policys)
	{
		//��ȡ�����µ�Policies��ǩ����Ϣ
		Policies policies = policys.getPolicies();
		
		//��Ҫ�����жϵĲ����п��ܴ��ڶ�����ԣ�����ʹ���б����жϽ��
		List<String> decidelist = Permission.getPermission(request, policies);
		
		//����Ӧ������ڵ��б�ת��Ϊ�ַ���
		String decide = decidelist.toString();

		return decide;
	}
}
