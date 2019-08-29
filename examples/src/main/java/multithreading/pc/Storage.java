package multithreading.pc;

import java.util.LinkedList;

public class Storage <T>{

    private volatile int limit;
    private final LinkedList<T> list = new LinkedList<>();

    public Storage(int limit) {
        this.limit = limit;
    }

    public void put(T value) throws InterruptedException {

        synchronized (this) {

            while (list.size() == limit) {
                wait();
            }

                System.out.println(Thread.currentThread().getName() + " adding value: " + value);
                list.add(value);
                System.out.println(Thread.currentThread().getName() + "=> storage size: " + list.size());

            notifyAll();

            Thread.sleep(1000);

        }
    }

    public T remove() throws InterruptedException {
        synchronized (this) {
            while (list.isEmpty()) {
                wait();
            }
            T value = list.remove();
            System.out.println(Thread.currentThread().getName() + "=> storage size: " + list.size());
            System.out.println(Thread.currentThread().getName() + " getting value: " + value);

            notifyAll();

            Thread.sleep(200);

            return value;

        }
    }

}
