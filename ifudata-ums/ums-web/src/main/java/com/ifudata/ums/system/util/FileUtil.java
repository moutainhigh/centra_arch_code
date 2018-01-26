package com.ifudata.ums.system.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);
    public static final String ZIP_OK = "OK";// 压缩成功

    public static final String ZIP_SRC_DIR_EMPTY = "EMPTY";// 源文件夹中没有文件

    public static final String ZIP_SRC_DIR_NOT_EXISTS = "NOSRC";// 源文件夹不存在

    public static final String ZIP_DEST_EXISTS = "DESTEXISTS";// 目标压缩文件已经存在

    public static final String ZIP_FAILURE = "FAILURE";

    /**
     * 根据传入参数导出EXCEL文件到指定路径
     * 
     * @param path
     *            excel生成路径
     * @param titleList
     *            表头列表
     * @param dataList
     *            数据列表
     * @author huaxiao2
     * @param path
     */
    public static boolean exportDataToExcel(String path, String fileName, List<String> titleList,
            List<List<String>> dataList) {

        boolean exportExcelFlag = true;
        /* 1.创建一个Excel文件 */
        HSSFWorkbook workbook = new HSSFWorkbook();
        /* 2.创建Excel的一个Sheet */
        HSSFSheet sheet = workbook.createSheet();
        /* 3.创建表头冻结 */
        sheet.createFreezePane(0, 1);
        /* 4.设置列宽 */
        for (int i = 0; i < titleList.size(); i++) {
            sheet.setColumnWidth((short) i, (short) 5000);
        }

        /* 5.表头字体 */
        HSSFFont headfont = workbook.createFont();
        headfont.setFontName("宋体");
        headfont.setFontHeightInPoints((short) 12);// 字体大小
        headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
        /* 6.表头样式 */
        HSSFCellStyle headstyle = workbook.createCellStyle();
        headstyle.setFont(headfont);
        headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中

        /* 7.普通单元格字体 */
        HSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 12);
        /* 8.普通单元格样式 */
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        /* 9. 拼装表头 */
        Iterator<String> titleRowIterator = titleList.iterator();
        short columnIndex = 0;
        HSSFRow row = sheet.createRow(0);
        while (titleRowIterator.hasNext()) {

            String cellValue = titleRowIterator.next();
            HSSFCell cell = row.createCell(columnIndex);
           // cell.setEncoding(HSSFWorkbook.);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(cellValue);
            cell.setCellStyle(headstyle);
            columnIndex++;

            cell = null;

        }
        /* 10.组织表数据 */
        Iterator<List<String>> rowIterator = dataList.iterator();
        int rowIndex = 1;
        while (rowIterator.hasNext()) {
            List<String> columnList = rowIterator.next();
            row = sheet.createRow(rowIndex);
            Iterator<String> columnIterator = columnList.iterator();
            columnIndex = 0;

            while (columnIterator.hasNext()) {

                String cellValue = columnIterator.next();
                HSSFCell cell = row.createCell(columnIndex);
                //cell.setEncoding(HSSFWorkbook.ENCODING_UTF_16);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                // System.out.println("rowIndex=" + rowIndex + " columnIndex=" + columnIndex);
                cell.setCellValue(cellValue);
                cell.setCellStyle(style);
                cell = null;
                columnIndex++;

            }
            row = null;
            rowIndex++;
        }
        
        logger.debug("wb============="+workbook.toString());

        String ramPath = path + fileName;
        /* 11.导出EXCEL文件到指定路径 */
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(ramPath);
            workbook.write(fileOut);
            fileOut.close();
            logger.info("生成文件: " + ramPath);
            logger.info("生成文件path:" + new File(ramPath).getAbsolutePath());
        } catch (Exception e) {
            exportExcelFlag = false;
            logger.error(e.getMessage(),e);
        }
        return exportExcelFlag;
    }
    /**
     * 根据传入参数导出EXCEL文件到指定路径
     * 
     * @param
     *            excel生成路径
     * @param titleList
     *            表头列表
     * @param dataList
     *            数据列表
     * @author huaxiao2
     * @param
     */
    public static HSSFWorkbook exportDataToExcel(List<String> titleList,
            List<List<String>> dataList) {
        
        /* 1.创建一个Excel文件 */
        HSSFWorkbook workbook = new HSSFWorkbook();
        /* 2.创建Excel的一个Sheet */
        HSSFSheet sheet = workbook.createSheet();
        /* 3.创建表头冻结 */
        sheet.createFreezePane(0, 1);
        /* 4.设置列宽 */
        for (int i = 0; i < titleList.size(); i++) {
            sheet.setColumnWidth((short) i, (short) 5000);
        }
        
        /* 5.表头字体 */
        HSSFFont headfont = workbook.createFont();
        headfont.setFontName("宋体");
        headfont.setFontHeightInPoints((short) 12);// 字体大小
        headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
        /* 6.表头样式 */
        HSSFCellStyle headstyle = workbook.createCellStyle();
        headstyle.setFont(headfont);
        headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        
        /* 7.普通单元格字体 */
        HSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 12);
        /* 8.普通单元格样式 */
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        /* 9. 拼装表头 */
        Iterator<String> titleRowIterator = titleList.iterator();
        short columnIndex = 0;
        HSSFRow row = sheet.createRow(0);
        while (titleRowIterator.hasNext()) {
            
            String cellValue = titleRowIterator.next();
            HSSFCell cell = row.createCell(columnIndex);
            //cell.setEncoding(HSSFWorkbook.ENCODING_UTF_16);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(cellValue);
            cell.setCellStyle(headstyle);
            columnIndex++;
            
            cell = null;
            
        }
        /* 10.组织表数据 */
        Iterator<List<String>> rowIterator = dataList.iterator();
        int rowIndex = 1;
        while (rowIterator.hasNext()) {
            List<String> columnList = rowIterator.next();
            row = sheet.createRow(rowIndex);
            Iterator<String> columnIterator = columnList.iterator();
            columnIndex = 0;
            
            while (columnIterator.hasNext()) {
                
                String cellValue = columnIterator.next();
                HSSFCell cell = row.createCell(columnIndex);
                //cell.setEncoding(HSSFWorkbook.ENCODING_UTF_16);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                // System.out.println("rowIndex=" + rowIndex + " columnIndex=" + columnIndex);
                cell.setCellValue(cellValue);
                cell.setCellStyle(style);
                cell = null;
                columnIndex++;
                
            }
            row = null;
            rowIndex++;
        }
        logger.info("wb============="+workbook.toString());
        return workbook;
    }

   
    /**
     * 将大的List分割成小List
     * 
     * @param excel_count
     * 
     * @return List<List>
     */
    public static List<List<List<String>>> splitList(List<List<String>> bigList, int excel_count) {
        List<List<List<String>>> splitList = new ArrayList<List<List<String>>>();
        List<List<String>> small_list = null;
        int list_all = bigList.size();
        int for_count = list_all / excel_count;
        if (list_all % excel_count > 0) {
            for_count += 1;
        }
        for (int i = 0; i < for_count; i++) {
            small_list = new ArrayList<List<String>>();
            for (int j = excel_count * i; j < Math.min(excel_count * (i + 1), list_all); j++) {
                small_list.add(bigList.get(j));
            }
            splitList.add(small_list);
        }
        return splitList;
    }

    
    
   
    /**
     * @param args
     * @author huaxiao2
     */
    public static void main(String[] args) {

       
    	
    	List<String> titilelist = new ArrayList<String>();
    	List<List<String>> dataList = new ArrayList<List<String>>();
    	List<String> detailList1 = new ArrayList<String>();
    	List<String> detailList2 = new ArrayList<String>();
    	titilelist.add("姓名");
    	titilelist.add("性别");
    	titilelist.add("年龄");
    	titilelist.add("职位");
    	
    	detailList1.add("张磊");
    	detailList1.add("男");
    	detailList1.add("26");
    	detailList1.add("软件工程师");
    	
    	detailList2.add("李文显");
    	detailList2.add("男");
    	detailList2.add("26");
    	detailList2.add("软件工程师");
    	
    	dataList.add(detailList1);
    	dataList.add(detailList2);
    	
    	String path = "D:\\coding\\zltest\\";
    	String dateString = DateUtil.getNowDate();
    	String fileName =dateString + ".xls";
    	FileUtil.exportDataToExcel(path, fileName, titilelist, dataList);
    	
    	
     	
    	
    	
    }
}
