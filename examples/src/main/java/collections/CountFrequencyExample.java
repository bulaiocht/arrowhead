package collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountFrequencyExample {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("examples/src/main/resources", "song.txt");

        String i = "I";

//        List<String> strings = Files.readAllLines(path);

        List<String> strings = Files
                .lines(path)
                .filter(s -> s.length() > 12)
                .collect(Collectors.toList());

        strings.stream()
                .map(s -> s.split("\\s"))
                .map(Arrays::asList)
                .forEach(list -> {
                    int frequency = Collections.frequency(list, i);
                    System.out.printf("There is %d of \'%s\'\n", frequency, i);
                });


        for (String string : strings) {
            String[] split = string.split("\\s");
            List<String> words = Arrays.asList(split);
            int frequency = Collections.frequency(words, i);
            System.out.printf("There is %d of \'%s\' in \"%s\"\n", frequency, i, string);
        }


        boolean b = strings
                .stream()
                .map(String::length)
                .distinct()
                .anyMatch(integer -> integer > 5);

        Stream<Double> distinct = Stream
                .generate(Math::random)
                .limit(200)
                .distinct();

        Optional<Double> max = distinct.max(Double::compareTo);

        Optional<Double> max1 = distinct.limit(10).max(Double::compareTo);

    }
}
