package org.api.requestApi;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.api.requestApi.Requests;
import org.junit.Test;

import com.google.gson.Gson;

public class ApiTest 
{
	@Test
	public void testApi() throws IOException
	{
		URL url = getClass().getClassLoader().getResource("req.json");
		File file = new File(url.getFile());
		String requestfile = FileUtils.readFileToString(file, "UTF-8");
		
		Requests request = new Gson().fromJson(requestfile, Requests.class);
		
//		for(int j=0;j<2;j++) {
//		int num = request.getRequest().getAttributeNum();
//		if(j>0)
//			num = num/2;
//		System.out.println(num);
//		for(int i = 0; i < num; i++)
//		{
//			String message = request.getRequest().getAttribute().get(i).toString();
//			System.out.println(message);
//		}
//		}
//		int num = request.getRequest().getAttribtueNum();
//		System.out.println(num);
	}
}
