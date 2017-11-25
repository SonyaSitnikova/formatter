package com.sitnikovasj.app.formatter;

/**
 *
 */
public class FormatterException extends Exception {

    /**
     *
     * @param cause Exception
     */
    public FormatterException(final Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message Message Exception
     * @param cause Exception
     */
    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
