package HomeTasks.HomeTaskThird.Task2;

public class Circle extends Shape {
    private double radius;
    private String color;

    public Circle (){
        this.radius = 1.0;
        this.color = super.getColor();

    }
    public Circle (double radius){
        this.radius = radius;
        this.color = super.getColor();

    }
    public Circle (double radius ,String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
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
