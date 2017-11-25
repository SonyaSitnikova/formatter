package com.sitnikovasj.app.io.closable;

/**
 * Closable interface
 */

public interface IClosable extends AutoCloseable {
    @Override
    void close() throws CloseException;
}
