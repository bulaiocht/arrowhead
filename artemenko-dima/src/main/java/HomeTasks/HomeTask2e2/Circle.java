package HomeTasks.HomeTask2e2;

public class Circle extends Shape {

    private double radius;


    public Circle() {
        this.radius = 1.0;
        super.getColor();
    }

    public Circle(double radius) {
        this.radius = radius;
        super.getColor();
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        super.setColor(color);
    }


    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2.0);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
