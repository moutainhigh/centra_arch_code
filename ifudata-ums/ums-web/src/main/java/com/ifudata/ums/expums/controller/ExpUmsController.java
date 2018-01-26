package com.ifudata.ums.expums.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ifudata.centra.base.vo.ResponseHeader;
import com.ifudata.centra.sdk.dubbo.util.DubboConsumerFactory;
import com.ifudata.ums.api.applybatch.interfaces.IOrdApplyBatchDubboSV;
import com.ifudata.ums.api.applybatch.param.*;
import com.ifudata.ums.expums.model.GrantsRecord;
import com.ifudata.ums.system.base.BatchOperController;
import com.ifudata.ums.system.config.ConstantsResultCode;
import com.ifudata.ums.system.exception.BusiException;
import com.ifudata.ums.system.util.StringUtil;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequestMapping(value = "/expums")
public class  ExpUmsController extends BatchOperController {
	private Logger logger = Logger.getLogger(ExpUmsController.class);    

	//页面路径
	private static final String EXP_UMS_CONFIG= "/expums/ExpUmsConfig";
	//上传文件模板名称
	private static final String UPLOAD_TEMPLET_FILE_NAME = "expUmsTemplate.xls"; 
	//失败文件模板名称
	private static final String FAILED_TEMPLET_FILE_NAME = "expUmsFailedTemplate.xls";
	//操作类型
	private static final String BATCH_GRANTS_BUSI_TYPE = "25"; // ??
	//是否需要下载失败文件
	private final String DOWNLOAD_FILE = "YES";//"YES"需要下载，"NO"不需要下载

	/* 初始导入页面	*/
	@Override
	@RequestMapping(value="ExpUmsConfig")
	public String initPage(HttpServletRequest request, HttpServletResponse response) {
		logger.info("ums短信监控配置begin");
		return EXP_UMS_CONFIG;
	}


	/* 下载 导入模板 */ 
	@Override
	@RequestMapping(value="downTemplateFile")
	public void downloadTempFile(HttpServletRequest request, HttpServletResponse response)
			throws Exception {    
		//模板下载后给用户显示的文件名称
		String fileName = "UMS短信推广模板"+".xls";
		this.downloadTempletFileOfExample(request, response, UPLOAD_TEMPLET_FILE_NAME, TEMPLET_FILE_PATH, fileName);
	}


