package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerExample {
    public static void main(String[] args) {

        InputStream is = IOExample.class.getClassLoader().getResourceAsStream("song.txt");

        if (is != null) {

            try (BufferedOutputStream os
                         = new BufferedOutputStream(new FileOutputStream("song_copy.txt"))){

                Scanner scanner = new Scanner(is);
//                scanner.useDelimiter(Pattern.compile("\\s"));

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    os.write(line.getBytes());
                    os.write("\n".getBytes());
                }

                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}
