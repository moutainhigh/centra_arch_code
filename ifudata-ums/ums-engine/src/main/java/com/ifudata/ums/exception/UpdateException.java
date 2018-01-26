package com.ifudata.ums.exception;

/**
 * Created by lvsj on 2015/9/25.
 */
public class UpdateException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4340480368665883140L;
	private String message;
    public UpdateException(String msg){
        message = msg + super.getMessage();
    }
    public String getMessage(){
        return this.message;
    }
    public void printMsg(){
        System.out.println(this.message);
    }
}
