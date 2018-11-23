package org.pdp.decide;

import org.api.policyApi.Condition;
import org.api.policyApi.Policy;
import org.api.policyApi.Target;
import org.api.requestApi.Requests;

public class Overrides 
{
	//���룺Requests����������ݡ�Policy��Ĳ�������
	//�����boolean�����жϽ��
	static boolean permitFunction(Requests request, Policy policy)
	{ 
		int d = 0;
		//permitoverrides's default decide is true;
		boolean decide = true;
		boolean tdecide = false;
		Target target = null;
		Condition condition = null;
		
		//��ȡPolicy��ǩ��Rule��ǩ������
		int num = policy.getRuleNum();
		//����Policy��ǩ������Rule��ǩ
		for(int i = 0;i < num;i++) 
		{
			//18.11 Update issuer: KHZN ����Condition�Ⱦ��ж�
			
			condition = new Condition();
			try {
				condition = policy.getRule().get(i).getCondition().get(0);
				boolean CONDITION_DECISION = ConditionDecision.conditionDecide(request, condition);
				
				if(CONDITION_DECISION)
				{
					//��ȡ��Ӧ��Rule��ǩ��Target��ǩ����Ϣ
					target = new Target();
					target = policy.getRule().get(i).getTarget().get(0);
					
					//����Target��ǩ�µ���Ϣ�ж��Ƿ�ƥ���������ݿ��е���Ϣ��ƥ��ɹ�����true����֮false
					tdecide = TargetDecision.targetDecide(request, target);
				}
			}catch(Exception NullPointerException) {
				//��ȡ��Ӧ��Rule��ǩ��Target��ǩ����Ϣ
				target = new Target();
				target = policy.getRule().get(i).getTarget().get(0);
				
				//����Target��ǩ�µ���Ϣ�ж��Ƿ�ƥ���������ݿ��е���Ϣ��ƥ��ɹ�����true����֮false
				tdecide = TargetDecision.targetDecide(request, target);
			}
			
			//18.11 End
			
//			//��ȡ��Ӧ��Rule��ǩ��Target��ǩ����Ϣ
//			target = new Target();
//			target = policy.getRule().get(i).getTarget().get(0);
//			
//			//����Target��ǩ�µ���Ϣ�ж��Ƿ�ƥ���������ݿ��е���Ϣ��ƥ��ɹ�����true����֮false
//			boolean tdecide = TargetDecision.targetDecide(request, target);
//			
//			//����Rule��ǩ�µ�Effect��ǩ����Ϣ��ѡ���Ӧ���жϺ���
			switch(policy.getRule().get(i).getEffect())
			{
			//��EffectֵΪPermitʱ
			case "Permit":
				tdecide = Effect.permitFunction(tdecide);
				break;
			//��EffectֵΪDenyʱ
			case "Deny":
				tdecide = Effect.denyFunction(tdecide);
				break;
			default:
				System.out.println("Wrong Effect");
			}
			//ÿ��Rule�жϽ��ΪPermitʱ��tedecide==true����������+1
			if(tdecide)
				d++;
		}
		
		//only if all tdecide are false, the final decide returns false;
		if(d==0)
			decide = false;
		
		return decide;
	}
	
	
	
	//���룺Requests����������ݡ�Policy��Ĳ�������
	//�����boolean�����жϽ��
	static boolean denyFunction(Requests request, Policy policy)
	{
		int d = 0;
		//denyoverrides's default decide is false;
		boolean decide = false;
		boolean tdecide = false;
		Target target = null;
		Condition condition = null;
		
		//��ȡPolicy��ǩ��Rule��ǩ������
		int num = policy.getRuleNum();
		//����Policy��ǩ������Rule��ǩ
		for(int i=0; i<num; i++) 
		{
			//18.11 Update issuer: KHZN ����Condition�Ⱦ��ж�
			
			condition = new Condition();
			try {
				condition = policy.getRule().get(i).getCondition().get(0);
				boolean CONDITION_DECISION = ConditionDecision.conditionDecide(request, condition);
				
				if(CONDITION_DECISION)
				{
					//��ȡ��Ӧ��Rule��ǩ��Target��ǩ����Ϣ
					target = new Target();
					target = policy.getRule().get(i).getTarget().get(0);
					
					//����Target��ǩ�µ���Ϣ�ж��Ƿ�ƥ���������ݿ��е���Ϣ��ƥ��ɹ�����true����֮false
					tdecide = TargetDecision.targetDecide(request, target);
				}
			}catch(Exception NullPointerException) {
				//��ȡ��Ӧ��Rule��ǩ��Target��ǩ����Ϣ
				target = new Target();
				target = policy.getRule().get(i).getTarget().get(0);
				
				//����Target��ǩ�µ���Ϣ�ж��Ƿ�ƥ���������ݿ��е���Ϣ��ƥ��ɹ�����true����֮false
				tdecide = TargetDecision.targetDecide(request, target);
			}
			
			//18.11 End
			
//			//��ȡ��Ӧ��Rule��ǩ��Target��ǩ����Ϣ
//			target = new Target();
//			target = policy.getRule().get(i).getTarget().get(0);
//			
//			//����Target��ǩ�µ���Ϣ�ж��Ƿ�ƥ���������ݿ��е���Ϣ��ƥ��ɹ�����true����֮false
//			boolean tdecide = TargetDecision.targetDecide(request, target);
			
			//����Rule��ǩ�µ�Effect��ǩ����Ϣ��ѡ���Ӧ���жϺ���
			switch(policy.getRule().get(i).getEffect())
			{
			//��EffectֵΪPermitʱ
			case "Permit":
				tdecide = Effect.permitFunction(tdecide);
				break;
			//��EffectֵΪDenyʱ
			case "Deny":
				tdecide = Effect.denyFunction(tdecide);
				break;
			default:
				System.out.println("Wrong Effect");
			}
			//ÿ��Rule�жϽ��ΪDenyʱ��tedecide==false����������+1
			if(!tdecide)
				d++;
		}
		
		//only if all tdecide are true, the final decide returns true;
		if(d==0)
			decide = true;
		
		return decide;
	}
}
