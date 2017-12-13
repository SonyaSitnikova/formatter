package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.io.writer.IWriter;
import com.sitnikovasj.app.io.writer.WriterException;
import com.sitnikovasj.app.lexer.ILexer;
import com.sitnikovasj.app.lexer.IToken;
import com.sitnikovasj.app.lexer.LexerException;

/**
 * Formatter to format Java source code that is specified in the input file
 */
public class Formatter2 implements IFormatter2 {

    @Override
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException,
            LexerException, ReaderException, WriterException {
        while (lexer.hasMoreTokens()) {
            IToken token = lexer.readToken();
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
