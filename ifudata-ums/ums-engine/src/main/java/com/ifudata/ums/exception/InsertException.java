package com.ifudata.ums.exception;

/**
 * Created by lvsj on 2015/9/27.
 */
public class InsertException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1523681342767257914L;
	private String message;
    public InsertException(String msg){
        message = msg + super.getMessage();
    }
    public String getMessage(){
        return this.message;
    }
    public void printMsg(){
        System.out.println(this.message);
    }

}
