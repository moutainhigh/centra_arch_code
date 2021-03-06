package com.ifudata.centra.sdk.component.excel.client.impl;

import com.ifudata.centra.sdk.component.excel.client.AbstractExcelHelper;
import com.ifudata.centra.sdk.component.excel.util.ExcelDateUtil;
import com.ifudata.centra.sdk.component.excel.util.ExcelStringUtil;
import com.ifudata.centra.sdk.component.excel.util.ReflectUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 基于POI实现的Excel 2003工具类
 * 
 * @author wangyongxin
 * 
 */
public class HssfExcelHelper extends AbstractExcelHelper {

	private static HssfExcelHelper instance = null; // 单例对象

	/**
	 * 私有化构造方法
	 */
	private HssfExcelHelper() {
		super();
	}

	/**
	 * 获取单例对象并进行初始化
	 * 
	 * @return 返回初始化后的单例对象
	 */
	public static HssfExcelHelper getInstance() {
		if (instance == null) {
			// 当单例对象为null时进入同步代码块
			synchronized (HssfExcelHelper.class) {
				// 再次判断单例对象是否为null，防止多线程访问时多次生成对象
				if (instance == null) {
					instance = new HssfExcelHelper();
				}
			}
		} else {
			
		}
		return instance;
	}	

	@Override
	public <T> List<T> readExcel(File file,Class<T> clazz, String[] fieldNames,
			int sheetNo, boolean hasTitle) throws Exception {
		List<T> dataModels = new ArrayList<T>();
		// 获取excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet = workbook.getSheetAt(sheetNo);
		int start = sheet.getFirstRowNum() + (hasTitle ? 1 : 0); // 如果有标题则从第二行开始
		for (int i = start; i <= sheet.getLastRowNum(); i++) {
			HSSFRow row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			// 生成实例并通过反射调用setter方法
			T target = clazz.newInstance();
			for (int j = 0; j < fieldNames.length; j++) {
				String fieldName = fieldNames[j];
				if (fieldName == null || UID.equals(fieldName)) {
					continue; // 过滤serialVersionUID属性
				}
				// 获取excel单元格的内容
				HSSFCell cell = row.getCell(j);
				if (cell == null) {
					continue;
				}
				String content = cell.getStringCellValue();
				// 如果属性是日期类型则将内容转换成日期对象
				if (isDateType(clazz, fieldName)) {
					// 如果属性是日期类型则将内容转换成日期对象
					ReflectUtil.invokeSetter(target, fieldName,
							ExcelDateUtil.parse(content));
				}
				else if(isTimestampType(clazz, fieldName)){
					// 如果属性是日期类型则将内容转换成日期对象
					ReflectUtil.invokeSetter(target, fieldName,
							ExcelDateUtil.parseTimestamp(content));
				}else {
					Field field = clazz.getDeclaredField(fieldName);
					ReflectUtil.invokeSetter(target, fieldName,
							parseValueWithType(content, field.getType()));
				}
			}
			dataModels.add(target);
		}
		workbook.close();
		return dataModels;
	}

