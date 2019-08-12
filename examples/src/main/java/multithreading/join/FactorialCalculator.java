package multithreading.join;

import java.math.BigInteger;

public class FactorialCalculator extends Thread {

    private final long num;

    private BigInteger factorial;

    private boolean finished;

    public FactorialCalculator(long num) {
        if (num < 0) {
            throw new IllegalArgumentException("Illegal argument: " + num + ". Must be positive number.");
        }
        this.num = num;
        this.setName(String.format("Calculator(%d)", num));
    }

    private BigInteger factorial(BigInteger number) {

        BigInteger result = BigInteger.ONE;
        BigInteger tmp = number;

        while (!isInterrupted()) {
            if (BigInteger.ZERO.equals(tmp) || BigInteger.ONE.equals(tmp)) {
                return result;
            }
            result = result.multiply(tmp);
            tmp = tmp.subtract(BigInteger.ONE);
        }
        System.out.printf("%s has been INTERRUPTED. Returning.\n", this.getName());
        return BigInteger.ZERO;
    }

    @Override
    public void run() {
        System.out.printf("%s started calculating factorial of %d\n", this.getName(), num);
        this.factorial = factorial(BigInteger.valueOf(num));
        System.out.printf("%s finished calculating factorial of %d\n", this.getName(), num);
    }

    public BigInteger getFactorial() {
        return factorial;
    }

    public long getNum() {
        return num;
    }

}
