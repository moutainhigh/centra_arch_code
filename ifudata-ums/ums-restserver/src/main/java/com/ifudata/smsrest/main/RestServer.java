package com.ifudata.smsrest.main;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.core.UriBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifudata.smsrest.constant.Constant;
import com.ifudata.smsrest.httpserver.Context;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
//@SuppressWarnings("restriction")
public class RestServer {
	private static final Logger log = LoggerFactory.getLogger(RestServer.class);

	public static final CopyOnWriteArrayList<String> deliverArray = new CopyOnWriteArrayList<String>();
	public static final CopyOnWriteArrayList<String> reportArray = new CopyOnWriteArrayList<String>();
	public static final CopyOnWriteArrayList<String> submitArray = new CopyOnWriteArrayList<String>();
	//private static final String RESPATH = "com.ifudata.billing.api";
	
	private static RestServer instance = new RestServer();
	private static final String RESPATH = "com.ifudata.smsrest.api";
	public static RestServer getInstance() {
		return instance;
	}
	// 启动服务，监听来自客户端的请求

	public void start() throws IOException {
//		ApplicationContextUtil.getInstance();
//		
//		Context.load();
//
//		HttpServerProvider provider = HttpServerProvider.provider();
//		HttpServer httpserver = provider.createHttpServer(new InetSocketAddress(Integer.parseInt(Constant.DELIVER_PORT)), 100);// 监听端口8080,能同时接
//																												// 受100个请求
//		httpserver.createContext(Context.contextPath, new NewHttpHandler());
//		httpserver.setExecutor(null);
//		httpserver.start();
//		
////		new Thread(new DeliverProc()).start();
////		new Thread(new ReportProc()).start();
////		new Thread(new SubmitProc()).start();
//		System.out.println("server started");
//		log.info("server started");
		
		
		log.info("init");
		URI uri = UriBuilder.fromUri(Constant.REST_URL).port(Integer.parseInt(Constant.DELIVER_PORT)).build();  
        ResourceConfig rc = new PackagesResourceConfig(RESPATH);

        try {  
    		log.info("Start begin");
            org.glassfish.grizzly.http.server.HttpServer server = GrizzlyServerFactory.createHttpServer(uri, rc);  
            server.start();
            
            while (true){
        		log.info("检查进程状态");
            	if (!server.isStarted()){
            		log.info("进程状态异常，重启");
                    server.start();
            		log.info("Start scucess");
            	}else{
            		log.info("进程状态正常");
            	}
            	
                try {  
                    Thread.sleep(100*1000);  
                } catch (InterruptedException e) {  
            		log.error("Start error",e);  
                }  
            }

        } catch (IllegalArgumentException e) {
    		log.error("Start error",e);
        } catch (NullPointerException e) {  
    		log.error("Start error",e);  
        } catch (IOException e) {  
    		log.error("Start error",e);  
        } catch ( Exception e ){
    		log.error("Start error",e);
        }
		
	}

	public static void main(String[] args) throws IOException {
		log.info("init");

		getInstance().start();
	}
}
