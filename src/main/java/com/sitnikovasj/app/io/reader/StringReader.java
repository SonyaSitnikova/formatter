package com.sitnikovasj.app.io.reader;

public class StringReader implements IReader{

    private String value;
    private int index;

    public StringReader(final String value) {
        this.value = value;
    }

    @Override
    public boolean readNext() throws ReaderException {
        return false;
    }

    @Override
    public char getChar() throws ReaderException {
        return 0;
    }
}
