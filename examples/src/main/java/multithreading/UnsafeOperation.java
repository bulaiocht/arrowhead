package multithreading;

public class UnsafeOperation {

    private volatile int number;

    public int getNumber() {
        return number;
    }

    synchronized int increment(int amount) {
        return number += amount;
    }

}
