package collections.iterators;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IteratorExample {

    public static void main(String[] args) {

        int number = 2000;
        List<String> strings = randomStrings(number);
        System.out.println(strings.size());

    }

    private static List<String> randomStrings(int number) {
        return Stream
                .generate(() -> RandomStringUtils.randomAlphabetic(5))
                .limit(number)
                .collect(Collectors.toList());
    }

}
