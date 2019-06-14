package HomeTask.ThirdTask.task2;

public class TriangleWithCoordinates extends Triangle{

    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;

    public TriangleWithCoordinates(double x1, double y1, double x2, double y2, double x3, double y3){
        super(new Point(x1,y1).distanse(new Point(x2,y2)),new Point(x2,y2).distanse(new Point(x3,y3)),
                new Point(x3,y3).distanse(new Point(x1,y1)));
        pointOne = new Point(x1,y1);
        pointTwo = new Point(x2,y2);
        pointThree = new Point(x2,y3);
    }

    public TriangleWithCoordinates(Point pointOne, Point pointTwo, Point pointThree) {
        super(pointOne.distanse(pointTwo),pointTwo.distanse(pointThree),pointThree.distanse(pointOne));
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
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

        double[] distances = new double[9];

        distances[0] = this.pointOne.distanse(otherTriangle.pointOne);
        distances[1] = this.pointOne.distanse(otherTriangle.pointTwo);
        distances[2] = this.pointOne.distanse(otherTriangle.pointThree);
        distances[3] = this.pointTwo.distanse(otherTriangle.pointOne);
        distances[4] = this.pointTwo.distanse(otherTriangle.pointTwo);
        distances[5] = this.pointTwo.distanse(otherTriangle.pointThree);
        distances[6] = this.pointThree.distanse(otherTriangle.pointOne);
        distances[7] = this.pointThree.distanse(otherTriangle.pointTwo);
        distances[8] = this.pointThree.distanse(otherTriangle.pointThree);
        double distance = distances[0];
        for (int i = 1; i < distances.length; i++) {
            if(distances[i]<distance) distance = distances[i];
        }
        return distance;
    }
}
