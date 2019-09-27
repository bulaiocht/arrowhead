package HomeTasks.HomeTaskTenth.client;

import HomeTasks.HomeTaskTenth.server.Server;
import HomeTasks.HomeTaskTenth.server.ServerConfig;

public class Anna extends Client {

    public static void main(String[] args) {

        Anna anna = new Anna();
        anna.getConnection();
        while (true){

            anna.sendJsonMessage();
            anna.getMessage();

        }


    }

}
