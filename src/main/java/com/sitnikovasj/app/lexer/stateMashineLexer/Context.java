package com.sitnikovasj.app.lexer.stateMashineLexer;

import java.util.ArrayList;

/**
 * the Context contains postponed, tokenName, lexeme
 */
public class Context implements IContext {
    private ArrayList<Character> postponed = null;
    private String tokenName;
    private StringBuilder lexeme;

    /**
     * Constructor
     * @param postponed postponed
     * @param tokenName tokenName
     * @param lexeme lexeme
     */
    public Context(final ArrayList<Character> postponed, final String tokenName, final StringBuilder lexeme) {
        this.postponed = postponed;
        this.tokenName = tokenName;
        this.lexeme = lexeme;
    }

    /**
     * Constructor
     * @param postponed postponed
     */
    public Context(final ArrayList<Character> postponed) {
        this.postponed = postponed;
    }

    /**
     * Constructor
     * @param tokenName tokenName
     * @param lexeme lexeme
     */
    public Context(final String tokenName, final StringBuilder lexeme) {
        this.tokenName = tokenName;
        this.lexeme = lexeme;
    }

    /**
     * Constructor
     */
    public Context(){

    }

    @Override
    public ArrayList<Character> getPostponed() {
        return postponed;
    }

    @Override
    public ArrayList<Character> addPostponed(final Character p) {
        this.postponed.add(p);
        return null;
    }

    @Override
    public String getTokenName() {
        return tokenName;
    }

    @Override
    public String setTokenName(final String tokenNam) {
        this.tokenName = tokenNam;
        return tokenName;
    }

    @Override
    public StringBuilder getLexeme() {
        return lexeme;
    }

    @Override
    public StringBuilder addLexeme(final StringBuilder lexem) {
        this.lexeme = lexem;
        return lexeme;
    }
}
