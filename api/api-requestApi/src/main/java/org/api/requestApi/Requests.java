package org.api.requestApi;

import java.io.Serializable;
import java.util.List;

//Request���ݿ�Ķ�����
@SuppressWarnings("serial")
public class Requests implements Serializable
{
	private Request Request;
	
	//��ȡ��ǩRequest�е�������Ϣ
	public Request getRequest()
	{
		return Request;
	}
	
	//���ñ�ǩRequest
	public void setRequest(Request Request)
	{
		this.Request = Request;
	}
	
	//�ض���toString����
	@Override
	public String toString()
	{
		return "{" + Request + "}";
	}
}
