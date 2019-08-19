package multithreading.wait;

public class Container {

    private int number;
    private int limit;
    private final Object lock = new Object();

    public Container(int limit) {
        if (limit < 0)
            throw new IllegalArgumentException("Limit must be positive");

        this.limit = limit;
    }

    public void increase() {

        synchronized (lock) {
            while (number >= limit) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": waiting...");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + ": I've been interrupted");
                    return;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
            number++;
            System.out.println(Thread.currentThread().getName() + ": " + number);
            lock.notifyAll();
        }

    }

    public void reduce() {
        synchronized (lock) {
            while (number <= 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": waiting...");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + ": I've been interrupted");
                    return;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
            number--;
            System.out.println(Thread.currentThread().getName() + ": " + number);
            lock.notifyAll();
        }

    }

}
