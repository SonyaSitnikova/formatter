package com.sitnikovasj.app.lexer;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.stateMashineLexer.Start;


public class Lexer implements ILexer {
    private IReader reader;
    private Start start = new Start();
    private IToken token;

    /**
     *
     * @param reader reader
     * @throws ReaderException exception
     */
    public Lexer(final IReader reader) throws ReaderException {
        this.reader = reader;

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
    public IToken readToken() throws LexerException, ReaderException {
        return token = start.startFiniteStateMashine(reader);
    }
}
