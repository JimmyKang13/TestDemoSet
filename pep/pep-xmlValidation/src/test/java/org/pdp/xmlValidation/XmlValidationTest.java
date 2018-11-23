package org.pdp.xmlValidation;

import org.junit.Test;


public class XmlValidationTest {
	@Test
	public void main() {
		System.out.println("test begin");
		XmlValidation a = new XmlValidation();
		System.out.println("requesttest.xml validate against request.xsd? " + a.validateXmlSchema("src/main/resources/request.xsd","src/test/resources/requesttest.xml"));
	}
}
