package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedExample {

    public static void main(String[] args) throws InterruptedException {

        PipeWriter pipeWriter = new PipeWriter("song.txt");

        PipeReader pipeReader = new PipeReader(pipeWriter.getOutputStream(), "copy.txt");

        Thread t1 = new Thread(pipeWriter);
        Thread t2 = new Thread(pipeReader);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

class PipeWriter implements Runnable {

    private PipedOutputStream outputStream;
    private String srcFile;
    private byte [] buff = new byte[1024];

    PipeWriter(String srcFile) {
        this.outputStream = new PipedOutputStream();
        this.srcFile = srcFile;
    }

    @Override
    public void run() {

        try(InputStream is = PipeWriter.class
                .getClassLoader()
                .getResourceAsStream(srcFile)){

            if (is != null) {
                while (true) {
                    int read = is.read(buff);
                    if (read == -1) break;
                    outputStream.write(buff, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    PipedOutputStream getOutputStream() {
        return this.outputStream;
    }
}

class PipeReader implements Runnable {

    private PipedInputStream pis;
    private PipedOutputStream pos;
    private String output;
    private byte [] buff = new byte[1024];

    PipeReader(PipedOutputStream pos,
                      String output) {
        this.pis = new PipedInputStream();
        this.pos = pos;
        this.output = output;
    }

    @Override
    public void run() {
        try (OutputStream os = new BufferedOutputStream(new FileOutputStream(output))){
            pis.connect(pos);
            while (true) {
                int read = pis.read(buff);
                if (read == -1) break;
                os.write(buff, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}