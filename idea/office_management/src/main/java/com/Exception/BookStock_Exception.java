package com.Exception;

public class BookStock_Exception extends RuntimeException{


    public BookStock_Exception() {
    }

    public BookStock_Exception(String message) {
        super(message);
    }

    public BookStock_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStock_Exception(Throwable cause) {
        super(cause);
    }

    public BookStock_Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
