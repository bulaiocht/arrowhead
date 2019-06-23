package homework.lesson4;

public class TriangleWithCoordinates {

    private Point pointOne = new Point();
    private Point pointTwo = new Point();
    private Point pointThree = new Point();
    public TriangleWithCoordinates (double x1, double y1, double x2, double y2, double x3, double y3){
    }
    public TriangleWithCoordinates (Point pointOne, Point pointTwo, Point pointThree) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
    }
}
