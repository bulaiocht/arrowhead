package HomeTasks.HomeTaskSixth.classes;

public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 1.0;
        this.y = 1.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double distance (double x, double y){
        return Math.sqrt(Math.pow(y-this.y,2)+Math.pow(x-this.x,2));
    }
    public double distance (Point point){
        return Math.sqrt(Math.pow(point.getY()-this.y,2)+Math.pow(point.getY()-this.x,2));
    }
}
