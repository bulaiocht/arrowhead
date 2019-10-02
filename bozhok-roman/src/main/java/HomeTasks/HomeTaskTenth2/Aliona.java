package HomeTasks.HomeTaskTenth2;

import java.io.IOException;

public class Aliona extends Client{

    public static void main(String[] args) {

        try {
            Aliona aliona = new Aliona();
            aliona.starter("127.0.0.2");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
