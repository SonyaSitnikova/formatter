package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.state.MyPair;
import com.sitnikovasj.app.lexer.stateMashineLexer.state.State;

import java.util.HashMap;

/**
 *  Class for Commands reposytory
 */
public class CommandRepository implements ICommandRepository {
    private HashMap<MyPair, ICommand> commandsMap;
    private CommandSkip command;

    /**
     *  Constructor
     */
    public CommandRepository() {
        this.commandsMap = new HashMap<>();
        State def = new State("DEFAULT");
        State spacing = new State("SPACING");

        ICommand append = new CommandAppend();
        ICommand postpone = new CommandPostpone();
        ICommand skip = new CommandSkip();

        commandsMap.put(new MyPair(def, ";"), append);
        commandsMap.put(new MyPair(def, "{"), append);
        commandsMap.put(new MyPair(def, "}"), append);
        commandsMap.put(new MyPair(def, " "), append);
        commandsMap.put(new MyPair(spacing, " "), append);
        commandsMap.put(new MyPair(def, null), append);
        commandsMap.put(new MyPair(spacing, null), postpone);

    }

    /**
     *
     * @param state current State
     * @param simbol current symbol
     * @return command
     */
    public ICommand getNextCommand(final State state, final String simbol) {

        if (commandsMap.containsKey(new MyPair(state, simbol))) {
            return commandsMap.get(new MyPair(state, simbol));
        } else {
            return commandsMap.get(new MyPair(state, null));
        }
    }

}
