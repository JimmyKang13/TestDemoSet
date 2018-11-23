package org.pdp.decide;

import java.util.ArrayList;
import java.util.List;

import org.api.policyApi.Policies;
import org.api.policyApi.Policy;
import org.api.requestApi.Requests;

public class Permission 
{
//	static boolean getPermission(Requests request, Policies policies)
//	{
//		boolean decide;
//		
//		Policy policy = policies.getPolicy();
//		
//		switch(policy.getRuleCombiningAlgId()) 
//		{
//		case "deny-overrides":
//			decide = Overrides.denyFunction(request, policy);
//			break;
//		
//		case "permit-overrides":
//			decide = Overrides.permitFunction(request, policy);
//			break;
//		
//		default:
//			decide = false;
//			System.out.println("Wrong RuleCombiningAlgId");
//		}
//
//		return decide;
//	}
	
	//���룺Requests����������ݡ�Policies��Ĳ�������
	//�������Ӧ�����list��
	static List<String> getPermission(Requests request, Policies policies)
	{
		boolean decide;
		//��ȡPolicies��ǩ��Policy��ǩ������
		int num = policies.getPolicyNum();
		List<String> decidelist = new ArrayList<>();
		
		//����Policies��ǩ������Policy��ǩ
		for(int i=0; i<num; i++)
		{
			//��ȡ��Ӧ��Policy��ǩ����Ϣ
			Policy policy = policies.getPolicy().get(i);
			
			//���ݵ�ǰPolicy��ǩ�µ�RuleCombiningAlgId��ǩ��ֵ��ѡ���Ӧ�ĸ��Ǻ���
			switch(policy.getRuleCombiningAlgId()) 
			{
			//�ܾ����ȸ���
			case "deny-overrides":
				decide = Overrides.denyFunction(request, policy);
				break;
			
			//�������ȸ���
			case "permit-overrides":
				decide = Overrides.permitFunction(request, policy);
				break;
			
			//������������ֵʱ��˵��RuleCombiningAlgId��ֵ���ڴ����жϽ��Ϊ�ܾ������������Ϣ
			default:
				decide = false;
				System.out.println("Wrong RuleCombiningAlgId");
			}
	
			//��Ӧ���Ϊ��PolicyId+Boolean�����жϽ�����ĸ�ʽ�����ڴ��ڶ�����Խ����жϣ���ŵ��б���
			String decidestring = policy.getPolicyId() + "\t" +decide;
			decidelist.add(decidestring);
		}
		return decidelist;
	}
}
