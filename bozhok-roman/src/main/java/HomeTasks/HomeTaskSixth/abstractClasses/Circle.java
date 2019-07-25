package HomeTasks.HomeTaskSixth.abstractClasses;

import HomeTasks.HomeTaskSixth.interfaces.Shape;


public abstract class Circle implements Shape {
    protected String color ;
    protected double radius;
    protected Circle (){
        this.radius = Shape.DEFAULT_NUMBER;
        this.color = Shape.COLOR;

    }
    protected Circle (double radius){
        this.radius = radius;
        this.color = Shape.COLOR;

    }
    protected Circle (double radius ,String color){
        this.radius = radius;
        this.color = color;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius,2);
    }


    public String getColor() {
        return color;
    }
}
