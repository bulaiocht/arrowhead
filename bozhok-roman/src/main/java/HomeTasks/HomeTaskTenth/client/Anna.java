package HomeTasks.HomeTaskTenth.client;

import HomeTasks.HomeTaskTenth.server.Server;
import HomeTasks.HomeTaskTenth.server.ServerConfig;

import java.io.IOException;
import java.net.Socket;

public class Anna extends Client {

    public static void main(String[] args) throws IOException {

        Anna anna = new Anna();
        anna.getConnection("127.0.0.3");
        anna.sendJsonMessage();



    }

}
