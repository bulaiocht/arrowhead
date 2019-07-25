package HomeTasks.HomeTaskSixth.abstractClasses;

import HomeTasks.HomeTaskSixth.interfaces.Shape;

public abstract class Cylinder extends Circle  implements Shape {
    protected double height ;

    protected Cylinder(){
        super();
        this.height = 1.0;

    }
    protected Cylinder(double radius){
        super(radius);
        this.height = 1.0;

    }
    protected Cylinder(double radius,String color, double height){
        super(radius,color);
        this.height = height;

    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    public double getVolume (){
        return super.getArea()*this.height;
    }


}
