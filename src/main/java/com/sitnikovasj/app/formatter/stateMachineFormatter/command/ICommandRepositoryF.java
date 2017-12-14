package com.sitnikovasj.app.formatter.stateMachineFormatter.command;

import com.sitnikovasj.app.formatter.stateMachineFormatter.state.State;

/**
 * interface command repository
 */
public interface ICommandRepositoryF {
    /**
     *
     * @param state current state
     * @param tokenName tokenName
     * @return command
     */
    ICommand getNextCommand(State state, String tokenName);
}
