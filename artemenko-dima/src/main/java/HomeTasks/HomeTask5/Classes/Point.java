package HomeTasks.HomeTask5.Classes;

import HomeTasks.HomeTask5.Interface.RandomCoordinate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Point implements RandomCoordinate {

    private double x;
    private double y;
    protected double radius;
    private String Type;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        String Type;
    }

    public Point() {
        this.x = getRandCoordinate();
        this.y = getRandCoordinate();
        String Type;
    }


    public String getType() {
        return Type;
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRandCoordinate() {
        return Math.random() * (RANDMAX - RANDMIN) + RANDMIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare( point.x, x ) == 0 &&
                Double.compare( point.y, y ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash( x, y );
    }

    @Override
    public String toString() {
        return "Point{" +
                "x= " + bigDecimal (x) +
                ", y= " + bigDecimal (y) +
                '}';
    }

    protected double bigDecimal (double val){
        return BigDecimal.valueOf(val)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
