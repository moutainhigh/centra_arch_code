package com.ifudata.centra.sdk.component.excel.factory;


import com.ifudata.centra.sdk.component.excel.client.AbstractExcelHelper;
import com.ifudata.centra.sdk.component.excel.client.impl.HssfExcelHelper;
import com.ifudata.centra.sdk.component.excel.client.impl.JxlExcelHelper;
import com.ifudata.centra.sdk.component.excel.client.impl.XssfExcelHelper;

public class ExcelFactory {
	/**
	 * Excel2003 .xls文件操作工具类--JXL 
	 * @return
	 * @author wangyongxin
	 */
	public static AbstractExcelHelper getJxlExcelHelper(){
		return JxlExcelHelper.getInstance();
	}
	/**
	 * Excel2003 .xls文件操作工具类--POI
	 * @return
	 * @author wangyongxin
	 */
	public static AbstractExcelHelper getHssfExcelHelper(){
		return HssfExcelHelper.getInstance();
	}
	/**
	 * Excel2007 .xlsx文件操作工具类--POI
	 * @return
	 * @author wangyongxin
	 */
	public static AbstractExcelHelper getXssfExcelHelper(){
		return XssfExcelHelper.getInstance();
	}
}
