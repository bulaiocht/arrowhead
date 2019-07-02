package HomeTasks.HomeTask2e2;

public class CircleWithCoordinates extends Circle {

    private Point center;

    public CircleWithCoordinates(Point center) {
        super.getRadius();
        this.center = center;
        super.getColor();
    }

    public CircleWithCoordinates(double radius, Point center) {
        super(radius);
        super.setRadius(radius);
        this.center = center;
        super.getColor();
    }

    public CircleWithCoordinates(double radius, Point center, String color) {
        super(radius, color);
        super.setRadius(radius);
        this.center = center;
        super.setColor(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

}
