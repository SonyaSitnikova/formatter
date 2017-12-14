package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.formatter.stateMachineFormatter.*;
import com.sitnikovasj.app.formatter.stateMachineFormatter.command.CommandRepositoryF;
import com.sitnikovasj.app.formatter.stateMachineFormatter.command.ICommand;
import com.sitnikovasj.app.formatter.stateMachineFormatter.state.State;
import com.sitnikovasj.app.formatter.stateMachineFormatter.state.StateTransitions;
import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.io.writer.IWriter;
import com.sitnikovasj.app.io.writer.WriterException;
import com.sitnikovasj.app.lexer.ILexer;
import com.sitnikovasj.app.lexer.IToken;
import com.sitnikovasj.app.lexer.LexerException;

/**
 * Formatter to format Java source code that is specified in the input file
 */
public class FormatterFSM implements IFormatterFSM {

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException,
            LexerException, ReaderException, WriterException {
        IToken token;
        String tokenName;
        Context context = new Context();
        ICommand nextCommand;
        CommandRepositoryF commands = new CommandRepositoryF();
        State state = new State("DEFAULT");
        StateTransitions st = new StateTransitions();

        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
            tokenName = token.getName();
            nextCommand = commands.getNextCommand(state, tokenName);
            nextCommand.execute(context, token);
            nextCommand.execute();
            state = st.getNextState(state, tokenName);

            String lexeme = token.getLexeme();
            write(writer, lexeme);
        }
    }

    private void write(final IWriter writer, final String lexeme) throws WriterException {
        char[] c = lexeme.toCharArray();
        for (int i = 0; i < c.length; i++) {
            writer.write(c[i]);
        }
    }
}
