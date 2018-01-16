package com.sitnikovasj.app.lexer;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.lexer.stateMashineLexer.Context;
import com.sitnikovasj.app.lexer.stateMashineLexer.command.CommandRepository;
import com.sitnikovasj.app.lexer.stateMashineLexer.command.ICommand;
import com.sitnikovasj.app.lexer.stateMashineLexer.state.State;
import com.sitnikovasj.app.lexer.stateMashineLexer.state.StateTransitions;

import java.util.ArrayList;

/**
 * The Lexer returns tokens to the formatter
 */
public class Lexer implements ILexer {

    private IToken token;
    private IReader reader;
    private char currentSymbol;
    private String tokenName = "";
    private StringBuilder lexeme;
    private ArrayList<Character> postponed = new ArrayList<>();
    private StateTransitions stateTransitions;
    private CommandRepository commands;
    private State currentState;
    private State finState;
    private Context context = new Context();

    /**
     *
     * @param reader reader
     * @throws ReaderException exception
     */
    public Lexer(final IReader reader) throws ReaderException {
        this.reader = reader;
        stateTransitions = new StateTransitions();
        commands = new CommandRepository();
        currentState = new State("DEFAULT");
        finState = new State("FINAL");
    }

    @Override
    public boolean hasMoreTokens() throws LexerException {
        try {
            return reader.hasNextChar();
        } catch (ReaderException e) {
            throw new LexerException("Can't read", e);
        }
    }

    @Override
    public IToken readToken() throws LexerException {

        lexeme = new StringBuilder("");
        context = new Context(postponed, tokenName, lexeme);

        try {
            while (!currentState.equals(finState) && reader.hasNextChar()) {
                postponed = context.getPostponed();
                if (postponed.size() > 0) {
                    currentSymbol = postponed.get(0);
                    postponed.remove(0);
                } else {
                    currentSymbol = reader.readChar();
                }

                ICommand nextCommand = commands.getNextCommand(currentState, Character.toString(currentSymbol));
                nextCommand.execute(currentSymbol, context);

                currentState = stateTransitions.getNextState(currentState, Character.toString(currentSymbol));
            }
        } catch (ReaderException e) {
            throw new LexerException("reader next char error", e);
        }

        tokenName = context.getTokenName();
        lexeme = context.getLexeme();
        return new Token(tokenName, lexeme.toString());

    }
}
