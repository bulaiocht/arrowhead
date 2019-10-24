package io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ByteArrayExample {

    public static void main(String[] args) {

        int loop = 0;

        byte [] buff = new byte[1024];

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try (InputStream is = ByteArrayExample.class
                .getClassLoader()
                .getResourceAsStream("song.txt")) {

            if(is != null) {
                while (true) {
                    int read = is.read(buff);
                    if (read == -1) break;
                    os.write(buff, 0, read);
                    Arrays.fill(buff, (byte) 0);
                    loop++;
                }
                System.out.printf("Loop ran %d times\n", loop);
            }

            String text = os.toString();
            System.out.println(text);

        } catch (IOException e ) {
            e.printStackTrace();
        }

    }

}
