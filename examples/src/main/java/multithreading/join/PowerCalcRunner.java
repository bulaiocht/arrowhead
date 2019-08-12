package multithreading.join;

import java.math.BigInteger;

public class PowerCalcRunner {
    public static void main(String[] args) {

        PowerCalc calc1 = new PowerCalc(BigInteger.valueOf(75), BigInteger.valueOf(39));
        PowerCalc calc2 = new PowerCalc(BigInteger.valueOf(11), BigInteger.valueOf(183));

        calc1.start();
        calc2.start();

        try {
            calc1.join();
            calc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BigInteger result1 = calc1.getResult();
        BigInteger result2 = calc2.getResult();

        System.out.println(result1);
        System.out.println(result2);

        System.out.println(result1.add(result2));

    }
}
