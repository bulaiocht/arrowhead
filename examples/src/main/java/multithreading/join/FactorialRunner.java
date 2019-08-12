package multithreading.join;

import java.math.BigInteger;

public class FactorialRunner {

    public static void main(String[] args) throws InterruptedException {

//        Random random = new Random();
//
//        List<FactorialCalculator> calculators = Stream
//                .generate(() -> random.nextInt(200000))
//                .distinct()
//                .limit(10)
//                .map(FactorialCalculator::new)
////                .peek(t -> t.setDaemon(true))
//                .peek(Thread::start)
//                .collect(Collectors.toList());
//
//        for (FactorialCalculator calculator : calculators) {
//
//            System.out.printf("Joining %s for 5 sec\n", calculator.getName());
//            calculator.join(5000);
//
//            if (calculator.isAlive()) {
//                System.out.printf("Tired of waiting for %s. Interrupting.\n", calculator.getName());
//                calculator.interrupt();
//            }
//
//            calculator.join();
//
//            System.out.printf("Factorial %d is %s\n", calculator.getNum(), calculator.getFactorial());
//        }
//
//        System.out.printf("%s: main method last line\n", Thread.currentThread().getName());
    }
}
