package com.ifudata.ums.exception;

/**
 * Created by lvsj on 2015/9/27.
 */
public class DeleteException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 515598873723442388L;
	private String message;
    public DeleteException(String msg){
        message = msg + super.getMessage();
    }
    public String getMessage(){
        return this.message;
    }
    public void printMsg(){
        System.out.println(this.message);
    }
}
