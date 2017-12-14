package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.io.writer.IWriter;
import com.sitnikovasj.app.io.writer.WriterException;
import com.sitnikovasj.app.lexer.ILexer;
import com.sitnikovasj.app.lexer.LexerException;

/**
 *  Formatter interface
 */
public interface IFormatterFSM {

    /**
     *
     * @param lexer - input stream
     * @param writer - output stream
     * @throws FormatterException with formatting error
     * @throws LexerException with lexer error
     * @throws ReaderException with read error
     * @throws WriterException with write error
     */
    void format(ILexer lexer, IWriter writer) throws FormatterException, LexerException, ReaderException, WriterException;
}
