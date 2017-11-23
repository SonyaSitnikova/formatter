package com.sitnikovasj.app.io.closable;

public interface IClosable extends AutoCloseable{
    @Override
    void close() throws CloseException;
}
