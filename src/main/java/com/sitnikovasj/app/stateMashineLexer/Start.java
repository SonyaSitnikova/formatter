package com.sitnikovasj.app.stateMashineLexer;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.lexer.IToken;
import com.sitnikovasj.app.lexer.Token;

import java.util.ArrayList;

public class Start {
    private IReader reader;
    private char currentSymbol;
    private String tokenName = "";
    private StringBuilder lexeme;
    private ArrayList<Character> postponed = null;
    private StateTransitions stateTransitions;
    private CommandRepository commands;
    private State currentState;
    private Context context = new Context();

    public Start(){
        this.reader = reader;
    }
    public IToken startFiniteStateMashine (final IReader reader) throws ReaderException {
        this.reader = reader;

        stateTransitions = new StateTransitions();
        currentState = new State("DEFAULT");
        State fin = new State("FINAL");

        lexeme = new StringBuilder("");
        commands = new CommandRepository();

        while(!currentState.equals(fin)){
            try {
                postponed = context.getPostponed();
//                if (postponed.size() > 0) { // здесь не работает
//                    currentSymbol = postponed.get(0);
//                    postponed.remove(0);
//                }else{
                currentSymbol = reader.getChar();
//                }
            } catch (ReaderException e) {
                throw new ReaderException("error read currentSymbol", e);
            }
            context = new Context(postponed, tokenName, lexeme);
            ICommand nextCommand = commands.getNextCommand(currentState, Character.toString(currentSymbol));
            nextCommand.execute(currentSymbol, context);

            currentState = stateTransitions.getNextState(currentState, Character.toString(currentSymbol));
        }

        tokenName = context.getTokenName();
        lexeme = context.getLexeme();
        return new Token(tokenName, lexeme.toString());
    }
}
