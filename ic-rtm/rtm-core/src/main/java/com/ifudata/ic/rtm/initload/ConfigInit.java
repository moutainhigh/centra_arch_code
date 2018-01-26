package com.ifudata.ic.rtm.initload;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.ifudata.dvp.sdk.util.RedisUtil;
import com.ifudata.ic.rtm.constants.RtmConstants;
import com.ifudata.ic.rtm.dao.RtmAuthInfo;
import com.ifudata.ic.rtm.dao.RtmDemoNum;
import com.ifudata.ic.rtm.dao.RtmFlowMds;
import com.ifudata.ic.rtm.dao.RtmParamInfo;
import com.ifudata.ic.rtm.dao.RtmSrcInfo;
import com.ifudata.ic.rtm.dao.RtmSrcRecord;
import com.ifudata.ic.rtm.entry.RtmRestStart;
import com.ifudata.ic.rtm.utils.PropertiesUtil;

public class ConfigInit {
	Logger logger=LoggerFactory.getLogger(ConfigInit.class);

	public void loadRtmInfo() {
		String rtm_info=" select * from rtm_src_info ";
		List<RtmSrcInfo> rtminfos=RtmRestStart.jdbcTemplate.query(rtm_info,new BeanPropertyRowMapper<RtmSrcInfo>(RtmSrcInfo.class));
		for(RtmSrcInfo rtminfo:rtminfos){
			StringBuilder mcsKey= new StringBuilder();
			mcsKey.append(rtminfo.getTenantId().toUpperCase()).append(RtmConstants.KEY_JOINER).append(rtminfo.getInfoType());
			String recordValue=(String) PropertiesUtil.getValue("rtm.record.split");
			RedisUtil.hset(mcsKey.toString(),recordValue, rtminfo.getRecordSplitFlag());
			String fieldValue=(String) PropertiesUtil.getValue("rtm.field.split");
			RedisUtil.hset(mcsKey.toString(),fieldValue, rtminfo.getFieldSplitFlag());
			System.out.println("the mcs insert into key "+mcsKey+" the fieldValue "+fieldValue);
		}
	}
	public static void main(String[] args){
		String a="MSG";
		String b="source_id";
		String c="1:1";
		RedisUtil.hset(a,b, c);
	}
	public void loadRtmRecord() {
		String rtm_record=" select * from rtm_src_record ";
		List<RtmSrcRecord> rtmrecords=RtmRestStart.jdbcTemplate.query(rtm_record, new BeanPropertyRowMapper<RtmSrcRecord>(RtmSrcRecord.class));
		for(RtmSrcRecord rtmrecord:rtmrecords){
			StringBuilder mcsKey= new StringBuilder();
			mcsKey.append(rtmrecord.getInfoId());
			StringBuilder mapKey= new StringBuilder();
			mapKey.append(rtmrecord.getFieldName().toLowerCase());
			StringBuilder value=new StringBuilder();
			value.append(rtmrecord.getFieldId()).append(RtmConstants.KEY_JOINER).append(rtmrecord.getFieldLength());
			logger.debug("the mcsKey is "+mcsKey.toString()+"  the mapKey is "+mapKey.toString()+"  the value is "+value.toString());
			RedisUtil.hset(mcsKey.toString(),mapKey.toString(), value.toString());
		}
		String record_sn="select * from rtm_src_record where is_sn=1 order by info_id ,field_id ASC ";
		List<RtmSrcRecord> snRecords=RtmRestStart.jdbcTemplate.query(record_sn, new BeanPropertyRowMapper<RtmSrcRecord>(RtmSrcRecord.class));
		StringBuilder infoContain=new StringBuilder();
		boolean flag=false;
		int num=0;
		StringBuilder field= new StringBuilder();
		StringBuilder infoKey=new StringBuilder();
		for(RtmSrcRecord snRecord:snRecords){
			num++;
			if(!flag){//表示是第一次
				infoContain.append(snRecord.getInfoId()).append(RtmConstants.KEY_JOINER).append("SN");			
				field.append(snRecord.getFieldId());
				infoKey=infoContain;
				flag=true;
			}else{
				if(num==1 && !(infoContain.toString().contains(snRecord.getInfoId()))){
					//表示在第一次的时候只有一个sn的情况
					infoKey=infoContain;
					infoKey.append(RtmConstants.KEY_JOINER).append("SN");
					System.out.println("the infoKey11 is "+infoKey.toString()+" the field 222 is "+field.toString());
					RedisUtil.set(infoKey.toString(), field.toString());
					infoContain.append(RtmConstants.KEY_JOINER).append(snRecord.getInfoId());
					infoKey.delete(0, infoKey.length()-1);
					infoKey.append(snRecord.getInfoId()).append(RtmConstants.KEY_JOINER).append("SN");
					field.delete(0, field.length()-1);
					field.append(snRecord.getFieldId());
				}else{
					if(infoContain.toString().contains(snRecord.getInfoId())){
						field.append(RtmConstants.KEY_JOINER).append(snRecord.getFieldId());
					}else{
						System.out.println("the infoKey is 222 "+infoKey.toString()+"  the field is 222 "+field.toString());
						RedisUtil.set(infoKey.toString(), field.toString());
						infoKey.delete(0, infoKey.length());
						field.delete(0, field.length());
						infoKey.append(snRecord.getInfoId()).append(RtmConstants.KEY_JOINER).append("SN");
						field.append(snRecord.getFieldId());
					}
				}
			}
		}
		System.out.println("the infoKey is 333 "+infoKey.toString()+"  the field is 333 "+field.toString());
		RedisUtil.set(infoKey.toString(), field.toString());
	}
	public void loadAutnInfo() {
		String auth_info=" select * from rtm_auth_info ";
		logger.debug("the jdbcTemplate is "+RtmRestStart.jdbcTemplate);
		List<RtmAuthInfo> authInfos=RtmRestStart.jdbcTemplate.query(auth_info, new BeanPropertyRowMapper<RtmAuthInfo>(RtmAuthInfo.class));
		for(RtmAuthInfo authinfo:authInfos){
			StringBuilder mcsKey= new StringBuilder();
			mcsKey.append(authinfo.getTenantId().toUpperCase()).append(RtmConstants.KEY_JOINER).append(authinfo.getUserId());
			RedisUtil.set(mcsKey.toString(), authinfo.getPassWd());
		}
	}
	
