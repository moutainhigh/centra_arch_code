package com.ai.opt.data.api.user.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ai.opt.sdk.constants.ExceptCodeConstants;
import org.I0Itec.zkclient.DataUpdater;
import org.apache.batik.css.engine.value.InheritValue;
import org.elasticsearch.discovery.zen.elect.ElectMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.data.api.user.interfaces.ILoginSV;
import com.ai.opt.data.api.user.param.ContinueLoginLogResponse;
import com.ai.opt.data.api.user.param.LoginLogRequest;
import com.ai.opt.data.api.user.param.ThirdUserQueryRequest;
import com.ai.opt.data.api.user.param.UserLoginResponse;
import com.ai.opt.data.constants.AccountConstants.ResultCode;
import com.ai.opt.data.constants.AccountExceptCode;
import com.ai.opt.data.dao.mapper.bo.LoginLog;
import com.ai.opt.data.dao.mapper.bo.UcContinueLoginLog;
import com.ai.opt.data.dao.mapper.bo.UcMembers;
import com.ai.opt.data.service.busi.interfaces.ILoginBusiSV;
import com.ai.opt.data.service.busi.interfaces.IVoValidateSV;
import com.ai.opt.data.util.RegexUtils;
import com.ai.opt.data.util.UCDateUtils;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.dubbo.util.DubboConsumerFactory;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.integrals.interfaces.IIntegralsSV;
import com.ai.slp.balance.api.integrals.param.UpdateIntegralsParam;
import com.ai.yc.common.api.sysconfig.interfaces.IQuerySysConfigSV;
import com.ai.yc.common.api.sysconfig.param.DonateIntegralConfig;
import com.ai.yc.user.api.usergriwthvalue.interfaces.IYCUserGriwthValueSV;
import com.ai.yc.user.api.usergriwthvalue.param.UsrGriwthValueRequest;
import com.alibaba.dubbo.config.annotation.Service;

import sun.util.logging.resources.logging;

@Service
@Component("loginSVImpl")
public class LoginSVImpl implements ILoginSV {
	protected final Logger logger = LoggerFactory.getLogger(LoginSVImpl.class);
    @Autowired
    private ILoginBusiSV iLoginBusiSV;
    @Autowired
	IVoValidateSV iVoValidateSV;

