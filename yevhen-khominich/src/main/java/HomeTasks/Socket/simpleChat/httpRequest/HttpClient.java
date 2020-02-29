package HomeTasks.Socket.simpleChat.httpRequest;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;

public class HttpClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("www.google.com", 80));

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        writer.write("GET / HTTP/1.1\n");
        writer.write("Host: www.google.com:80");
        writer.newLine();
        writer.flush();
        writer.close();

        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }
}
