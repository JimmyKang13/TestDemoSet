package org.ctxt.reqTransformation;

import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Request 
{
	static JsonObject getRequest(Document document, JsonObject request)
	{
		//��ȡ�����ĵ���Ԫ��λ��
		Element reqElement = document.getRootElement();
		JsonArray reqinfo = null;
		
		//�жϸ�Ԫ����AttributesԪ���Ƿ�Ϊ��
		//�ǿգ�������һ���������գ����ش�����Ϣ
		if(reqElement.element("Attributes") != null)
		{
			//����JsonArray�������ڴ洢Attributes�µ���Ϣ��������ݴ�ŵ�Attribute��ǩ��
			reqinfo = new JsonArray();
			Attributes.getCategory(reqElement, reqinfo);
			request.add("Attribute", reqinfo);
			
		} else
		{
			System.out.println("element 'Attribtues' is null");
		}
		return request;
	}
}
