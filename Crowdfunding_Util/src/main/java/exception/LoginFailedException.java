package exception;

/**
 * @author lenovo
 */
public class LoginFailedException extends RuntimeException{

    static final long serialVersionUID = -7034897190745766939L;


    public LoginFailedException() {
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }


}
