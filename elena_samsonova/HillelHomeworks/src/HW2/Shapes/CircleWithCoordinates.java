package HW2.Shapes;

public class CircleWithCoordinates extends Circle {
    private double radius = 1.0;
    private Point center;
    private String color = "red";

    public CircleWithCoordinates (Point center){
        this.center=center;
    }
    public CircleWithCoordinates (Point center, double radius){
        this.center=center;
        this.radius=radius;
    }
    public CircleWithCoordinates (Point center, double radius, String color){
        this.center=center;
        this.radius=radius;
        this.color=color;
    }

    public double getPerimeter (){return 2 * Math.PI * radius;}
    public Point getCenter (){return this.center;}
    public void setCenter (Point center){
        this.center=center;
    }
    public double distance (Point other){
        return center.distance(other);
    }

    public double distance (CircleWithCoordinates other) {

        return  this.center.distance(other.center);
    }
}
