package HomeTasks.HomeTask5.Utilities;

import HomeTasks.HomeTask5.Classes.Distance;
import HomeTasks.HomeTask5.Classes.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DistanceList<T>{

    private static double dis;
    private static String str;

    public static List<Distance> distanceList(List<? extends Point> input) {

        ArrayList<Distance> distanceAL = new ArrayList<>();

        input.forEach( p1 -> input.stream().filter( p2 -> !p1.equals( p2 ) ).forEach( p2 -> {

            Distance distance = new Distance( p1, p2, str );
            dis = distance.getDis();
            str = message( input, p1, p2);
            distance.setStr( str );
            distanceAL.add( distance );
        } ) );

        return distanceAL.stream()
                .distinct()
                .peek( System.out::println )
                .collect( Collectors.toList() );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistanceList<?> that = (DistanceList<?>) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash( dis );
    }

    private double getDis() {
        return dis;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        DistanceList.str = str;
    }


    private static <T extends Point> String message(List<? extends Point> arrayL, T t1, T t2) {

        if (arrayL.indexOf( t1 ) < arrayL.indexOf( t2 )) {
            str = (t1.getType() + " #" + (arrayL.indexOf( t1 ) + 1) + " & " +
                    t2.getType() + " #" + (arrayL.indexOf( t2 ) + 1) + " distance = ");
        } else {
            str = (t2.getType() + " #" + (arrayL.indexOf( t2 ) + 1) + " & " +
                    t1.getType() + " #" + (arrayL.indexOf( t1 ) + 1) + " distance = ");
        }
        return str;
    }
}
