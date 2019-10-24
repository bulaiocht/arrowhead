package io.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvRunner {

    public static void main(String[] args) throws IOException {

        Path tempFile = Files.createTempFile("temp_", ".scv");

        CsvCreator csvCreator = new CsvCreator(tempFile.toFile(), Headers.class);


    }

    enum Headers {
        NAME,
        AGE,
        ADDRESS
    }
}
