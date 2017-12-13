package com.sitnikovasj.app;

import com.sitnikovasj.app.formatter.Formatter2;
import com.sitnikovasj.app.formatter.IFormatter2;
import com.sitnikovasj.app.io.reader.FileReader;
import com.sitnikovasj.app.io.writer.FileWriter;
import com.sitnikovasj.app.lexer.ILexer;
import com.sitnikovasj.app.lexer.Lexer;

/**
 * Class main.
 */
public class Main {
    /**
     * Constructor
     */
    public Main(){}

    /**
     * Main method.
     * @param args console arguments
     * @throws Exception exception
     */

    public static void main(final String[] args) throws Exception {
        IFormatter2 formatter2 = new Formatter2();
        try (
                FileReader fr = new FileReader(args[0]);
                FileWriter fw = new FileWriter(args[1])
        )
        {
            ILexer lexer = new Lexer(fr);
            formatter2.format(lexer, fw);
        }
    }
}