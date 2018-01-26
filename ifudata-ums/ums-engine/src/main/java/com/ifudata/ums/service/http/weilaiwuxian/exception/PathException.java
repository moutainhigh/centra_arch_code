package com.ifudata.ums.service.http.weilaiwuxian.exception;

import java.io.Serializable;

/**
 *
 * 2015年7月29日下午7:04:43
 * hongzhenfu
 *
 */
public class PathException extends RuntimeException implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4816448562111458172L;
	public PathException(){
		super("路径不能为空！");
	}
	public PathException(String msg){
		super(msg);
	}
	public PathException(String msg, Throwable cause){
		super(msg,cause);
	}
	public PathException(Throwable cause){
		super(cause);
	}
}

