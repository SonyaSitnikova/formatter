package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.io.writer.IWriter;
import com.sitnikovasj.app.io.writer.WriterException;

/**
 * Formatter to format Java source code that is specified in the input file
 */
public class Formatter implements IFormatter {

    @Override
    public void format(final IReader in, final IWriter out) throws FormatterException {
        char currentSymbol;
        String str;
        int p;
        final int tab = 4;
        try {
            p = 0;
            while (in.hasNextChar()) {
                currentSymbol = in.readChar();
                if ((currentSymbol != ';') && (currentSymbol != '{') && (currentSymbol != '}')) {
                    out.write(currentSymbol);
                } else {
                    if (currentSymbol == ';') {
                        str = "";
                        str = str + ";" + "\r\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }
                        char[] c = str.toCharArray();
                        for (int i = 0; i < c.length; i++) {
                            out.write(c[i]);
                        }

                    }
                    if (currentSymbol == '{') {
                        str = "";
                        p = p + tab;
                        str = str + "{" + "\r\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }

                        char[] c = str.toCharArray();
                        for (int i = 0; i < c.length; i++) {
                            out.write(c[i]);
                        }

                    }
                    if (currentSymbol == '}') {
                        str = "";
                        p = p - tab;
                        str = str + "}" + "\r\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }

                        char[] c = str.toCharArray();
                        for (int i = 0; i < c.length; i++) {
                            out.write(c[i]);
                        }

                    }
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        }
    }
    }
