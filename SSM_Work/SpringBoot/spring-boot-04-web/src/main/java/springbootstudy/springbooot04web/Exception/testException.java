package springbootstudy.springbooot04web.Exception;


public class testException extends RuntimeException{

    public testException() {
        super();
    }

    public testException(String message) {
        super(message);
    }

    public testException(String message, Throwable cause) {
        super(message, cause);
    }

    public testException(Throwable cause) {
        super(cause);
    }

    protected testException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
