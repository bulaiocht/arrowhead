package HomeTasks.HomeTaskTenth2;

import java.io.IOException;

public class Anna extends Client {

    public static void main(String[] args) {

        try {
            Anna anna = new Anna();
            anna.starter("127.0.0.1");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
