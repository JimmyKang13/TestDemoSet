package org.api.requestApi;

import java.io.Serializable;
import java.util.List;

//Request数据块的顶层类
@SuppressWarnings("serial")
public class Requests implements Serializable
{
	private Request Request;
	
	//获取标签Request中的所有信息
	public Request getRequest()
	{
		return Request;
	}
	
	//设置标签Request
	public void setRequest(Request Request)
	{
		this.Request = Request;
	}
	
	//重定义toString函数
	@Override
	public String toString()
	{
		return "{" + Request + "}";
	}
}
