package collections;

import java.util.ArrayList;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();

        for (final String string : strings) {
            System.out.println(string);
        }

    }
}
