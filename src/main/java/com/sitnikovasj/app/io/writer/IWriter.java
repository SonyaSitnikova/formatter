package com.sitnikovasj.app.io.writer;

/**
 * FileWriter interface
 */
public interface IWriter {
    /**
     *
     * @param symbol for write
     * @throws WriterException if there was a write error
     */
    void write(char symbol) throws WriterException;
}
