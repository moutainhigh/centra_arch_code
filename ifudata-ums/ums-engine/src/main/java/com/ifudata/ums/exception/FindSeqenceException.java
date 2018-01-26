package com.ifudata.ums.exception;

/**
 * Created by lvsj on 2015/9/29.
 */
public class FindSeqenceException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7183878109451106722L;
	private String message;
    public FindSeqenceException(String msg) {
        message = msg + super.getMessage();
    }
    public String getMessage(){
        return this.message;
    }
    public void printMsg(){
        System.out.println(this.message);
    }
}
