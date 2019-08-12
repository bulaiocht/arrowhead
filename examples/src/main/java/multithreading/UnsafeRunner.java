package multithreading;

public class UnsafeRunner {
    public static void main(String[] args) throws InterruptedException {

        UnsafeOperation operation = new UnsafeOperation();
        Runnable r1 = () -> {
            try {
                for (;;) {
                    incrementAndSleep(operation, 150);
                }

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopping what it does.");
            }
        };

        Runnable r2 = () -> {
            try {
                for (;;) {
                    incrementAndSleep(operation, 200);
                }

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopping what it does.");
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        if (t1.isAlive() && t2.isAlive()) {
            t1.join(2000);
            t2.join(2000);

            if (t1.isAlive()) {
                t1.interrupt();
            }
            if (t2.isAlive()) {
                t2.interrupt();
            }

        }

        System.out.println(operation.getNumber());

    }

    private static void incrementAndSleep(UnsafeOperation operation, long sleep) throws InterruptedException {
        Thread.sleep(sleep);
        System.out.println(Thread.currentThread().getName() + ": " + operation.increment(1));
    }

}
