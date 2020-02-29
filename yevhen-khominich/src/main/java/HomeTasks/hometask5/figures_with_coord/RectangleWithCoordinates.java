package HomeTasks.hometask5.figures_with_coord;

import HomeTasks.hometask5.figures.Point;
import HomeTasks.hometask5.figures.Rectangle;
import HomeTasks.hometask5.interfaces.FigureWithCoord;
import HomeTasks.hometask5.utils.CalcDist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RectangleWithCoordinates extends Rectangle implements FigureWithCoord {

    final private int NUMBER_OF_ANGELS = 4;
    private List<Point> points = new ArrayList<>(NUMBER_OF_ANGELS);

    RectangleWithCoordinates() {
    }

    //Можно добавить исключение !
    public RectangleWithCoordinates(double[] x, double[] y) {

        Point[] pointArray = {new Point(), new Point(), new Point(), new Point()};
        this.points.addAll(Arrays.asList(pointArray));

        for (int i = 0; i < NUMBER_OF_ANGELS; i++) {
            this.points.get(i).setX(x[i]);
            this.points.get(i).setY(y[i]);
        }
    }

    public RectangleWithCoordinates(Point[] points) {
        this.points.addAll(Arrays.asList(points));
    }

    public Point getPoint(int index) {
        return this.points.get(index);
    }

    public void setPoint(Point point, int index) {
        this.points.add(index, point);
    }

    @Override
    public double getArea() {

        List<Double> distances = CalcDist.calcRectangleSides(this.points, NUMBER_OF_ANGELS);

        return distances.get(0) * distances.get(1);
    }

    @Override
    public double getPerimetr() {
        double perimetr = 0;
        for (Double side : CalcDist.calcRectangleSides(this.points, NUMBER_OF_ANGELS)) {
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
