package HomeTask.SixthTask.shape.interfaces;

import HomeTask.SixthTask.shape.classes.Point;

public interface Shape {

    int getNumberOfPoint();
    double getPerimeter();
    double getArea();
    Point getPoint(int i);

}