    @Override
    public UserLoginResponse queryUserByUserName(String username)
            throws BusinessException,SystemException {
        iVoValidateSV.validateLogin(username);
        // 判断用户名是手机还是邮箱
        /* boolean isEmial = RegexUtils.checkIsEmail(username);
        boolean isPhone = RegexUtils.checkIsPhone(username);
        UcMembers account = new UcMembers();
        if (isPhone == true) {
            account.setMobilephone(username);
        }else if (isEmial == true) {
            account.setEmail(username);
        }else{
            account.setUsername(username); 
        }*/
        UcMembers sysUser = iLoginBusiSV.queryByUserNamePhoneEmail(username);
        // 组织返回对象
        UserLoginResponse response = new UserLoginResponse();
        if (sysUser != null) {
            BeanUtils.copyProperties(response, sysUser);
            response.setUserId(String.valueOf(sysUser.getUid()));
			response.setLoginName(sysUser.getUsername());
			response.setEmail(sysUser.getEmail());
			response.setMobile(sysUser.getMobilephone());
			response.setLoginPassword(sysUser.getPassword());
			response.setSalt(sysUser.getSalt());
			response.setDomainname(sysUser.getDomainName());
			response.setEmailcheck(sysUser.getEmailcheck());
			
            ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.SUCCESS_CODE,
                    "成功");
            response.setResponseHeader(responseHeaders);
        } else {
            ResponseHeader responseHeaders = new ResponseHeader(false, ResultCode.FAIL_CODE,
                    "用户不存在");
            response.setResponseHeader(responseHeaders);
        }
        return response;
    }

	@Override
	public String bindThirdUser(UcMembers ucMembers) throws BusinessException, SystemException {
		if(ucMembers==null){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		if(StringUtil.isBlank(ucMembers.getUsersource())){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "用户来源为空");
		}
		if(StringUtil.isBlank(ucMembers.getThirduid())){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "第三方用户ID为空");
		}
		return iLoginBusiSV.saveThirdUser(ucMembers);
	}

	@Override
	public UcMembers queryThirdUser(ThirdUserQueryRequest thirdUser) throws BusinessException, SystemException {
		if(thirdUser==null){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		if(StringUtil.isBlank(thirdUser.getUsersource())){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "用户来源为空");
		}
		if(StringUtil.isBlank(thirdUser.getThirduid())){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "第三方用户ID为空");
		}
		return iLoginBusiSV.queryThirdUser(thirdUser.getUsersource(),thirdUser.getThirduid());
	}

	@Override
    public UserLoginResponse queryUserByMobile(String mobile)
            throws BusinessException,SystemException {
		boolean isPhone = RegexUtils.checkIsPhone(mobile);
		if (!isPhone) {
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_VALUE_ERROR, "手机号错误");
		}
        UcMembers sysUser = iLoginBusiSV.queryByUserNamePhoneEmail(mobile);
        // 组织返回对象
        UserLoginResponse response = new UserLoginResponse();
        if (sysUser != null) {
            BeanUtils.copyProperties(response, sysUser);
            response.setUserId(String.valueOf(sysUser.getUid()));
			response.setLoginName(sysUser.getUsername());
			response.setEmail(sysUser.getEmail());
			response.setMobile(sysUser.getMobilephone());
			response.setLoginPassword(sysUser.getPassword());
			response.setSalt(sysUser.getSalt());
			response.setDomainname(sysUser.getDomainName());
			response.setEmailcheck(sysUser.getEmailcheck());
			
            ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.SUCCESS_CODE,
                    "成功");
            response.setResponseHeader(responseHeaders);
        } else {
            ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.SUCCESS_CODE,
                    "用户不存在");
            response.setResponseHeader(responseHeaders);
        }
        return response;
    }

	@Override
	public String saveUserByMobileLogin(UcMembers ucMembers) throws BusinessException, SystemException {
		if(ucMembers==null){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		return iLoginBusiSV.saveUserByMobileLogin(ucMembers);
	}

	@Override
	public BaseResponse saveLoginLog(LoginLogRequest req) throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		if(req==null){
			throw new BusinessException(AccountExceptCode.ErrorCode.PARAM_NULL_ERROR, "参数对象为空");
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String todayStr = format.format(new Date());
		Timestamp timestamp = DateUtil.getTimestamp(todayStr);
		//今天00:00:00
		long time2 = timestamp.getTime()/1000;
		int todayDate2 = (int)time2;
		//获取当前时间
		int todayDate = (int) UCDateUtils.getSystime();
		
		//记录日志
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(req.getUserId());
		loginLog.setLoginDate(todayDate2);
		loginLog.setLoginDatetime(new Timestamp(todayDate));
		loginLog.setSystemSource(req.getSystemSource());
		iLoginBusiSV.saveLoginLog(loginLog);

		//更新用户最后登陆时间
		UcMembers members = new UcMembers();
		members.setUid(req.getUserId());
		members.setLastlogintime(todayDate);
		iLoginBusiSV.updateUcMembers(members);

		//记录连续天数
		UcContinueLoginLog continueLoginLog = iLoginBusiSV.queryContinueLoginLog(req.getUserId());
		//是否为当天的第一天登录
		boolean isTodayFirst = false;
		if (continueLoginLog == null) {
			//插入
			continueLoginLog = new UcContinueLoginLog();
			continueLoginLog.setLastDate(todayDate2);
			continueLoginLog.setContinueDays(1);
			continueLoginLog.setUid(req.getUserId());
			iLoginBusiSV.saveContinueLoginLog(continueLoginLog);
			isTodayFirst = true;
		}//若不是当天登录
		else if(todayDate2 != continueLoginLog.getLastDate()){
			//更新
			////若最后登录日期在昨天之前
			if (todayDate2-86400 > continueLoginLog.getLastDate()) {
				continueLoginLog.setContinueDays(1);
			}else {
				continueLoginLog.setContinueDays(continueLoginLog.getContinueDays()+1);
			}
			continueLoginLog.setLastDate(todayDate2);
			iLoginBusiSV.updateContinueLoginLog(continueLoginLog);
			isTodayFirst = true;
		}
		
		//校验登陆来源 (满足0,5)
		if (!req.getSystemSource().equals("0") && !req.getSystemSource().equals("5")) {//SystemSource:0 pc  5 手机
			 ResponseHeader responseHeaders = new ResponseHeader(true, ResultCode.SUCCESS_CODE,
					 "登陆日志写入成功,由于登录系统来源不满足送积分...");
	         response.setResponseHeader(responseHeaders);
	         return response;
		}
		//查询登陆天数
		int growthDays = 0;
		int scoreDays = 0;
		if (continueLoginLog.getContinueDays()>=5 && continueLoginLog.getContinueDays()%5==0) {
			growthDays = 5;
		} else {
			growthDays = continueLoginLog.getContinueDays()%5;
		}
		
		if (continueLoginLog.getContinueDays()>=7 && continueLoginLog.getContinueDays()%7==0) {
			scoreDays = 7;
		}else {
			scoreDays = continueLoginLog.getContinueDays()%7;
		}
		
		//校验是否开启送积分
		IQuerySysConfigSV iQuerySysConfigSV = DubboConsumerFactory.getService(IQuerySysConfigSV.class);
		DonateIntegralConfig config = iQuerySysConfigSV.getDonateIntegralConfig();
		//若赠送积分 且是当天第一次登录
		if (isTodayFirst && config.getLstate().equals("1")) {
			logger.info("更新积分");
			// 更新积分
			//更新积分
			IIntegralsSV integralsSV = DubboConsumerFactory.getService(IIntegralsSV.class);
			UpdateIntegralsParam updateIntegralsParam = new UpdateIntegralsParam();
			updateIntegralsParam.setUserId(req.getUserId().toString());
			updateIntegralsParam.setIntegrals(getScore(scoreDays, config));
			//积分来源中文
			updateIntegralsParam.setIntegralsResource(getIntegralsResource(scoreDays, "zh_CN"));
			//积分来源英文
			updateIntegralsParam.setIntegralResourceEn(getIntegralsResource(scoreDays, "en_US"));
			//积分明细中文
			updateIntegralsParam.setIntegralSourceDetailCn(getIntegralSourceDetail(scoreDays, "zh_CN"));
			//积分明细英文
			updateIntegralsParam.setIntegralSourceDetailEn(getIntegralSourceDetail(scoreDays, "en_US"));
			updateIntegralsParam.setSystemResource(req.getSystemSource());
			integralsSV.updateIntegrals(updateIntegralsParam);
			logger.info("今天是第一次登陆,已送积分{}",updateIntegralsParam.getIntegrals());
		}

		if(isTodayFirst) {
			logger.info("更新成长值");
			// 更新成长值
			//更新成长值
			IYCUserGriwthValueSV griwthValueSV = DubboConsumerFactory.getService(IYCUserGriwthValueSV.class);
			UsrGriwthValueRequest griwthValueInfo = new UsrGriwthValueRequest();
			griwthValueInfo.setUserId(req.getUserId().toString());
			griwthValueInfo.setGriwthValue(getGriwthValue(growthDays));
			griwthValueInfo.setCreateTime(UCDateUtils.toTimeStamp(new Date()));
			//成长来源中文
			griwthValueInfo.setGriwthResourceZh(getIntegralsResource(scoreDays, "zh_CN"));
			//成长来源英文
			griwthValueInfo.setGriwthResourceEn(getIntegralsResource(scoreDays, "en_US"));
			//来源详情中文
			griwthValueInfo.setResourceDetailZh(getIntegralSourceDetail(scoreDays, "zh_CN"));
			//来源详情英文
			griwthValueInfo.setResourceDetailEn(getIntegralSourceDetail(scoreDays, "en_US"));
			
			griwthValueSV.insertGriwthValueInfo(griwthValueInfo);
			
			logger.info("今天是第一次登陆,已送成长值{}",griwthValueInfo.getGriwthValue());
		}
		ResponseHeader responseHeaders = new ResponseHeader(true,
				ExceptCodeConstants.Special.SUCCESS, "OK");
		response.setResponseHeader(responseHeaders);
		return response;
	}

	public int getScore(int days, DonateIntegralConfig config) throws BusinessException, SystemException {
		if (days == 1) {
			return Integer.parseInt(config.getOneday());
		}else if (days == 2) {
			return Integer.parseInt(config.getTwoday());
		}else if (days == 3) {
			return Integer.parseInt(config.getThreeday());
		}else if (days == 4) {
			return Integer.parseInt(config.getFourday());
		}else if (days == 5) {
			return Integer.parseInt(config.getFiveday());
		}else if (days == 6) {
			return Integer.parseInt(config.getSixday());
		}else if (days == 7) {
			return Integer.parseInt(config.getSevenday());
		}
		
		return 0;
		
	}
	public int getGriwthValue(int days) throws BusinessException, SystemException {
		/*连续登录第一天    +10
		连续登录第二天  +20
		连续登录第三天  +30
		连续登录第四天  +40
		连续登录第五天  +50*/
		if (days == 1) {
			return 10;
		}else if (days ==2) {
			return 20;
		}else if (days ==3) {
			return 30;
		}else if (days ==4) {
			return 40;
		}else if (days ==5) {
			return 50;
		}
		return 0;
	}

	public String getIntegralsResource(int days,String language) throws BusinessException, SystemException {
		if (days == 1) {
			if (language == "zh_CN") {
				return "登录第一天";
			}else if (language == "en_US") {
				return "Login for the 1th day";
			}
		}else if(days == 2){
			if (language == "zh_CN") {
				return "登录第二天";
			}else if (language == "en_US") {
				return "Login for the 2th day";
			}
		}else if(days == 3){
			if (language == "zh_CN") {
				return "登录第三天";
			}else if (language == "en_US") {
				return "Login for the 3th day";
			}
		}else if(days == 4){
			if (language == "zh_CN") {
				return "登录第四天";
			}else if (language == "en_US") {
				return "Login for the 4th day";
			}
		}else if(days == 5){
			if (language == "zh_CN") {
				return "登录第五天";
			}else if (language == "en_US") {
				return "Login for the 5th day";
			}
		}else if(days == 6){
			if (language == "zh_CN") {
				return "登录第六天";
			}else if (language == "en_US") {
				return "Login for the 6th day";
			}
		}else if(days == 7){
			if (language == "zh_CN") {
				return "登录第七天";
			}else if (language == "en_US") {
				return "Login for the 7th day";
			}
		}
		return null;
	}
	
	public String getIntegralSourceDetail(int days,String language) throws BusinessException, SystemException {
		if (days == 1) {
			if (language == "zh_CN") {
				return "连续登录第一天";
			}else if (language == "en_US") {
				return "Continuous log-in for 1 day";
			}
		}else if(days == 2){
			if (language == "zh_CN") {
				return "连续登录第二天";
			}else if (language == "en_US") {
				return "Continuous log-in for 2 day";
			}
		}else if(days == 3){
			if (language == "zh_CN") {
				return "连续登录第三天";
			}else if (language == "en_US") {
				return "Continuous log-in for 3 day";
			}
		}else if(days == 4){
			if (language == "zh_CN") {
				return "连续登录第四天";
			}else if (language == "en_US") {
				return "Continuous log-in for 4 day";
			}
		}else if(days == 5){
			if (language == "zh_CN") {
				return "连续登录第五天";
			}else if (language == "en_US") {
				return "Continuous log-in for 5 day";
			}
		}else if(days == 6){
			if (language == "zh_CN") {
				return "连续登录第六天";
			}else if (language == "en_US") {
				return "Continuous log-in for 6 day";
			}
		}else if(days == 7){
			if (language == "zh_CN") {
				return "连续登录第七天";
			}else if (language == "en_US") {
				return "Continuous log-in for 7 day";
			}
		}
		return null;
	}
}
