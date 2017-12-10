package com.sitnikovasj.app.stateMashineLexer;

import java.util.HashMap;

public class CommandRepository implements ICommandRepository {
    private HashMap<MyPair, ICommand> commandsMap;
    private CommandSkip command;

    public CommandRepository(){
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
        commandsMap.put(new MyPair(spacing, " "), append);
        commandsMap.put(new MyPair(def, ";"), append);
        commandsMap.put(new MyPair(def, null), append);

    }

    public ICommand getNextCommand(State state, String simbol) {

        if (commandsMap.containsKey(new MyPair(state, simbol))) {
            return commandsMap.get(new MyPair(state, simbol));
        } else {
            return commandsMap.get(new MyPair(state, null));
        }
    }

}
