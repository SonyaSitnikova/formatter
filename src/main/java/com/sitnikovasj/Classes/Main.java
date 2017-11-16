package com.sitnikovasj.Classes;

public class Main {
    public static void main(final String[] args) throws Exception {
        Formatter formatter = new Formatter();
        try (
                FileReader fr = new FileReader("target/classes/input.txt");
                FileWriter fw = new FileWriter("target/classes/output.txt");

        )

        { formatter.formatter(fr, fw);
            fr.close();
            fw.close();
        }

    }
}