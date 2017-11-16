package com.sitnikovasj.Interfaces;

import com.sitnikovasj.Exceptions.WriterException;

public interface IWriter {
    void write(final char symbol) throws WriterException;
}
