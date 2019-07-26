package HomeTask.SixthTask.shape.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Polygon implements Shape {

    private static int NUMBER_OF_POINT;
    private List<Double> sides = new ArrayList<>();
    private double perimeter = 0;
    private double area;

    public Polygon() {
        calculatePerimeter();
        calculateArea();
    }

    public Polygon(Double... sides) {
        this.sides.addAll(Arrays.asList(sides));
        NUMBER_OF_POINT = sides.length;
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
        for (double side :
                sides) {
            perimeter += side;
        }
    }

    private void calculateArea() {
        area =  0.0;
    }

}
