package HW2.Shapes;

public class Cylinder extends Circle {
    private double height = 1.0;
    private double radius = 1.0;
    private String color = "red";
    Cylinder() {
    }

    public Cylinder(double radius) {
        this.radius = radius;
    }

    public Cylinder(double radius, String color) {
        this.radius = radius;
        this.color=color;
    }

    public double getHeight (){
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume (){
        return getArea()*height;}
}
