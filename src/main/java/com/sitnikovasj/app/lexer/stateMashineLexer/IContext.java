package com.sitnikovasj.app.lexer.stateMashineLexer;

import java.util.ArrayList;

/**
 * the Context contains postponed, tokenName, lexeme
 */
public interface IContext {
    /**
     *
     * @return postponed
     */
    ArrayList<Character> getPostponed();

    /**
     *
     * @param p add postpone
     */
    void addPostponed(Character p);

    /**
     *
     * @return tokenName
     */
    String getTokenName();

    /**
     *
     * @param tokenName tokenName
     * @return tokenName
     */
    void setTokenName(String tokenName);

    /**
     *
     * @return lexeme
     */
    StringBuilder getLexeme();

    /**
     *
     * @param lexeme lexeme
     * @return lexeme
     */
    void addLexeme(char lexeme);

}
