package homework.lesson4;

public class Circle extends Shape {

    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        super.setColor(color);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public String getColor() {
        return super.getColor();
    }

    public void setColor(String color) {
        super.setColor(color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

}
