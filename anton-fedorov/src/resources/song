package lesson3;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test1 {
    public static void main(String[] args) {
        String something = "qwe";
        Predicate<String> stringPredicate = something::equals;
        boolean hello = stringPredicate.test("qwe");
        System.out.println(hello);

        Double[] doubles=new Double[100];

        randomizeArray(Math::random, doubles);

        for (final Double aDouble : doubles) {
            System.out.println(aDouble);
        }

        randomizeArray(()->1.0, doubles);

        for (final Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    private static void randomizeArray(Supplier<Double> supplier, Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i]=supplier.get();
        }
    }

}
