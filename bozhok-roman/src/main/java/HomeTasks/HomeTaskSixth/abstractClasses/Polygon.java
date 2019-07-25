package HomeTasks.HomeTaskSixth.abstractClasses;

import HomeTasks.HomeTaskSixth.interfaces.Shape;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Polygon implements Shape {
    protected List<Double> sideLengths;
    protected String color;
    protected Polygon(int n){
        this.sideLengths = Stream.generate(new Random()::nextDouble)
                .map(s -> s * Math.random() * 50)
                .limit(n)
                .collect(Collectors.toList());
    }
    protected Polygon (List<Double> sideLengths){
        this.sideLengths = sideLengths;
    }
    @Override
    public double getPerimeter() {
        return sideLengths.stream().reduce(Double::sum).orElse(0.0);
    }

    @Override
    public double getArea() {
        return sideLengths.stream().reduce((s1,s2)-> s1*s2).orElse(0.0);
    }

    @Override
    public String getColor() {
        return null;
    }
}
