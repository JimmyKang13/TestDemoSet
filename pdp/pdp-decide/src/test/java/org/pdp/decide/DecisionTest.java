package org.pdp.decide;

import java.io.IOException;

import org.ctxt.reqTransformation.ReqTransformation;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.pap.policyTransformation.PolicyTransformation;

import com.google.gson.JsonObject;

public class DecisionTest 
{
	@Test
	public void testDecision() throws DocumentException, IOException
	{
		JsonObject requestjson = ReqTransformation.transformReq("src/main/resources/requesttest.xml");
		JsonObject policyjson = PolicyTransformation.transformPolicy("src/main/resources/policytest.xml");
		
		String decide = new Decision().decide(requestjson, policyjson);
		System.out.println(decide);
	}
}
