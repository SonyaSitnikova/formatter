package com.sitnikovasj.app.lexer.stateMashineLexer.state;

import java.util.HashMap;

/**
 *  State Transitions for Lexer
 */
public class StateTransitions implements IStateTransitions {
    private HashMap<MyPair, State> stateTransitions;
    private State fin;

    /**
     *  Constructor
     */
    public StateTransitions() {
        this.stateTransitions = new HashMap<>();
        State def = new State("DEFAULT");
        State spacing = new State("SPACING");
        fin = new State("FINAL");

        stateTransitions.put(new MyPair(def, ";"), fin);
        stateTransitions.put(new MyPair(def, "{"), fin);
        stateTransitions.put(new MyPair(def, "}"), fin);
        stateTransitions.put(new MyPair(def, " "), spacing);
        stateTransitions.put(new MyPair(spacing, " "), spacing);
        stateTransitions.put(new MyPair(spacing, (String) null), fin);
        stateTransitions.put(new MyPair(def, (String) null), fin);

    }

    @Override
    public State getNextState(final State state, final String inputSignal) {
        //return stateTransitions.getOrDefault(new MyPair(state, inputSignal),fin);
        if (stateTransitions.containsKey(new MyPair(state, inputSignal))) {
            return stateTransitions.get(new MyPair(state, inputSignal));
        } else {
            return stateTransitions.get(new MyPair(state, (String) null));
        }
    }
}
