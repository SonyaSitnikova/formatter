package com.sitnikovasj.app.lexer.stateMashineLexer.state;

/**
 * interface for Pair(state, inputChar)
 */
public interface IMyPair {
    /**
     *
     * @return input Char
     */
    String getInputSignal();

    /**
     *
     * @return state
     */
    State getState();

}
