package com.sitnikovasj.app.io.writer;

public class StringWriter implements IWriter {

    private StringBuilder resultString;

    public StringWriter() {
        resultString = new StringBuilder();
    }

    public final String toString() {
        return resultString.toString();
    }

    @Override
    public void write(char symbol) throws WriterException {
        try {
            resultString.append(symbol);
        } catch (Exception e) {
            throw new WriterException("Writing error", e);
        }
    }
}
