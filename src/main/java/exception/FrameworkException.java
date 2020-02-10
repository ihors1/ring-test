package exception;

public class FrameworkException extends RuntimeException{

    public FrameworkException(String failureMsg) {
        super(failureMsg);
    }

    public FrameworkException(String failureMsg, Throwable e) {
        super(failureMsg, e);
    }

}
