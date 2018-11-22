//18.11 Update issuer: KHZN

package org.api.structureApi;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> 
{
	public final C third;
	
	public ThreeTuple(A a, B b, C c)
	{
		super(a, b);
		third = c;
	}
}
