package org.ctxt.reqTransformation;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.junit.Test;

public class ReqTransformationTest 
{
	@Test
	public void testReqTransformation() throws DocumentException, IOException
	{
		ReqTransformation.transformReq("src/main/resources/requesttest.xml");
	}
}
