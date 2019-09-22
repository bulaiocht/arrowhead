package multithreading.pc;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ItemQueue {

    private final Random random;

    private final Semaphore full;
    private final Semaphore empty;
    private final Lock writeLock;
    private final Lock readLock;

    private Queue<Integer> queue = new ArrayDeque<>();

    public ItemQueue(int capacity) {
        this.full = new Semaphore(0);
        this.empty = new Semaphore(capacity);
        this.random = new Random();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.readLock = reentrantReadWriteLock.readLock();
    }

    private int createItem() {
        return random.nextInt();
    }

    public void produce() {
        int item = createItem();
        try {
            empty.acquire();
            System.out.printf("thread %s acquired permit\n", Thread.currentThread().getName());
            try{
                writeLock.lock();
                System.out.printf("thread %s putting item %d\n", Thread.currentThread().getName(), item);
                queue.offer(item);
            }finally {
                writeLock.unlock();
            }
            full.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int consume() {
        try{
            full.acquire();
            System.out.printf("thread %s acquired permit\n", Thread.currentThread().getName());
            Integer poll;

            try{
                writeLock.lock();
                poll = queue.remove();
                System.out.printf("thread %s removed item %d\n", Thread.currentThread().getName(), poll);
            } finally {
                writeLock.unlock();
            }

            empty.release();

            return poll;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void printQueue() {
        try {
            readLock.lock();
            System.out.println(queue);
        } finally {
            readLock.unlock();
        }
    }


}
