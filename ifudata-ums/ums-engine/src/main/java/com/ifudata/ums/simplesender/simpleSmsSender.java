package com.ifudata.ums.simplesender;

import com.ifudata.ums.service.sgip.client.SGIPClient;
import com.ifudata.ums.service.sgip.constant.ClientConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangyongxin on 2017/7/12.
 */
public class simpleSmsSender {

    public static void main(String[] args) throws Exception {
        String phone = ClientConstant.USER_PHONE;
        if(phone!=null&&!"".equals(phone)){
            List<String> phoneList = new ArrayList<>();
            if(phone.indexOf(",")>0){
                String[] phones = phone.split(",");
                phoneList.addAll(Arrays.asList(phones));
            }else {
                phoneList.add(phone);
            }
            SGIPClient.sendMsg(phoneList,ClientConstant.SEND_CONTENT,false);
        }else {
            throw new Exception("请设置发送号码，多个号码用\",\"隔开");
        }
    }
}
