package com.sitnikovasj.app.lexer;

import com.sitnikovasj.app.io.reader.ReaderException;

/**
 * interface for Lexer
 */

public interface ILexer {
    /**
     *
     * @return true if there's tokens to read
     * @throws LexerException when can't read
     */
    boolean hasMoreTokens() throws LexerException;

    /**
     * Read token
     * @return token
     * @throws LexerException when can't read
     * @throws ReaderException when can't read
     */
    IToken readToken() throws LexerException;
}
