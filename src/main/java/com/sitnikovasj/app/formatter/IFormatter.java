package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.writer.IWriter;

public interface IFormatter {

    void format(IReader in, IWriter out) throws FormatterException;
}
