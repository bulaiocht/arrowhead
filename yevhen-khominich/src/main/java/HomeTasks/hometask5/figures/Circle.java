package HomeTasks.hometask5.figures;

import HomeTasks.hometask5.abstracts.Shape;

public class Circle extends Shape {

    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getCircumference() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimetr() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "I'm circle";
    }
}
