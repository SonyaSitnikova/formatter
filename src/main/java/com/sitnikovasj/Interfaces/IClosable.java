package com.sitnikovasj.Interfaces;

import com.sitnikovasj.Exceptions.CloseException;
import com.sitnikovasj.Exceptions.WriterException;

public interface IClosable extends AutoCloseable{
    @Override
    void close() throws CloseException;
}
