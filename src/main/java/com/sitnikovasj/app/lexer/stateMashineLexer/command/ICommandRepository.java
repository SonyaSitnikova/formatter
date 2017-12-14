package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.state.State;

/**
 * interface command reposytory
 */
public interface ICommandRepository {
    /**
     *
     * @param state current state
     * @param simbol current symbol
     * @return command
     */
    ICommand getNextCommand(State state, String simbol);
}
