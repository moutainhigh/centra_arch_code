package com.ifudata.centra.sdk.exception;

import java.io.Serializable;

public class SdkException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public SdkException(String exception) {
        super(exception);
    }

    public SdkException(Exception exception) {
        super(exception);
    }

    public SdkException(String message, Exception exception) {
        super(message, exception);
    }
}
