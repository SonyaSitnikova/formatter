package com.sitnikovasj.app.formatter.stateMachineFormatter.command;

import com.sitnikovasj.app.formatter.stateMachineFormatter.state.PairST;
import com.sitnikovasj.app.formatter.stateMachineFormatter.state.State;

import java.util.HashMap;

/**
 *  Class for Commands repository
 */
public class CommandRepositoryF implements ICommandRepositoryF {
    private HashMap<PairST, ICommand> commandsMap;

    /**
     *  Constructor
     */
    public CommandRepositoryF() {
        this.commandsMap = new HashMap<>();
        State def = new State("DEFAULT");
        State spacing = new State("SPACING");

        commandsMap.put(new PairST(def, null), new Comanda());
        commandsMap.put(new PairST(def, "char"), new Comanda());

    }

    /**
     *
     * @param state current state
     * @param tokenName tokenName
     * @return next command
     */
    @Override
    public ICommand getNextCommand(final State state, final String tokenName) {
        if (commandsMap.containsKey(new PairST(state, tokenName))) {
            return commandsMap.get(new PairST(state, tokenName));
        } else {
            return commandsMap.get(new PairST(state, null));
        }
    }
}
