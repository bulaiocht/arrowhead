package HomeTasks.HomeTask2e2;

import java.util.ArrayList;
import java.util.Collections;

public class MostСloseNcircles {
    public static void main(String[] args) {

        System.out.println("-поиск 2 наиболие близких кругов в масиве" + "\n");

        int m = 6;
        CircleWithCoordinates[] circle = new CircleWithCoordinates[m];
        for (int i = 0; i < circle.length; i++) {

            double rendMin = 1.0;
            double rendMax = 100.0;
            double x = Math.random() * (rendMax - rendMin) + rendMin;
            double y = Math.random() * (rendMax - rendMin) + rendMin;
            double radius = Math.random() * (50.0 - rendMin) + rendMin;
            Point center = new Point(x, y);
            circle[i] = new CircleWithCoordinates(radius, center);

            System.out.print("Circle" + (i+1) + " radius =");
            System.out.printf("%3.2f", radius);
            System.out.print(";  center (");
            System.out.printf("%3.2f", x);
            System.out.print(";");
            System.out.printf("%3.2f", y);
            System.out.println(");");
        }// инициализация массива объектов

        ArrayList distList = new ArrayList();
        ArrayList distStrList = new ArrayList();

        for (int i = 0; i < circle.length; i++) {
            for (int j = i + 1; j < circle.length; j++) {
                double dis = Math.abs(circle[i].getCenter().distance(circle[j].getCenter()) - circle[i].getRadius() - circle[j].getRadius());
                String distStr = ("Most close circles in the array are Circle" + (i+1) + " and Circle" + (j+1));
                distList.add(dis);
                distStrList.add(distStr);
            }
        }// список растояний между кругами масива

        System.out.println("\n 4 Most close circles in the array: \n");

        for ( int i = 4; i == 0; i--){
            System.out.println(distStrList.get(distList.indexOf(Collections.min(distList))));
            System.out.print("Distance = ");
            System.out.printf("%3.2f", Collections.min(distList));
            System.out.println("\n");

            distStrList.remove(distStrList.get(distList.indexOf(Collections.min(distList))));
            distList.remove(Collections.min(distList));
        }
    }
}
