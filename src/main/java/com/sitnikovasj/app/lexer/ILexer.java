package com.sitnikovasj.app.lexer;

import com.sitnikovasj.app.io.reader.ReaderException;

public interface ILexer {
    /**
     *
     * @return true if there's tokens to read
     */
    boolean hasMoreTokens() throws LexerException;

    /**
     * Read token
     * @return token
     * @throws LexerException when can't read
     */
    IToken readToken() throws LexerException, ReaderException;
}
