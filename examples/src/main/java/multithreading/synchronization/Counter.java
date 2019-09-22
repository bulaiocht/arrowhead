package multithreading.synchronization;

public class Counter {

    private volatile long counter = 0;
    private volatile long counter2 = 0;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void increment() {
        //some other non-critical code
        synchronized (lock1) {
            counter++;
        }

    }

    public void decrement() {
        synchronized (lock2) {
            counter2--;
        }
    }

    public long getCounter() {
        return counter;
    }

    public long getCounter2() {
        return counter2;
    }
}
