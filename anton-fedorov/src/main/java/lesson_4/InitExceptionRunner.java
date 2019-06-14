package lesson_4;

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
        Optional<Object> optional=Optional.of(InitExceptionRunner.o);

        boolean present = optional.isPresent();

        Object o = optional.orElse(new Object());

        Object objrct_shoild_not_be_null = optional.orElseThrow(() -> new IllegalArgumentException("Objrct shoild not be null"));

        Object o1 = optional.orElseGet(Math::random);

        Optional<Object> optional1 = optional.filter(obj -> obj.equals(o));

        Optional.of(line).isPresent(l-> System.out.println(l.toLowerCase()));

        boolean b = Objects.nonNull(line);

        String s = InitExceptionRunner.o.toString();
        System.out.println(InitExceptionRunner.o.hashCode());
        System.out.println("Main method");
    }

}
