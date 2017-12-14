package com.sitnikovasj.app.formatter.stateMachineFormatter.state;


/**
 *
 */
public interface IStateTransitions {
    /**
     *
     * @param state current State
     * @param tokenName tokenName
     * @return Next State
     */
    State getNextState(State state, String tokenName);
}
