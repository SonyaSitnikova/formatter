package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.io.writer.IWriter;
import com.sitnikovasj.app.io.writer.WriterException;

public class Formatter implements IFormatter{

    @Override
    public void format(IReader in, IWriter out) throws FormatterException {
        try {
            char currentSymbol;
            String str;
            int p = 0;
            while (in.readNext()) {
                currentSymbol = in.getChar();
                if ((currentSymbol != ';') && (currentSymbol != '{') && (currentSymbol != '}')) {
                    out.write(currentSymbol);
                } else {
                    if (currentSymbol == ';') {
                        str = "";
                        str = str + ";" + "\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }
                        while (in.readNext() && (in.getChar()) == ' ') {

                        }
                        char[] c = str.toCharArray();
                        for (int i = 0; i < c.length; i++) {
                            out.write(c[i]);
                        }
                    }
                    if (currentSymbol == '{') {
                        str = "";
                        p = p + 4;
                        str = str + "{" + "\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }
                        while (in.readNext() && (in.getChar()) == ' ') {

                        }
                        char[] c = str.toCharArray();
                        for (int i = 0; i < c.length; i++) {
                            out.write(c[i]);
                        }
                    }
                    if (currentSymbol == '}') {
                        str = "";
                        p = p - 4;
                        str = str + "}" + "\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }
                        while (in.readNext() && (in.getChar()) == ' ') {

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
