package homework.lesson4;

public class CircleWithCoordinates extends Circle {
    private double radius = 1.0;
    private String color = "red";
    private Point center = new Point();

    public CircleWithCoordinates (Point center){
    }
    public CircleWithCoordinates(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }
    public CircleWithCoordinates(Point center, double radius, String color){
        this.center = center;
        this.radius = radius;
        this.color = color;
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
    public void setRadius(double radius) {
        super.setRadius(radius);
    }
    @Override
    public double getRadius() {
        return super.getRadius();
    }
    @Override
    public double getCircumference() {
        return super.getCircumference();
    }
    public void setCenter(Point center) {
        this.center = center;
    }
    public Point getCenter() {
        return center;
    }
    public double distance(Point other){
        return distance(other);
    }
}
