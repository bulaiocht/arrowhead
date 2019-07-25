package HomeTasks.HomeTaskSixth.abstractClasses;

import HomeTasks.HomeTaskSixth.interfaces.Shape;

public abstract class Rectangle implements Shape {
    protected double length;
    protected double width;
    protected String color;

    protected Rectangle(){
        this.length = Shape.DEFAULT_NUMBER;
        this.width = Shape.DEFAULT_NUMBER;
        this.color = Shape.COLOR;
    }
    protected Rectangle(double length, double width){
        this.length = length;
        this.width = width;
        this.color = Shape.COLOR;
    }
    protected Rectangle(double length, double width, String color){
        this.length = length;
        this.width = width;
        this.color = color;
    }

    @Override
    public double getPerimeter() {
        return (length+width)*2;
    }

    @Override
    public double getArea() {
        return length*width;
    }

    @Override
    public String getColor() {
        return color;
    }
}
