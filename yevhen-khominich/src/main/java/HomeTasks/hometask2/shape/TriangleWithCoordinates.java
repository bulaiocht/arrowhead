package shapes;

import java.util.Arrays;

public class TriangleWithCoordinates extends Shape {
    private Point pointOne = new Point();
    private Point pointTwo = new Point();
    private Point pointThree = new Point();


    public TriangleWithCoordinates(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.pointOne.setX(x1);
        this.pointOne.setY(y1);
        this.pointTwo.setX(x2);
        this.pointTwo.setY(y2);
        this.pointThree.setX(x3);
        this.pointThree.setY(y3);
    }

    public TriangleWithCoordinates(Point pointOne, Point pointTwo, Point pointThree) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;

    }

    public String getType() {
        double a = pointOne.distance(pointTwo);
        double b = pointOne.distance(pointThree);
        double c = pointTwo.distance(pointThree);
        return (a == b && a == c && b == c) ? "Equilatetal" : (a == b || a == c || b == c) ? "Isosceles" : "Scalene";
    }

    @Override
    public double getArea() {
        double p = getPerimetr() / 2;
        double a = pointOne.distance(pointTwo);
        double b = pointOne.distance(pointThree);
        double c = pointTwo.distance(pointThree);

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimetr() {
        double a = pointOne.distance(pointTwo);
        double b = pointOne.distance(pointThree);
        double c = pointTwo.distance(pointThree);

        return a + b + c;
    }

    @Override
    public String getColor() {
        return "red";
    }

    //Search the nearest way to points between Thriangles
    public double distance(TriangleWithCoordinates other) {
        double[] pointers = new double[9];

        pointers[0] = this.pointOne.distance(other.pointOne);
        pointers[1] = this.pointOne.distance(other.pointTwo);
        pointers[2] = this.pointOne.distance(other.pointThree);

        pointers[3] = this.pointTwo.distance(other.pointOne);
        pointers[4] = this.pointTwo.distance(other.pointTwo);
        pointers[5] = this.pointThree.distance(other.pointThree);

        pointers[6] = this.pointThree.distance(other.pointOne);
        pointers[7] = this.pointThree.distance(other.pointTwo);
        pointers[8] = this.pointThree.distance(other.pointThree);

        Arrays.sort(pointers);

        return pointers[0];

    }

    public Point getPointOne() {
        return pointOne;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
    }

    public Point getPointThree() {
        return pointThree;
    }

    public void setPointThree(Point pointThree) {
        this.pointThree = pointThree;
    }
}
