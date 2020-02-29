package shapes;

public class CircleWithCoordinates extends Circle {
    private double radius = 1.0;
    private Point center;
    private String colore = "red";

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public CircleWithCoordinates() {

    }

    public CircleWithCoordinates(Point center) {
        this.center = center;
    }

    public CircleWithCoordinates(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public CircleWithCoordinates(Point center, double radius, String color) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(center.getX() - other.getX(), 2) + Math.pow(center.getY() - other.getY(), 2));
    }
    public double distanceBetweenCenters(CircleWithCoordinates other) {
        return distance(other.getCenter());
    }
}
