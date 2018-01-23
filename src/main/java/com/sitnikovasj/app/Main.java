package com.sitnikovasj.app;

import com.sitnikovasj.app.formatter.FormatterFSM;
import com.sitnikovasj.app.formatter.IFormatterFSM;
import com.sitnikovasj.app.io.reader.FileReader;
import com.sitnikovasj.app.io.writer.FileWriter;
import com.sitnikovasj.app.lexer.ILexer;
import com.sitnikovasj.app.lexer.Lexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) throws Exception {
        logger.info("info");
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