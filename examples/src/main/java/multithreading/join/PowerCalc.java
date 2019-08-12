package multithreading.join;

import java.math.BigInteger;

public class PowerCalc extends Thread {

    private BigInteger result = BigInteger.ONE;
    private BigInteger base;
    private BigInteger power;

    public PowerCalc(BigInteger base, BigInteger power) {
        this.base = base;
        this.power = power;
    }

    @Override
    public void run() {
        this.result = pow(base, power);
    }

    private BigInteger pow(BigInteger base, BigInteger power) {

        if (base.compareTo(BigInteger.ZERO) < 0 || power.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Base and power must be positive.");
        }

        result = BigInteger.ONE;
        for (BigInteger counter = BigInteger.ZERO; counter.compareTo(power) < 0; counter = counter.add(BigInteger.ONE)) {
            result = result.multiply(base);
        }

        return result;
    }

    public BigInteger getResult() {
        return result;
    }
}
