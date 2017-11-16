package com.sitnikovasj.Classes;

import com.sitnikovasj.Exceptions.CloseException;
import com.sitnikovasj.Exceptions.WriterException;
import com.sitnikovasj.Interfaces.IClosable;
import com.sitnikovasj.Interfaces.IWriter;

import java.io.*;

public class FileWriter implements IWriter, IClosable{

    private BufferedWriter bufferedWriter;

    public FileWriter(final String path) throws WriterException {
        try {
            Writer fileWriter = new java.io.FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (FileNotFoundException e) {
            throw new WriterException("Opening file error", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws CloseException {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new CloseException("Closing error", e);
        }
    }

    @Override
    public void write(char symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            throw new WriterException("Writing error", e);
        }
    }
}
