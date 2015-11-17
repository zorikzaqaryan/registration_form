package com.springapp.mvc.exception;

/**
 * Created by root on 11/16/15.
 */
public class InternalErrorException extends  Exception {
    public InternalErrorException() {
    }

    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalErrorException(Throwable cause) {
        super(cause);
    }
}
