package HomeTasks.hometask5.figures;

import HomeTasks.hometask5.abstracts.Shape;

public class Rectangle extends Shape {

    private double length = 1.0;
    private double width = 1.0;
    private double NUMBER_OF_ANGELS = 4;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimetr() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "I'm rectangle";
    }

}
