package org.api.equalFunction;

public class IntMorethan 
{
	//int类型大于函数
	public boolean intMorethan(String requestvalue, String policyvalue)
	{
		//将以string表示的数据转化为int类型
		int reqvalue = Integer.parseInt(requestvalue);
		int polvalue = Integer.parseInt(policyvalue);
		
		//int类型数据之间的匹配，大于返回true，反之false
		boolean result = false;
		if(reqvalue > polvalue)
			result = true;
		return result;
	}
}
