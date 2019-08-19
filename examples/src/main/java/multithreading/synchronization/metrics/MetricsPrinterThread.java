package multithreading.synchronization.metrics;

public class MetricsPrinterThread extends Thread {

    private Metrics metrics;

    public MetricsPrinterThread(Metrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Printer interrupted.");
                return;
            }
            System.out.println("Current average time: " + metrics.getAverage());
        }
    }
}
