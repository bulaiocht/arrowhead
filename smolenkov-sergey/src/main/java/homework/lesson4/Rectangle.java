package homework.lesson4;

public class Rectangle extends Shape {

    private double length = 1.0;
    private double width = 1.0;


    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        super.setColor(color);
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

    public String getColor() {
        return super.getColor();
    }

    public void setColor(String color) {
        super.setColor(color);
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

}
