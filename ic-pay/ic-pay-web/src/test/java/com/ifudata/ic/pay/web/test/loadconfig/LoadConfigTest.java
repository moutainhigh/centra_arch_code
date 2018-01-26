package com.ifudata.ic.pay.web.test.loadconfig;

import java.util.ResourceBundle;

import org.junit.Test;

public class LoadConfigTest {

    public static void main(String[] args) {
        //Load2ConfigCenter.main(new String[]{"F:\\\\myJob\\test"});
    }
    
    @Test
    public void testResouceBundle() {
        ResourceBundle rb = ResourceBundle.getBundle("appsvr_conf");
        String value = rb.getString("appId");
        System.out.println(value);
    }
        
}
