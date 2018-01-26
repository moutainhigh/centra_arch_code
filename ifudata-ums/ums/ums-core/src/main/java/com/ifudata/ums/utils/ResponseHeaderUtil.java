package com.ifudata.ums.utils;

import com.ifudata.centra.base.exception.GenericException;
import com.ifudata.centra.base.vo.ResponseHeader;
import com.ifudata.ums.constants.ExceptCodeConstants;

public class ResponseHeaderUtil {

    public static ResponseHeader assemble(Exception ex) {
        ResponseHeader responseHeader = new ResponseHeader();
        if(ex instanceof GenericException){
            GenericException e = (GenericException) ex;
            if(ExceptCodeConstants.Special.SUCCESS.equals(e.getErrorCode())){
                responseHeader.setSuccess(true);
            }else {
                responseHeader.setSuccess(false);
            }
            responseHeader.setResultCode(e.getErrorCode());
            responseHeader.setResultMessage(e.getErrorMessage());
        }else {
            responseHeader.setSuccess(false);
            responseHeader.setResultCode(ExceptCodeConstants.Special.ERROR);
            responseHeader.setResultMessage(ex.getMessage());
        }

        return responseHeader;
    }
}