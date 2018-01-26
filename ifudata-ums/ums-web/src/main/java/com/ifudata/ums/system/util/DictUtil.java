package com.ifudata.ums.system.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;

public class DictUtil {
	 private static Logger logger = Logger.getLogger(DictUtil.class);
	/**
	 * 获取参数表GN_SYS_PARAM 参数描述信息
	 * 
	 * @param dictId  TYPE_CODE.PARAM_CODE
	 * @param value    COLUMN_VALUE
	 * @return
	 */
	public static String getValueDesc(String dictId, String value){
		try {
			String result = "";
			if(StringUtils.isNotBlank(dictId)&&dictId.contains(".")){
				//--表名、字段名
				String typeCode = dictId.substring(0,dictId.indexOf("."));
				String paramCode  = dictId.substring(dictId.indexOf(".")+1);
				//result = SysParamUtil.getSysParamDesc(typeCode, paramCode, value);
				if(StringUtils.isBlank(result)){
					//result = GnSysSqlParamUtil.getSysParamDesc(typeCode, paramCode, value);
				}
			}
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
	
	/**
	 * 获取参数表GN_SYS_PARAM 参数信息
	 * 
	 * @param dictId  TYPE_CODE.PARAM_CODE
	 * @return
	 */
	public static JSONArray getSysParamS(String dictId){
		try {
			JSONArray arrays = null;
			if(StringUtils.isNotBlank(dictId)&&dictId.contains(".")){
				//--表名、字段名
				String typeCode = dictId.substring(0,dictId.indexOf("."));
				String paramCode  = dictId.substring(dictId.indexOf(".")+1);
				//arrays = SysParamUtil.getSysParams(typeCode, paramCode);
				if(arrays==null||arrays.isEmpty()||arrays.size()==0){
					//arrays = JSONArray.parseArray(GnSysSqlParamUtil.getSysParams(typeCode, paramCode).toString());
				}
			}
			return arrays;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
	public static void main(String[] args) {
//	    System.out.println(SysParamUtil.getSysParamDesc("TD_M_AREA","AREA_LEVEL","1"));
//	    System.out.println(getValueDesc("GN_AREA.AREA_CODE","11"));
    }
}
