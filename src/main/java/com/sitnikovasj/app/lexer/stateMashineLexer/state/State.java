package com.sitnikovasj.app.lexer.stateMashineLexer.state;

/**
 * State for Lexer
 */
public class State implements IState {
    private String name;

    /**
     *
     * @param sname the name of the state
     */
    public State(final String sname) {
        this.name = sname;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        State state = (State) o;

        return name != null ? name.equals(state.name) : state.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
