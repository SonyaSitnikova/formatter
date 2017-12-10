package com.sitnikovasj.app.stateMashineLexer;

public interface ICommand {
    void execute (char currentSymbol, Context context);
}
