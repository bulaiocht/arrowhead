package HomeTasks.HomeTask5.Utilities;

import HomeTasks.HomeTask5.Classes.Distance;

import java.util.List;
import java.util.stream.Collectors;

public class IntersectionFigures {

    public static List<Distance> closestFigures(
            List<Distance> input, int k) {

        return input.stream()


                .sorted( Distance::compareTo )
                .distinct()
                .peek( System.out::println )
                .limit( k )
                .collect( Collectors.toList() );

    }
}

