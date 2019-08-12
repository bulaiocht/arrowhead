package HomeTasks.HomeTask5.Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class Distance <T extends Point> implements Comparable<Distance> {

    private double dis;
    private String str;

    public Distance(T t1, T t2, String str) {

        this.str = str;

        if (t1 instanceof Circle && t2 instanceof Circle )
            this.dis = bigDecimal( distance((Circle) t1, (Circle) t2));
        else if (t1 instanceof Triangle && t2 instanceof Triangle)
            this.dis = bigDecimal( distance((Triangle) t1, (Triangle) t2));
        else if (t1 instanceof Triangle && t2 instanceof Circle)
            this.dis = bigDecimal( distance( (Triangle) t1, (Circle) t2 ) );
        else
            this.dis = bigDecimal( distance( (Triangle) t2, (Circle) t1 ) );

    }

    private double distancePoint(Point point1, Point point2) {
        return Math.sqrt (Math.pow(point1.getX() - point2.getX(),2.0)
                + Math.pow(point1.getY() - point2.getY(),2.0));
    }

    public  double distance(Circle circle1 , Circle circle2) {
        return distancePoint( circle1.getCentre(), circle2.getCentre() )- circle1.radius - circle2.radius;
    }

    public double distance(Triangle triangle1, Triangle triangle2) {

        ArrayList<Point> trianglesAL1 = new ArrayList<>();
        trianglesAL1.add( triangle1.getPointA() );
        trianglesAL1.add( triangle1.getPointB() );
        trianglesAL1.add( triangle1.getPointC() );

        ArrayList<Point> trianglesAL2 = new ArrayList<>(  );
        trianglesAL2.add( triangle2.getPointA() );
        trianglesAL2.add( triangle2.getPointB() );
        trianglesAL2.add( triangle2.getPointC() );

        HashSet<Double> triangleDistance = new HashSet<>(  );

       for (Point point1 : trianglesAL1){
           for (Point point2 : trianglesAL2){
               double minDist = distancePoint (point1, point2);
               triangleDistance.add( minDist );
           }
       }
        return Collections.min( triangleDistance );
    }

    public double distance(Triangle triangle, Circle circle) {
        ArrayList<Point> trianglesAL1 = new ArrayList<>();
        trianglesAL1.add( triangle.getPointA() );
        trianglesAL1.add( triangle.getPointB() );
        trianglesAL1.add( triangle.getPointC() );

        HashSet<Double> triangleDistance = new HashSet<>(  );

        for (Point point : trianglesAL1){
            double minDist = distancePoint (point, circle.getCentre());
            triangleDistance.add( minDist );
        }
        return Collections.min( triangleDistance );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance<?> distance = (Distance<?>) o;
        return Double.compare( distance.dis, dis ) == 0 &&
                Objects.equals( str, distance.str );
    }

    @Override
    public int hashCode() {
        return Objects.hash( dis );
    }

    public double getDis() {
        return dis;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setDis(double dis) {
        this.dis = dis;
    }

    @Override
    public int compareTo(Distance distance) {
        if (this.dis > distance.getDis())
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return str +
                bigDecimal (dis);
    }

    private double bigDecimal (double dis){
        return BigDecimal.valueOf(dis)
                .setScale(2,RoundingMode.HALF_UP)
                .doubleValue();
    }

}
