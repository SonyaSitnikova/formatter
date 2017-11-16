package com.sitnikovasj.Classes;

import com.sitnikovasj.Exceptions.CloseException;
import com.sitnikovasj.Exceptions.ReaderException;
import com.sitnikovasj.Interfaces.IClosable;
import com.sitnikovasj.Interfaces.IReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class FileReader  implements IReader, IClosable {
    private BufferedReader bufferedReader;
    private int currentSymbolId;

    public FileReader(final String path) throws ReaderException {

        try {
            Reader fileReader = new java.io.FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            throw new ReaderException("Opening file error", e);
        }

    }

    @Override
    public void close() throws CloseException {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new CloseException("Closing stream error", e);
        }
    }

    @Override
    public boolean readNext() throws ReaderException {
        try {
            currentSymbolId = bufferedReader.read();
            return currentSymbolId > -1;
        } catch (IOException e) {
            throw new ReaderException("Attempting to read outside of the input stream", e);
        }
    }

    @Override
    public char getChar() throws ReaderException {
        return (char) currentSymbolId;
    }
}
