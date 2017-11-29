package com.sitnikovasj.app.lexer;

/**
 *
 */
public class LexerException extends Exception {

    /**
     *
     * @param cause Exception
     */
    public LexerException(final Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message Message Exception
     * @param cause Exception
     */
    public LexerException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
