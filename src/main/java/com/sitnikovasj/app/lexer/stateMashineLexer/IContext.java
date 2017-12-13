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
    public ArrayList<Character> getPostponed();

    /**
     *
     * @param p add postpone
     * @return postponed
     */
    public ArrayList<Character> addPostponed(Character p);

    /**
     *
     * @return tokenName
     */
    public String getTokenName();

    /**
     *
     * @param tokenName tokenName
     * @return tokenName
     */
    public String setTokenName(String tokenName);

    /**
     *
     * @return lexeme
     */
    public StringBuilder getLexeme();

    /**
     *
     * @param lexeme lexeme
     * @return lexeme
     */
    public StringBuilder addLexeme(StringBuilder lexeme);

}
