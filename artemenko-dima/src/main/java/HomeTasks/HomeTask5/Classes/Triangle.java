package HomeTasks.HomeTask5.Classes;

import HomeTasks.HomeTask5.Interface.RandomCoordinate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Triangle extends Point implements RandomCoordinate {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private String Type;

    public Triangle() {
        this.pointA = new Point();
        this.pointB = new Point();
        this.pointC = new Point();
        Type = "Triangle";
    }

    Point getPointA() {
        return pointA;
    }

    Point getPointB() {
        return pointB;
    }

    Point getPointC() {
        return pointC;
    }

    public String getType() {
        return Type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return pointA.equals(triangle.pointA) &&
                pointB.equals(triangle.pointB) &&
                pointC.equals(triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "pointA= " + pointA +
                ", pointB= " + pointB +
                ", pointC= " + pointC +
                '}';
    }

    public List<Triangle> triangles (int n){
        return Stream.generate( Triangle::new )
                .peek( System.out::println )
                .limit( n )
                .collect( Collectors.toList() );
    }
}
