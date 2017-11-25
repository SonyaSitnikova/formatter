package com.sitnikovasj.app.formatter;

import com.sitnikovasj.app.io.reader.IReader;
import com.sitnikovasj.app.io.reader.ReaderException;
import com.sitnikovasj.app.io.reader.StringReader;
import com.sitnikovasj.app.io.writer.IWriter;
import com.sitnikovasj.app.io.writer.StringWriter;
import com.sitnikovasj.app.io.writer.WriterException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    private IFormatter formatter;

    @Before
    public void setUp() {

        formatter = new Formatter();
    }

    @Test
    public void Test1() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("Hello world");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("Hello world", out.toString());
    }

    @Test
    public void Test2() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("Hello world;");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("Hello world;\r\n", out.toString());
    }

    @Test
    public void Test3() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("main {}");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("main {\r\n    }\r\n", out.toString());
    }

    @Test
    public void Test4() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("class Class {method {int x = 1;}}");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("class Class {\r\n    method {\r\n        int x = 1;\r\n        }\r\n    }\r\n", out.toString());
    }

    @Test
    public void Test5() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("x = 1;fun1{}");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("x = 1;\r\nfun1{\r\n    }\r\n", out.toString());
    }
}
