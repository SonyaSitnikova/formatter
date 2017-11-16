package com.sitnikovasj.Interfaces;

import com.sitnikovasj.Classes.FileReader;
import com.sitnikovasj.Classes.FileWriter;
import com.sitnikovasj.Exceptions.FormatterException;

public interface IFormatter {

    void formatter(FileReader fr, FileWriter fw)throws FormatterException;
}
