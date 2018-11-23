package org.pdp.decide;

import org.api.policyApi.AllOf;
import org.api.policyApi.AnyOf;
import org.api.requestApi.Requests;


public class AnyOfDecision 
{
	//���룺Requests����������ݡ�AnyOf��Ĳ�������
	//�����boolean�����жϽ��
	static boolean anyofDecide(Requests request, AnyOf anyof)
	{
		int d = 0;
		boolean decide = false;
		AllOf allof = null;
		
		//��ȡAnyOf��ǩ��AllOf��ǩ������
		int num = anyof.getAllOfNum();
		//����AnyOf��ǩ������AllOf��ǩ
		for(int i=0; i<num; i++)
		{
			//��ȡ��Ӧ��AllOf��ǩ����Ϣ
			allof = new AllOf();
			allof = anyof.getAllOf().get(i);
			//��ȡAllOf��ǩ����Ϣ���������ݿ��ƥ����
			boolean adecide = AllOfDecision.allofDecide(request, allof);
			
			//ÿ��AllOf��ǩƥ����Ϊtrueʱ��������+1
			if(adecide)
				d++;
		}
		
		//if the AllOf elements under AnyOf  have one element returns true, that AnyOf returns true;
		if(d>0)
			decide = true;
		//System.out.println(decide);
		return decide;
	}
}
