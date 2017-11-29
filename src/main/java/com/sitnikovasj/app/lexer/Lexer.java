package com.sitnikovasj.app.lexer;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.reader.ReaderException;

public class Lexer implements ILexer {
    private IReader reader;
    private char currentSymbol;
    private String name = "anyToken";
    private String lexeme;


    public Lexer(IReader reader) throws ReaderException {
        this.reader = reader;
    }

    @Override
    public boolean hasMoreTokens() throws LexerException {
        try {
            return reader.readNext();
        } catch (ReaderException e) {
            throw new LexerException("Can't read", e);
        }
    }

    @Override
    public IToken readToken() throws LexerException, ReaderException {
        currentSymbol = reader.getChar();
        lexeme = Character.toString(currentSymbol);
        return new Token(name, lexeme);
    }
}
