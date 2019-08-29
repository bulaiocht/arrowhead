package multithreading.wait;

public class WaitRunner {
    public static void main(String[] args) throws InterruptedException {

        Container c = new Container(10);

        Thread t1 = new Thread(() -> {
            while (true) {
                c.increase();
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                c.reduce();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
