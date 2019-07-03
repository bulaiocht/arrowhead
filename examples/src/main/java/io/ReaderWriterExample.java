package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class ReaderWriterExample {

    public static void main(String[] args) throws IOException {

        buffReaderWriterExample();
//        printStreamExample();

    }

    private static void buffReaderWriterExample() throws IOException {

        InputStream resource = ReaderWriterExample.class.getClassLoader().getResourceAsStream("song.txt");

        Reader fileReader = new FileReader(new File("examples/src/main/resources/song.txt"));

        if (resource != null){
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            BufferedWriter writer = new BufferedWriter(new FileWriter("copy.txt"));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        }

    }

    private static void printStreamExample() {
        PrintStream stream = new PrintStream(System.out, true);
        stream.printf("Hello %s\n", "World");
        stream.println("line");
    }
}
