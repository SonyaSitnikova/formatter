package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.Context;

public class CommandAppend implements ICommand {

    @Override
    public void execute(char currentSymbol, Context context) {
        StringBuilder lexeme = context.getLexeme();
        String tokenName = context.getTokenName();
        lexeme.append(currentSymbol);
        tokenName = lexeme.toString();
        context.addLexeme(lexeme);
        context.setTokenName(tokenName);
    }
}
