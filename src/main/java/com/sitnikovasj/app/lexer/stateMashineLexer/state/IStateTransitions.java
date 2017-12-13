package com.sitnikovasj.app.lexer.stateMashineLexer.state;

/**
 *
 */
public interface IStateTransitions {
    /**
     *
     * @param state current State
     * @param inputSignal current Char
     * @return Next State
     */
    State getNextState(State state, String inputSignal);
}
