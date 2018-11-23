package org.ctxt.reqTransformation;

import java.io.IOException;
import java.io.PrintWriter;

import org.dom4j.DocumentException;

import com.google.gson.JsonObject;

public class ReqTransformation 
{
	//将xacml格式的请求文件转换成json数据块
	//输入为请求文件所在路径，输出为JsonObject格式的请求数据
	public static JsonObject transformReq(String reqPath) throws IOException, DocumentException
	{
		JsonObject object = new JsonObject();
		//调用GenerateMethod类中ReqToJsonMethod函数，获得JsonObject格式的请求数据
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
