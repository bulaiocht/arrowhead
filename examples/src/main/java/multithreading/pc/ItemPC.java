package multithreading.pc;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemPC {
    public static void main(String[] args) {

        ItemQueue queue = new ItemQueue(10);

        List<Thread> putters = Stream.generate(() -> (Runnable) () -> {
            while (true) {
                queue.produce();
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

        List<Thread> consumers = Stream.generate(() -> (Runnable) () -> {
            while (true) {
                queue.consume();
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
            while (true) {
                queue.printQueue();
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

        putters.forEach(Thread::start);
        consumers.forEach(Thread::start);
        printers.forEach(Thread::start);

    }
}
