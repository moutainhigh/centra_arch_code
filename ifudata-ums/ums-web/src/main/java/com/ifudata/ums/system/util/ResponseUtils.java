package com.ifudata.ums.system.util;

import com.ifudata.centra.base.vo.ResponseHeader;
import com.ifudata.ums.system.config.ConstantsResultCode;
import com.ifudata.ums.system.exception.BusiException;

/**
 * 后场响应--工具处理类
 * @author weichuang
 */
public class ResponseUtils {
	/**
	 * 非成功状态，抛异常
	 */
	public static void notSuccessException(ResponseHeader responseHeader, String msg) {
		if (!responseHeader.getResultCode().equals(ConstantsResultCode.SUCCESS)) {
			throw new BusiException("业务受理失败", responseHeader.getResultCode(),
					responseHeader.getResultMessage(), responseHeader.getInfo(), "");
		}
	}
	/**
	 * 非成功状态和非无数据状态，抛异常
	 */
	public static void notSuccessAndNotNoDataException(ResponseHeader responseHeader, String msg) {
		if (!responseHeader.getResultCode().equals(ConstantsResultCode.SUCCESS)
				&& !responseHeader.getResultCode().equals(ConstantsResultCode.NODATA)) {
			throw new BusiException("业务受理失败", responseHeader.getResultCode(),
					responseHeader.getResultMessage(), responseHeader.getInfo(), "");
		}
	}
}
