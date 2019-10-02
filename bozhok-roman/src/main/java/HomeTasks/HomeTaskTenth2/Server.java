package HomeTasks.HomeTaskTenth2;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Server {
    private static final String QUIT = "QUIT";
    private static final String TERMINATE = "X";

    private static volatile Map<String, Socket> pullClient = new HashMap<>();
    private static volatile Map<String, List<String>> pullMessage = new HashMap<>();

    public static void starter(int port) throws IOException {

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));


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

                String hostName = clientSocket.getLocalAddress().toString();

                System.out.println("connection from " + hostName + ":" + port);
                String nameClient = reader.readLine();

                pullClient.put(nameClient, clientSocket);
                pullMessage.put(nameClient, new ArrayList<>());
                writer.write("hello, " + nameClient);
                writer.newLine();
                writer.flush();

                while (true) {
                    String line = reader.readLine();

                    if (QUIT.equalsIgnoreCase(line) || TERMINATE.equalsIgnoreCase(line)) {
                        pullClient.remove(pullClient);
                        clientSocket.close();
                        System.out.println("connection lost from " + hostName + ":" + port);
                        break;
                    }
                    if (line != null) {
                        String[] $s = line.split("@");
                        String[] receiver = $s[0].split("->");
                        System.out.println(receiver[1]);
                        System.out.println($s[1]);
                        String message = "From: " + receiver[0] + $s[1];
                        Socket socket = pullClient.get(receiver[1]);
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        bufferedWriter.write(message);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();

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
