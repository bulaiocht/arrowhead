package HomeTasks.hometask5.utils;

import HomeTasks.hometask5.figures.Point;
import HomeTasks.hometask5.interfaces.FigureWithCoord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalcDist {
    public static List<Double> calcTrianglesSides(List<Point> points, int numberOfAngels) {

        List<Double> distances = new ArrayList<>();

        for (int i = 0; i < numberOfAngels - 1; i++) {
            for (int j = 1; j < numberOfAngels; j++) {
                if (i >= j) continue;
                distances.add(points.get(i).distance(points.get(j)));
            }
        }
        return distances;
    }

    public static List<Double> calcRectangleSides(List<Point> points, int numberOfAngels) {
        List<Double> distances = new ArrayList<>();

        for (int i = 0; i < numberOfAngels - 2; i++) {
            distances.add(points.get(0).distance(points.get(1)));
            distances.add(points.get(0).distance(points.get(3)));
        }
        return distances;
    }

    public static List<Double> calcPolygonSides(List<Point> points, int numberOfAngels) {
        List<Double> distances = new ArrayList<>();

        for (int i = 0; i < numberOfAngels - 1; i++) {
            distances.add(points.get(i).distance(points.get(i + 1)));
        }
        distances.add(points.get(numberOfAngels - 1).distance(points.get(0)));

        return distances;
    }

    public static List<Double> calculateDistanceBetweenDifferentPoints(List<Point> pointsFirstFigure,
                                                                       List<Point> pointsSecondFigure) {

        List<Double> distances = new ArrayList<>();

        for (int i = 0; i < pointsFirstFigure.size(); i++) {
            for (int j = 0; j < pointsSecondFigure.size(); j++) {
                if (i > j) continue;
                distances.add(pointsFirstFigure.get(i).distance(pointsSecondFigure.get(j)));

            }
        }

//        return pointsFirstFigure.stream()
//                .map(p -> minDistance(p, pointsSecondFigure))
//                .collect(Collectors.toList());

        return distances;

    }

    private static Double minDistance(Point p, List<Point> points) {
        return points
                .stream()
                .map(point -> point.distance(p))
                .min(Double::compareTo)
                .orElse(0.0);
    }

    public static Double distanceTo(FigureWithCoord first, List<Point> pointersOther) {
        List<Point> pointersFirst = first.getPoints();
        List<Double> distancesBetweenFigures = CalcDist.calculateDistanceBetweenDifferentPoints(pointersFirst, pointersOther);

        return Collections.min(distancesBetweenFigures);

    }

}
