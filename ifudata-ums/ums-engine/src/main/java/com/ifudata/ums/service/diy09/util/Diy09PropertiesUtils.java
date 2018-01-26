package com.ifudata.ums.service.diy09.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.ifudata.ums.service.sgip.exception.SGIPException;
import com.ifudata.ums.service.sgip.util.SgipPropertiesUtils;

public class Diy09PropertiesUtils {
	private static final Properties props = new Properties();

	static {
		try {
			props.load(new InputStreamReader(SgipPropertiesUtils.class.getClassLoader().getResourceAsStream("diy09/diy09SMS.properties"),"UTF-8"));
//			props.load(SgipPropertiesUtils.class.getClassLoader().getResourceAsStream("sgip/sgip.properties"));
		} catch (IOException e) {
			throw new SGIPException(e);
		}
	}
	
	public static Properties getProps(){
		return props;
	}
	
	public static void main(String[] args) {
		System.out.println(props);
	}
}
