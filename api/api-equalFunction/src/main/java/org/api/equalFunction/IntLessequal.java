package org.api.equalFunction;

public class IntLessequal 
{
	//int����С�ڵ��ں���
	public boolean intLessequal(String requestvalue, String policyvalue)
	{
		//����string��ʾ������ת��Ϊint����
		int reqvalue = Integer.parseInt(requestvalue);
		int polvalue = Integer.parseInt(policyvalue);
		
		//int��������֮���ƥ�䣬С�ڵ��ڷ���true����֮false
		boolean result = false;
		if(reqvalue <= polvalue)
			result = true;
		return result;
	}
}
