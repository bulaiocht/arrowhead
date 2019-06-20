package HomeTasks.HomeTaskThird.Task2;

public class CircleWithCoordinates extends Circle {
    private double radius;
    private Point center;
    private String color;

    public CircleWithCoordinates(){
        this.radius = 1.0;
        this.center = new Point();
        this.color = "red";
    }
    public CircleWithCoordinates(Point center,double radius){
        this.radius = radius;
        this.center = center;
        this.color = "red";
    }
    public CircleWithCoordinates(Point center, double radius, String color){
        this.center = center;
        this.radius = radius;
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

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
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
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    public double distance(Point center){
        return this.center.distance(center);
    }




}
