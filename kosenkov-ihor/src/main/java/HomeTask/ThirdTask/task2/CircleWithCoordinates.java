package HomeTask.ThirdTask.task2;

public class CircleWithCoordinates extends Circle {

    private double radius = 1.0;
    private Point center;
    private String color = "red";

    public CircleWithCoordinates(){

    }

    public CircleWithCoordinates(Point center){
        this.center = center;
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
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
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

    public double distance(Point otherPoint){
        return center.distanse(otherPoint);
    }
}
