package HomeTasks.HomeTaskSixth.classes;

import HomeTasks.HomeTaskSixth.abstractClasses.Triangle;
import HomeTasks.HomeTaskSixth.interfaces.PointMarker;
import HomeTasks.HomeTaskSixth.interfaces.Shape;


import java.util.ArrayList;

import java.util.List;
import java.util.Set;

public class TriangleWithCoordinates extends Triangle implements Shape , PointMarker {
    private List<Point> points;


    public TriangleWithCoordinates(double x1,double y1,double x2,double y2,double x3,double y3){
        super(new Point(x1,y1).distance(new Point(x2,y2)),
                new Point(x2,y2).distance(new Point(x3,y3))
                ,new Point(x3,y3).distance(new Point(x1,y1)));
        List<Point> points = new ArrayList<>();
        points.add( new Point(x1,y1));
        points.add( new Point(x2,y2));
        points.add( new Point(x3,y3));
        test(points);
        this.points = points;
    }

    public TriangleWithCoordinates(List<Point> points){
        super(points.get(0).distance(points.get(1)),points.get(1).distance(points.get(2)),points.get(2).distance(points.get(0)));
        test(points);
        this.points = points;

    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public int countPoint() {
        return 3;
    }
    @Override
    public List<Point> getListPoint() {
        return points;
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    private static void test (List<Point> pointList){
        Set<Point> pointList1 = (Set<Point>) pointList;
        if (pointList1.size()!=3)
            throw new IllegalArgumentException("bad point");
    }

    public double distance (TriangleWithCoordinates otherTriangle){

        List<Double> distances = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                distances.add(this.points.get(i).distance(otherTriangle.points.get(j)));

            }
        }


        return distances.stream().min(Double::compareTo).orElse(0.0);
    }

    @Override
    public String toString() {
        return "TriangleWithCoordinates{" +
                "points=" + points +
                '}';
    }
}
