package org.api.policyApi;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.google.gson.Gson;

public class ApiTest 
{
	@Test
	public void testApi() throws IOException
	{
		URL url = getClass().getClassLoader().getResource("policy.json");
		File file = new File(url.getFile());
		String policyfile = FileUtils.readFileToString(file, "UTF-8");
		
		Policys policy = new Gson().fromJson(policyfile, Policys.class);
		
//		int a1 = policy.getPolicy().getRuleNum();
//		for(int a=0;a<a1;a++)
//		{
//			Rule rule = policy.getPolicy().getRule().get(a);
//			System.out.println(rule.toString());
//			int b1 = rule.getTarget().get(0).getAnyOfNum();
//			for(int b=0;b<b1;b++)
//			{
//				AnyOf anyof = rule.getTarget().get(0).getAnyOf().get(b);
//				System.out.println(anyof.toString());
//				int c1 = anyof.getAllOfNum();
//				for(int c=0;c<c1;c++)
//				{
//					AllOf allof = anyof.getAllOf().get(c);
//					System.out.println(allof.toString());
//					int d1 = allof.getMatchNum();
//					for(int d=0;d<d1;d++)
//					{
//						Match match = allof.getMatch().get(d);
//						System.out.println(match.toString());
//					}
//				}
//			}
//		}
		
//		int num = policy.getPolicy().getRule().get(0).getTarget().get(0).getAnyOfNum();
//		System.out.println(num);
		
//		for(int a=0;a<1;a++)
//		{
//			System.out.println("a"+a);
//			for(int b=0;b<2;b++)
//			{
//				System.out.println("b"+b);
//				for(int c=0;c<3;c++)
//				{
//					System.out.println("c"+c);
//					for(int d=0;d<4;d++)
//					{
//						System.out.println("d"+d);
//					}
//				}
//			}
//		}
	}
}
