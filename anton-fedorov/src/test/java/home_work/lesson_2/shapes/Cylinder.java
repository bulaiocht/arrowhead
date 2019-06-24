package home_work.lesson_2.shapes;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Cylinder extends Circle {
    private double height = 1.0;

    private double sSide = 2 * PI * super.getRadius() * height;
    private double sBase = PI * pow(super.getRadius(), 2);

    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, String color) {
        super(radius, color);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return sSide + 2 * sBase;
    }
}
