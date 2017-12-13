package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.Context;

public interface ICommand {
    void execute (char currentSymbol, Context context);
}
