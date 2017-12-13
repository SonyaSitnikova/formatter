package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.Context;

public class CommandPostpone implements ICommand {

    @Override
    public void execute(char currentSymbol, Context context) {
        context.addPostponed(currentSymbol);
    }
}

