package org.api.equalFunction;

public class IntEqual 
{
	//int����ƥ�亯��
	public boolean intEqual(String requestvalue, String policyvalue)
	{
		//����string��ʾ������ת��Ϊint����
		int reqvalue = Integer.parseInt(requestvalue);
		int polvalue = Integer.parseInt(policyvalue);
		
		//int��������֮���ƥ�䣬��ȷ���true����֮false
		boolean result = false;
		if(reqvalue == polvalue)
			result = true;
		return result;
	}
}
