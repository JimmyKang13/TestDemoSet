package org.ctxt.reqTransformation;

import java.io.IOException;
import java.io.PrintWriter;

import org.dom4j.DocumentException;

import com.google.gson.JsonObject;

public class ReqTransformation 
{
	//��xacml��ʽ�������ļ�ת����json���ݿ�
	//����Ϊ�����ļ�����·�������ΪJsonObject��ʽ����������
	public static JsonObject transformReq(String reqPath) throws IOException, DocumentException
	{
		JsonObject object = new JsonObject();
		//����GenerateMethod����ReqToJsonMethod���������JsonObject��ʽ����������
		GenerateMethod.ReqToJsonMethod(object, reqPath);
		
//		String reqjson = object.toString();
//		
//		PrintWriter pw = new PrintWriter("src/main/resources/req.json");
//		pw.print(reqjson);
//		pw.flush();
//		pw.close();
		
		return object;
	}
}
