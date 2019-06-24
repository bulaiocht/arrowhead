package home_work.lesson_2.shapes;

public class CircleWithCoordinates extends Circle {
    private double radius = 1.0;
    private Point center;
    private String color = "red";

    public CircleWithCoordinates(Point center) {
        this.center = center;
    }

    public CircleWithCoordinates(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public CircleWithCoordinates(double radius, String color, Point center) {
        this.radius = radius;
        this.center = center;
        this.color = color;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public double distance(Point other) {
        return this.center.distance(other);
    }
}
