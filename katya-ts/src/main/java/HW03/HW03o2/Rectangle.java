package HW03.HW03o2;

public class Rectangle {
    private double length = 1.0;
    private double width = 1.0;
    private String color = "red";

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getPerimeter() {
        double perim = 2*length*width;
        return perim;
    }

    public double getArea() {
        double area = length*width;
        return area;
    }
}