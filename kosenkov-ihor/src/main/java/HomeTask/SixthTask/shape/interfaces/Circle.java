package HomeTask.SixthTask.shape.interfaces;

public abstract class Circle implements Shape {

    public static final int NUMBER_OF_POINT = 1;
    private double radius = 1.0;
    private double perimeter;
    private double area;

    public Circle() {
        calculatePerimeter();
        calculateArea();
    }

    public Circle(double radius) {
        this.radius = radius;
        calculatePerimeter();
        calculateArea();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int getNumberOfPoint() {
        return NUMBER_OF_POINT;
    }

    private void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    private void calculateArea() {
        area = Math.PI * Math.pow(radius, 2);
    }
}
