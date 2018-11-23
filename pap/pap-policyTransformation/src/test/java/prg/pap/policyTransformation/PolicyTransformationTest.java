package prg.pap.policyTransformation;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.junit.Test;
import org.pap.policyTransformation.PolicyTransformation;

import com.google.gson.JsonObject;

public class PolicyTransformationTest 
{
	@Test
	public void testPolicyTransformation() throws DocumentException, IOException
	{
//		JsonObject policy = PolicyTransformation.transformPolicy("src/main/resources/policytest.xml");
//		
//		System.out.println(policy.getAsJsonObject("Policy").get("Rule"));
		
//		JsonObject policies = PolicyTransformation.transformPolicy("src/main/resources/policytest.xml");
		JsonObject policies = PolicyTransformation.transformPolicy("src/main/resources/policy-conditiontest.xml");
		
		System.out.println(policies.getAsJsonObject("Policies").get("Policy"));
	}
}
