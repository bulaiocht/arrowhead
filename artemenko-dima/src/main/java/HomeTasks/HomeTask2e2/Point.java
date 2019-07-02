package HomeTasks.HomeTask2e2;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 1.0;
        this.y = 1.0;
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

    public double distance (double x, double y){
        return Math.sqrt (Math.pow(x - this.x,2.0) + Math.pow(y - this.y,2.0));
    }

    public double distance (Point point){
        return Math.sqrt (Math.pow(point.getX() - this.x,2.0)
                + Math.pow(point.getY() - this.y,2.0));
    }
}
