package HomeTask.SixthTask.shape.classes;

import HomeTask.SixthTask.shape.interfaces.Circle;
import HomeTask.SixthTask.shape.interfaces.ShapeWithCoordinates;

import java.util.HashSet;
import java.util.Set;

public class CircleWithCoordinates extends Circle implements ShapeWithCoordinates {

    private Point center = new Point();
    private Set<Point> points = new HashSet<>(Circle.NUMBER_OF_POINT);

    {
        points.add(this.center);
    }

    public CircleWithCoordinates() {
        super();
    }

    public CircleWithCoordinates(double radius) {
        super(radius);
    }

    public CircleWithCoordinates(Point center) {
        this.center = center;
        addPointToPoints();
    }

    public CircleWithCoordinates(Point center, double radius) {
        super(radius);
        this.center = center;
        addPointToPoints();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point point) {
        this.center = point;
        addPointToPoints();
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
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
    public Point getPoint(int i) {
        return this.center;
    }

    // Метод чтобы добавить новый центр в множество точек
    private void addPointToPoints(){
        points.clear();                        // Очищаем множество чтобы добавить новый центр
        points.add(this.center);
    }

    @Override
    public String toString() {
        return "CircleWithCoordinates{" +
                "points=" + points +
                '}';
    }
}
