package HW2.Shapes;

public class Point {
    private double x = 1.0;
    private double y = 1.0;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(double x, double y) {
        return Math.pow((Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)), 0.5);
    }

    public double distance(Point other) {
        return distance(other.getX(), other.getY());
    }


}
