package HW2.Shapes;

public class Rectangle extends Shape {
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

    void setLength(double length) {
        this.length = length;
    }

    double getLength() {
        return this.length;
    }

    void setWidth(double width) {
        this.width = width;
    }

    double getWidth(double width) {
        return this.width;
    }

    void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }


}
