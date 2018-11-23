package org.pap.policySearcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.api.requestApi.Requests;
import org.dom4j.DocumentException;

public class PolicySearcher 
{
	//输入：请求数据块（.json）
	public static void searchPolicy(Requests request) throws IOException, DocumentException
	{
		List<String> policyIdList = new ArrayList<>();
		StringBuffer policy = new StringBuffer();
		
		//get the matched policyIds, use List<>
		PolicySetData.getPolicySetData(request, policyIdList);
		
		//remove the possible duplicates in the list
		ListRemoveDuplicate.removeDuplicate(policyIdList);
		
		//according to policyIdList, get policies from the policy data
		PolicyData.getPolicyData(policyIdList, policy);
		
		PrintWriter pw = new PrintWriter("src/test/resources/policy.xml");
		pw.print(policy);
		pw.flush();
		pw.close();
		
	}
}
