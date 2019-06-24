package home_work.lesson_2.shapes;

import static java.lang.Math.PI;

public class Circle extends Shape{
    private double radius = 10.0;
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
        return 2 * PI * radius;
    }

    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCircumference() {
        return 2 * PI * radius;
    }
}
