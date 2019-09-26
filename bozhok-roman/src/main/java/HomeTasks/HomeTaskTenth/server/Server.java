package HomeTasks.HomeTaskTenth.server;

import HomeTasks.HomeTaskSixth.abstractClasses.Polygon;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Server implements ServerConfig {

    private static final ServerSocket serverSocket = getServerSocket();
    private static final  int MAX_USERS = 10;

    private static ServerSocket getServerSocket(){
        try {
            return new ServerSocket(PORT,MAX_USERS,INET_ADDRESS);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(serverSocket.getInetAddress());
    }


}
