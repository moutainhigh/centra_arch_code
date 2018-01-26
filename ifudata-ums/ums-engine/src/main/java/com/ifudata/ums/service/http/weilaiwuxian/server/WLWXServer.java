package com.ifudata.ums.service.http.weilaiwuxian.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.core.SMAbstractServer;
import com.ifudata.ums.service.http.weilaiwuxian.constant.WeilaiwuxianConstant;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

/**
 *
 * 2015年8月5日上午10:14:04
 * hongzhenfu
 *
 */
public class WLWXServer extends SMAbstractServer{
	
	private static final Log log = LogFactory.getLog(WLWXServer.class);

	@Override
	public void startServer() {
		// TODO Auto-generated method stub
		log.debug("*******************启动未来无线HTTP协议接收功能****************************");
		HttpServerProvider provider = HttpServerProvider.provider();
		try {
			log.debug("server端口："+WeilaiwuxianConstant.PORT+"	并发接收量："+WeilaiwuxianConstant.CONCURRENCY);
			HttpServer httpserver = provider.createHttpServer(new InetSocketAddress(Integer.valueOf(WeilaiwuxianConstant.PORT)), Integer.valueOf(WeilaiwuxianConstant.CONCURRENCY));
			log.debug("server进入的actionName："+WeilaiwuxianConstant.ACTIONNAME);
			//这里应该根据不同的actionName进入到不同的Handler的实现里面，可以将端口分开，也可以公用一个端口
			httpserver.createContext("/"+WeilaiwuxianConstant.ACTIONNAME, new WLWXHttpHandler());
			httpserver.setExecutor(null); 
	        httpserver.start(); 
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			log.debug("******************服务失败！******************");
			log.debug("请查看端口，并发量是否正确配置***	NumberFormatException = [" + e.toString() + "]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.debug("******************服务失败！******************");
			log.debug("请查看配置文件是***路径***配置参数***是否正确***服务是否已经启动	IOException = [" + e.toString() + "]");
		}
	}

}

