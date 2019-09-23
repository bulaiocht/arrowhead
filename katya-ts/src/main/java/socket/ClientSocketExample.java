package socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocketExample {
    private static final String QUIT = "QUIT";
    private static final String TERMINATE = "X";

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.1.39", 5000));

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            while (true) {
                String line = inputReader.readLine();
                if (line != null) {
                    writer.write("meow");
                    writer.newLine();
                    writer.flush();
                }
                if (QUIT.equalsIgnoreCase(line) || TERMINATE.equalsIgnoreCase(line)) {
                    break;
                }
                String response = reader.readLine();
                System.out.println(response);
            }
        } finally {
            socket.close();
        }
    }
}
