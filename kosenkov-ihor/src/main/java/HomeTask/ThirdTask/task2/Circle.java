package HomeTask.ThirdTask.task2;

public class Circle extends Shape{

    private double radius = 1.0;
    private String color = "red";

    public Circle(){

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCircumference(){
        return 2*Math.PI*radius;
    }
}
