package HomeTasks.HomeTask2e2;

public class TriangleWithCoordinates extends Shape  {

    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;
    private String typeTriangle;


    public TriangleWithCoordinates(double x1, double y1, double x2, double y2, double x3, double y3) {
        pointOne.setX(x1);
        pointOne.setY(y1);
        pointTwo.setX(x2);
        pointTwo.setY(y2);
        pointThree.setX(x3);
        pointThree.setY(y3);
        getType();
        getColor();
    }

    public TriangleWithCoordinates(Point pointOne, Point pointTwo, Point pointThree) {
        this.pointOne = new Point();
        this.pointTwo = new Point();
        this.pointThree = new Point();
        getType();
        getColor();
    }

    public TriangleWithCoordinates() {
        this.pointOne = new Point();
        this.pointTwo = new Point();
        this.pointThree = new Point();
        getType();
        getColor();
    }

    public Point getPointOne() {
        return pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public Point getPointThree() {
        return pointThree;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
    }

    public void setPointThree(Point pointThree) {
        this.pointThree = pointThree;
    }

    public double sideTriangle (Point point1, Point point2) {
        return Math.sqrt (Math.pow(point1.getX() - point2.getX(),2.0)
                + Math.pow(point1.getY() - point2.getY(),2.0));
    }

    public double getPerimeter(){
        return sideTriangle(pointOne, pointTwo) +
                sideTriangle(pointTwo, pointThree) +
                sideTriangle(pointThree, pointOne);
    }

    public double getArea(){
        double p = getPerimeter() * 0.5;
        return Math.sqrt(p * (p - sideTriangle(pointOne, pointTwo)) *
                (p - sideTriangle(pointTwo, pointThree)) *
                (p - sideTriangle(pointThree, pointOne)));
    }

    public String getType(){
        if (sideTriangle(pointOne, pointTwo) == sideTriangle(pointTwo, pointThree) &&
                sideTriangle(pointOne, pointTwo) == sideTriangle(pointThree, pointOne)){
            typeTriangle = "Type is Equilateral";
        }else if (sideTriangle(pointOne, pointTwo) == sideTriangle(pointTwo, pointThree) ||
                sideTriangle(pointOne, pointTwo) == sideTriangle(pointThree, pointOne)){
            typeTriangle = "Type is Isosceles";
        }else {
            typeTriangle = "Type is Scalene";
        }
        return typeTriangle;
    }
}
