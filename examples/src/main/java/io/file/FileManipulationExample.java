package io.file;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class FileManipulationExample {

    public static void main(String[] args) {

        File someFile = new File("examples/src/main/resources/song.txt");
        File dir = new File("examples/src/main/resources");
        File nonexistent = new File("foo");

        try {
            boolean newFile = nonexistent.createNewFile();
            if (newFile){
                System.out.println("Hooray! Created new file " + nonexistent.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printStuffAboutFile(nonexistent);

        final boolean deleted = nonexistent.delete();
        final boolean deleted1 = nonexistent.delete();

        if (deleted1)
            System.out.println("Hooray! deleted file " + nonexistent.getName());



    }

    private static void printStuffAboutFile(final File someFile) {

        System.out.printf("File name: %s\n", someFile.getName());
        System.out.printf("File exists: %s\n", someFile.exists());
        System.out.printf("File is dir: %s\n",someFile.isDirectory());
        System.out.printf("File length in bytes: %s\n", someFile.length());
        System.out.printf("I can execute: %s\n", someFile.canExecute());

        final long lastModified = someFile.lastModified();
        final Instant instant = Instant.ofEpochMilli(lastModified);
        System.out.printf("Last modified: %s\n", instant.toString());

        System.out.printf("File path: %s\n", someFile.getPath());
        System.out.printf("File abs path: %s\n", someFile.getAbsolutePath());
    }

}
