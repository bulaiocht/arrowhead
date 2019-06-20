package HomeTasks.HomeTaskThird.Task2;

public class Rectangle extends Shape {

    private double length;
    private double width;
    private String color;

    public Rectangle(){
        this.length = 1.0;
        this.width = 1.0;
        this.color = super.getColor();
    }
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
        this.color = super.getColor();
    }
    public Rectangle(double length, double width, String color){
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

    public void setColor(String color) {
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
