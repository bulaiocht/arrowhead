package HomeTask.SixthTask.shape.interfaces;

public abstract class Rectangle implements Shape {

    public static final int NUMBER_OF_POINT = 4;
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double perimeter;
    private double area;

    public Rectangle() {
        calculatePerimeter();
        calculateArea();
    }

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
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
        perimeter = (side1 + side2) * 2;
    }

    private void calculateArea() {
        area =  side1 * side2;
    }

}
