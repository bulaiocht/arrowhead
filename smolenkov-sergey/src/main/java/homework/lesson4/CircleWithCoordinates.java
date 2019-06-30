package homework.lesson4;

public class CircleWithCoordinates extends Circle {
    private double radius;
    private Point center;

    public CircleWithCoordinates() {
        this.radius = 1.0;
        this.center = new Point();
    }

    public CircleWithCoordinates(Point center) {
        this.radius = 1.0;
        this.center = center;
    }

    public CircleWithCoordinates(Point center, double radius) {
        this.radius = 1.0;
        this.center = center;
        this.radius = radius;
    }

    public CircleWithCoordinates(Point center, double radius, String color) {
        this.center = center;
        this.radius = radius;
        super.setColor(color);
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

    @Override
    public double getCircumference() {
        return super.getCircumference();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double distance(Point center) {
        return this.center.distance(center);
    }
}