	public void loadBsn(){
		StringBuilder bsnKey=new StringBuilder();
		bsnKey.append("BSN-BAAS");
		String bsnValue=RedisUtil.get(bsnKey.toString());
		if(bsnValue==null){
			Date date=new Date();
			Long time=date.getTime();
			RedisUtil.set(bsnKey.toString(), String.valueOf(time));
			//return String.valueOf(time);
		}
//		else {
//			return bsnValue;
//		}
	}
	
	public void loadMds(){
		String rtmMds=" select * from rtm_flow_mds ";
		List<RtmFlowMds> rtmFlows=RtmRestStart.jdbcTemplate.query(rtmMds, new BeanPropertyRowMapper<RtmFlowMds>(RtmFlowMds.class));
		for(RtmFlowMds rtmFlow:rtmFlows){
			StringBuilder mcsKey= new StringBuilder();
			mcsKey.append(rtmFlow.getSourceId().toUpperCase()).append(RtmConstants.KEY_JOINER).append(rtmFlow.getModuleId().toUpperCase());
			logger.debug("the load mcs is "+mcsKey.toString());
			RedisUtil.set(mcsKey.toString(),rtmFlow.getDestMds() );
		}
	}
	public void loadDemoNum(){
		String rtmDemoNum=" select * from bmc_basedata_code where param_type='RTM_COUNT' ";
		List<RtmDemoNum> rtmDemos=RtmRestStart.jdbcTemplate.query(rtmDemoNum, new BeanPropertyRowMapper<RtmDemoNum>(RtmDemoNum.class));
		for(RtmDemoNum rtmDemo:rtmDemos){
			StringBuilder mcsKey= new StringBuilder();
			mcsKey.append(rtmDemo.getTenantId().toUpperCase()).append(RtmConstants.KEY_JOINER).append(rtmDemo.getParamType().toUpperCase());
			logger.debug("the demo key is "+mcsKey.toString()+" the num is "+rtmDemo.getDefaultValue());
			RedisUtil.set(mcsKey.toString(),rtmDemo.getDefaultValue());
		}
	}
	
	public void loadRtmParam(){
		String rtmNumber=" select * from rtm_param_info";
		List<RtmParamInfo> rtmParams=RtmRestStart.jdbcTemplate.query(rtmNumber, new BeanPropertyRowMapper<RtmParamInfo>(RtmParamInfo.class));
		for(RtmParamInfo rtmParam:rtmParams){
			StringBuilder paramFirstKey=new StringBuilder();
			paramFirstKey.append(rtmParam.getTenantId().toUpperCase()).append(RtmConstants.KEY_JOINER).append(rtmParam.getSystemId().toUpperCase())
			.append(RtmConstants.KEY_JOINER).append(rtmParam.getSourceId().toUpperCase());
			String secondKey=rtmParam.getParamName();
			logger.debug("the paramFirst is"+paramFirstKey.toString());
			logger.debug("the secondKey is"+secondKey.toString());
			RedisUtil.hset(paramFirstKey.toString(),secondKey,rtmParam.getParamValue());	
			logger.debug("the value is"+rtmParam.getParamValue());
		}
		
	}
	
	
	
}
