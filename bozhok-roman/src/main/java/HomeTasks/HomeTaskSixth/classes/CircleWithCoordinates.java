package HomeTasks.HomeTaskSixth.classes;

import HomeTasks.HomeTaskSixth.abstractClasses.Circle;
import HomeTasks.HomeTaskSixth.abstractClasses.Polygon;
import HomeTasks.HomeTaskSixth.interfaces.PointMarker;
import HomeTasks.HomeTaskSixth.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;


public class CircleWithCoordinates extends Circle implements Shape, PointMarker {

    private Point center;


    public CircleWithCoordinates(){
        super();
        this.center = new Point();

    }
    public CircleWithCoordinates(Point center){
        super();
        this.center = center;

    }
    public CircleWithCoordinates(Point center,double radius){
        super(radius);
        this.center = center;

    }
    public CircleWithCoordinates(Point center, double radius, String color){
        super(radius,color);
        this.center = center;
    }


    public double getRadius() {
        return super.radius;
    }


    public void setRadius(double radius) {
        super.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public String getColor() {
        return super.color;
    }


    public void setColor(String color) {
        super.color = color;
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }



    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public int countPoint() {
        return 1;
    }

    @Override
    public List<Point> getListPoint() {
        List<Point> list = new ArrayList<>();
        list.add(center);
        return list;
    }

    public double distance(Point center){
        return this.center.distance(center);
    }
}
