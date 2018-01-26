package com.ifudata.ums.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import com.ifudata.ums.exception.BusiException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * 提供properties文件的填充服务
 * @author guofei
 */
public class PropertitesFiller {

	private static final Log log = LogFactory.getLog(PropertitesFiller.class);
	
	/**
	 * 从当前路径加载properties文件
	 * @param propFileName
	 * @return
	 */
	public static Properties fillPropertites(String propFileName) {
		Properties prop = new Properties();
		try {
			InputStream in = new FileInputStream(new File(propFileName));
			InputStreamReader isr = new InputStreamReader(in, Charset.forName("UTF-8"));
			prop.load(isr);
		} catch (IOException e) {
			log.error(propFileName+"文件未找到");
			throw new BusiException(propFileName+"文件未找到");
		}
		return prop;
	}
	
	/**
	 * 从类路径加载properties文件
	 * @param propFileName
	 * @return
	 */
	public static Properties fillPropertitesFromClassPath(String propFileName) {
		Properties prop = new Properties();
		try {
			InputStream in = PropertitesFiller.class.getClassLoader().getResourceAsStream(propFileName);
			InputStreamReader isr = new InputStreamReader(in, Charset.forName("UTF-8"));
			prop.load(isr);
		} catch (IOException e) {
			log.error(propFileName+"文件未找到");
			throw new BusiException(propFileName+"文件未找到");
		}
		return prop;
	}
}
