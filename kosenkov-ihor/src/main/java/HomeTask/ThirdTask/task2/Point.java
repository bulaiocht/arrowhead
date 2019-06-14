package HomeTask.ThirdTask.task2;

public class Point {

    private double x = 1.0;
    private double y = 1.0;

    public  Point(){

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

    public double distance(double x, double y){
        return Math.sqrt(Math.pow(x-this.x,2)+Math.pow(y-this.y,2));
    }

    public double distanse(Point otherPoint){
        return Math.sqrt(Math.pow(otherPoint.getX()-this.x,2)+Math.pow(otherPoint.getY()-this.y,2));
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
