package com_Xml.Exception;

public class UserAccount_Exception extends RuntimeException{





    public UserAccount_Exception() {
    }

    public UserAccount_Exception(String message) {
        super(message);
    }

    public UserAccount_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccount_Exception(Throwable cause) {
        super(cause);
    }

    public UserAccount_Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
