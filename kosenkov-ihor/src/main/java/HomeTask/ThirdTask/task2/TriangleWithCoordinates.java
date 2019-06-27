package HomeTask.ThirdTask.task2;

public class TriangleWithCoordinates extends Triangle{

    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;

    private Point[] points = new Point[3];

    public TriangleWithCoordinates(double x1, double y1, double x2, double y2, double x3, double y3){
        super(new Point(x1,y1).distanse(new Point(x2,y2)),new Point(x2,y2).distanse(new Point(x3,y3)),
                new Point(x3,y3).distanse(new Point(x1,y1)));
        pointOne = new Point(x1,y1);
        pointTwo = new Point(x2,y2);
        pointThree = new Point(x2,y3);

        points[0] = pointOne;
        points[1] = pointTwo;
        points[2] = pointThree;
    }

    public TriangleWithCoordinates(Point pointOne, Point pointTwo, Point pointThree) {
        super(pointOne.distanse(pointTwo),pointTwo.distanse(pointThree),pointThree.distanse(pointOne));
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;

        points[0] = pointOne;
        points[1] = pointTwo;
        points[2] = pointThree;
    }

    public Point getPoint(int numberOfPoint){
        return points[numberOfPoint];
    }

    public Point getPointOne() {
        return pointOne;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
    }

    public Point getPointThree() {
        return pointThree;
    }

    public void setPointThree(Point pointThree) {
        this.pointThree = pointThree;
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    public double distance(TriangleWithCoordinates otherTriangle){

        double[] distances = new double[3*3];

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                distances[k] = this.getPoint(i).distanse(otherTriangle.getPoint(j));
                k++;
            }
        }

        double distance = distances[0];
        for (int i = 1; i < distances.length; i++) {
            if(distances[i]<distance) distance = distances[i];
        }
        return distance;
    }
}
