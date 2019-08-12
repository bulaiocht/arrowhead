package multithreading.wait;

public class Container {

    private int number;
    private int limit;

    public Container(int limit) {
        if (limit < 0)
            throw new IllegalArgumentException("Limit must be positive");

        this.limit = limit;
    }

    public synchronized void increase() {

        while (number >= limit) {
            try {
                System.out.println(Thread.currentThread().getName() + ": waiting...");
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": I've been interrupted");
                break;
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            return;
        }
        number++;
        System.out.println(Thread.currentThread().getName() + ": " + number);

    }

    public synchronized void reduce() {

        while (number <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + ": waiting...");
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": I've been interrupted");
                break;
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            return;
        }
        number--;
        System.out.println(Thread.currentThread().getName() + ": " + number);

    }

}
