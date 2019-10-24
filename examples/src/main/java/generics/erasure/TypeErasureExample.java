package generics.erasure;

import java.util.Arrays;
import java.util.List;

public class TypeErasureExample {
    public static void main(String[] args) {

        List<String> hello = Arrays.asList("Hello", "world");

        SomeType type = new SomeType();
        type.consume(hello);// ClassCastException

        SomeType<Number> numberType = new SomeType<>();
        numberType.consume(hello);

    }
}
