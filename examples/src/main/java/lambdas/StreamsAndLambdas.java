package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsAndLambdas {

    public static void main(String[] args) {
//
//        Optional<Human> billy = Stream
//                .generate(Human::new)
//                .map(Function.identity())
//                .filter(Objects::nonNull)
//                .peek(human -> human.setName("Billy"))
//                .peek(System.out::println)
//                .limit(100)
//                .findAny();


//        Stream.generate(StreamsAndLambdas::counter)
//                .filter(integer -> integer > 50)
//                .peek(System.out::println)
//                .limit(100)
//                .findAny();


//        IntStream
//                .range(0, 200)
//                .peek(System.out::println)
//                .sorted();
//
        List<String> strings = new ArrayList<>();
        strings.add("c");
        strings.add("b");
        strings.add("f");
        strings.add("a");
        strings.add("d");

        String prefix = "/";

//        List<String> collect = strings.stream()
//                .sorted()
//                .peek(strings::add)
////                .peek(System.out::println)
//                .collect(Collectors.toList());

        Stream<String> one = Stream.of("a", "b", "c");
        Stream<String> two = Stream.of("d", "e", "f");
        Stream<String> concat = Stream.concat(one, two);

        Stream<Human> humanStream = Stream.of(new Human());

        Stream<HumChild> humChildStream = Stream.of(new HumChild());

        Stream.concat(humanStream, humChildStream);


        Map<String, List<Human>> collect = humanStream
                .collect(Collectors.groupingBy(Human::getName));



        concat
                .peek(System.out::println)
                .collect(Collectors.toList());

//        for (final String string : collect) {
//            System.out.println(string);
//        }
//
//        for (final String string : strings) {
//            System.out.println(strings);
//        }

    }

    private static int c = 0;

    private static int counter() {
        return c++;
    }

}
