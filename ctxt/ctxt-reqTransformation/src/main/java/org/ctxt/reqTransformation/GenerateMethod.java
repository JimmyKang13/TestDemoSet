package org.ctxt.reqTransformation;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.google.gson.JsonObject;

public class GenerateMethod 
{
	static JsonObject ReqToJsonMethod(JsonObject object, String reqPath) throws DocumentException
	{
		JsonObject request = new JsonObject();
		
		//��ȥ����·����Ӧ���ļ���Ϣ
		SAXReader reader = new SAXReader();
		Document document = reader.read(reqPath);
		
		//����Request����getRequest���������JsonObject��ʽ��request����
		Request.getRequest(document, request);
		
		//����õ�request���ݴ�ŵ�Request��ǩ��
		object.add("Request", request);
		
		return object;
	}
}
