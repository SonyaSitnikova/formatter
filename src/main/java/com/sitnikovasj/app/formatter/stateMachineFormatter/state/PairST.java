package com.sitnikovasj.app.formatter.stateMachineFormatter.state;

/**
 * the MyPaip contains the state and inputSignal(char)
 */
public class PairST implements IPairST {
    private State state;
    private String tokenName;

    /**
     *
     * @param state state
     * @param tokenName tokenName
     */

    public PairST(final State state, final String tokenName) {
        this.state = state;
        this.tokenName = tokenName;
    }


    @Override
    public State getState() {
        return state;
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PairST myPair = (PairST) o;

        if (state != null ? !state.equals(myPair.state) : myPair.state != null) {
            return false;
        }
        return tokenName != null ? tokenName.equals(myPair.tokenName) : myPair.tokenName == null;
    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (tokenName != null ? tokenName.hashCode() : 0);
        return result;
    }

}
