package com.sitnikovasj.app;

import com.sitnikovasj.app.formatter.FormatterFSM;
import com.sitnikovasj.app.formatter.IFormatterFSM;
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
        IFormatterFSM formatterFSM = new FormatterFSM();
        try (
                FileReader fr = new FileReader(args[0]);
                FileWriter fw = new FileWriter(args[1])
        )
        {
            ILexer lexer = new Lexer(fr);
            formatterFSM.format(lexer, fw);
        }
    }
}