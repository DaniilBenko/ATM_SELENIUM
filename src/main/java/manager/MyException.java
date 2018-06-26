package manager;

import java.io.Serializable;

public class MyException extends RuntimeException implements Serializable{

    private static final long serialVersionUID = -1468109695483543144L;

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

}
