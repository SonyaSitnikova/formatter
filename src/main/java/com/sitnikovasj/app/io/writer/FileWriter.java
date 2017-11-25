package com.sitnikovasj.app.io.writer;

import com.sitnikovasj.app.io.closable.CloseException;
import com.sitnikovasj.app.io.closable.IClosable;

import java.io.*;

/**
 * Implementation of the writer
 */
public class FileWriter implements IWriter, IClosable {

    private BufferedWriter bufferedWriter;

    /**
     *
     * @param path where output
     * @throws WriterException if there was a write error
     */
    public FileWriter(final String path) throws WriterException {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(path));
            Writer fileWriter = new OutputStreamWriter(outputStream, "utf-8");
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            throw new WriterException("Opening file error", e);
        }
    }

    @Override
    public void close() throws CloseException {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new CloseException("Closing error", e);
        }
    }

    @Override
    public void write(final char symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            throw new WriterException("Writing error", e);
        }
    }
}
