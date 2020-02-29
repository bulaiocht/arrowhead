package HomeTasks.hometask5.figures;

import HomeTasks.hometask5.abstracts.Shape;

import java.util.List;

public class Polygon extends Shape {

    private List<Double> sidesLengths;
    private int numberOfAngels;

    public Polygon(){

    }

    public Polygon(List<Double> sidesLengths, int numberOfAngels) {
        this.sidesLengths = sidesLengths;
        this.numberOfAngels = numberOfAngels;
    }

    public int getNumberOfAngels() {
        return numberOfAngels;
    }

    @Override
    public double getPerimetr() {
        return sidesLengths.stream().reduce(Double::sum).orElse(0.0);
    }

    //Рандомно
    @Override
    public double getArea() {
        List<Double> distances = this.sidesLengths;

        double p = getPerimetr() / 2;

        return Math.abs(Math.sqrt(p * (p - distances.get(0)) * (p - distances.get(1))));
    }
    @Override
    public String toString() {
        return "I'm polygon";
    }

}
