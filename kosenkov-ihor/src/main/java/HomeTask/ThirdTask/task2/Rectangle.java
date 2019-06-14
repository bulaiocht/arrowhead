package HomeTask.ThirdTask.task2;

public class Rectangle extends Shape{

    private double length = 1.0;
    private double width = 1.0;
    private String color = "red";

    public Rectangle(){

    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return length * width;
    }

    public double getPerimeter(){
        return (length + width) * 2;
    }
}
