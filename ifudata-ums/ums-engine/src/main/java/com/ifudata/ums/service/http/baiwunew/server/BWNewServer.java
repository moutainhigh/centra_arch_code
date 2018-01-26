package com.ifudata.ums.service.http.baiwunew.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifudata.ums.service.http.baiwunew.constant.BaiwuNewConstant;
import com.ifudata.ums.service.http.baiwunew.server.http.Context;
import com.ifudata.ums.service.http.baiwunew.server.http.NewHttpHandler;
import com.sun.net.httpserver.spi.HttpServerProvider;
import com.sun.net.httpserver.HttpServer;
//import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
//import com.sun.jersey.api.core.PackagesResourceConfig;
//import com.sun.jersey.api.core.ResourceConfig;

public class BWNewServer {
	private static final Logger log = LoggerFactory.getLogger(BWNewServer.class);

	public static final CopyOnWriteArrayList<String> deliverArray = new CopyOnWriteArrayList<String>();
	public static final CopyOnWriteArrayList<String> reportArray = new CopyOnWriteArrayList<String>();
	//private static final String RESPATH = "com.ifudata.billing.api";
	
	private static BWNewServer instance = new BWNewServer();

	public static BWNewServer getInstance() {
		return instance;
	}
	// 启动服务，监听来自客户端的请求
	public void start() throws IOException {
		Context.load();

		HttpServerProvider provider = HttpServerProvider.provider();
		HttpServer httpserver = provider.createHttpServer(new InetSocketAddress(Integer.parseInt(BaiwuNewConstant.DELIVER_PORT)), 100);// 监听端口8080,能同时接
																												// 受100个请求
		httpserver.createContext(Context.contextPath, new NewHttpHandler());
		httpserver.setExecutor(null);
		httpserver.start();
		
		new Thread(new BWNewDeliver()).start();
		new Thread(new BWNewReport()).start();
		System.out.println("server started");
		log.info("server started");
	}

	public static void main(String[] args) throws IOException {
		log.info("init");

		// URI uri =
		// UriBuilder.fromUri(BaiwuNewConstant.DELIVER_URL).port(Integer.parseInt(BaiwuNewConstant.DELIVER_PORT)).build();

		getInstance().start();

		// ResourceConfig rc = new PackagesResourceConfig(RESPATH);
		//
		// try {
		// log.info("Start begin");
		// HttpServer server = GrizzlyServerFactory.createHttpServer(uri, rc);
		// server.start();
		//
		// while (true) {
		// log.info("检查进程状态");
		// if (!server.isStarted()) {
		// log.info("进程状态异常，重启");
		// server.start();
		// log.info("Start scucess");
		// } else {
		// log.info("进程状态正常");
		// }
		//
		// try {
		// Thread.sleep(100 * 1000);
		// } catch (InterruptedException e) {
		// log.error("Start error", e);
		// }
		// }
		//
		// } catch (IllegalArgumentException e) {
		// log.error("Start error", e);
		// } catch (NullPointerException e) {
		// log.error("Start error", e);
		// } catch (IOException e) {
		// log.error("Start error", e);
		// } catch (Exception e) {
		// log.error("Start error", e);
		// }
	}
}
