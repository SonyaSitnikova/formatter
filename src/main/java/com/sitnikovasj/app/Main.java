package com.sitnikovasj.app;

import com.sitnikovasj.app.formatter.Formatter;
import com.sitnikovasj.app.formatter.Formatter2;
import com.sitnikovasj.app.formatter.IFormatter;
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
     * Main method.
     * @param args console arguments
     * @throws Exception exception
     */
//    public static void main1(final String[] args) throws Exception {
//        IFormatter formatter = new Formatter();
//        try (
//                FileReader fr = new FileReader(ags[0]);
//                FileWriter fw = new FileWriter(args[1])
//        )
//        {
//            formatter.format(fr, fw);
//        }
//    }

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