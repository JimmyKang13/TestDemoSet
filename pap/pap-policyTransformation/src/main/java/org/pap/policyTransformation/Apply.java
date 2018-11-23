//18.11 Update owner: KHZN

package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Apply 
{
	//���룺AllOfԪ��λ�á�json���ݣ�Ԫ��Apply�µ���Ϣ���գ�
	//�����json���ݣ�Ԫ��Apply�µ���Ϣ��
	static JsonArray getApply(Element allofElement, JsonArray applies)
	{
		//��λ����ǰλ���µ�ApplyԪ�أ�ApplyԪ�ؿ��ܴ��ڶ����ʹ���б���
		List<Element> applyElementList = allofElement.elements("Apply");
		JsonObject apply = null;
		
		//����Ԫ���б�������ApplyԪ��
		for(Element applyElement : applyElementList)
		{
			//Apply�µĸ���Ԫ�ػ�������Ϣ��Ϊjson������
			apply = new JsonObject();
			
			//��ȡ��ǰApplyԪ��������FunctionId��ֵ�����ű�ǩFunctionId��
			String functionId = applyElement.attributeValue("FunctionId");
			apply.addProperty("FunctionId", functionId);
			
			//��ȡApplyԪ����AttributeValueԪ�ص���Ϣ
			AttributeValue.getAttributeValue(applyElement, apply);
			
			//��ȡApplyԪ����AttributeDesignatorԪ�ص���Ϣ
			AttributeDesignator.getAttributeDesignator(applyElement, apply);
			
			//����AttributeValue��AttributeDesignatorԪ�ص���Ϣ����ȡ����json����
			apply = new JsonParser().parse(apply.toString()).getAsJsonObject();
			//��json������뵽json������
			applies.add(apply);
		}
		return applies;
	}
}
