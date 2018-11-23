package org.pdp.decide;

import org.api.policyApi.AllOf;
import org.api.policyApi.Match;
import org.api.requestApi.Requests;

public class AllOfDecision 
{
	//���룺Requests����������ݡ�AllOf��Ĳ�������
	//�����boolean�����жϽ��
	static boolean allofDecide(Requests request, AllOf allof)
	{	
		int d = 0;
		boolean decide = false;
		Match match = null;
		
		//��ȡAllOf��ǩ��Match��ǩ������
		int num = allof.getMatchNum();
//		System.out.println(num);
		//����AllOf��ǩ������Match��ǩ
		for(int i=0; i<num; i++)
		{
			//��ȡ��Ӧ��Match��ǩ����Ϣ
			match = new Match();
			match = allof.getMatch().get(i);
			//��ȡMatch��ǩ����Ϣ���������ݿ��ƥ����
			boolean adecide = MatchDecision.matchDecide(request, match);
			
			//ÿ��Match��ǩƥ����Ϊtrueʱ��������+1
			if(adecide)
				d++;
		}
		
		//only all Match elements under AllOf have matched and return true, that AllOf element returns true;
		if(d==allof.getMatchNum())
			decide = true;
		//System.out.println(decide);
		return decide;
	}
}
