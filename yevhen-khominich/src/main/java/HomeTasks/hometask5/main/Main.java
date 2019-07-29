package HomeTasks.hometask5.main;

import HomeTasks.hometask5.figures.Point;
import HomeTasks.hometask5.figures_with_coord.CircleWithCoordinates;
import HomeTasks.hometask5.figures_with_coord.RectangleWithCoordinates;
import HomeTasks.hometask5.figures_with_coord.TriangleWithCoordinates;
import HomeTasks.hometask5.interfaces.FigureWithCoord;
import HomeTasks.hometask5.utils.Util;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Point point[]={new Point(5,1),new Point(0,1),new Point(8,8)};
        Point point1[]={new Point(-1,1),new Point(15,1),new Point(9,9)};
        Point pointTriangle[] = {new Point(0, 7), new Point(-1, 1), new Point(9, 9)};

        Point rectPoint[] = {new Point(0, 0), new Point(7, 0), new Point(7, 4), new Point(0, 4)};
        Point polPoint[] = {new Point(0, 0), new Point(2, 9), new Point(7, 4), new Point(3, 4), new Point(5, 0)};


        TriangleWithCoordinates triangle = new TriangleWithCoordinates(pointTriangle);
        RectangleWithCoordinates rectangle = new RectangleWithCoordinates(rectPoint);
        CircleWithCoordinates circle = new CircleWithCoordinates(new Point(15, 15));

        List<FigureWithCoord> figures = new ArrayList<>();
        figures.add(triangle);
        figures.add(rectangle);
        figures.add(circle);

        System.out.println(Util.searchNearFigures(2, figures));


    }


}

