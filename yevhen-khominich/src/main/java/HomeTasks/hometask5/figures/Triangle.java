package HomeTasks.hometask5.figures;

import HomeTasks.hometask5.enums.EType;
import HomeTasks.hometask5.abstracts.Shape;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape {

    private List<Number> sides = new ArrayList<>();

    public Triangle(){

    }

    public Triangle(List<Number> sides) {
        this.sides.addAll(sides);
    }

    public Triangle(double side1, double side2, double side3) {
        this.sides.add(side1);
        this.sides.add(side2);
        this.sides.add(side3);
    }

    public EType getType() {
        double a = (Double) sides.get(0);
        double b = (Double) sides.get(1);
        double c = (Double) sides.get(2);
        return (a == b && a == c && b == c) ? EType.EQUILATETAL : (a == b || a == c || b == c) ? EType.ISOSCELES : EType.SCALENE;
    }

    @Override
    public double getPerimetr() {
        double perimetr = 0;
        for (Number side : this.sides) {
            perimetr += (Double) side;
        }
        return perimetr;
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimetr();
        return Math.sqrt(halfPerimeter * (halfPerimeter - (Double) sides.get(0)) * (halfPerimeter - (Double) sides.get(1)) * (halfPerimeter - (Double) sides.get(2)));
    }

    @Override
    public String toString() {
        return "I'm triangle";
    }

}

