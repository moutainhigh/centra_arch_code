package com.ifudata.ums.service.http.dahansantong.test;
/**
 *
 * 2015年10月10日上午9:31:19
 * hongzhenfu
 *
 */
import java.util.ArrayList;
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
import com.ifudata.ums.service.http.dahansantong.client.deliver.DHSTClientDeliver;
import com.ifudata.ums.util.ApplicationContextUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;



public class Test {
	
	private static final Log log = LogFactory.getLog(DHSTClientDeliver.class);
	private ISmsCommTask smsCommTaskService = (ISmsCommTask)ApplicationContextUtil
			.getInstance().getBean("smsCommTaskService");
	private ISysSequenceCredit sysSequence = (ISysSequenceCredit)ApplicationContextUtil
			.getInstance().getBean("sysSequence");
	
	public static void main(String[] args) {
		String shang = "{\"result\":\"0\",\"desc\":\"成功\",\"delivers\":[{\"phone\":\"15711666132\",\"content\":\"短信内容\",\"subcode\":\"4210\",\"delivertime\":\"2015-03-11 11:00:00\"},{\"phone\":\"15711666139\",\"content\":\"短信内容s\",\"subcode\":\"4210\",\"delivertime\":\"2015-03-11 11:00:00\"}]}";
//		Map<String, Object> map = JSON.parseObject(shang, new TypeReference<Map<String,Object>>(){});
//		List<Map<String, Object>> list = JSON.parseObject(map.get("delivers").toString(), new TypeReference<List<Map<String, Object>>>() {});
//		for(Map<String, Object> maps:list){
//			System.out.println("phone:["+maps.get("phone")+"] content:["+maps.get("content")+"] subcode:["+maps.get("subcode")+"] delivertime:["+maps.get("delivertime")+"]");
//		}
		new Test().test(shang);
	}
	
	public void test(String para){
		Map<String,String> jsonMap = JSON.parseObject(para, new TypeReference<Map<String, String>>() {});
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
			log.debug("********** DHSTClientDeliver 大汉三通http获取上行信息 接收到的响应值["+para+"] 不包含delivers信息");
		}	
	}
}
