package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.writer.IWriter;

/**
 *  Formatter interface
 */
public interface IFormatter {

    /**
     *
     * @param in - input stream
     * @param out - output stream
     * @throws FormatterException with formatting error
     */
    void format(IReader in, IWriter out) throws FormatterException;
}
