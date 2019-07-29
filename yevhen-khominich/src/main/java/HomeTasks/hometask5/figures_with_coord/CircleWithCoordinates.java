package HomeTasks.hometask5.figures_with_coord;

import HomeTasks.hometask5.figures.Circle;
import HomeTasks.hometask5.figures.Point;
import HomeTasks.hometask5.interfaces.FigureWithCoord;
import HomeTasks.hometask5.utils.CalcDist;

import java.util.ArrayList;
import java.util.List;

public class CircleWithCoordinates extends Circle implements FigureWithCoord {

    private double radius = 1.0;
    private Point center;

    public CircleWithCoordinates(Point center) {
        this.center = center;
    }

    public CircleWithCoordinates(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double distance(Point other) {
        return center.distance(other);
    }

    public double distanceBetweenCenters(CircleWithCoordinates other) {
        return distance(other.getCenter());
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public Double distanceTo(FigureWithCoord figure) {
        return CalcDist.distanceTo(figure,this.getPoints());
    }

    @Override
    public List<Point> getPoints() {
        List<Point> center = new ArrayList<>();
        center.add(getCenter());
        return center;
    }

}
