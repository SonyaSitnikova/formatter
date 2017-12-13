package com.sitnikovasj.app.lexer.stateMashineLexer.command;

import com.sitnikovasj.app.lexer.stateMashineLexer.state.MyPair;
import com.sitnikovasj.app.lexer.stateMashineLexer.state.State;

import java.util.HashMap;

/**
 *  Class for Commands reposytory
 */
public class CommandRepository implements ICommandRepository {
    private HashMap<MyPair, ICommand> commandsMap;

    /**
     *  Constructor
     */
    public CommandRepository() {
        this.commandsMap = new HashMap<>();
        State def = new State("DEFAULT");
        State spacing = new State("SPACING");

        commandsMap.put(new MyPair(def, ";"), (symbol, context) -> {
            context.addLexeme(symbol); context.setTokenName("semicolon"); });
        commandsMap.put(new MyPair(def, "{"), (symbol, context) -> {
            context.addLexeme(symbol); context.setTokenName("openBracket"); });
        commandsMap.put(new MyPair(def, "}"), (symbol, context) -> {
            context.addLexeme(symbol); context.setTokenName("closeBracket"); });
        commandsMap.put(new MyPair(def, " "), (symbol, context) -> {
            context.addLexeme(symbol); context.setTokenName("space"); });
        commandsMap.put(new MyPair(def, "\n"), (symbol, context) -> {
            context.addLexeme(symbol); context.setTokenName("newLine"); });
        commandsMap.put(new MyPair(def, null), (symbol, context) -> {
            context.addLexeme(symbol); context.setTokenName("char"); });

        commandsMap.put(new MyPair(spacing, " "), (symbol, context) -> {
            context.addLexeme(symbol); context.setTokenName("space"); });
        commandsMap.put(new MyPair(spacing, null), (symbol, context) -> {
            context.addPostponed(symbol); });

    }

    /**
     *
     * @param state current State
     * @param symbol current symbol
     * @return command
     */
    public ICommand getNextCommand(final State state, final String symbol) {

        if (commandsMap.containsKey(new MyPair(state, symbol))) {
            return commandsMap.get(new MyPair(state, symbol));
        } else {
            return commandsMap.get(new MyPair(state, null));
        }
    }

}
