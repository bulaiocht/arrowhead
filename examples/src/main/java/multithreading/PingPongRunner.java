package multithreading;

public class PingPongRunner {
    public static void main(String[] args) throws InterruptedException {

        PingPong ping = new PingPong("ping", 5000);
        PingPong pong = new PingPong("pong", 5000);

        Thread t1 = new Thread(ping);
        Thread t2 = new Thread(pong);

        t1.start();
        t2.start();

        Thread.sleep(50000);

        t1.interrupt();
        t2.interrupt();

    }
}
