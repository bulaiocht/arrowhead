package HomeTask.TenthTask.server;



import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private ServerSocket serverSocket;
    private ConcurrentHashMap<String, ClientConnectionThread> clientMap;

    public Server() {

        ResourceBundle config = ResourceBundle.getBundle("server_config");
        String host = config.getString("host");
        String port = config.getString("port");

        try {

            InetSocketAddress socketAddress = new InetSocketAddress(host, Integer.parseInt(port));
            serverSocket = new ServerSocket();
            serverSocket.bind(socketAddress);

        } catch (IOException e) {
            throw new RuntimeException("Unable to create server socket", e);
        }

        this.clientMap = new ConcurrentHashMap<>();

    }

    public void startServer() {

        InetAddress inetAddress = serverSocket.getInetAddress();
        int localPort = serverSocket.getLocalPort();

        System.out.println("starting server on " + inetAddress.getHostName() + ":" + localPort);
        try {

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientSocket.setKeepAlive(false);

                String id = String.valueOf(clientSocket.getPort());
                ClientConnectionThread clientConnectionThread =
                        new ClientConnectionThread(id, clientSocket, this);
                clientConnectionThread.start();
                clientMap.put(id, clientConnectionThread);
                System.out.println(id + " connected to server.");

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void deleteClient(String id) {
        ClientConnectionThread clientConnectionThread = clientMap.get(id);
        clientConnectionThread.sendMessage("Good bye " + id);
        Socket socket = clientConnectionThread.getSocket();
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                clientMap.remove(id);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(id + " disconnected from the server.");
    }

    public void sendClientMessage(String sender, String recipient, String message) {
        ClientConnectionThread recipientThread = clientMap.get(recipient);
        String toSend = String.format("%s %s: %s", LocalTime.now(), sender, message);
        recipientThread.sendMessage(toSend);
    }

    public void sendMessageToAll(String sender, String message) {
        String toSend = String.format("%s user %s %s", LocalTime.now(), sender, message);
        getClientList().forEach(client -> client.sendMessage(toSend));
    }

    public List<ClientConnectionThread> getClientList() {
        return new ArrayList<>(clientMap.values());
    }
}
