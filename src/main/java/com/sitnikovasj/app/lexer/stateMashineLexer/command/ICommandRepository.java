package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.state.State;

public interface ICommandRepository {
    public ICommand getNextCommand(State state, String simbol);
}
