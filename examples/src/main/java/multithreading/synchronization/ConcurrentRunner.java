package multithreading.synchronization;

public class ConcurrentRunner {

    private static final int ROUNDS = 10_000_000;

    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < ROUNDS; i++) {
                c.increment();
            }
        }, "Incrementor");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < ROUNDS; i++) {
                c.decrement();
            }
        }, "Decrementor");

        long start = System.currentTimeMillis();

            t1.start();
            t2.start();

            t1.join();
            t2.join();

        long end = System.currentTimeMillis();

        System.out.println("Counter1: " + c.getCounter());
        System.out.println("Counter2: " + c.getCounter2());

        System.out.println("Millis taken: " + (end - start));
    }
}
