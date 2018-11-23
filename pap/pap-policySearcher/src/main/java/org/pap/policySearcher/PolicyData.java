package org.pap.policySearcher;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class PolicyData 
{
	//输入：PolicyId列表、策略寄存器（空）
	//输出：完整的Policy信息（补充了标签policies）
	static StringBuffer getPolicyData(List<String> policyIdList, StringBuffer policy) throws DocumentException
	{
		//读取路径对应的文档，定位到根元素
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/main/resources/policydata.xml");
		Element policydataElement = document.getRootElement();
		
		//增加一个顶层标签Policies，若删除仅需修改api中的Policies类即可
		policy.append("<Policies>" + "\n");
		
		//判断根元素下的Policy元素是否为空
		if(policydataElement.element("Policy") != null)
		{
			Policy.getPolicy(policydataElement, policyIdList, policy);
		}
		
		policy.append("</Policies>");
		
		return policy;
	}
}