	/* 上传excel文件  */
	@Override
	@RequestMapping(value="uploadBatchGrants",method=RequestMethod.POST)
	public void uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//newFileName 生成校验失败的临时文件名
		String newFileName = "expUmsFailed_"+String.valueOf(System.currentTimeMillis())+".xls"; 
		 System.out.println("newFileName生成校验失败的临时文件名："+newFileName);
		this.uploadFileOfExample(request, response, UPLOAD_TEMPLET_FILE_NAME, FAILED_TEMPLET_FILE_NAME, TEMPLET_FILE_PATH, newFileName, FAILED_FILE_PATH, BATCH_GRANTS_BUSI_TYPE);
	}
	/* 下载校验失败记录临时文件 */
	@Override
	@RequestMapping(value="downloadFailedFile") 
	public void downloadFailedFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//失败文件名 
		String fileName = request.getParameter("failFileName");
		fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		//给用户展示的失败文件名称
		String displayFileName = "短信推广失败信息_" + String.valueOf(System.currentTimeMillis()) + ".xls";
		downloadFailedFileOfExample(request, response, FAILED_FILE_PATH, fileName, true, displayFileName);

	}



	/*  验证序列号
	 * @param seriesNo 
	 */
	private boolean validateSeriesNo(String seriesNo){

		Pattern pattern = Pattern.compile("^\\d{1,9}$");
		Matcher matcher = pattern.matcher(seriesNo);
		return matcher.matches();
	}


	/*  手机号码校验
	 * @param phoneNum 
	 */
	public boolean validPhoneNum(String phoneNum){
		boolean flag=false;
		Pattern pattern = null;
		Matcher m = null;
		pattern = Pattern.compile("^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\\d{8})?$");		
		if(phoneNum.length()!=11){
			return false;
		}else{
			m = pattern.matcher(phoneNum);
			flag = m.matches();
		}
		return flag;
	}



	/*  按指定格式将字符串转换为 java.sql.Timestamp  */
	public static Timestamp to_timestamp(String dateStr, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			Date date = df.parse(dateStr);
			Timestamp d = new Timestamp(date.getTime());
			return d;
		} catch (Exception e) {

		}

		return null;
	}

	/*  判断时间是否符合格式要求   */
	public static boolean isValidDate(String str, String fomat) {
		boolean flag = true;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(fomat);
			sdf.parse(str);
			flag = true;
		} catch (ParseException e) {
			flag = false;
		}
		return flag;
	} 



	/* 验证日期格式 yyyyMM、yyyyMMdd、yyyyMMddHHmmss   */
	public static boolean isDateType(String str) {
		String withYYYYMMDDHHSSRegax = "^\\d{4}([1-9]|(1[0-2])|(0[1-9]))([1-9]|([12]\\d)|(3[01])|(0[1-9]))(([0-1][0-9])|([2][0-3]))([0-5][0-9])([0-5][0-9])$";
		String withYYYYMMDDRegax = "^\\d{4}([1-9]|(1[0-2])|(0[1-9]))([1-9]|([12]\\d)|(3[01])|(0[1-9]))$";
		String withYYYYMMRegax = "^\\d{4}((1[0-2])|(0[1-9]))$";
		if (StringUtil.isBlank(str))
			return false;
		if (str.length() == 6)
			return str.matches(withYYYYMMRegax);

		if (str.length() == 8)
			return str.matches(withYYYYMMDDRegax);

		if (str.length() == 14)
			return str.matches(withYYYYMMDDHHSSRegax);

		return false;
	}


  
	/**
	 * 校验上传文件，生成成功与失败记录
	 */
	@Override
	public Map<String, Object> checkFileFormat(List<List<Object>> dataList, String busiType) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<GrantsRecord> successDataList = new ArrayList<GrantsRecord>();
		List<GrantsRecord> failDataList = new ArrayList<GrantsRecord>();

		List<String> seriesNoList = new ArrayList<String>();
		List<String> serviceNumList = new ArrayList<String>();

		for (List<Object> list : dataList) {

			StringBuffer failMsg = new StringBuffer();
			String seriesNo = (String) list.get(0);
			String phone = (String) list.get(1);
			String content = (String) list.get(2); //内容
			// String effectDate = (String) list.get(3); //推送时间 
			String chiId  = (String) list.get(3);  //渠道
			String groupNum = (String) list.get(4);  //分组号
			String provinceCode = (String) list.get(5);  //省份
			String cityCode = (String) list.get(6);  //地市
			String reason = (String) list.get(7);  //原因
			//去掉空行
			if (StringUtil.isBlank(seriesNo) && StringUtil.isBlank(phone)) {
				logger.info("序列号与服务号为空，过滤掉此行");
				continue;
			}

			//1.校验序列号
			if (!StringUtil.isBlank(seriesNo)) {

				if (!validateSeriesNo(seriesNo)) {
					failMsg.append("序列号格式不合法;");
				} else {
					if (seriesNoList.contains(seriesNo)) {
						failMsg.append("序列号重复;");
					} else {
						seriesNoList.add(seriesNo);
					}
				}

			} else {
				failMsg.append("序列号不能为空;");
			}

			//2.校验服务号码
			if (!StringUtil.isBlank(phone)) {

				if (!validPhoneNum(phone)) {
					failMsg.append("服务号码格式不合法，必须是正确手机号;");
				} else {

					if(serviceNumList.contains(phone)){
						failMsg.append("服务号码重复;");
					}else {
						serviceNumList.add(phone);
					}
				}

			} else {
				failMsg.append("服务号码不能为空;");
			}

			//3.内容 
            if(StringUtil.isBlank(content)) {
                failMsg.append("内容不能为空;");
            }
            
			//4.推送时间
			/*Timestamp effectTime = null;
			if(StringUtil.isBlank(effectDate)) {
				failMsg.append("推送时间不能为空;");
			} else if(!isDateType(effectDate)) {
				failMsg.append("推送时间格式不正确;");
			} else {
				effectTime = to_timestamp(effectDate, "yyyyMMdd");
				if(effectTime == null) {
					failMsg.append("推送时间格式不正确;");
				}
			}*/



			//7.原因描述
			GrantsRecord record = new GrantsRecord();
			record.setSeriesNo(seriesNo);
			record.setPhone(phone);   
			record.setContent(content);
		//	record.setEffectDate(effectDate); 
			record.setChiId(chiId);
			record.setGroupNum(groupNum); 
			record.setProvinceCode(provinceCode);
			record.setCityCode(cityCode);
			record.setReason(reason);

			if (failMsg.length() > 0) {
				record.setFailMsg(failMsg.toString());
				failDataList.add(record);
			} else {
				successDataList.add(record);
			}

		} 
		dataMap.put("sucessedDataList", successDataList);
		dataMap.put("failedDataList", failDataList);

		return dataMap;
	}


	/**
	 * 把失败数据插入到sheet中
	 */
	@Override
	public void setSheet(Sheet sheet, List<Object> failedDataList) {

		Row oldRow =sheet.getRow(1);// sheet.createRow(1);
		Cell oldCell = oldRow.getCell(0);
		CellStyle cellStyle= oldCell.getCellStyle();

		int index = 1;
		for (Object object : failedDataList) {

			GrantsRecord failRecord = (GrantsRecord) object;
			Row row = sheet.createRow(index);

			Cell cell = row.createCell(0);
			buildCell(cell, failRecord.getSeriesNo(), cellStyle);

			cell = row.createCell(1);
			buildCell(cell, failRecord.getFailMsg(), cellStyle);

			cell = row.createCell(2);
			buildCell(cell, failRecord.getPhone(), cellStyle);

			cell = row.createCell(3);
			buildCell(cell, failRecord.getContent(), cellStyle);

		/*	cell = row.createCell(4); //推送时间
			buildCell(cell, failRecord.getEffectDate(), cellStyle);
*/

			cell = row.createCell(4); //渠道
			buildCell(cell, failRecord.getChiId(), cellStyle);


			cell = row.createCell(5); //分组号
			buildCell(cell, failRecord.getGroupNum(), cellStyle);


			cell = row.createCell(6); //省份
			buildCell(cell, failRecord.getProvinceCode(), cellStyle);


			cell = row.createCell(7); //地市
			buildCell(cell, failRecord.getCityCode(), cellStyle);

			cell = row.createCell(8);
			buildCell(cell, failRecord.getReason(), cellStyle);

			index++;
		}

	}



	/**
	 * 构造业务数据 
	 */
	private List<BatchAccCreditDate> constructBatchAccDepositData(List<CreditInfo> records, RequestHeader requestHeader) {


		List<BatchAccCreditDate> dataList = new ArrayList<BatchAccCreditDate>();
		for(CreditInfo creditInfo : records) {           
			BatchAccCreditDate data = new BatchAccCreditDate(); 
			data.setCreditInfo(creditInfo);
			dataList.add(data);
		}

		return dataList;
	}
 
	

	/**
	 * 批量提交
	 */
	 @Override
	 @RequestMapping(value="submitBatch",method=RequestMethod.POST)
	 public void submitBatch(HttpServletRequest request, HttpServletResponse response)
			 throws Exception {
		 logger.info("接收ExpUmsConfig.jsp页面传来参数.");  
		 String contentDesJ =  request.getParameter("contentDes");
		 String PlanTimeJ =  request.getParameter("PlanTime");
		 String timesJ =  request.getParameter("times"); 
		 
	//	 System.out.println("contentDesJ："+contentDesJ);
	//	 System.out.println("PlanTimeJ："+PlanTimeJ);
	//	 System.out.println("timesJ："+timesJ); 
		  
		 String fileName = request.getParameter("failFileName"); 
		 String fileNameParam = request.getParameter("fileNameParam"); 
		 System.out.println("fileNameParam上传文件名：："+fileNameParam); 
		 try {
			 /*1.获取页面参数*/
			 String grantsRecords = request.getParameter("grantsRecords");
			 grantsRecords = grantsRecords.replaceAll("&quot;", "\"");
			 logger.info("grantsRecords: " + grantsRecords);
			 /*2.将页面json参数转化为实体list*/
			 Gson gson = new Gson();
			 List<CreditInfo> grantsList =gson.fromJson(grantsRecords, new TypeToken<List<CreditInfo>>(){}.getType());
			 logger.info("grantsList: " + grantsList);
			 if(grantsList == null || grantsList.size() == 0){
				 return;
			 }

			 /*3.初始化服务参数，调用后场批量业务服务*/

			 RequestHeader umsHarder = new RequestHeader();
			 RequestHeader requestHeader = new RequestHeader();/*根据session中的操作员信息生成报文头VO*/
			 /*umsHarder.setChlId(requestHeader.getChlId());
             umsHarder.setCityCode(requestHeader.getCityCode());
             umsHarder.setOperId(requestHeader.getOperId());
             umsHarder.setProvinceCode(requestHeader.getProvinceCode());
             umsHarder.setCorpId(String.valueOf(requestHeader.getOperId()));*/
             umsHarder.setChlId("111");
             umsHarder.setCityCode("4103");
             umsHarder.setOperId(1000l);
             umsHarder.setProvinceCode("41");
             umsHarder.setCorpId(String.valueOf("11212"));
             
		/*	  
			 RequestHeader umsHarder = new RequestHeader();
		  // com.ifudata.ums.crm.api.base.vo.RequestHeader requestHeader = RequestUtil.getRequestHeader(request);
	         umsHarder.setChlId("11111");
	         umsHarder.setCityCode("22222");
	         umsHarder.setOperId(Long.valueOf("33333"));
	         umsHarder.setProvinceCode("44444");
	         umsHarder.setCorpId("55555");
	              */

			 System.out.println("timesJ " + timesJ);
			 OrdApplyBatchRequest batchRequest =  new OrdApplyBatchRequest();
			 batchRequest.setBusiType(BATCH_GRANTS_BUSI_TYPE);
			 batchRequest.setRequestHeader(umsHarder);
			 batchRequest.setBatchContext(contentDesJ);//内容
			 batchRequest.setJobTime(PlanTimeJ);//执行时间
			 batchRequest.setFlag((timesJ==null || timesJ =="" )?0:Integer.valueOf(timesJ));//执行次数
			 batchRequest.setFileName(fileNameParam);//文件名 
			 
			 OrdApplyBatchDetailCredit info = new OrdApplyBatchDetailCredit();
			 // List<BatchAccDepositDate> dataList = this.constructBatchAccDepositData(grantsList, requestHeader);
			 // info.setDataList(dataList);
			 List<BatchAccCreditDate> dataList = this.constructBatchAccDepositData(grantsList, umsHarder);
		     info.setDateList(dataList);  
			 batchRequest.setApplyBatchDetailCredit(info);
			 IOrdApplyBatchDubboSV ordApplyBatchDubboSV = DubboConsumerFactory.getService(IOrdApplyBatchDubboSV.class);
			 logger.info("===============入参："+JSON.toJSONString(batchRequest));
			 OrdApplyBatchResponse batchResponse = ordApplyBatchDubboSV.batchApply(batchRequest);  //方法
			 ResponseHeader header = batchResponse.getResponseHeader();
			 System.out.println("代码 " + header.getResultCode());
			
			 if("100009".equals(header.getResultCode())){
				System.out.println("文件名已经存在，可能已经导入过.");
			}
				
			 if (!header.getResultCode().equals(ConstantsResultCode.SUCCESS)) {
				 logger.error("业务受理失败, resultCode: "+header.getResultCode()+"\nmessage: "+header.getResultMessage());
				 throw new BusiException("业务受理失败", header.getResultCode(), header.getResultMessage(), header.getInfo(), null);
			 }

			 /*4.组织返回值*/
			 JSONObject json = new JSONObject();
			 
			 json.put("batchId", batchResponse.getBatchId());
			 json.put("batchDesc", batchResponse.getBatchDesc()); 
			 responseSuccess(response, "批量推广成功", json);

		 } catch (BusiException ex) {
			 logger.error(ex.getMessage());
			 responseError(response, ex.getMessage(), ex);
		 } catch (Throwable e) {
			 String errMsg = "[提交批量推广]异常信息";
			 logger.error(errMsg, e);
			 //responseError(response, errMsg, e);
		 } finally{
			 //删除校验错误文件
			 //无论是否下载文件，临时文件最后都需要立即删除
			 if(! StringUtil.isBlank(fileName)){

				 String realPath = request.getSession().getServletContext().getRealPath("");
				 File file = new File(realPath+FAILED_FILE_PATH+fileName);
				 if(file.exists()){
					 file.delete();
				 }
			 }
		 }
	 }
  
}
