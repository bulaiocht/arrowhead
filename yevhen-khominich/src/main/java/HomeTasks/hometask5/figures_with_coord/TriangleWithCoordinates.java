package HomeTasks.hometask5.figures_with_coord;

import HomeTasks.hometask5.enums.EType;
import HomeTasks.hometask5.figures.Point;
import HomeTasks.hometask5.figures.Triangle;
import HomeTasks.hometask5.interfaces.FigureWithCoord;
import HomeTasks.hometask5.utils.CalcDist;

import java.util.*;


public class TriangleWithCoordinates extends Triangle implements FigureWithCoord {

    final private int NUMBER_OF_ANGELS = 3;
    private List<Point> points = new ArrayList<>(NUMBER_OF_ANGELS);


    //Можно добавить исключение !
    TriangleWithCoordinates(double[] x, double[] y) {

        Point[] pointArray = {new Point(), new Point(), new Point()};
        this.points.addAll(Arrays.asList(pointArray));

        for (int i = 0; i < NUMBER_OF_ANGELS; i++) {
            this.points.get(i).setX(x[i]);
            this.points.get(i).setY(y[i]);
        }

    }

    public TriangleWithCoordinates(Point[] points) {
        this.points.addAll(Arrays.asList(points));
    }

    //Улучшить
    public EType getType() {

        List<Double> distances = CalcDist.calcTrianglesSides(this.points, NUMBER_OF_ANGELS);
        double a = distances.get(0);
        double b = distances.get(1);
        double c = distances.get(2);

        return (a == b && a == c && b == c) ? EType.EQUILATETAL : (a == b || a == c || b == c) ? EType.ISOSCELES : EType.SCALENE;
    }

    @Override
    public Double distanceTo(FigureWithCoord figure) {
        return CalcDist.distanceTo(figure, this.getPoints());
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public double getArea() {

        List<Double> distances = CalcDist.calcTrianglesSides(this.points, NUMBER_OF_ANGELS);

        double p = getPerimetr() / 2;

        return Math.abs(Math.sqrt(p * (p - distances.get(0)) * (p - distances.get(1)) * (p - distances.get(2))));
    }

    @Override
    public double getPerimetr() {
        double perimetr = 0;
        for (Double dis : CalcDist.calcTrianglesSides(this.points, NUMBER_OF_ANGELS)) {
            perimetr += dis;
        }
        return perimetr;
    }


    //     Search the nearest way to points between Thriangles переделать в distanceTo
//    @Override
//    public double distanceTo(FigureWithCoord other) {
//        List<Point> pointersFirstTriangle = this.getPoints();
//        List<Point> pointersOtherTriangle = other.getPoints();
//
//        List<Double> distancesBetweenTriangles = CalcDist.calculateDistanceBetweenDifferentPoints(pointersFirstTriangle, pointersOtherTriangle);
//        Collections.sort(distancesBetweenTriangles);
//        return distancesBetweenTriangles.get(0);
//
//    }

    public Point getPoint(int index) {
        return this.points.get(index);
    }

    public void setPoint(Point point, int index) {
        this.points.add(index, point);
    }



}

