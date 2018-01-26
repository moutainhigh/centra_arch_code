/**
 * COPYRIGHT (C) 2010 LY. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of 3KW.
 *
 * Created By: zzqiang
 * Created On: 2013-10-17
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.ifudata.ums.service.sgip.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.ifudata.ums.service.sgip.exception.SGIPException;

/**
 * @author guofei
 */
public class SgipPropertiesUtils {

	private static final Properties props = new Properties();

	static {
		try {
			props.load(new InputStreamReader(SgipPropertiesUtils.class.getClassLoader().getResourceAsStream("conf/sgip/sgip.properties"),"UTF-8"));
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
