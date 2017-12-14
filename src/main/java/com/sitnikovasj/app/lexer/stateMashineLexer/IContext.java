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
     * @return postponed
     */
    ArrayList<Character> addPostponed(Character p);

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
    String setTokenName(String tokenName);

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
    StringBuilder addLexeme(char lexeme);

}
