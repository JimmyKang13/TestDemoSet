package org.api.equalFunction;

public class IntMoreequal 
{
	//int���ʹ��ڵ��ں���
	public boolean intMoreequal(String requestvalue, String policyvalue)
	{
		//����string��ʾ������ת��Ϊint����
		int reqvalue = Integer.parseInt(requestvalue);
		int polvalue = Integer.parseInt(policyvalue);
		
		//int��������֮���ƥ�䣬���ڵ��ڷ���true����֮false
		boolean result = false;
		if(reqvalue >= polvalue)
			result = true;
		return result;
	}
}
