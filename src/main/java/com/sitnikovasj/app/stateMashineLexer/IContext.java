package com.sitnikovasj.app.stateMashineLexer;

import java.util.ArrayList;

public interface IContext {
    public ArrayList<Character> getPostponed();
    public String getTokenName();
    public String setTokenName(String tokenName);
    public StringBuilder getLexeme();
    public StringBuilder setLexeme(StringBuilder lexeme);

}
