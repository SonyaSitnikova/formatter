package com.sitnikovasj.app.io.reader;

/**
 * FileReader interface
 */
public interface IReader {
    /**
     *
     * @return true, if read next symbol
     * @throws ReaderException if there was a read error
     */
    boolean readNext() throws ReaderException;

    /**
     *
     * @return getChar
     * @throws ReaderException if there was a read error
     */
    char getChar() throws ReaderException;
}
