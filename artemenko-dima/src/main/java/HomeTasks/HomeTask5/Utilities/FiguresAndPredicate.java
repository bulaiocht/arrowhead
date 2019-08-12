package HomeTasks.HomeTask5.Utilities;

import HomeTasks.HomeTask5.Classes.Point;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FiguresAndPredicate {

    public static  List <? extends Point> figuresAndPredicate(
            Collection<? extends Point> input, int k) {

        return input.stream()
                .filter( (p) -> p.getRadius() < k )
                .peek( System.out::println )
                .collect( Collectors.toList() );
    }
}

