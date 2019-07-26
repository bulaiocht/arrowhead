package HomeTask.SixthTask;

import HomeTask.SixthTask.shape.classes.*;
import HomeTask.SixthTask.shape.interfaces.ShapeWithCoordinates;
import HomeTask.SixthTask.shape.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class ShapeRunner{
    public static void main(String[] args) {

        List<ShapeWithCoordinates> shapes = new ArrayList<>();
        shapes.add(new TriangleWithCoordinates(new Point(0,1), new Point(1,0), new Point(0,0)));
        shapes.add(new TriangleWithCoordinates(new Point(3,1), new Point(5,0), new Point(3,0)));
        shapes.add(new TriangleWithCoordinates(new Point(0,8), new Point(1,8), new Point(0,51)));
        shapes.add(new PolygonWithCoordinates(
                new Point(3,1), new Point(5,0), new Point(3,0),
                new Point(1,8), new Point(0,51)));
        shapes.add(new RectangleWithCoordinates(
                new Point(3,1), new Point(5,0), new Point(3,0), new Point(2,1)));
        shapes.add(new CircleWithCoordinates(new Point(0,1)));


        List<ShapeWithCoordinates> shapes1 = new ArrayList<>();
        shapes1.add(new TriangleWithCoordinates(
                new Point(0,1), new Point(1,0), new Point(0,0)));
        shapes1.add(new RectangleWithCoordinates(
                new Point(3,1), new Point(5,0), new Point(3,0), new Point(2,1)));


        List<ShapeWithCoordinates> shapes2 = new ArrayList<>();
        shapes2.add(new PolygonWithCoordinates(
                new Point(3,1), new Point(5,0), new Point(3,0),
                new Point(1,8), new Point(0,51)));
        shapes2.add(new CircleWithCoordinates(new Point(0,1)));

        //1
        System.out.println("1.");
        List<? super ShapeWithCoordinates> closestFigures = Utilities.getClosestFigures(shapes, 4);
        closestFigures.forEach(System.out::println);

        //2
        System.out.println("2.");
        List<? super ShapeWithCoordinates> closestFigures2 = Utilities.getClosestFigures(shapes1, shapes2, 4);
        closestFigures2.forEach(System.out::println);

        //3
        System.out.println("3.");
        List<? super ShapeWithCoordinates> objects =
                Utilities.sortWithPredicate(shapes, shape ->
                        shape.getPoint(0).getX() == 0 && shape.getPoint(0).getY() == 1);
        objects.forEach(System.out::println);

        // 4
        System.out.println("4.");
        boolean intersect = Utilities.isIntersect(shapes.get(0), shapes.get(5));
        System.out.println("Фигуры пересекаются: " + (intersect ? "да" : "нет"));

    }
}