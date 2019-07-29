package HomeTasks.hometask5.interfaces;

import HomeTasks.hometask5.figures.Point;

import java.util.List;

public interface FigureWithCoord {
    Double distanceTo(FigureWithCoord figure);

    List<Point> getPoints();
}
