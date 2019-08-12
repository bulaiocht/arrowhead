package HomeTasks.HomeTask5.Classes;

import HomeTasks.HomeTask5.Interface.RandomCoordinate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Circle extends Point implements RandomCoordinate {

    public double radius;
    private Point centre;
    private String Type;

    public Circle() {
        this.centre = new Point(getX(), getY());
        this.radius = getRandCoordinate() / 4;
        Type = "Circle";
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getType() {
        return Type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return centre.equals(circle.centre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centre);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius= " + bigDecimal (radius) +
                ", centre= " + centre +
                '}';
    }

    @Override
    protected double bigDecimal(double val) {
        return super.bigDecimal( val );
    }

    public List<Circle> circles (int n){
        int counter;
        return Stream.generate( Circle::new )
                .peek( System.out::println )
                .limit( n )
                .collect( Collectors.toList() );
    }
}
