package multithreading.synchronization.metrics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MetricsRunner {
    public static void main(String[] args) {

        Metrics metrics = new Metrics();

        BusinessThread t1 = new BusinessThread(metrics);
        BusinessThread t2 = new BusinessThread(metrics);
        BusinessThread t3 = new BusinessThread(metrics);

        MetricsPrinterThread printerThread = new MetricsPrinterThread(metrics);

        List<Thread> threads = new LinkedList<>(Arrays.asList(t1, t2, t3, printerThread));

        threads.forEach(Thread::start);

    }
}
