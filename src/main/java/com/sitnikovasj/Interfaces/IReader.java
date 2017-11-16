package com.sitnikovasj.Interfaces;

import com.sitnikovasj.Exceptions.ReaderException;

public interface IReader {
    boolean readNext() throws ReaderException;
    char getChar() throws ReaderException;
}
