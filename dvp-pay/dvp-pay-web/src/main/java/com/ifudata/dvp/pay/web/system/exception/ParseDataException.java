package com.ifudata.dvp.pay.web.system.exception;

/**
 * 数据解析异常
 * 
 * Date: 2015年11月10日 <br>
 */
public class ParseDataException extends AbstractPayException {

    private static final long serialVersionUID = 1L;

    public ParseDataException() {
        super();
    }

    public ParseDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseDataException(String message) {
        super(message);
    }

    public ParseDataException(Throwable cause) {
        super(cause);
    }

}
