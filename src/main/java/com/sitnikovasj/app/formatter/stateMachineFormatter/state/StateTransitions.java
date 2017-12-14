package com.sitnikovasj.app.formatter.stateMachineFormatter.state;

import java.util.HashMap;

/**
 *  State Transitions for Formatter
 */
public class StateTransitions implements IStateTransitions {
    private HashMap<PairST, State> stateTransitions;
    private State fin;

    /**
     *  Constructor
     */
    public StateTransitions() {
        this.stateTransitions = new HashMap<>();
        State def = new State("DEFAULT");
        fin = new State("FINAL");

        stateTransitions.put(new PairST(def, (String) null), def);

    }

    @Override
    public State getNextState(final State state, final String tokenName) {

        if (stateTransitions.containsKey(new PairST(state, tokenName))) {
            return stateTransitions.get(new PairST(state, tokenName));
        } else {
            return stateTransitions.get(new PairST(state, (String) null));
        }
    }

}
