package com.ifudata.ic.pay.web.test.config;

import java.util.Map;

import org.junit.Test;

import com.ifudata.centra.sdk.component.ccs.util.ConfigTool;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:context/core-context.xml"})
public class ConfigTestUtils {

	// com.ifudata.dvp.sdk.ccs.util
	@Test
	public void ConfigToolTest() {

		Map<String, Object> configFile = ConfigTool.getConfigFile("ic_pay_infomation.properties");
		System.out.println("-------------------------------");

		
		Object object = configFile.get("/com/ifudata/ic/pay-center/config/BIS-ST/ZFB");
		//System.out.println(configFile.toString());
		System.out.println(object.toString());
		
//		System.out.println("====----->"+configFile.get("com.ifudate.pay"));

	}

}
