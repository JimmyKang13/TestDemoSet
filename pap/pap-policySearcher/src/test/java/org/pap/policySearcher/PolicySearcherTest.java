package org.pap.policySearcher;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.api.requestApi.Requests;
import org.dom4j.DocumentException;
import org.junit.Test;

import com.google.gson.Gson;

public class PolicySearcherTest 
{
	@Test
	public void testPolicySearcher() throws IOException, DocumentException
	{
		URL url = getClass().getClassLoader().getResource("testrequest.json");
		File file = new File(url.getFile());
		String requestfile = FileUtils.readFileToString(file, "UTF-8");
		Requests request = new Gson().fromJson(requestfile, Requests.class);
		
		PolicySearcher.searchPolicy(request);
	}
}
