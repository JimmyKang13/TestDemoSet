package org.pap.policySearcher;

import java.util.List;

import org.api.requestApi.Requests;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PolicySetData 
{
	//输入：请求数据块（.json）、policyId列表（空）
	//输出：policyId列表（匹配到的Id）
	static List<String> getPolicySetData(Requests request, List<String> policyIdList) throws DocumentException
	{
		//读取路径对应的文档，定位到根元素
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/main/resources/policysetdata.xml");
		Element policysetdataElement = document.getRootElement();
		
		//判断根元素下的PolicySet是否为空
		if(policysetdataElement.element("PolicySet") != null)
		{
			//根据PolicySet数据和请求数据块，获得匹配的policyId列表（可能存在重复值）
			PolicySet.getPolicySet(policysetdataElement, request, policyIdList);
		}
		
		return policyIdList;
	}
}
