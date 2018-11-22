package org.api.equalFunction;

public class IntEqual 
{
	//int类型匹配函数
	public boolean intEqual(String requestvalue, String policyvalue)
	{
		//将以string表示的数据转换为int类型
		int reqvalue = Integer.parseInt(requestvalue);
		int polvalue = Integer.parseInt(policyvalue);
		
		//int类型数据之间的匹配，相等返回true，反之false
		boolean result = false;
		if(reqvalue == polvalue)
			result = true;
		return result;
	}
}
