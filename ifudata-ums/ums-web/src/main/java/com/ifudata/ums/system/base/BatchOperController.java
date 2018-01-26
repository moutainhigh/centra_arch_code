package com.ifudata.ums.system.base;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifudata.ums.system.util.StringUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;


public abstract class BatchOperController extends BaseController{
    
    //文件模板存放路径
    protected final static String TEMPLET_FILE_PATH = "/excel_config/templet/";
    //失败文件存放路径
    protected final static String FAILED_FILE_PATH = "/excel_config/tempFile/failedRecordFile/";
    
    protected Logger logger = Logger.getLogger(BatchOperController.class);
    

    
    /**
     * 初始化页面信息，并进入到批量操作页面
     * @param request
     * @param response
     * @return
     * @author moubd
     */
    public abstract String initPage(HttpServletRequest request, HttpServletResponse response) ;
    
    /**
     * 下载上传文件模板
     * @param request
     * @param response
     * @author moubd
     */
    public abstract void downloadTempFile(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * 上传文件
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @author moubd
     */
    public abstract void uploadFile(HttpServletRequest request,HttpServletResponse response) throws Exception;
    
    
    /**
     * 下载格式校验失败的数据文件
     * @param request
     * @param response
     * @throws Exception
     * @author moubd
     */
    public abstract void downloadFailedFile(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * 批量提交
     * @param request
     * @param response
     * @throws Exception
     * @author moubd
     */
    public abstract void submitBatch(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * 下载上传文件模板——样例方法（可直接使用此方法）
     * @param request
     * @param response
     * @param templetFileName 模板文件名 例：userTemplet.xls
     * @param filePath 模板文件路径 例：\\excel_config\\templet\\
     * @param fileName 模板下载后给用户显示的文件名称
     * @throws Exception
     * @author moubd
     */
    public void downloadTempletFileOfExample(HttpServletRequest request,HttpServletResponse response,String templetFileName,String filePath,String fileName) throws Exception{
        String realPath = request.getServletContext().getRealPath("");
        OutputStream outputStream = null;
        PrintWriter printWriter =null;
        FileInputStream fileInputStream = null;
        InputStream inps = null;
        try {
            logger.debug(realPath+filePath+templetFileName);
            fileInputStream = new FileInputStream(realPath+filePath+templetFileName);
            
            inps = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[inps.available()];
            inps.read(buffer);
            inps.close();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String((fileName).getBytes("GBK"), "ISO8859-1"));
            outputStream = response.getOutputStream();
            outputStream.write(buffer);
            outputStream.flush();
         } catch (Exception e) {
                String retMsg = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
                String message = "下载明细文件失败，失败原因："+retMsg;
                logger.error(message);
                response.setContentType("text/html;charset=utf-8");
                printWriter = response.getWriter();
                printWriter.write(message);
                printWriter.flush();
        }finally{
            if(inps!=null){
                inps.close();
            }
            if(fileInputStream!=null){
                fileInputStream.close();
            }
            if(outputStream!=null){
                outputStream.close();
            }
            if(printWriter!=null){
                printWriter.close();
            }
        }
    }
    /**
     * 上传文件——样例方法（可直接使用此方法）
     * @param request
     * @param response
     * @param validateTempletFileName 校验模板文件名称
     * @param failTempletFileName 失败文件模板名称
     * @param templetFilePath 失败文件模板路径
     * @param newFileName 生成校验失败的临时文件名
     * @param storeNewFilePath 存放临时文件的路径
     * @param busiType 操作类型
     * @throws Exception
     * @author moubd
     */
    @SuppressWarnings("unchecked")
    public void uploadFileOfExample(HttpServletRequest request,HttpServletResponse response,String validateTempletFileName, String failTempletFileName,String templetFilePath,String newFileName,String storeNewFilePath, String busiType) throws Exception{
        logger.debug("-------------上传Excel start-------------");
        List<FileItem> items = null;
        String fileName = null;
        FileItem item = null;
        InputStream inputStream = null;
        // 设置请求编码方式
        request.setCharacterEncoding("utf-8");
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
        	//String maxCount = CfgPropertiesUtil.getValue("BATCH_MEMBER_IMPORT", "MAX_COUNT");
        	//int MAX_ITEM_COUNT = Integer.valueOf(maxCount);
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if(isMultipart){
                items = upload.parseRequest(request);
                 Iterator<FileItem> iter_check = items.iterator();
                    /* 1.校验上传文件名称 */
                    while (iter_check.hasNext()) {
                        item = (FileItem) iter_check.next();
                        if (! item.isFormField()){
                            fileName = item.getName();
                            logger.debug("文件全名 AllFileName:"+fileName);
                            fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                            logger.debug("文件名称 fileName："+fileName);
                        }
                    } 
                    if( StringUtil.isBlank(fileName)){
                        logger.debug("获取文件失败");
                        this.responseFailed(response, "获取文件失败", null);
                        return;
                    }
         
                    inputStream = item.getInputStream();
                    
                    Workbook workbook = createWorkbook(inputStream);
            
                    Sheet sheet = workbook.getSheetAt(0);
                    
                    //去掉空行
                    Iterator<Row> rowIterator = sheet.iterator();
                    List<Row> removeRowList = new ArrayList<Row>();
                    while (rowIterator.hasNext()) {
                        
                        Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.iterator();
                        
                        boolean isNull = true;
                        while (cellIterator.hasNext()) {

                            Cell cell = cellIterator.next();
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            if( ! StringUtil.isBlank(cell.getStringCellValue())){
                                isNull = false;
                                break;
                            }
                        }
                        if(isNull == true){
                        	
                        	removeRowList.add(row);
                        }
                    }
                    for (Row row : removeRowList) {
						
                    	sheet.removeRow(row);
					}
                   
                    //校验excel表头
                    if(! validateExcelHead(sheet, validateTempletFileName, templetFilePath)){
                        responseFailed(response, "上传文件格式错误，请参照模板", null);
                        return;
                    }
                    List<List<Object>> dataList=new ArrayList<List<Object>>();
                    StringBuffer sb=new StringBuffer();
                    sb.setLength(0);
                    int startIndex = sheet.getFirstRowNum();
                    Row sheetHead = sheet.getRow(startIndex);
                    Cell tempCell = sheetHead.getCell(1);
                    tempCell.setCellType(Cell.CELL_TYPE_STRING);
                    String itemStr = tempCell.getStringCellValue();
                    if( StringUtil.isBlank(itemStr) || ! itemStr.matches("^\\d+$")){
                        
                        this.responseFailed(response, "上传文档记录数为空", null);
                        return;
                    }
                    int itemCount = Integer.parseInt(itemStr);
                    /*
                    if(itemCount > MAX_ITEM_COUNT){
                        this.responseFailed(response, "记录数不能超过"+MAX_ITEM_COUNT+"条", null);
                        return;
                    }
                    */
                    if(itemCount != sheet.getLastRowNum()-1){
                        this.responseFailed(response, "记录总记录数与实际记录数不匹配", null);
                        return;
                    }
                    
                    logger.debug("sheet.getLastRowNum()="+sheet.getLastRowNum());
                    //组装成list
                    
                    for(int i=2;i<=sheet.getLastRowNum();i++){
                        Row row = sheet.getRow(i);
                        if(row==null){
                            continue;
                        }
                        List<Object> rowList=new ArrayList<Object>();
                        for(int j=0;j<row.getLastCellNum();j++){
                            Cell cell = row.getCell(j);
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            rowList.add(cell.getStringCellValue());
                            sb.append("\t"+cell.getStringCellValue());
                        }
                        sb.append("\n");
                        dataList.add(rowList);
                    }
                    logger.debug(sb.toString());
                    //获取校验后list，包含成功list，失败list
                    Map<String,Object> subsListMap = checkFileFormat(dataList, busiType);
                    //获取检验成功的数据信息列表，用于返回前台显示，同时生成临时文件作为开户提交
                    List<Object> successedDataList = (List<Object>) subsListMap.get("sucessedDataList");
                    org.json.JSONObject jsonObject = new JSONObject();
                    List<Object> failedDataList = (List<Object>) subsListMap.get("failedDataList");
                    if(failedDataList!=null&&failedDataList.size()>0){
                        String realPath = request.getServletContext().getRealPath("");
                        String readPath = realPath + templetFilePath + failTempletFileName;
                        String writePath = realPath + storeNewFilePath + newFileName;
                        this.createFilePath(realPath + storeNewFilePath);
                        List<Object> tmpList = new ArrayList<Object>();
                        tmpList.addAll(failedDataList);
                        if(successedDataList!=null&&successedDataList.size()>0){
                        	tmpList.addAll(successedDataList);
                        }
                        boolean flag = exportDataToExcel(tmpList,readPath,writePath);
                        logger.info("exportDataToExcel flag===\n\r"+flag+"\n\r");
                        System.out.println("exportDataToExcel flag="+flag);
                        if(flag){
                            //返回生成的校验失败信息ExcelID
                            jsonObject.put("fileId", newFileName);
                            jsonObject.put("failedSize", failedDataList.size());
                        }
                    }
                    jsonObject.put("countSize", successedDataList.size()+failedDataList.size());
                    jsonObject.put("array", successedDataList);
                    logger.debug(jsonObject);
                    logger.info("jsonObject ======\n\r"+jsonObject.toString());
                    this.responseSuccess(response, "成功！", jsonObject);
            }
        }catch (NumberFormatException e) {
            logger.error("获取文件总记录数失败",e);
            this.responseFailed(response, "获取文件总记录数失败，请检查是否为纯数字后再提交！", null);
            
        }catch(NullPointerException e){
            logger.error("页面停留时间过长获取请求失败，请重新刷新页面" + e.getCause(),e);
            this.responseFailed(response, "上传文件失败，请检查文件内容格式是否正确！", null);
        }catch (Exception e) {
            logger.error("文件上传失败" + e.getCause(),e);
            this.responseFailed(response, "上传文件失败，请联系系统管理员", null);
        }finally{
            if(inputStream!=null){
                inputStream.close();
            }
        }
    }

    private boolean validateExcelHead(Sheet sheet, String templetFileName, String templetFilePath) throws InvalidFormatException {
        
        String realPath = request.getServletContext().getRealPath("");
        String path = realPath+templetFilePath+templetFileName;
        try {
        	path = path.replaceAll("\\\\", "/");
            FileInputStream inputStream = new FileInputStream(path);
            Workbook wb = createWorkbook(inputStream);
          
            Sheet templeteSheet = wb.getSheetAt(0);
            Row templeteNumRow = templeteSheet.getRow(0);
            String templeteNum = templeteNumRow.getCell(templeteNumRow.getFirstCellNum()).getStringCellValue();
            Row templeteHeadRow = templeteSheet.getRow(1);
            
            Row numRow = sheet.getRow(0);
            String num = numRow.getCell(numRow.getFirstCellNum()).getStringCellValue();
            Row headRow = sheet.getRow(1);
            
            if(templeteNum.equals(num) && templeteHeadRow.getLastCellNum() == headRow.getLastCellNum()){
                
                
                for (int i=templeteHeadRow.getFirstCellNum();  i < templeteHeadRow.getLastCellNum(); i++) {
                    
                    String templetHead = templeteHeadRow.getCell(i).getStringCellValue();
                    String head = headRow.getCell(i).getStringCellValue();
                    if (! templetHead.equals(head)) {
                        return false;
                    }
                }
            }else {
                return false;
            }
            
        } catch (FileNotFoundException e) {
            logger.error("模板文件不存在", e);
            return false;
        } catch (IOException e) {
            logger.error("操作模板文件异常", e);
            return false;
        }
        return true;
    }

    /**
     * 校验数据格式
     * @param dataList
     * @param busiType 操作类型
     * @return
     * @author moubd
     */
    public abstract Map<String,Object> checkFileFormat(List<List<Object>> dataList, String busiType);
    /**
     * 失败数据信息列表转换Excel文件
     * @param failedDataList
     * @param readPath
     * @param writePath
     * @return
     * @throws Exception
     * @author moubd
     */
    private boolean exportDataToExcel(List<Object> failedDataList,String readPath,String writePath) throws Exception{
        boolean excelExportFlag = true;
        FileInputStream inputStream = null;
        FileOutputStream fileOut = null;
        try {
            inputStream = new FileInputStream(new File(readPath));
            Workbook workbook = createWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            this.setSheet(sheet, failedDataList);
            fileOut = new FileOutputStream(writePath);
            workbook.write(fileOut);
            fileOut.close();
            logger.debug("生成文件: " + writePath);
            logger.debug("生成文件path:" + new File(writePath).getAbsolutePath());
        } catch (Exception e) {
            excelExportFlag = false;
            logger.error("生成文件: " + e.getMessage(),e);
        }finally{
            if(fileOut!=null){
                fileOut.close();
            }if(inputStream!=null){
                inputStream.close();
            }
        }
       return excelExportFlag;
    }
    /**
     * 把失败数据插入到sheet中
     * @param sheet
     * @param failedDataList
     * @author moubd
     */
    public abstract void setSheet(Sheet sheet,List<Object> failedDataList);
    /**
     * 下载失败方法——样例方法（可直接使用此方法）
     * @param request
     * @param response
     * @param filePath 失败文件的存放路径
     * @param fileName 失败文件名
     * @param flag 是否需要下载文件表示  其中：true 表示需要；false表示不需要
     * @param displayFileName  给用户展示的失败文件名称
     * @throws Exception
     * @author moubd
     */
    public void downloadFailedFileOfExample(HttpServletRequest request, HttpServletResponse response,String filePath,String fileName,boolean flag,String displayFileName) throws Exception{
        logger.debug("失败记录文件名称："+fileName);
        String realPath = request.getServletContext().getRealPath("");
        OutputStream outputStream = null;
        PrintWriter printWriter =null;
        FileInputStream fileInputStream = null;
        InputStream inps = null;
        if (fileName.contains("..") || displayFileName.contains("..")) {

            String retMsg = "文件禁止访问";
            String message = "下载失败记录失败，失败原因：" + retMsg;
            logger.error(message);
            response.setContentType("text/html;charset=utf-8");
            printWriter = response.getWriter();
            printWriter.write(message);
            printWriter.flush();
        }else{
            try {

                if (flag) {
                    // 需要下载文件
                    logger.debug(realPath + filePath + fileName);
                    fileInputStream = new FileInputStream(realPath + filePath + fileName);

                    inps = new BufferedInputStream(fileInputStream);
                    byte[] buffer = new byte[inps.available()];
                    inps.read(buffer);
                    inps.close();
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-disposition", "attachment;filename="
                            + new String((displayFileName).getBytes("GBK"), "ISO8859-1"));
                    outputStream = response.getOutputStream();
                    outputStream.write(buffer);
                    outputStream.flush();
                }
                // 无论是否下载文件，临时文件最后都需要立即删除
                File file = new File(realPath + filePath + fileName);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                String retMsg = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
                String message = "下载失败记录失败，失败原因：" + retMsg;
                logger.error(message);
                response.setContentType("text/html;charset=utf-8");
                printWriter = response.getWriter();
                printWriter.write(message);
                printWriter.flush();
            } finally {
                if (inps != null) {
                    inps.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            }
        }
     }
    /**
     * 创建文件目录，如果存在，则什么也不执行，否则创建目录
     * @param path
     * @author moubd
     */
    public void createFilePath(String path){
        File myPath=new File(path);
        if(!myPath.exists()){
            myPath.mkdir();             
        }
    }
    
    public void buildCell(Cell cell,String cellText,CellStyle cellStyle){
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(cellText);
    }
    
    private Workbook createWorkbook(InputStream inputStream) throws IOException, InvalidFormatException {
        
        Workbook workbook = null;
        if( ! inputStream.markSupported()){
            inputStream = new PushbackInputStream(inputStream,8);
        }
        //OLE 2  EXCEL 2003
        if (POIFSFileSystem.hasPOIFSHeader(inputStream)) {
            workbook =  new HSSFWorkbook(inputStream);
            return workbook;
        }
        //OOXML EXCEL 2007+
        if (POIXMLDocument.hasOOXMLHeader(inputStream)) {
            workbook =  new XSSFWorkbook(OPCPackage.open(inputStream));
        }

      
        return workbook;
    }
    public void qrySubsBalance(HttpServletRequest request, HttpServletResponse response)throws Exception {}
    
}
