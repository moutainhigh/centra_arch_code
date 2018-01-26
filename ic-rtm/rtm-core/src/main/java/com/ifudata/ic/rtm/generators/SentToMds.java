package com.ifudata.ic.rtm.generators;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ifudata.dvp.sdk.mds.MessageSender;
import com.ifudata.dvp.sdk.util.RedisUtil;
import com.ifudata.ic.rtm.constants.RtmConstants;
import com.ifudata.ic.rtm.initload.GetMdsProperty;
import com.ifudata.ic.rtm.utils.PropertiesUtil;
import com.alibaba.fastjson.JSON;
import java.util.Random;

public class SentToMds {
	private static Random random = new Random();
	private static Logger logger=LoggerFactory.getLogger(SentToMds.class);
	private static final String topic = "IFUDATA_SMC_PREPROCESS_MDS";
	public void MessagePackage(String systemId,String[] records,String recordSplit,int type){
		//String batchSplit=(String)PropertiesUtil.getValue("rtm.batch.head.message");
		StringBuilder batchrecord=new StringBuilder();
		int num=0;
		int sendNum=0;
		for(String record:records){
			if(num==0){
				batchrecord.append(record);	
				num++;
			}else{
				batchrecord.append(recordSplit).append(record);
				num++;
			}
			if(num>=50){
				sentMessage(systemId,batchrecord.toString(),type);
				num=0;
				batchrecord.delete(0,batchrecord.length());
				logger.debug("the lllllllllll is "+batchrecord.toString());
				sendNum++;
				logger.debug("the hahahahahahahaha is "+sendNum);
			}
		}
		sentMessage(systemId,batchrecord.toString(),type);
	}
	//开始向Mds中发送消息
	private void sentMessage(String systemId,String message,int type){
		StringBuilder mdsKey= new StringBuilder();
		if(type==1)
			mdsKey.append(systemId.toUpperCase()).append(RtmConstants.KEY_JOINER).append("AMC");
		if(type==0)
			mdsKey.append(systemId.toUpperCase()).append(RtmConstants.KEY_JOINER).append("BMC");
		logger.debug("the read mds is "+mdsKey.toString());
		String mds=RedisUtil.get(mdsKey.toString());
		logger.debug("the mds is "+mds);
		 logger.debug("the message length is "+message.length());
		logger.debug("the kafka message is11 "+JSON.toJSONString(message));
		if(message.length()!=0){
		//for(String name:names){
			try{
//				 IMessageSender sender = MDSClientFactory.getSenderClient(mds);
//				 sender.send(message, new Random(1000).nextLong());
				
				MessageSender.send(topic, message);
			}catch(Exception e){
				logger.debug("send to kafka is fail ....."+e.getMessage());
				e.printStackTrace();
			}
			 //logger.debug("the kafka message is "+JSON.toJSONString(message));
		}
		//}
	}
	
	public static void main(String[] args){
		String mds="BAAS_VLVBMC_MDS";
//		IMessageSender sender = MDSClientFactory.getSenderClient(mds);
		MessageSender.send(topic, mds);
//		sender.send("hello ......", random.nextInt(2)%2);
		MessageSender.send(topic, "hello ......");
	}
	
}
