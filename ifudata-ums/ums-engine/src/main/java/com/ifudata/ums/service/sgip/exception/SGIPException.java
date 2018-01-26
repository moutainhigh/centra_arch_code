package com.ifudata.ums.service.sgip.exception;

import java.io.Serializable;

/**
 * SGIP业务异常类(运行时异常)
 * @author guofei
 */
public class SGIPException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public SGIPException(String message) {
		super(message);
	}
	
	public SGIPException(Throwable e){
		super(e);
	}
}

