package HomeTasks.HomeTaskThird.Task2;

public class TriangleWithCoordinates extends Triangle {
    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;

    public TriangleWithCoordinates(double x1,double y1,double x2,double y2,double x3,double y3){
        super(new Point(x1,y1).distance(new Point(x2,y2)),new Point(x2,y2).distance(new Point(x3,y3)),new Point(x3,y3).distance(new Point(x1,y1)));
        pointOne = new Point(x1,y1);
        pointTwo = new Point(x2,y2);
        pointThree = new Point(x3,y3);
    }

    public TriangleWithCoordinates(Point pointOne,Point pointTwo,Point pointThree){
        super(pointOne.distance(pointTwo),pointTwo.distance(pointThree),pointThree.distance(pointOne));
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
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

    public double distance (TriangleWithCoordinates otherTriangle){

        double[] distances = new double[9];

        distances[0] = this.pointOne.distance(otherTriangle.pointOne);
        distances[1] = this.pointOne.distance(otherTriangle.pointTwo);
        distances[2] = this.pointOne.distance(otherTriangle.pointThree);
        distances[3] = this.pointTwo.distance(otherTriangle.pointOne);
        distances[4] = this.pointTwo.distance(otherTriangle.pointTwo);
        distances[5] = this.pointTwo.distance(otherTriangle.pointThree);
        distances[6] = this.pointThree.distance(otherTriangle.pointOne);
        distances[7] = this.pointThree.distance(otherTriangle.pointTwo);
        distances[8] = this.pointThree.distance(otherTriangle.pointThree);
        double distance = distances[0];
        for (int i = 1; i < distances.length; i++) {
            if(distances[i]<distance) distance = distances[i];
        }
        return distance;
    }


}
