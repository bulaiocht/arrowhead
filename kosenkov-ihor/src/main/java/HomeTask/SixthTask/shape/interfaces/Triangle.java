package HomeTask.SixthTask.shape.interfaces;

public abstract class Triangle implements Shape {

    public static final int NUMBER_OF_POINT = 3;
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    private double perimeter;
    private double area;

    public Triangle() {
        calculatePerimeter();
        calculateArea();
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        calculatePerimeter();
        calculateArea();
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
        perimeter = side1 + side2 + side3;
    }

    private void calculateArea() {
        double hP = perimeter / 2;     // Полупериметр
        area =  Math.sqrt(hP * (hP - side1) * (hP - side2) * (hP -side3));
    }
}
