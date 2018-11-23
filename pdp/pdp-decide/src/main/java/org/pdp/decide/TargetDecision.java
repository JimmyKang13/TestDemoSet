package org.pdp.decide;

import org.api.policyApi.AnyOf;
import org.api.policyApi.Target;
import org.api.requestApi.Requests;

public class TargetDecision 
{
	//���룺Requests����������ݡ�Target��Ĳ�������
	//�����boolean�����жϽ��
	static boolean targetDecide(Requests request, Target target)
	{
		int d = 0;
		boolean decide = false;
		AnyOf anyof = null;
		
		//��ȡTarget��ǩ��AnyOf��ǩ������
		int num = target.getAnyOfNum();
		//����Target��ǩ������AnyOf��ǩ
		for(int i=0; i<num; i++) 
		{
			//��ȡ��Ӧ��AnyOf��ǩ����Ϣ
			anyof = new AnyOf();
			anyof = target.getAnyOf().get(i);
			//��ȡAnyOf��ǩ����Ϣ���������ݿ��ƥ����
			boolean adecide = AnyOfDecision.anyofDecide(request, anyof);
			
			//ÿ��AnyOf��ǩƥ����Ϊtrueʱ��������+1
			if(adecide)
				d++;
		}
		
		//Target's AnyOfs should be all true, the decide could return true;
		if(d==target.getAnyOfNum())
			decide = true;
		
		return decide;
	}
}
