package com.sitnikovasj.app;

import com.sitnikovasj.app.formatter.Formatter;
import com.sitnikovasj.app.formatter.IFormatter;
import com.sitnikovasj.app.io.reader.FileReader;
import com.sitnikovasj.app.io.writer.FileWriter;

/**
 * Class main.
 */
public class Main {
    /**
     * Main method.
     * @param args console arguments
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {
        IFormatter formatter = new Formatter();
        try (
                FileReader fr = new FileReader(args[0]);
                FileWriter fw = new FileWriter(args[1])
        )
        {
            formatter.format(fr, fw);
        }
    }
}