package socket;

import javax.swing.*;
import java.io.*;
import java.net.*;

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

//        @Override
//        public void run() {
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
//
//                int port = clientSocket.getPort();
//                InetAddress inetAddress = clientSocket.getInetAddress();
//                String hostName = inetAddress.getHostName();
//                System.out.println("connection from " + hostName + ":" + port);
//
//                while (true) {
//                    String line = reader.readLine();
//                    if (line != null) {
//                        System.out.println(line);
//                    }
//
//                    if (QUIT.equalsIgnoreCase(line)) {
//                        break;
//                    }
//                    if (TERMINATE.equalsIgnoreCase(line)) {
//                        return;
//                    }
//                }
//            }
//        }
    }
}