package HomeTasks.HomeTask2e2;

public class Cylinder extends Circle {

    private double height;

    public Cylinder() {
        this.height = 1.0;
        super.getRadius();
        super.getColor();
    }

    public Cylinder(double radius) {
        super(radius);
        this.height = 1.0;
        super.setRadius(radius);
        super.getColor();
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
        super.setRadius(radius);
        super.setColor(color);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return height * super.getArea();
    }
}
