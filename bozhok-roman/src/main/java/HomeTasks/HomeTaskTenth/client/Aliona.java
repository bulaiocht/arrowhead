package HomeTasks.HomeTaskTenth.client;

public class Aliona extends Client {

    public static void main(String[] args) {

        Aliona aliona = new Aliona();
        aliona.getConnection("127.0.0.3");
        aliona.sendJsonMessage();


    }

}
