package interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceRunner {
    public static void main(String[] args) {

        A.staticMethod();

        Swimmable swimmable1 = new Duck();
        Swimmable swimmable2 = new Barge();

        List<Swimmable> swimmables = Arrays.asList(swimmable1, swimmable2);

        for (final Swimmable swimmable : swimmables) {
            swimmable.swim();
        }

        LambdaInterface lambda = new LambdaInterface() {
            private int number;
            @Override
            public void consume(String text) {
                final int number = this.number;
                System.out.println(text);
            }
        };

        lambda.consume("Hello");

        String something = "something";

        LambdaInterface lambda2 = t -> {
            String concat = t.concat(something);
            System.out.println(concat);
        };

        lambda2.consume("hello");

        Function<String, Integer> function = String::length;

        Integer stringLength = function.andThen(integer -> integer - 20).apply("This is some string");

        System.out.println(stringLength);

        Consumer<Integer> integerConsumer = System.out::println;
        BiConsumer<Integer, Integer> integerIntegerBiConsumer = (i1, i2) -> System.out.println(i1+i2);

        Predicate<String> stringPredicate = something::equalsIgnoreCase;

        final boolean hello = stringPredicate.test("hello");

        System.out.println(hello);

        Double[] doubles = new Double[100];

        randomizeArray(Math::random, doubles);

        for (final Double aDouble : doubles) {
            System.out.println(aDouble);
        }

        randomizeArray(() -> 1.0,doubles);

        for (final Double aDouble : doubles) {
            System.out.println(aDouble);
        }

    }

    public static void randomizeArray(Supplier<Double> supplier, Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = supplier.get();
        }
    }
}
