package com.sitnikovasj.app.lexer.stateMashineLexer;

import java.util.ArrayList;

public interface IContext {
    public ArrayList<Character> getPostponed();
    public ArrayList<Character> addPostponed(Character p);
    public String getTokenName();
    public String setTokenName(String tokenName);
    public StringBuilder getLexeme();
    public StringBuilder addLexeme(StringBuilder lexeme);

}
