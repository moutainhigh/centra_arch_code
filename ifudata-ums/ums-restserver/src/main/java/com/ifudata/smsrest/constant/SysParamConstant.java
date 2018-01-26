package com.ifudata.smsrest.constant;

import com.ifudata.smsrest.util.PropertitesFiller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SysParamConstant {

    public static Long tIME_OUT_LIMIT;
    public static Long TIMEOUT_HIS_LIMIT;
    public static Integer BATCH_TIMEOUT_SIZE;
    public static Integer BATCH_GEN_SIZE;
    public static Integer BATCH_SEND_SIZE;
    public static Integer BAND_WIDTH;
    public static List<String> SERVICE_TYPE;
    public static Integer SLEEP_TIME_TIMEOUT_MONITOR;
    public static Integer SLEEP_TIME_GENERATOR;
    public static Integer SLEEP_TIME_SENDER;
    public static Integer SLEEP_TIME_HEART_BEAT_MACHINE;
    public static String PROTOCOL;
    public static Integer SLEEP_TIME_RECEIVER;
    public static String PROCESS_UPDELIVERS;
    public static String SERVER_ID;
    
    static
    {
        Properties props = PropertitesFiller.fillPropertitesFromClassPath("conf/sysParams.properties");
        if(props != null){

            tIME_OUT_LIMIT = ((props.getProperty("timeOutLimit")!=null&&!"".equals(props.getProperty("timeOutLimit"))) ? Long.parseLong(props.getProperty("timeOutLimit")) : 30*60*1000L);
            TIMEOUT_HIS_LIMIT = ((props.getProperty("timeOutHisLimit")!=null&&!"".equals(props.getProperty("timeOutHisLimit"))) ? Long.parseLong(props.getProperty("timeOutHisLimit")) : 3*24*60*60*1000L);
            BATCH_TIMEOUT_SIZE = ((props.getProperty("batchTimeOutSize")!=null&&!"".equals(props.getProperty("batchTimeOutSize"))) ? Integer.parseInt(props.getProperty("batchTimeOutSize")) : 100);
            BATCH_GEN_SIZE = ((props.getProperty("batchGenSize")!=null&&!"".equals(props.getProperty("batchGenSize"))) ? Integer.parseInt(props.getProperty("batchGenSize")) : 100);
            BATCH_SEND_SIZE = ((props.getProperty("batchSendSize")!=null&&!"".equals(props.getProperty("batchSendSize"))) ? Integer.parseInt(props.getProperty("batchSendSize")) : 100);
            BAND_WIDTH = ((props.getProperty("bandWidth")!=null&&!"".equals(props.getProperty("bandWidth"))) ? Integer.parseInt(props.getProperty("bandWidth")) : 100);
            SLEEP_TIME_TIMEOUT_MONITOR = ((props.getProperty("sleepTimeTimeoutMonitor")!=null&&!"".equals(props.getProperty("sleepTimeTimeoutMonitor"))) ? Integer.parseInt(props.getProperty("sleepTimeTimeoutMonitor")) : 1000);
            SLEEP_TIME_GENERATOR = ((props.getProperty("sleepTimeGenerator")!=null&&!"".equals(props.getProperty("sleepTimeGenerator"))) ? Integer.parseInt(props.getProperty("sleepTimeGenerator")) : 1000);
            SLEEP_TIME_SENDER = ((props.getProperty("sleepTimeSender")!=null&&!"".equals(props.getProperty("sleepTimeSender"))) ? Integer.parseInt(props.getProperty("sleepTimeSender")) : 1000);
            SLEEP_TIME_HEART_BEAT_MACHINE = ((props.getProperty("sleepTimeHeartBeatMachine")!=null&&!"".equals(props.getProperty("sleepTimeHeartBeatMachine"))) ? Integer.parseInt(props.getProperty("sleepTimeHeartBeatMachine")) : 30000);
            PROTOCOL = ((props.getProperty("protocol")!=null&&!"".equals(props.getProperty("protocol"))) ? props.getProperty("protocol") : "sgip");
            SLEEP_TIME_RECEIVER = ((props.getProperty("sleepTimeReceiver")!=null&&!"".equals(props.getProperty("sleepTimeReceiver"))) ? Integer.parseInt(props.getProperty("sleepTimeReceiver")) : 200);
            PROCESS_UPDELIVERS = ((props.getProperty("processUpdelivers")!=null&&!"".equals(props.getProperty("processUpdelivers"))) ? props.getProperty("processUpdelivers") : "n");
            SERVER_ID = ((props.getProperty("serverID")!=null&&!"".equals(props.getProperty("serverID"))) ? props.getProperty("serverID") : "n");
            String serviceType = ((props.getProperty("serviceType")!=null&&!"".equals(props.getProperty("serviceType"))) ? props.getProperty("serviceType") : "0");
            String[] st = serviceType.split(",");
            SERVICE_TYPE = new ArrayList<>();
            for(String item:st){
                SERVICE_TYPE.add(item);
            }
        }
    }

}
