package com.ifudata.ums.service.http.dahansantong.client.deliver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.ums.dao.mapper.bo.SmsCommTask;
import com.ifudata.ums.exception.FindSeqenceException;
import com.ifudata.ums.exception.InsertException;
import com.ifudata.ums.exception.UpdateException;
import com.ifudata.ums.manager.ISmsCommTask;
import com.ifudata.ums.manager.ISysSequenceCredit;
import com.ifudata.ums.service.http.dahansantong.constant.DaHanSanTongConstant;
import com.ifudata.ums.service.http.dahansantong.until.MD;
import com.ifudata.ums.util.ApplicationContextUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 *
 * 2015年10月9日下午3:54:52
 * hongzhenfu
 *
 */
public class DHSTClientDeliver implements Runnable{
	
	private static final Log log = LogFactory.getLog(DHSTClientDeliver.class);
	private ISmsCommTask smsCommTaskService = (ISmsCommTask)ApplicationContextUtil
			.getInstance().getBean("smsCommTaskService");
	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
			.getInstance().getBean("sysSequence");
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//首先设置当前线程名称
		Thread.currentThread().setName("DHSTClientDeliver");
		while (true) {
			 Map<String, String> sendMessage = new HashMap<String, String>();
			try {
				URL myurl = new URL(DaHanSanTongConstant.DELIVER_URL);
				URLConnection urlc = myurl.openConnection();
				urlc.setReadTimeout(1000 * 30);
				urlc.setDoOutput(true);
				urlc.setDoInput(true);
				urlc.setAllowUserInteraction(false);
				String pwd = MD.sign(DaHanSanTongConstant.PASSWORD, "", "utf-8");
			    sendMessage.put("account", DaHanSanTongConstant.ACCOUNT);
			    sendMessage.put("password", pwd);
			    
				DataOutputStream server = new DataOutputStream(urlc.getOutputStream());
				server.write(JSON.toJSONString(sendMessage).getBytes("utf-8"));
			    log.debug("********** DHSTClientDeliver 大汉三通http获取上行信息  发送地址： ["
			                + DaHanSanTongConstant.DELIVER_URL + "]; account：["
			                + DaHanSanTongConstant.ACCOUNT + "]; password：["
			                + DaHanSanTongConstant.PASSWORD+"];加密后password:["+pwd+"] **********");
				server.close();

				BufferedReader in = new BufferedReader(new InputStreamReader(
						urlc.getInputStream(), "utf-8"));
				String result = "", s = "";
				while ((s = in.readLine()) != null)
					result = result + s;
				in.close();
				Map<String,String> jsonMap = JSON.parseObject(result, new TypeReference<Map<String, String>>() {});
				if("0".equals(jsonMap.get("result"))&&null!=jsonMap.get("delivers")&&!"".equals(jsonMap.get("delivers"))){
					List<Map<String, Object>> list = JSON.parseObject(jsonMap.get("delivers").toString(), new TypeReference<List<Map<String, Object>>>() {});
					List<SmsCommTask> sctlist = new ArrayList<>();
					for(Map<String, Object> maps:list){
						SmsCommTask sct = new SmsCommTask();
						try {
							sct.setCommTaskSerial(Integer.valueOf(sysSequence.getSequence("SAC_SMS_MM").toString()));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UpdateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (FindSeqenceException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						sct.setSvcType("0");
						sct.setRegionId("Z");
						sct.setDeviceNumber(maps.get("phone").toString());
						sct.setRunStatus("0");
						sct.setMessage(maps.get("content").toString());
						sct.setTryNum(0);
						sct.setSpNumber(maps.get("subcode").toString());
						sct.setReturnResult(null);
						sctlist.add(sct);
					}
					try {
						smsCommTaskService.insertSmsCommTask(sctlist);
					} catch (InsertException e) {
						// TODO Auto-generated catch block
						log.debug("插入SmsCommTask表失败 "+e.toString());
					}
				}else{
					log.debug("********** DHSTClientDeliver 大汉三通http获取上行信息 接收到的响应值["+result+"] 不包含delivers信息");
					try {
						Thread.sleep(Long.valueOf(DaHanSanTongConstant.DELIVER_SLEEP)*1000);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				log.debug("********** submit_url无法连接，请查看url配置是否正确以及有效 **********");
				log.debug(e.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.debug("********** submit_url无法连接，请查看url配置是否正确以及有效 **********");
				log.debug(e.toString());
			}
		}
	}
}

