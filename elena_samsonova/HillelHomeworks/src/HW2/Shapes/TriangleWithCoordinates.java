package HW2.Shapes;

public class TriangleWithCoordinates {
    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;

    private double sideA;
    private double sideB;
    private double sideC;

    public TriangleWithCoordinates(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.pointOne.setX(x1);
        this.pointOne.setY(y1);
        this.pointTwo.setX(x2);
        this.pointTwo.setY(y2);
        this.pointThree.setX(x3);
        this.pointThree.setY(y3);
        sideA = pointOne.distance(pointTwo);
        sideB = pointTwo.distance(pointThree);
        sideC = pointThree.distance(pointOne);

    }

    public TriangleWithCoordinates(Point pointOne, Point pointTwo, Point pointThree) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
        sideA = pointOne.distance(pointTwo);
        sideB = pointTwo.distance(pointThree);
        sideC = pointThree.distance(pointOne);

    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double getArea() {
        double p = getPerimeter() / 2.0; //полупериметр
        return Math.pow(p * (p - sideA) * (p - sideB) * (p - sideC), 0.5); //Формула Герона
    }

    public String getType() {

        if (sideA == sideB && sideB == sideC) {
            return "equilateral";
        } else if (sideA == sideB || sideB == sideC || sideC == sideA) {
            return "isosceles";
        } else return "scalene";
    }

    public double distance(TriangleWithCoordinates other) {

        double dist[] = new double[9];
        double minDistance = this.pointOne.distance(other.pointOne)+1; //почему +1 не работает, а +10 работает?

        dist[0] = this.pointOne.distance(other.pointOne);
        dist[1] = this.pointOne.distance(other.pointTwo);
        dist[2] = this.pointOne.distance(other.pointThree);
        dist[3] = this.pointTwo.distance(other.pointOne);
        dist[4] = this.pointTwo.distance(other.pointTwo);
        dist[5] = this.pointTwo.distance(other.pointThree);
        dist[6] = this.pointThree.distance(other.pointOne);
        dist[7] = this.pointThree.distance(other.pointTwo);
        dist[8] = this.pointThree.distance(other.pointThree);

        for (int i = 0; i < 9; i++) {
            if (dist[i] <= minDistance){
                minDistance = dist[i];}
        }
        return minDistance;
    }


}
