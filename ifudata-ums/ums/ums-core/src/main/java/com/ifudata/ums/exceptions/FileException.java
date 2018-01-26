package com.ifudata.ums.exceptions;

public class FileException extends Exception {
	
	private static final long serialVersionUID = -6949735519225714411L;

	private String code;
	
	public FileException(String msg){
		super(msg);
		this.code = "000000";
	}
	
	public FileException(String code, String msg){
		super(msg);
		this.code = code;
	}
	
	public FileException(String code, String msg, Throwable cause){
		super(msg,cause);
		this.code = code;
	}
	
	public FileException(String code, Throwable cause){
		super(cause);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
