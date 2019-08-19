package multithreading.synchronization.metrics;

import java.util.Random;

public class BusinessThread extends Thread {

    private Metrics metrics;

    private static final Random RANDOM = new Random();

    public BusinessThread(Metrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public void run() {

        while (true) {

            long start = System.currentTimeMillis();
            try {
                Thread.sleep(RANDOM.nextInt(100));
            } catch (InterruptedException e) {
                System.err.println("Interrupted.");
                return;
            }
            long end = System.currentTimeMillis();
            metrics.addSample(end - start);

        }
    }
}
