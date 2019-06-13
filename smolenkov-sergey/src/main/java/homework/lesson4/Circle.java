package homework.lesson4;

public class Circle {

    private double radius = 1.0;
    private String color = "red";
    private double perimeter = 2 * Math.PI * radius;
    private double area = Math.PI * Math.pow(radius, 2);

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
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getCircumference() {
        return perimeter;
    }

}
