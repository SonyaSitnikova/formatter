package com.sitnikovasj.app.lexer;

/**
 * the token contains the name and lexeme
 */
public interface IToken {
    /**
     *
     * @return name
     */

    String getName();

    /**
     *
     * @return lexeme
     */
    String getLexeme();
}
