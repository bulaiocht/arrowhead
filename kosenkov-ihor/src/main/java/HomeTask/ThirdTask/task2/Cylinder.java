package HomeTask.ThirdTask.task2;

public class Cylinder extends Circle{

    private double height = 1.0;

    public Cylinder(){

    }

    public Cylinder(double radius){
        super(radius);
    }

    public Cylinder(double radius, String color){
        super(radius, color);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return Math.PI*super.getRadius()*super.getRadius()*height;
    }
}
