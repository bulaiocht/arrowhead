package HomeTasks.hometask5.figures_with_coord;

import HomeTasks.hometask5.figures.Point;
import HomeTasks.hometask5.figures.Polygon;
import HomeTasks.hometask5.interfaces.FigureWithCoord;
import HomeTasks.hometask5.utils.CalcDist;

import java.util.ArrayList;
import java.util.List;

public class PolygonWithCoordinates extends Polygon implements FigureWithCoord {

    private int NUMBER_OF_ANGELS;
    private List<Point> points = new ArrayList<>();

    public PolygonWithCoordinates(List<Point> points, int NUMBER_OF_ANGELS) {
        this.NUMBER_OF_ANGELS = NUMBER_OF_ANGELS;
        this.points = points;
    }

    //Рандом
    @Override
    public double getArea() {

        List<Double> distances = CalcDist.calcPolygonSides(this.points, NUMBER_OF_ANGELS);

        double p = getPerimetr() / 2;
        return Math.abs(Math.sqrt(p * (p - distances.get(0)) * (p - distances.get(1))));
    }

    @Override
    public double getPerimetr() {
        double perimetr = 0;
        for (Double side : CalcDist.calcPolygonSides(this.points, NUMBER_OF_ANGELS)) {
            perimetr += side;
        }
        return perimetr;
    }

    //     Search the nearest way between Figures
    @Override
    public Double distanceTo(FigureWithCoord figure) {
        return CalcDist.distanceTo(figure, this.getPoints());
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

}
