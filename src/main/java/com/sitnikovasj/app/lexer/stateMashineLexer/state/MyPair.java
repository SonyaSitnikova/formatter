package com.sitnikovasj.app.lexer.stateMashineLexer.state;

/**
 * the MyPaip contains the state and inputSignal(char)
 */
public class MyPair implements IMyPair {
    private State state;
    private String inputSignal;

    /**
     *
     * @param state state
     * @param inputSignal input char
     */
    public MyPair(final State state, final String inputSignal) {
        this.state = state;
        this.inputSignal = inputSignal;
    }

    @Override
    public String getInputSignal() {
        return inputSignal;
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

        MyPair myPair = (MyPair) o;

        if (state != null ? !state.equals(myPair.state) : myPair.state != null) {
            return false;
        }
        return inputSignal != null ? inputSignal.equals(myPair.inputSignal) : myPair.inputSignal == null;
    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (inputSignal != null ? inputSignal.hashCode() : 0);
        return result;
    }
}
