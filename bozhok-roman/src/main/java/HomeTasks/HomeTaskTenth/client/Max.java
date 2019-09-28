package HomeTasks.HomeTaskTenth.client;

public class Max extends Client  {

    public static void main(String[] args) {

        Max max = new Max();
        max.getConnection("127.0.0.5");
        max.sendJsonMessage();

    }

}
