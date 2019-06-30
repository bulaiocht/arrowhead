package homework.lesson4;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        CircleWithCoordinates[] circleWithCoordinates = new CircleWithCoordinates[5];
        for (int i = 0; i < circleWithCoordinates.length; i++) {
            circleWithCoordinates[i] = new CircleWithCoordinates(new Point(random.nextInt(201),
                    random.nextInt(201)));
        }
        searchTheClosestCircle(circleWithCoordinates);

        TriangleWithCoordinates[] triangleWithCoordinates = new TriangleWithCoordinates[5];
        for (int i = 0; i < triangleWithCoordinates.length; i++) {
            triangleWithCoordinates[i] = new TriangleWithCoordinates(new Point(random.nextInt(201),
                    random.nextInt(201)),
                    new Point(random.nextInt(201), random.nextInt(201)),
                    new Point(random.nextInt(201), random.nextInt(201)));
        }

        searchClosestTriangle(triangleWithCoordinates);
        CircleWithCoordinates[] circleWithCoordinatesCountN = new CircleWithCoordinates[5];
        for (int i = 0; i < circleWithCoordinatesCountN.length; i++) {
            circleWithCoordinatesCountN[i] = new CircleWithCoordinates(new Point(random.nextInt(201),
                    random.nextInt(201)));
        }

        searchTheClosestCircleCountN(circleWithCoordinatesCountN);
        TriangleWithCoordinates[] triangleWithCoordinatesCountN = new TriangleWithCoordinates[5];
        for (int i = 0; i < triangleWithCoordinatesCountN.length; i++) {

            triangleWithCoordinatesCountN[i] = new TriangleWithCoordinates(
                    new Point(random.nextInt(201), random.nextInt(201)),
                    new Point(random.nextInt(201), random.nextInt(201)),
                    new Point(random.nextInt(201), random.nextInt(201)));
        }
        searchClosestTriangleCountN(triangleWithCoordinatesCountN);
    }


    public static void searchTheClosestCircle(CircleWithCoordinates[] circles) {
        double minDistance = circles[0].distance(circles[1].getCenter());
        int index1 = 0;
        int index2 = 1;

        for (int i = 0; i < circles.length; i++) {
            for (int j = 1; j < circles.length; j++) {
                if (i != j) {
                    if (minDistance > circles[i].distance(circles[j].getCenter())) {
                        minDistance = circles[i].distance(circles[j].getCenter());
                        index1 = i;
                        index2 = j;
                    }
                }
            }
        }
        System.out.println("The closest circle with center : "
                + circles[index1].getCenter() + ","
                + circles[index2].getCenter());
    }

    public static void searchTheClosestCircleCountN(CircleWithCoordinates[] circles) {
        double minDistance = circles[0].distance(circles[1].getCenter());
        int[] index1 = new int[circles.length * 2];
        int[] index2 = new int[circles.length * 2];
        for (int i = 0; i < index1.length; i++) {
            index1[i] = -1;
            index2[i] = -1;
        }
        for (int i = 0; i < circles.length; i++) {
            for (int j = 0; j < circles.length; j++) {
                if (i != j) {
                    if (minDistance > circles[i].distance(circles[j].getCenter())) {
                        minDistance = circles[i].distance(circles[j].getCenter());
                    }
                }
            }
        }
        int k = 0;
        for (int i = 0; i < circles.length; i++) {
            for (int j = 1; j < circles.length; j++) {
                if (i != j) {
                    if (minDistance == circles[i].distance(circles[j].getCenter())) {
                        index1[k] = i;
                        index2[k] = j;
                        k++;
                    }
                }
            }
        }

        if (index1[1] != -1) {
            System.out.println("Circle with the same closest centers ");
            for (int i = 0; i < index1.length; i++) {
                try {
                    System.out.println("The closest circle with center : "
                            + circles[index1[i]].getCenter()
                            + "," + circles[index2[i]].getCenter());
                } catch (Exception e) {

                }
            }

        } else {
            System.out.println("The closest circle with center : "
                    + circles[index1[0]].getCenter()
                    + "," + circles[index2[0]].getCenter());
        }
    }

    public static void searchClosestTriangle(TriangleWithCoordinates[] triangles) {
        double minDistance = triangles[0].distance(triangles[1]);
        int index1 = 0;
        int index2 = 1;

        for (int i = 0; i < triangles.length; i++) {
            for (int j = 1; j < triangles.length; j++) {
                if (i != j) {
                    if (minDistance > triangles[i].distance(triangles[j])) {
                        minDistance = triangles[i].distance(triangles[j]);
                        index1 = i;
                        index2 = j;
                    }
                }
            }
        }
        System.out.println("The closest triangle with point : " + triangles[index1] + "," + triangles[index2]);

    }

    public static void searchClosestTriangleCountN(TriangleWithCoordinates[] triangles) {
        double minDistance = triangles[0].distance(triangles[1]);
        int[] index1 = new int[triangles.length * 2];
        int[] index2 = new int[triangles.length * 2];
        for (int i = 0; i < index1.length; i++) {
            index1[i] = -1;
            index2[i] = -1;
        }
        for (int i = 0; i < triangles.length; i++) {
            for (int j = 1; j < triangles.length; j++) {
                if (i != j) {
                    if (minDistance > triangles[i].distance(triangles[j])) {
                        minDistance = triangles[i].distance(triangles[j]);
                    }
                }
            }
        }

        int k = 0;
        for (int i = 0; i < triangles.length; i++) {
            for (int j = 1; j < triangles.length; j++) {
                if (i != j) {
                    if (minDistance == triangles[i].distance(triangles[j])) {

                        index1[k] = i;
                        index2[k] = j;
                        k++;
                    }
                }
            }
        }

        if (index1[1] != -1) {
            System.out.println("Triangles that are neat ");
            for (int i = 0; i < index1.length; i++) {
                try {
                    System.out.println("Closest Triangle with point : " + triangles[i] + "," + triangles[i]);
                } catch (Exception e) {

                }
            }
        } else {
            System.out.println("The closest triangle with point : " + triangles[0] + "," + triangles[0]);
        }
    }
}
