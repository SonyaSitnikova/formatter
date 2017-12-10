package com.sitnikovasj.app.stateMashineLexer;

import java.util.ArrayList;

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
    public Context(ArrayList<Character> postponed, String tokenName, StringBuilder lexeme){
        this.postponed = postponed;
        this.tokenName = tokenName;
        this.lexeme = lexeme;
    }

    /**
     * Constructor
     * @param postponed postponed
     */
    public Context(ArrayList<Character> postponed){
        this.postponed = postponed;
    }

    /**
     * Constructor
     * @param tokenName tokenName
     * @param lexeme lexeme
     */
    public Context(String tokenName, StringBuilder lexeme){
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
    public String getTokenName() {
        return tokenName;
    }

    @Override
    public String setTokenName(String tokenName) {
        return tokenName;
    }

    @Override
    public StringBuilder getLexeme() {
        return lexeme;
    }

    @Override
    public StringBuilder setLexeme(StringBuilder lexeme) {
        return lexeme;
    }
}
