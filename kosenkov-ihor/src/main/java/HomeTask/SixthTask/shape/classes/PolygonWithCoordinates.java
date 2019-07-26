package HomeTask.SixthTask.shape.classes;

import HomeTask.SixthTask.shape.interfaces.Polygon;
import HomeTask.SixthTask.shape.interfaces.ShapeWithCoordinates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PolygonWithCoordinates extends Polygon implements ShapeWithCoordinates {

    private int NUMBER_OF_POINT;
    private Set<Point> points = new HashSet<>(this.NUMBER_OF_POINT);
    private Point[] pointsArray = new Point[this.NUMBER_OF_POINT];

    public PolygonWithCoordinates(Point... points) {
        NUMBER_OF_POINT = points.length;
        this.points.addAll(Arrays.asList(points));
        // Используем этот метод, чтобы в случае передачи в конструктор одинаковых точек, добавить другие
        fillAllPoint();
        // Переводим в массив чтобы можно было запросить точку по индексу
        pointsArray = this.points.toArray(pointsArray);
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
        return pointsArray[i];
    }

    private void fillAllPoint() {
        // Заполняем множество рандомными точками, пока размер не станет n
        while (points.size() != this.NUMBER_OF_POINT){
            points.add(new Point((int)(Math.random() * 10), (int)(Math.random() * 10)));
        }
    }

    @Override
    public int getNumberOfPoint() {
        return this.NUMBER_OF_POINT;
    }

    @Override
    public String toString() {
        return "PolygonWithCoordinates{" +
                "points=" + points +
                '}';
    }

}