	@Override
	public <T> void writeExcel(File file,String sheetName,Class<T> clazz, List<T> dataModels,
			String[] fieldNames, String[] titles) throws Exception {
		HSSFWorkbook workbook = null;
		// 检测文件是否存在，如果存在则修改文件，否则创建文件
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			workbook = new HSSFWorkbook(fis);
		} else {
			workbook = new HSSFWorkbook();
		}
		// 根据当前工作表数量创建相应编号的工作表
		if(ExcelStringUtil.isBlank(sheetName)){
			sheetName = ExcelDateUtil.format(new Date(), "yyyyMMddHHmmssSS");
		}
		HSSFSheet sheet = workbook.createSheet(sheetName);
		HSSFRow headRow = sheet.createRow(0);
		//标题单元格样式
		HSSFCellStyle headCellStyle = buildHeadCellStyle(workbook);
		//正文单元格样式
		HSSFCellStyle bodyCellStyle = buildBodyCellStyle(workbook);
		//正文数字单元格样式
		HSSFCellStyle bodyDigitalCellStyle = buildBodyDigitalCellStyle(workbook);		
						
		
		// 添加表格标题
		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = headRow.createCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(titles[i]);			
			//设置样式
			cell.setCellStyle(headCellStyle);
			// 设置单元格宽度(20个字节宽度)
			//sheet.setDefaultColumnWidth(20);
			int colWidth=titles[i].length()>5?titles[i].length():5;
			sheet.setColumnWidth(i, colWidth*1000);
		}
		// 添加表格内容
		for (int i = 0; i < dataModels.size(); i++) {
			HSSFRow row = sheet.createRow(i + 1);
			// 遍历属性列表
			for (int j = 0; j < fieldNames.length; j++) {
				// 通过反射获取属性的值域
				String fieldName = fieldNames[j];
				if (fieldName == null || UID.equals(fieldName)) {
					continue; // 过滤serialVersionUID属性
				}
				Object result = ReflectUtil.invokeGetter(dataModels.get(i),
						fieldName);
				HSSFCell cell = row.createCell(j);
				cell.setCellStyle(bodyCellStyle);
				//数值类型 居右
				if(isDigitalType(clazz, fieldName)){
					cell.setCellStyle(bodyDigitalCellStyle);
				}
				// 如果是日期类型则进行格式化处理
				if (isDateType(clazz, fieldName)) {
					cell.setCellValue(ExcelDateUtil.format((Date) result));
				}
				// 如果是日期类型则进行格式化处理
				else if (isTimestampType(clazz, fieldName)) {
					cell.setCellValue(ExcelDateUtil.format((Timestamp) result));
				}
				//其他类型  均作为字符串处理
				else{
					cell.setCellValue(ExcelStringUtil.toString(result));
				}
			}
		}
		// 将数据写到磁盘上
		FileOutputStream fos = new FileOutputStream(file);
		try {
			workbook.write(new FileOutputStream(file));
			workbook.close();
		} finally {
			if (fos != null) {
				fos.close(); // 不管是否有异常发生都关闭文件输出流
			}
		}
	}

	@Override
	public <T> void writeExcel(OutputStream os, String sheetName,Class<T> clazz, List<T> dataModels, String[] fieldNames,
			String[] titles) throws Exception {
		HSSFWorkbook workbook = null;
		workbook = new HSSFWorkbook();
		// 根据当前工作表数量创建相应编号的工作表
		if(ExcelStringUtil.isBlank(sheetName)){
			sheetName = ExcelDateUtil.format(new Date(), "yyyyMMddHHmmssSS");
		}
		HSSFSheet sheet = workbook.createSheet(sheetName);
		HSSFRow headRow = sheet.createRow(0);
		
		//标题单元格样式
		HSSFCellStyle headCellStyle = buildHeadCellStyle(workbook);
		//正文单元格样式
		HSSFCellStyle bodyCellStyle = buildBodyCellStyle(workbook);
		//正文数字单元格样式
		HSSFCellStyle bodyDigitalCellStyle = buildBodyDigitalCellStyle(workbook);		
						
		
		// 添加表格标题
		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = headRow.createCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(titles[i]);			
			//设置样式
			cell.setCellStyle(headCellStyle);
			// 设置单元格宽度(20个字节宽度)
			//sheet.setDefaultColumnWidth(20);
			int colWidth=titles[i].length()>5?titles[i].length():5;
			sheet.setColumnWidth(i, colWidth*1000);
		}
		// 添加表格内容
		for (int i = 0; i < dataModels.size(); i++) {
			HSSFRow row = sheet.createRow(i + 1);
			// 遍历属性列表
			for (int j = 0; j < fieldNames.length; j++) {
				// 通过反射获取属性的值域
				String fieldName = fieldNames[j];
				if (fieldName == null || UID.equals(fieldName)) {
					continue; // 过滤serialVersionUID属性
				}
				Object result = ReflectUtil.invokeGetter(dataModels.get(i),
						fieldName);
				HSSFCell cell = row.createCell(j);
				cell.setCellStyle(bodyCellStyle);
				//数值类型 居右
				if(isDigitalType(clazz, fieldName)){
					cell.setCellStyle(bodyDigitalCellStyle);
				}
				// 如果是日期类型则进行格式化处理
				if (isDateType(clazz, fieldName)) {
					cell.setCellValue(ExcelDateUtil.format((Date) result));
				}
				// 如果是日期类型则进行格式化处理
				else if (isTimestampType(clazz, fieldName)) {
					cell.setCellValue(ExcelDateUtil.format((Timestamp) result));
				}
				//其他类型  均作为字符串处理
				else{
					cell.setCellValue(ExcelStringUtil.toString(result));
				}
			}
		}
		// 将数据写到磁盘上
		try {
			workbook.write(os);
			workbook.close();
		} finally {
			if (os != null) {
				os.close(); // 不管是否有异常发生都关闭文件输出流
			}
		}
		
	}
	


	private HSSFCellStyle buildBodyDigitalCellStyle(HSSFWorkbook workbook) {
		HSSFCellStyle bodyDigitalCellStyle = workbook.createCellStyle();
		HSSFFont bodyDigitalFont = workbook.createFont();
		bodyDigitalFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		bodyDigitalFont.setFontHeightInPoints((short)10);
		bodyDigitalCellStyle.setFont(bodyDigitalFont);
		bodyDigitalCellStyle.setWrapText(true);// 设置自动换行
		//bodyDigitalCellStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		//bodyDigitalCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		bodyDigitalCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  //底边框
		bodyDigitalCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  //左边框
		bodyDigitalCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  //右边框
		bodyDigitalCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  //顶边框
		bodyDigitalCellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT); //居中
		bodyDigitalCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		return bodyDigitalCellStyle;
	}


	private HSSFCellStyle buildBodyCellStyle(HSSFWorkbook workbook) {
		HSSFCellStyle bodyCellStyle = workbook.createCellStyle();
		HSSFFont bodyFont = workbook.createFont();
		bodyFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		bodyFont.setFontHeightInPoints((short)10);
		bodyCellStyle.setFont(bodyFont);
		bodyCellStyle.setWrapText(true);// 设置自动换行
		//bodyCellStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		//bodyCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		bodyCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  //底边框
		bodyCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  //左边框
		bodyCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  //右边框
		bodyCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  //顶边框
		bodyCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //居中
		bodyCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		return bodyCellStyle;
	}


	private HSSFCellStyle buildHeadCellStyle(HSSFWorkbook workbook) {
		//标题单元格样式
		HSSFCellStyle headCellStyle = workbook.createCellStyle();
		HSSFFont headFont = workbook.createFont();
		headFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headFont.setFontHeightInPoints((short)10);
		headCellStyle.setFont(headFont);
		headCellStyle.setWrapText(true);// 设置自动换行
		headCellStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		headCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  //底边框
		headCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  //左边框
		headCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  //右边框
		headCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  //顶边框
		headCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //居中
		headCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		return headCellStyle;
	}


}
