package HomeTasks.HomeTaskSixth.main;


import HomeTasks.HomeTaskSixth.classes.CircleWithCoordinates;
import HomeTasks.HomeTaskSixth.classes.Point;
import HomeTasks.HomeTaskSixth.classes.PolygonWithCoordinates;
import HomeTasks.HomeTaskSixth.classes.TriangleWithCoordinates;
import HomeTasks.HomeTaskSixth.interfaces.PointMarker;
import HomeTasks.HomeTaskSixth.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Point> pointsTrg = Utils.generatorPoint(3);
        List<Point> pointsTrg1 =Utils.generatorPoint(3);
        List<Point> points1 = Utils.generatorPoint((int)(Math.random()*10));
        List<Point> points2 = Utils.generatorPoint((int)(Math.random()*10));
        List<Point> points3 = Utils.generatorPoint((int)(Math.random()*10));

        List<PointMarker> shapes1 = new ArrayList<>();

        shapes1.add(new CircleWithCoordinates());
        shapes1.add(new PolygonWithCoordinates(points2));
        shapes1.add(new TriangleWithCoordinates(pointsTrg1));

        List<PointMarker> shapes2 = new ArrayList<>();

        shapes2.add(new CircleWithCoordinates(new Point(1.0,2.0)));
        shapes2.add(new PolygonWithCoordinates(points1));
        shapes2.add(new TriangleWithCoordinates(pointsTrg));

        PolygonWithCoordinates polygon1 = new PolygonWithCoordinates(pointsTrg);
        PolygonWithCoordinates polygon2 = new PolygonWithCoordinates(points3);


        List<List<? super PointMarker>> lists1 = Utils.find(shapes1, 2);

        List<List<? super PointMarker>> lists2 = Utils.find(shapes1, shapes2, 2);

        List<? super PointMarker> withPredicate = Utils.findWithPredicate(shapes1, new Predicate<PointMarker>() {
            @Override
            public boolean test(PointMarker pointMarker) {
                if (pointMarker.countPoint()==3)
                    return true;
                return false;
            }
        });

        boolean cross = Utils.isCross(polygon1, polygon2);
        System.out.println("Test:");
        System.out.println(lists1);
        System.out.println(lists2);
        System.out.println(withPredicate);
        System.out.println(cross);


    }
}
