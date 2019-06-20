package exceptions;

import java.util.Objects;
import java.util.Optional;

public class InitExceptionRunner {

    private static final int NUMBER = 10;
    private static final int ZERO = 0;
    private static int VAR;
    private static String line;


    private static Object o;

    static {
        System.out.println("Static initializer");
//        VAR = NUMBER / ZERO;
    }

    public static void main(String[] args) {

//        String arg = args[0];
//
//        System.out.println(arg.length());

        Optional<Object> optional = Optional.of(InitExceptionRunner.o);

        final boolean present = optional.isPresent();

        final Object o1 = optional.orElse(new Object());

        Object o2 = optional.orElseThrow(() -> new IllegalArgumentException("Object should not be null!"));

        final Object o3 = optional.orElseGet(Math::random);

        Optional<Object> optional1 = optional.filter(Objects::isNull);

        Optional.of(line).ifPresent(l -> System.out.println(l.toLowerCase()));

        final Object o = optional.get();

        boolean b = Objects.nonNull(line);

        String string = InitExceptionRunner.o.toString();

        string.concat("0000");

        System.out.println("Main method");
    }



}
