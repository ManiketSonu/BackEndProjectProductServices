package com.mani.example.productservices.ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
    public double divideGivenNumber(int x)
    {
        return 100 / x;
    }

    public static void createFile(String name) throws IOException {
        FileReader fileReader = new FileReader(name);
        fileReader.read();
    }
}
