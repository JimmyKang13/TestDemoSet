package org.api.equalFunction;

public class StringEqual 
{
	//string����ƥ��
	public boolean stringEqual(String requestvalue, String policyvalue)
	{
		boolean result = requestvalue.equals(policyvalue);
		return result;
	}
}
