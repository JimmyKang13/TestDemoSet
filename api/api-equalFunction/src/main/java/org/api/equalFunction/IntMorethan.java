package org.api.equalFunction;

public class IntMorethan 
{
	//int���ʹ��ں���
	public boolean intMorethan(String requestvalue, String policyvalue)
	{
		//����string��ʾ������ת��Ϊint����
		int reqvalue = Integer.parseInt(requestvalue);
		int polvalue = Integer.parseInt(policyvalue);
		
		//int��������֮���ƥ�䣬���ڷ���true����֮false
		boolean result = false;
		if(reqvalue > polvalue)
			result = true;
		return result;
	}
}
