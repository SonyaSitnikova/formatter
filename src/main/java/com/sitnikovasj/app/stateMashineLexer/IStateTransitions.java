package com.sitnikovasj.app.stateMashineLexer;

public interface IStateTransitions {
    State getNextState(State state, String inputSignal);
}
