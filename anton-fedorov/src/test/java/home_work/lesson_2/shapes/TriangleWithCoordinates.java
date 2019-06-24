package home_work.lesson_2.shapes;

import static java.lang.Math.pow;

public class TriangleWithCoordinates extends Circle {
    private Point center;
    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;

    double d1 = Math.sqrt((pow(pointTwo.getX() - pointOne.getX(), 2)) + pow(pointTwo.getY() - pointOne.getY(), 2));
    double d2 = Math.sqrt((pow(pointThree.getX() - pointTwo.getX(), 2)) + pow(pointThree.getY() - pointTwo.getY(), 2));
    double d3 = Math.sqrt((pow(pointOne.getX() - pointThree.getX(), 2)) + pow(pointThree.getY() - pointThree.getY(), 2));
    double perimeter = d1 + d2 + d3;
    double p = perimeter / 2;

    public TriangleWithCoordinates(Point pointOne, Point pointTwo, Point pointThree) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
    }

    public TriangleWithCoordinates(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.pointOne.setX(x1);
        this.pointOne.setY(y1);
        this.pointTwo.setX(x2);
        this.pointTwo.setY(y2);
        this.pointThree.setX(x3);
        this.pointThree.setY(y3);
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return Math.sqrt(p * (p - d1) * (p - d2) * (p - d3));
    }

    public double distance(TriangleWithCoordinates other) {
        return Math.sqrt(pow(center.getX() - other.center.getX(), 2) + pow(center.getY() + other.center.getY(), 2));
    }

    public String getType() {
        return TriangleWithCoordinates.class.getName();
    }
}
