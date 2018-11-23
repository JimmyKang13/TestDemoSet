package org.pdp.decide;

public class Effect 
{
	//当Effect值为Permit时，返回值与匹配结果返回值相同
	static boolean permitFunction(boolean decide)
	{
		return decide;
	}
	
	//当Effect值为Deny时。返回值与匹配结果返回值相反
	static boolean denyFunction(boolean decide)
	{
		if(decide)
		{
			return false;
		} else
		{
			return true;
		}
	}
}
