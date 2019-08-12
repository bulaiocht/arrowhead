package multithreading.pc;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {

        Storage<String> storage = new Storage<>(10);

        Thread t1 = new Thread(() -> {
            for (; ;) {
                try {
                    storage.put("hehe");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer");
        Thread t2 = new Thread(() -> {
            for (; ;) {
                try {
                    System.out.println(storage.remove());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer1");

        Thread t3 = new Thread(() -> {
            for (; ;) {
                try {
                    System.out.println(storage.remove());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer2");


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
