package shapes;

public class Cylinder extends Circle {

    private double height = 1.0;


    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, String color) {
        super(radius, color);
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getRadius() * getRadius() * Math.PI * height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * (height + getRadius());
    }


}
