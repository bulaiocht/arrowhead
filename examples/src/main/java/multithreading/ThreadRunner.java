package multithreading;

import multithreading.join.FactorialCalculator;

public class ThreadRunner {

    public static void main(String[] args) throws InterruptedException {


//        Thread currentThread = Thread.currentThread();
//        currentThread.setName("Billy Bob");
//
//        System.out.println(currentThread.getName());
//
//        currentThread.setUncaughtExceptionHandler(new Handler());

//        throw new IllegalArgumentException();
//        Thread t1 = new Thread("Worker thread");
//        t1.start();
//        System.out.println(t1.getName());

//        Worker worker = new Worker();
//        Worker worker1 = new Worker();
//        Worker worker2 = new Worker();
//        Worker worker3 = new Worker();
//        BadThread badThread = new BadThread();

//        worker.setDaemon(true);
//        worker1.setDaemon(true);
//        worker2.setDaemon(true);
//        worker3.setDaemon(true);
//        badThread.setDaemon(true);
//
//        worker.start();
//        worker1.start();
//        worker2.start();
//        worker3.start();
//        badThread.start();
//
//        worker.interrupt();


        FactorialCalculator calculator = new FactorialCalculator(10000);

        calculator.start();

        calculator.join(1500);

        if (calculator.isAlive()) {

            calculator.interrupt();

            calculator.join();
        }

        System.out.println(calculator.getFactorial().toString().length());

        System.out.printf("Last Line for %s\n", Thread.currentThread().getName());
    }

    private static class Handler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.err.printf("Exception %s caught in thread %s",
                    e.getMessage(),
                    t.getName());
        }
    }

    private static class BadThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (i == 8){
                    i -= 5;
                }
            }
        }
    }

    private static class Worker extends Thread {

        @Override
        public void run() {
            int counter = 0;
            while (counter < 100000) {
//                try {
//                    sleep(500);
//                } catch (InterruptedException e) {
//                    System.out.printf("%s: I've been interrupted", getName());
//                    System.out.printf("%s: My last result was %d", getName(), counter);
//                    return;
//                }
                if (counter == 99999){
                    System.out.println("Thread " + getName() + ": " + counter);
                }
                counter++;
            }
        }
    }

}
