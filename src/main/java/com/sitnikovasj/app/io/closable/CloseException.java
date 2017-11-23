package com.sitnikovasj.app.io.closable;

public class CloseException extends Exception{

    public CloseException(final Throwable cause) {
        super(cause);
    }

    public CloseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
