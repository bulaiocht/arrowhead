package socket.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class SimpHttpClient {

    public static void main(String[] args) throws IOException {

        InetAddress addr = InetAddress.getByName("www.google.com");
        Socket socket = new Socket(addr, 80);
        boolean autoFlush = true;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), autoFlush);
        BufferedReader in = new BufferedReader(

                new InputStreamReader(socket.getInputStream()));
        // send an HTTP request to the web server
        out.println("GET / HTTP/1.1");
        out.println("Host: www.google.com:80");
        out.println("Connection: Close");
        out.println();

        // read the response
        boolean loop = true;
        StringBuilder sb = new StringBuilder();
        while (loop) {
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
        }
        String string = sb.toString();
        String[] split = string.split("\r\n");
        String s1 = Arrays.stream(split)
                .filter(s -> s.startsWith("<"))
                .findFirst().orElse("");

        Files.deleteIfExists(Paths.get("examples/src/main/resources/body.html"));
        Path file = Files.createFile(Paths.get("examples/src/main/resources/body.html"));
        OutputStream outputStream = Files.newOutputStream(file);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        writer.write(s1);
        writer.flush();
        writer.close();

        System.out.println(s1);
        socket.close();
    }

}
