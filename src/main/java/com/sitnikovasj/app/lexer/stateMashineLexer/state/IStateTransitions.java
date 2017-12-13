package com.sitnikovasj.app.lexer.stateMashineLexer.state;

public interface IStateTransitions {
    State getNextState(State state, String inputSignal);
}
