package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.Context;

/**
 *
 */
public class CommandPostpone implements ICommand {

    @Override
    public void execute(final char currentSymbol, final Context context) {
        context.addPostponed(currentSymbol);
    }
}

