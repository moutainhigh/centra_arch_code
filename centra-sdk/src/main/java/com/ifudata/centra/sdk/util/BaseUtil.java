package com.ifudata.centra.sdk.util;

import com.ifudata.centra.sdk.constant.ExceptionCodeConstant;
import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.centra.base.vo.BaseInfo;
import com.ifudata.centra.base.vo.RequestHeader;

/**
 * 基础参数校验工具类<br>
 * Date: 2015年8月12日 <br>
 * Copyright (c) 2015 ifudata.com <br>
 * 
 * @author mayt
 */
public final class BaseUtil {

    private BaseUtil() {
    }

    /**
     * 报文头校验<br>
     * 
     * @param requestHeader
     * @author mayt
     * @throws BusinessException
     * 
     */
    public static void checkRequestHeader(RequestHeader requestHeader) throws BusinessException {
        if (requestHeader == null) {
            throw new BusinessException(ExceptionCodeConstant.PARAM_IS_NULL, "[请求报文头为空]");
        }
        if(requestHeader.getStaffId() == null || requestHeader.getStaffId() == 0){
        	throw new BusinessException(ExceptionCodeConstant.PARAM_IS_NULL, "[报文头员工ID为空]");
        }
//        if (StringUtil.isBlank(requestHeader.getApplyChlId())) {
//            throw new BusinessException(ExceptionCodeConstant.PARAM_IS_NULL, "[报文头渠道ID为空]");
//        }
//        if (StringUtil.isBlank(requestHeader.getSystemId())) {
//            throw new BusinessException(ExceptionCodeConstant.PARAM_IS_NULL, "[报文头系统ID为空]");
//        }
//        if (requestHeader.getOperId() == null || requestHeader.getOperId() == 0) {
//            throw new BusinessException(ExceptionCodeConstant.PARAM_IS_NULL, "[报文头操作员ID为空]");
//        }
    }

    /**
     * 租户信息校验<br>
     * 
     * @param baseInfo
     * @author rui
     * @throws BusinessException
     * @ApiDocMethod
     */
    public static void checkBaseInfo(BaseInfo baseInfo) throws BusinessException {
        if (null == baseInfo) {
            throw new BusinessException(ExceptionCodeConstant.PARAM_IS_NULL, "[请求报文]为空");
        }
        if (StringUtil.isBlank(baseInfo.getTenantId())) {
            throw new BusinessException(ExceptionCodeConstant.PARAM_IS_NULL, "[租户ID]为空");
        }
    }


}
