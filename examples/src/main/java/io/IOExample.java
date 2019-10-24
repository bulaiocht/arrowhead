package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOExample {

    private static final String SRC = String.format("examples%ssrc%smain%sresources%ssong.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator);

    private static final String COPY = String.format("examples%ssrc%smain%sresources%ssong_copy.txt",
            File.separator,
            File.separator,
            File.separator,
            File.separator);


    public static void main(String[] args) {
        bufferedInOut();
        byteArrayInOut();
    }

    private static void inputOutputRaw() {

        try (InputStream fis = new FileInputStream(SRC);

             OutputStream fos = new FileOutputStream(COPY)) {

            int i = 0;

            byte [] buff = new byte[1024];

            while (true) {
                int read = fis.read(buff);
                if (read == -1) break;
                i++;
                fos.write(buff, 0, read);
            }

            System.out.println("Cycles: " + i);


        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        } catch (IOException e ) {
            System.out.println("Unable to read file");
        }

    }

    private static void bufferedInOut() {
        try (InputStream is = new BufferedInputStream(new FileInputStream(SRC));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(COPY))){

            System.out.println(is.markSupported());

            while (true) {
                int read = is.read();
                if (read == -1) break;
                os.write(read);
            }

            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e ){
            e.printStackTrace();
        }
    }

    private static void byteArrayInOut() {
        String text = "Hello world";
        ByteArrayInputStream is = new ByteArrayInputStream(text.getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        while (true) {
            int read = is.read();
            if (read == -1) break;
            os.write(read);
        }

        System.out.println(os.toString());

    }
}
