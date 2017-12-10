package com.sitnikovasj.app.stateMashineLexer;

public class CommandAppend implements ICommand {

    @Override
    public void execute(char currentSymbol, Context context) {
        StringBuilder lexeme = context.getLexeme();
        String tokenName = context.getTokenName();
        lexeme.append(currentSymbol);
        tokenName = lexeme.toString();
        context.setLexeme(lexeme);
        context.setTokenName(tokenName);
    }
}
