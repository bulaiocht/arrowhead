package multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicRunner {
    public static void main(String[] args) {

        AtomicLong atomicLong = new AtomicLong(0);

        Thread t1 = new Thread( () -> {
           while (true) {
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(atomicLong.incrementAndGet());
           }
        });

        Thread t2 = new Thread( () -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicLong.decrementAndGet());
            }
        });

        t1.start();
        t2.start();
    }
}
