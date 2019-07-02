package HomeTasks.HomeTask2e2;
//- поиск 2 наиболее близких фигур в массиве. (для многоугольников ищем расстояние до ближайшего угла)

import java.util.ArrayList;
import java.util.Collections;

public class MostClosestFigures {
    public static void main(String[] args) {

        System.out.println("- поиск 2 наиболее близких фигур в массиве" + "\n");

        ArrayList figure = new ArrayList();

        for (int i = 0; i < 8; i++) {
            if (Math.random() < 0.5) {
                double rendMin = 1.0;
                double rendMax = 100.0;
                double x = Math.random() * (rendMax - rendMin) + rendMin;
                double y = Math.random() * (rendMax - rendMin) + rendMin;
                double radius = Math.random() * (20.0 - rendMin) + rendMin;
                Point center = new Point(x, y);
                Circle circle = new CircleWithCoordinates(radius, center);
                figure.add(circle);
                System.out.print("Circle" + i + " radius =");
                System.out.printf("%3.2f", radius);
                System.out.print(";  center (");
                System.out.printf("%3.2f", x);
                System.out.print(":");
                System.out.printf("%3.2f", y);
                System.out.println(");");
            }
            else {
                Point[] point = new Point[3];
                double rendMin = 1.0;
                double rendMax = 100.0;
                for (int n = 0; n <= 2; n++) {
                    double x = Math.random() * (rendMax - rendMin) + rendMin;
                    double y = Math.random() * (rendMax - rendMin) + rendMin;
                    point[n] = new Point(x, y);
                }
                TriangleWithCoordinates triangle = new TriangleWithCoordinates();
                triangle.setPointOne(point[0]);
                triangle.setPointTwo(point[1]);
                triangle.setPointThree(point[2]);
                figure.add(triangle);
                System.out.print("Triangle" + i);
                System.out.print(":  point One (");
                System.out.printf("%3.2f", point[0].getX());
                System.out.print(":");
                System.out.printf("%3.2f", point[0].getY());
                System.out.print(");");
                System.out.print("  point Two (");
                System.out.printf("%3.2f", point[1].getX());
                System.out.print(":");
                System.out.printf("%3.2f", point[1].getY());
                System.out.print(");");
                System.out.print("  point Three (");
                System.out.printf("%3.2f", point[2].getX());
                System.out.print(":");
                System.out.printf("%3.2f", point[2].getY());
                System.out.println(");");
            }
        }// инициализация списка объектов

        System.out.print("\n");

        ArrayList distList = new ArrayList();
        ArrayList distStrList = new ArrayList();

        for (int i = 0; i < figure.size(); i++) {
            for (int j = i + 1; j < figure.size(); j++) {

                if (figure.get(i) instanceof CircleWithCoordinates && figure.get(j) instanceof CircleWithCoordinates){
                    double dis = Math.abs(((CircleWithCoordinates) figure.get(i)).getCenter().distance(((CircleWithCoordinates)figure.get(j)).getCenter())
                            - ((CircleWithCoordinates) figure.get(i)).getRadius() - ((CircleWithCoordinates) figure.get(j)).getRadius());
                    String distStr = ("Most close figure in the array are Circle" + i + " and Circle" + j);
                    distList.add(dis);
                    distStrList.add(distStr);
                }
                else if (figure.get(i) instanceof TriangleWithCoordinates && figure.get(j) instanceof TriangleWithCoordinates){

                    double dis = Math.abs(((TriangleWithCoordinates) figure.get(i)).getPointOne().distance(((TriangleWithCoordinates)figure.get(j)).getPointOne()));
                    String distStr = ("Most close figure in the array are Triangle" + i + " PointOne"+ " and Triangle" + j + " PointOne");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((TriangleWithCoordinates) figure.get(i)).getPointOne().distance(((TriangleWithCoordinates) figure.get(j)).getPointTwo()));
                    distStr = ("Most close figure in the array are Triangle" + i + " PointOne"+ " and Triangle" + j + " PointTwo");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((TriangleWithCoordinates) figure.get(i)).getPointOne().distance(((TriangleWithCoordinates)figure.get(j)).getPointThree()));
                    distStr = ("Most close figure in the array are Triangle" + i + " PointOne"+ " and Triangle" + j + " PointThree");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((TriangleWithCoordinates) figure.get(i)).getPointTwo().distance(((TriangleWithCoordinates)figure.get(j)).getPointTwo()));
                    distStr = ("Most close figure in the array are Triangle" + i + " PointTwo"+ " and Triangle" + j + " PointTwo");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((TriangleWithCoordinates) figure.get(i)).getPointTwo().distance(((TriangleWithCoordinates)figure.get(j)).getPointThree()));
                    distStr = ("Most close figure in the array are Triangle" + i + " PointTwo"+ " and Triangle" + j + " PointThree");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((TriangleWithCoordinates) figure.get(i)).getPointThree().distance(((TriangleWithCoordinates)figure.get(j)).getPointThree()));
                    distStr = ("Most close figure in the array are Triangle" + i + " PointThree"+ " and Triangle" + j + " PointThree");
                    distList.add(dis);
                    distStrList.add(distStr);
                }
                else if (figure.get(i) instanceof CircleWithCoordinates && figure.get(j) instanceof TriangleWithCoordinates){
                    double dis = Math.abs(((CircleWithCoordinates) figure.get(i)).getCenter().distance(((TriangleWithCoordinates)figure.get(j)).getPointOne()) - ((CircleWithCoordinates) figure.get(i)).getRadius());
                    String distStr = ("Most close figure in the array are Circle" + i + " and Triangle" + j + " PointOne");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((CircleWithCoordinates) figure.get(i)).getCenter().distance(((TriangleWithCoordinates) figure.get(j)).getPointTwo()) - ((CircleWithCoordinates) figure.get(i)).getRadius());
                    distStr = ("Most close figure in the array are Circle" + i + " and Triangle" + j + " PointTwo");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((CircleWithCoordinates) figure.get(i)).getCenter().distance(((TriangleWithCoordinates)figure.get(j)).getPointThree()) - ((CircleWithCoordinates) figure.get(i)).getRadius());
                    distStr = ("Most close figure in the array are Circle" + i + " and Triangle" + j + " PointThree");
                    distList.add(dis);
                    distStrList.add(distStr);
                }
                else {
                    double dis = Math.abs(((CircleWithCoordinates) figure.get(j)).getCenter().distance(((TriangleWithCoordinates)figure.get(i)).getPointOne()) - ((CircleWithCoordinates) figure.get(j)).getRadius());
                    String distStr = ("Most close figure in the array are Circle" + j + " and Triangle" + i + " PointOne");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((CircleWithCoordinates) figure.get(j)).getCenter().distance(((TriangleWithCoordinates) figure.get(i)).getPointTwo()) - ((CircleWithCoordinates) figure.get(j)).getRadius());
                    distStr = ("Most close figure in the array are Circle" + j + " and Triangle" + i + " PointTwo");
                    distList.add(dis);
                    distStrList.add(distStr);
                    dis = Math.abs(((CircleWithCoordinates) figure.get(j)).getCenter().distance(((TriangleWithCoordinates)figure.get(i)).getPointThree()) - ((CircleWithCoordinates) figure.get(j)).getRadius());
                    distStr = ("Most close figure in the array are Circle" + j + " and Triangle" + i + " PointThree");
                    distList.add(dis);
                    distStrList.add(distStr);
                }
            }
        }// список растояний между фигурами масива
        System.out.println(distStrList.get(distList.indexOf(Collections.min(distList))));
        System.out.print("Distance = ");
        System.out.printf("%3.2f",Collections.min(distList));
    }
}
