package com.ifudata.ums.exception;

import java.io.Serializable;

/**
 * 业务异常类(运行时异常)
 * @author guofei
 */
public class BusiException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -1L;

	public BusiException(String message) {
		super(message);
	}
	
	public BusiException(Throwable e){
		super(e);
	}
}
