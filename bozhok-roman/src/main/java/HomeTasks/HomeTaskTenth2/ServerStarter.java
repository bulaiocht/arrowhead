package HomeTasks.HomeTaskTenth2;

import java.io.IOException;

public class ServerStarter   {
    public static void main(String[] args) {
        try {
            Server.starter(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
