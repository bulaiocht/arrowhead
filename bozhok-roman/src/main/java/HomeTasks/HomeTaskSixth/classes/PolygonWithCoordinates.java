package HomeTasks.HomeTaskSixth.classes;

import HomeTasks.HomeTaskSixth.abstractClasses.Polygon;
import HomeTasks.HomeTaskSixth.interfaces.PointMarker;
import HomeTasks.HomeTaskSixth.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class PolygonWithCoordinates extends Polygon implements Shape , PointMarker {

    private List<Point> points;

    @Override
    public List<Point> getListPoint() {
        return points;
    }

    public PolygonWithCoordinates(List<Point> points){
        super(points.size());
        this.points = points;

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
    public int countPoint() {
        return points.size();
    }

    public double distance (PolygonWithCoordinates otherPolygon){

        List<Double> distances = new ArrayList<>();


        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < otherPolygon.points.size(); j++) {
                distances.add(this.points.get(i).distance(otherPolygon.points.get(j)));

            }
        }


        return distances.stream().min(Double::compareTo).orElse(0.0);
    }

}
