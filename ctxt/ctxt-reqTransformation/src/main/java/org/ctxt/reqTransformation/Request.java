package org.ctxt.reqTransformation;

import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Request 
{
	static JsonObject getRequest(Document document, JsonObject request)
	{
		//获取请求文档根元素位置
		Element reqElement = document.getRootElement();
		JsonArray reqinfo = null;
		
		//判断根元素下Attributes元素是否为空
		//非空，进行下一步操作；空，返回错误信息
		if(reqElement.element("Attributes") != null)
		{
			//创建JsonArray对象用于存储Attributes下的信息，最后将数据存放到Attribute标签下
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
