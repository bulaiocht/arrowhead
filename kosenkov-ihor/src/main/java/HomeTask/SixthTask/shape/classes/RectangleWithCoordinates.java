package HomeTask.SixthTask.shape.classes;

import HomeTask.SixthTask.shape.interfaces.Rectangle;
import HomeTask.SixthTask.shape.interfaces.ShapeWithCoordinates;

import java.util.HashSet;
import java.util.Set;

public class RectangleWithCoordinates extends Rectangle implements ShapeWithCoordinates {

    private Set<Point> points = new HashSet<>(Rectangle.NUMBER_OF_POINT);
    private Point[] pointsArray = new Point[Rectangle.NUMBER_OF_POINT];

    public RectangleWithCoordinates(Point point1, Point point2, Point point3, Point point4) {
        super(point1.distance(point2), point2.distance(point3));
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        // Используем этот метод, чтобы в случае передачи в конструктор одинаковых точек, добавить другие
        fillAllPoint();
        // Переводим в массив чтобы можно было запросить точку по индексу
        pointsArray = points.toArray(pointsArray);
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
        // Заполняем множество рандомными точками, пока размер не станет 4
        while (points.size() != Rectangle.NUMBER_OF_POINT){
            points.add(new Point((int)(Math.random() * 10), (int)(Math.random() * 10)));
        }
    }

    @Override
    public String toString() {
        return "RectangleWithCoordinates{" +
                "points=" + points +
                '}';
    }
}
