package org.pdp.decide;

import org.api.policyApi.Policys;
import org.api.requestApi.Requests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Decision 
{
//	public boolean decide(JsonObject requestjson, JsonObject policyjson)
//	{
//		boolean decide;
//		
//		String requestfile = requestjson.toString();
//		String policyfile = policyjson.toString();
//		
//		Requests request = new Gson().fromJson(requestfile, Requests.class);
//		Policys policys = new Gson().fromJson(policyfile, Policys.class);
//		
//		decide = Permission.getPermission(request, policys);
//		
//		return decide;
//	}
	
	//���룺�������ݿ顢�������ݿ�
	//�������Ӧ���
	public String decide(JsonObject requestjson, JsonObject policyjson)
	{
		//���������ݿ�Ͳ������ݿ��е���Ϣת�����ַ���
		String requestfile = requestjson.toString();
		String policyfile = policyjson.toString();
		
		//ʹ�ñ�д�õ�Requests���Policy��ֱ��json��ʽ�����ݿ鶨��
		Requests request = new Gson().fromJson(requestfile, Requests.class);
		Policys policys = new Gson().fromJson(policyfile, Policys.class);
		
		//���û�ȡ��Ӧ��Ϣ�ĺ�������ȡ��Ӧ
		String decide = Response.getResponse(request, policys);
		
		return decide;
	}
}
