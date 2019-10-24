package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {

    private static final String QUIT = "QUIT";
    private static final String TERMINATE = "X";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("192.168.1.39", 5000));

        try {

            while (true) {
                Socket client = serverSocket.accept();
                new Worker(client).start();
            }
        } finally {
            serverSocket.close();
        }


    }

    private static class Worker extends Thread {

        private final Socket clientSocket;

        private Worker(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
            ) {
                int port = clientSocket.getPort();
                InetAddress inetAddress = clientSocket.getInetAddress();
                String hostName = inetAddress.getHostName();

                System.out.println("connection from " + hostName + ":" + port);
                writer.write("hello, " + hostName);
                writer.newLine();
                writer.flush();

                while (true) {
                    String line = reader.readLine();
                    if (line != null) {
                        System.out.println(line);
                        writer.write("ECHO: " + line);
                        writer.newLine();
                        writer.flush();
                    }

                    if (QUIT.equalsIgnoreCase(line)) {
                        writer.write("Bye!");
                        writer.newLine();
                        writer.flush();
                        break;
                    }

                    if (TERMINATE.equalsIgnoreCase(line)) {
                        writer.write("Terminating server");
                        writer.newLine();
                        writer.flush();
                        return;
                    }
                }

            } catch (IOException e) {

            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
