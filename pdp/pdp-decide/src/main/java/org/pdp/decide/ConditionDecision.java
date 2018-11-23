//18.11 Update issuer: KHZN

package org.pdp.decide;

import org.api.policyApi.AnyOf;
import org.api.policyApi.Condition;
import org.api.requestApi.Requests;

public class ConditionDecision 
{
	//���룺Requests����������ݡ�Target��Ĳ�������
	//�����boolean�����жϽ��
	static boolean conditionDecide(Requests request, Condition condition)
	{
		int DECISION_NUM = 0;
		boolean decide = false;
		AnyOf anyof = null;
		
		//��ȡCondition��ǩ��AnyOf��ǩ������
		int ANYOF_NUM = condition.getAnyOfNum();
		//����Condition��ǩ������AnyOf��ǩ
		for(int i=0; i<ANYOF_NUM; i++)
		{
			//��ȡ��Ӧ��AnyOf��ǩ����Ϣ
			anyof = new AnyOf();
			anyof = condition.getAnyOf().get(i);
			//��ȡAnyOf��ǩ����Ϣ���������ݿ��ƥ����
			boolean ANYOF_DECISION = AnyOfDecision.anyofDecide(request, anyof);
			
			//ÿ��AnyOf��ǩƥ����Ϊtrueʱ��������+1
			if(ANYOF_DECISION)
				DECISION_NUM++;
		}
		
		//ֻ�е�Condition�µ�����AnyOf��ǩ��Ϊtrueʱ����Condition���жϽ��Ϊtrue
		if(DECISION_NUM==condition.getAnyOfNum())
			decide = true;
		
		return decide;
	}
}
