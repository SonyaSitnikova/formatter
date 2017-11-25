package com.sitnikovasj.app.io.closable;

/**
 * Exception class for close
 */
public class CloseException extends Exception {

    /**
     *
     * @param cause Exception
     */
    public CloseException(final Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message Message Exception
     * @param cause Exception
     */
    public CloseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
