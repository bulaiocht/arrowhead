package HomeTasks.HomeTaskSixth.main;


import HomeTasks.HomeTaskSixth.classes.CircleWithCoordinates;
import HomeTasks.HomeTaskSixth.classes.Point;
import HomeTasks.HomeTaskSixth.classes.PolygonWithCoordinates;
import HomeTasks.HomeTaskSixth.classes.TriangleWithCoordinates;
import HomeTasks.HomeTaskSixth.interfaces.PointMarker;
import HomeTasks.HomeTaskSixth.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();

        List<PointMarker> shapes1 = new ArrayList<>();

        shapes1.add(new CircleWithCoordinates());
        shapes1.add(new PolygonWithCoordinates(points));
        shapes1.add(new TriangleWithCoordinates(points));

        List<PointMarker> shapes2 = new ArrayList<>();

        shapes2.add(new CircleWithCoordinates());
        shapes2.add(new PolygonWithCoordinates(points));
        shapes2.add(new TriangleWithCoordinates(points));

        PolygonWithCoordinates polygon1 = new PolygonWithCoordinates(points);
        PolygonWithCoordinates polygon2 = new PolygonWithCoordinates(points);


        List<List<? extends PointMarker>> lists1 = Utils.find(shapes1, 3);

        List<List<? extends PointMarker>> lists2 = Utils.find(shapes1, shapes2, 3);

        List<? extends PointMarker> withPredicate = Utils.findWithPredicate(shapes1, 3);

        boolean cross = Utils.isCross(polygon1, polygon2);


    }
}
