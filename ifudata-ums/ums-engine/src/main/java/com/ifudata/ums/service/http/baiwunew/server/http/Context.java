package com.ifudata.ums.service.http.baiwunew.server.http;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ifudata.ums.service.http.baiwunew.server.http.HttpHandler;
import com.ifudata.ums.service.http.baiwunew.server.http.XmlUtils;
/**
 * 
 * @author 
 * @Description: 上下文 
 * @date 2014年11月12日 下午3:53:48 
 * @version V1.0
 */
public class Context {
	private static Map<String,HttpHandler> contextMap = new HashMap<String,HttpHandler>();
	public static String contextPath = "";
	public static void load(){
		try{
			Document doc = XmlUtils.load("resource/conf/http/baiwunew/" + "context.xml");
			//Document doc = XmlUtils.load(/*Context.class.getResource("/").getPath()+*/"context.xml");
			Element root = doc.getDocumentElement();
			
			contextPath = XmlUtils.getAttribute(root,"context");
			Element[] handlers = XmlUtils.getChildrenByName(root, "handler");
			for(Element ele : handlers){
				String handle_class = XmlUtils.getChildText(ele, "handler-class");
				String url_pattern = XmlUtils.getChildText(ele, "url-pattern");
				
				Class<?> cls = Class.forName(handle_class);
				Object newInstance = cls.newInstance();
				if(newInstance instanceof HttpHandler){
					contextMap.put(contextPath+url_pattern, (HttpHandler)newInstance);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static HttpHandler getHandler(String key){
		return contextMap.get(key);
	}
	
}
