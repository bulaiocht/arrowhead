package multithreading.concurrent.lock;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LockExample {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        List<Thread> putters = Stream.generate(() -> (Runnable) () -> {
            Random random = new Random();
            while (true) {
                int item = random.nextInt(200);
                resource.putNewItem(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })
                .limit(5)
                .map(Thread::new)
                .collect(Collectors.toList());

        List<Thread> removers = Stream.generate(() -> (Runnable) () -> {
            Random random = new Random();
            while (true) {
                int item = random.nextInt(200);
                resource.removeItem(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })
                .limit(5)
                .map(Thread::new)
                .collect(Collectors.toList());


        List<Thread> printers = Stream.generate(() -> (Runnable) () -> {
            Random random = new Random();
            while (true) {
                int lowPrice = random.nextInt(100);
                int highPrice = random.nextInt(100) + 101;
                System.out.printf("Number of items in price range: %d - %d is %d\n",
                        lowPrice,
                        highPrice,
                        resource.countItems(lowPrice, highPrice));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })
                .limit(5)
                .map(Thread::new)
                .collect(Collectors.toList());

        putters.forEach(Thread::start);
        removers.forEach(Thread::start);
        printers.forEach(Thread::start);

    }

    static class SharedResource {

        private TreeMap<Integer, Integer> priceToQuantity =
                new TreeMap<>();

        private Lock lock = new ReentrantLock();

        private ReadWriteLock readWriteLock;

        private Lock readLock;

        private Lock writeLock;

        public SharedResource() {

            this.readWriteLock = new ReentrantReadWriteLock();

            this.readLock = readWriteLock.readLock();

            this.writeLock = readWriteLock.writeLock();

        }

        public void putNewItem(int item) {

            if (writeLock.tryLock()) {

                try {

                    if (priceToQuantity.containsKey(item)) {
                        Integer quantity = priceToQuantity.get(item);
                        priceToQuantity.put(item, quantity + 1);
                    } else priceToQuantity.put(item, 1);
                } finally {
                    writeLock.unlock();
                }

            } else {
                System.out.printf("Thread: %s was unable to acquire lock\n", Thread.currentThread().getName());
            }

        }

        public void removeItem(int item) {

            if (writeLock.tryLock()) {
                try {
                    Integer quantity = priceToQuantity.get(item);
                    if (quantity == null || quantity == 1) {
                        priceToQuantity.remove(item);
                    } else {
                        priceToQuantity.put(item, quantity - 1);
                    }
                } finally {
                    writeLock.unlock();
                }
            } else {
                System.out.printf("Thread: %s was unable to acquire lock\n", Thread.currentThread().getName());
            }
        }

        public int countItems(int lowPrice, int topPrice) {


            try {

                readLock.lock();

                Integer from;
                Integer to;

                from = priceToQuantity.ceilingKey(lowPrice);
                to = priceToQuantity.floorKey(topPrice);

                if (from == null || to == null) {
                    return 0;
                }

                return priceToQuantity
                        .subMap(from, to)
                        .values()
                        .stream()
                        .reduce(0, Integer::sum);

            } finally {
                readLock.unlock();
            }

        }
    }
}
