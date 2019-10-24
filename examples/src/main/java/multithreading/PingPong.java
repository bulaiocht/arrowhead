package multithreading;

public class PingPong implements Runnable {

    private String phrase;
    private long sleepPeriod;

    public PingPong(String phrase, long period) {
        this.phrase = phrase;
        this.sleepPeriod = period;
    }

    @Override
    public void run() {
        try {
            for (; ;) {
                System.out.println(phrase);
                Thread.sleep(sleepPeriod);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " stopping its stuff.");
        }
    }
}
