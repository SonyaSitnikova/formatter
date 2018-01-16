package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.formatter.stateMachineFormatter.*;
import com.sitnikovasj.app.formatter.stateMachineFormatter.command.CommandRepositoryF;
import com.sitnikovasj.app.formatter.stateMachineFormatter.command.ICommand;
import com.sitnikovasj.app.formatter.stateMachineFormatter.state.State;
import com.sitnikovasj.app.formatter.stateMachineFormatter.state.StateTransitions;
import com.sitnikovasj.app.io.writer.IWriter;
import com.sitnikovasj.app.io.writer.WriterException;
import com.sitnikovasj.app.lexer.ILexer;
import com.sitnikovasj.app.lexer.IToken;
import com.sitnikovasj.app.lexer.LexerException;

/**
 * Formatter to format Java source code that is specified in the input file
 */
public class FormatterFSM implements IFormatterFSM {

    CommandRepositoryF commands;
    State state;
    StateTransitions st;
    /**
     * Constructor formatter
     */
    public FormatterFSM() {
        commands = new CommandRepositoryF();
        state = new State("DEFAULT");
        st = new StateTransitions();
    }

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        IToken token;
        IToken nextToken = null;
        String tokenName;
        Context context = new Context();
        ICommand nextCommand;

        try {
            while (lexer.hasMoreTokens()) {
                token = nextToken;
                nextToken = lexer.readToken();
                tokenName = token.getName();
                nextCommand = commands.getNextCommand(state, tokenName);
                nextCommand.execute(context, token);
                nextCommand.execute();
                state = st.getNextState(state, tokenName);

                String lexeme = token.getLexeme();
                //write(writer, lexeme);
            }
        } catch (LexerException e) {
            throw new FormatterException("read token error", e);
        }
    }

    private void write(final IWriter writer, final String lexeme) throws WriterException {
        char[] c = lexeme.toCharArray();
        for (int i = 0; i < c.length; i++) {
            writer.write(c[i]);
        }
    }
}
