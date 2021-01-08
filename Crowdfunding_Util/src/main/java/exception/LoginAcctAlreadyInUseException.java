package exception;

/**
 * @author lenovo
 * 当保存或更新Admin时，若检测到登录账号重复抛出这个异常
 */
public class LoginAcctAlreadyInUseException extends RuntimeException{

    static final long serialVersionUID = -7034897190745766939L;

    public LoginAcctAlreadyInUseException() {
    }

    public LoginAcctAlreadyInUseException(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseException(Throwable cause) {
        super(cause);
    }
}
