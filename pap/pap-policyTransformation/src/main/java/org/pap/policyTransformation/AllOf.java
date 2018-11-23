package org.pap.policyTransformation;

import java.util.List;

import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AllOf 
{
	//���룺AnyOfԪ��λ�á�json���飨Ԫ��AllOf�µ���Ϣ���գ�
	//�����json���飨Ԫ��AllOf�µ���Ϣ��
	static JsonArray getAllOf(Element anyofElement, JsonArray allofs)
	{
		//��λ����ǰλ���µ�AllOfԪ�أ�AllOfԪ�ؿ��ܴ��ڶ����ʹ���б���
		List<Element> allofElementList = anyofElement.elements("AllOf");
		JsonObject allof = null;
		JsonArray matchs = null;
//		//18.11 Update owner: KHZN
//		JsonArray applies = null;
		
		//����Ԫ���б�������AllOfԪ��
		for(Element allofElement : allofElementList)
		{
			//�жϵ�ǰAllofԪ���µ�MatchԪ���Ƿ�Ϊ��
			//�ǿգ�������һ���������գ����ش�����Ϣ
			if(allofElement.element("Match") != null)
			{
				//AllOf�¸���Ԫ����Ϣ��Ϊjson������
				allof = new JsonObject();
				matchs = new JsonArray();
				
				//Match�µ���Ϣ��Ϊjson�����ţ���ȡ�����ݺ󣬷ŵ�Match��ǩ��
				Match.getMatch(allofElement, matchs);
				allof.add("Match", matchs);
			} else
			{
				System.out.println("element 'Match' is null");
			}
			
//			//18.11 Update owner: KHZN
//			
//			//�жϵ�ǰAllOfԪ���µ�ApplyԪ���Ƿ�Ϊ��
//			//�ǿգ�������һ���������գ����ش�����Ϣ
//			if(allofElement.element("Apply") != null)
//			{
//				//AllOf�¸���Ԫ����Ϣ��Ϊjson������
//				allof = new JsonObject();
//				applies = new JsonArray();
//				
//				//Apply�µ���Ϣ��Ϊjson���ݴ�ţ���ȡ�����ݺ󣬷ŵ�Apply��ǩ��
//				Apply.getApply(allofElement, applies);
//				allof.add("Apply", applies);
//			}else 
//			{
//				//System.out.println("element 'Apply' is null");
//			}
			
			//��json������뵽json������
			allofs.add(allof);
		}
		return allofs;
	}
}
