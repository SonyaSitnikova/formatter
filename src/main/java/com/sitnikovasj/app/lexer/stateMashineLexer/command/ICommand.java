package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.Context;

/**
 *
 */
public interface ICommand {
    /**
     *
     * @param currentSymbol char
     * @param context context
     */
    void execute(char currentSymbol, Context context);
}
