package com.ifudata.ums.service.http.dahansantong.until;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import com.ifudata.ums.exception.BusiException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.ifudata.ums.service.http.weilaiwuxian.exception.PathException;

/**
 *
 * 2015年7月29日下午6:53:55
 * hongzhenfu
 *
 */
public class GetProperties {

	private static final Log log = LogFactory.getLog(GetProperties.class);
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Properties prop =getProperties(System.getProperty("user.dir")+"/resource/conf/http/dahansantong/dahansantong.properties");
//		System.out.println(prop.getProperty("sendtime"));
//	}
	public static Properties getProperties(String filePath){
		if(IsNull.FieldIsNull(filePath)){
			log.error(filePath+"路径不能为空");
			throw new PathException();
		}
		Properties prop = new Properties();
		try {
			InputStream in = new FileInputStream(new File(filePath));
			InputStreamReader isr = new InputStreamReader(in, Charset.forName("UTF-8"));
			prop.load(isr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(filePath+"	文件不存在！");
			throw new BusiException(filePath+"	文件未找到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(filePath+"	配置文件格式有误");
		}
		return prop;
	}

}

