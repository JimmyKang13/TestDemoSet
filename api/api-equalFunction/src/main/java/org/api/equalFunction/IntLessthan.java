package org.api.equalFunction;

public class IntLessthan 
{
	//int����С�ں���
	public boolean intLessthan(String requestvalue, String policyvalue)
	{
		//����string��ʾ������ת��Ϊint����
		int reqvalue = Integer.parseInt(requestvalue);
		int polvalue = Integer.parseInt(policyvalue);
		
		//int��������֮���ƥ�䣬С�ڷ���true����֮false
		boolean result = false;
		if(reqvalue < polvalue)
			result = true;
		return result;
	}
}
