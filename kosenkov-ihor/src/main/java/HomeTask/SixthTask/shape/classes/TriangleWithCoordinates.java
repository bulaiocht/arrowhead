package HomeTask.SixthTask.shape.classes;

import HomeTask.SixthTask.shape.interfaces.ShapeWithCoordinates;
import HomeTask.SixthTask.shape.interfaces.Triangle;

import java.util.HashSet;
import java.util.Set;

public class TriangleWithCoordinates extends Triangle implements ShapeWithCoordinates {

    private Set<Point> points = new HashSet<>(Triangle.NUMBER_OF_POINT);
    private Point[] pointsArray = new Point[Triangle.NUMBER_OF_POINT];

    public TriangleWithCoordinates(Point point1, Point point2, Point point3) {
        super(point1.distance(point2), point2.distance(point3), point3.distance(point1));
        points.add(point1);
        points.add(point2);
        points.add(point3);
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
        // Заполняем множество рандомными точками, пока размер не станет 3
        while (points.size() != Triangle.NUMBER_OF_POINT){
            points.add(new Point((int)(Math.random() * 10), (int)(Math.random() * 10)));
        }
    }

    @Override
    public String toString() {
        return "TriangleWithCoordinates{" +
                "points=" + points +
                '}';
    }
}
