package com.ifudata.ums.core;

import com.ifudata.ums.constant.SysParamConstant;
import com.ifudata.ums.service.diy09.client.Diy09Client;
import com.ifudata.ums.service.http.baiwu.client.BWClient;
import com.ifudata.ums.service.http.baiwunew.client.BWNewClient;
import com.ifudata.ums.service.http.byd.client.BYDClient;
import com.ifudata.ums.service.http.dahansantong.client.Submit.DHSTClientSubmit;
import com.ifudata.ums.service.http.sikong.client.SikongClient;
import com.ifudata.ums.service.http.sikong.client.SikongClientDeliver;
import com.ifudata.ums.service.http.sikong.server.SikongServer;
import com.ifudata.ums.service.http.weilaiwuxian.client.WLWXClient;
import com.ifudata.ums.service.http.weilaiwuxian.server.WLWXServer;
import com.ifudata.ums.service.http.youku.client.YKClient;
import com.ifudata.ums.service.sgip.client.SGIPClient;
import com.ifudata.ums.util.ApplicationContextUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SMSEngine {

	private static final Log log = LogFactory.getLog(SMSEngine.class);

	public static void main(String[] args) {
		log.debug("********** SMSEngine 启动 。。。。。。**********");
		// ApplicationContext Resource =
		// ApplicationContextUtil.getInstance().getCtx();
		ApplicationContextUtil.getInstance();
		// 启动超时监控器
		new Thread(new SMTimeoutMonitor()).start();
		// 启动短信生成器
		new Thread(new SMGenerator()).start();
		// 准备邮递员通讯需要的与具体协议绑定的客户端
		SMAbstractClient smWriteClient = null;
		SMAbstractClient smReadClient = null;
		SMAbstractServer smServer = null;
		if (SysParamConstant.PROTOCOL.equals("sgip")) {
			SGIPClient sgipClient = new SGIPClient();
			smWriteClient = sgipClient;
			smReadClient = sgipClient;
		} else if (SysParamConstant.PROTOCOL.equals("baiwu")) {
			smWriteClient = new BWClient();
			smReadClient = new BWClient();
		} else if (SysParamConstant.PROTOCOL.equals("baiwunew")) {
			smWriteClient = new BWNewClient();
			smReadClient = new BWNewClient();
		} else if (SysParamConstant.PROTOCOL.equals("youku")) {
			smWriteClient = new YKClient();
			smReadClient = new YKClient();
		} else if (SysParamConstant.PROTOCOL.equals("dahansantong")) {
			smWriteClient = new DHSTClientSubmit();
			smReadClient = new DHSTClientSubmit();
			// new Thread(new DHSTClientDeliver()).start();
		} else if (SysParamConstant.PROTOCOL.equals("diy09")) {
			Diy09Client diy09Client = new Diy09Client();
			smWriteClient = diy09Client;
			smReadClient = diy09Client;
		} else if (SysParamConstant.PROTOCOL.equals("byd")) {
			BYDClient bydClient = new BYDClient();
			smWriteClient = bydClient;
			smReadClient = bydClient;
		} else if (SysParamConstant.PROTOCOL.equals("weilaiwuxian")) {
			smServer = new WLWXServer();
			smServer.startServer();
			smWriteClient = new WLWXClient();
		} else if (SysParamConstant.PROTOCOL.equals("sikong")) {
			smServer = new SikongServer();
			smServer.startServer();
			smWriteClient = new SikongClient();
			//上行
			new Thread(new SikongClientDeliver()).start();
		}
		// 激活短信邮递员
		SMPostman smPostman = new SMPostman();
		smPostman.setSmWriteClient(smWriteClient);
		smPostman.setSmReadClient(smReadClient);
		new Thread(smPostman).start();
	}
}
