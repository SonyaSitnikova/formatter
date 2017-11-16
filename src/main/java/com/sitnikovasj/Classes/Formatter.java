package com.sitnikovasj.Classes;

import com.sitnikovasj.Exceptions.FormatterException;
import com.sitnikovasj.Exceptions.ReaderException;
import com.sitnikovasj.Exceptions.WriterException;
import com.sitnikovasj.Interfaces.IFormatter;


public class Formatter implements IFormatter{

    @Override
    public void formatter(com.sitnikovasj.Classes.FileReader fr, com.sitnikovasj.Classes.FileWriter fw) throws FormatterException {
        try {
            char ch;
            String str;
            int p = 0;
            while (fr.readNext()) {
                ch = fr.getChar();
                if ((ch != ';') && (ch != '{') && (ch != '}')) {
                    fw.write(ch);
                } else {
                    if (ch == ';') {
                        str = "";
                        str = str + ";" + "\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }
                        while (fr.readNext() && (fr.getChar()) == ' ') {

                        }
                        char[] c = str.toCharArray();
                        for (int i=0; i<c.length; i++) {
                            fw.write(c[i]);
                        }
                    }
                    if (ch == '{') {
                        str = "";
                        p = p + 4;
                        str = str + "{" + "\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }
                        while (fr.readNext() && (fr.getChar()) == ' '){

                        }
                        char[] c = str.toCharArray();
                        for (int i=0; i<c.length; i++) {
                            fw.write(c[i]);
                        }
                    }
                    if (ch == '}') {
                        str = "";
                        p = p - 4;
                        str = str + "}" + "\n";
                        for (int i = 0; i < p; i++) {
                            str = str + " ";
                        }
                        while (fr.readNext() && (fr.getChar()) == ' '){

                        }
                        char[] c = str.toCharArray();
                        for (int i=0; i<c.length; i++) {
                            fw.write(c[i]);
                        }
                    }
                }
            }

    } catch (WriterException e) {
            throw new FormatterException("Formatter error", e);
        } catch (ReaderException e) {
            throw new FormatterException("Formatter error", e);
        }
    }
}
