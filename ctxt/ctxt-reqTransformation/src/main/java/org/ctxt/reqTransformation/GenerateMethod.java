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
		
		//读去所给路径对应的文件信息
		SAXReader reader = new SAXReader();
		Document document = reader.read(reqPath);
		
		//调用Request类中getRequest函数，获得JsonObject格式的request数据
		Request.getRequest(document, request);
		
		//将获得的request数据存放到Request标签下
		object.add("Request", request);
		
		return object;
	}
}
