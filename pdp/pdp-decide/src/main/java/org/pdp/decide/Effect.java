package org.pdp.decide;

public class Effect 
{
	//��EffectֵΪPermitʱ������ֵ��ƥ��������ֵ��ͬ
	static boolean permitFunction(boolean decide)
	{
		return decide;
	}
	
	//��EffectֵΪDenyʱ������ֵ��ƥ��������ֵ�෴
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
