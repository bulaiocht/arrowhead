package HW03.HW03o2;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getPerimeter() {
        double perim = 2*Math.PI*radius;
        return perim;
    }

    public double getArea() {
        double area = Math.PI*Math.pow(radius, 2);
        return area;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getCircumference(){
        double circ = 2*Math.PI*radius;
        return circ;
    }
}