package com.sitnikovasj;

import java.io.*;

public class Main {
    public static void main(final String[] args) {
        try {
            File filein = new File("target/classes/input.txt");
            File fileout = new File("target/classes/output.txt");
            BufferedReader br = new BufferedReader(new FileReader(filein));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileout));
            int c;
            char ch;
            String str;
            int p = 0;
            while((c = br.read()) != -1) {
                ch = (char)c;
                if ((ch!=';') && (ch!='{') && (ch!='}')){
                    bw.write(ch);
                } else {
                    if (ch == ';'){
                        str = "";
                        str = str + ";" + "\n";
                        for (int i=0; i<p; i++){
                            str = str + " ";
                        }
                        while ((c = br.read()) == ' ' && (c = br.read()) != -1) {

                        }
                        bw.write(str);
                    }
                    if (ch == '{'){
                        str = "";
                        p = p + 4;
                        str = str + "{" + "\n";
                        for (int i=0; i<p; i++){
                            str = str + " ";
                        }
                        while (((c = br.read()) == ' ') && ((c = br.read()) != -1)) {

                        }
                        bw.write(str);
                    }
                    if (ch == '}'){
                        str = "";
                        p = p - 4;
                        str = str + "}" + "\n";
                        for (int i=0; i<p; i++){
                            str = str + " ";
                        }
                        while (((c = br.read()) == ' ') && ((c = br.read()) != -1)) {

                        }
                        bw.write(str);
                    }
                }
            }
            br.close();
            bw.close();
        } catch(IOException exc){
            exc.printStackTrace();
        }
    }

}