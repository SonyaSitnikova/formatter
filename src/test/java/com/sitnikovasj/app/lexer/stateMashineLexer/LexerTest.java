package com.sitnikovasj.app.lexer.stateMashineLexer;

import com.sitnikovasj.app.formatter.FormatterException;
import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.io.reader.StringReader;
import com.sitnikovasj.app.io.writer.WriterException;
import com.sitnikovasj.app.lexer.ILexer;
import com.sitnikovasj.app.lexer.IToken;
import com.sitnikovasj.app.lexer.Lexer;
//import org.junit.Before;
import com.sitnikovasj.app.lexer.LexerException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexerTest {
    private IReader in;
    private IToken token;
    private ILexer lexer;

//    @Before
//    public void setUp() throws ReaderException {
//        in = new StringReader("");
//        lexer = new Lexer(in);
//    }

    @Test
    public void TestTokensLexeme() throws ReaderException, LexerException {
        in = new StringReader("a");
        lexer = new Lexer(in);
        token = lexer.readToken();
        assertEquals("a", token.getLexeme());

        in = new StringReader(";");
        lexer = new Lexer(in);
        token = lexer.readToken();
        assertEquals(";", token.getLexeme());

        in = new StringReader("   ");
        lexer = new Lexer(in);
        token = lexer.readToken();
        assertEquals("   ", token.getLexeme());
    }
    @Test
    public void TestTokensName() throws ReaderException, LexerException {
        in = new StringReader("a");
        lexer = new Lexer(in);
        token = lexer.readToken();
        assertEquals("char", token.getName());

        in = new StringReader(";");
        lexer = new Lexer(in);
        token = lexer.readToken();
        assertEquals("semicolon", token.getName());

        in = new StringReader("   ");
        lexer = new Lexer(in);
        token = lexer.readToken();
        assertEquals("space", token.getName());
    }


}
