package shapes;

public class ShapeRunner {
    public static void main(String[] args) {
        Point centers[] = {new Point(0, 0), new Point(4, 4), new Point(6, 6), new Point(10, 10), new Point(15, 15)};
        CircleWithCoordinates[] circles = {new CircleWithCoordinates(centers[0]), new CircleWithCoordinates(centers[1]), new CircleWithCoordinates(centers[2]), new CircleWithCoordinates(centers[3]), new CircleWithCoordinates(centers[4])};
        TriangleWithCoordinates[] triangles = {new TriangleWithCoordinates(0, 0, 5, 5, -5, -5), new TriangleWithCoordinates(10, 10, 15, 15, -20, -20), new TriangleWithCoordinates(-25, -25, 25, 25, -12, -12), new TriangleWithCoordinates(-30, -30, -8, -8, 30, 30)};

        searchTwoNearCircles(circles);
        searchNearCircles(3, circles);

        searchTwoNearTriangles(triangles);
        searchNearTriangles(3, triangles);
    }

    public static void searchNearCircles(int n, CircleWithCoordinates[] circles) {

        int size = calculateVariants(circles.length);
        double[][] distancesAndIndex = new double[size][3];
        for (int i = 0, k = 0; i < circles.length; i++) {
            for (int j = i + 1; j < circles.length; j++) {
                distancesAndIndex[k][0] = circles[i].distanceBetweenCenters(circles[j]);
                distancesAndIndex[k][1] = i;
                distancesAndIndex[k][2] = j;
                k++;

            }
        }
        sortCoordinates(distancesAndIndex);
        System.out.println("Nearest of " + n + " " + "circles");

        for (int i = 0; i < n; i++) {
            System.out.println("Distance between circle " + (int) distancesAndIndex[i][1] + " and " + (int) distancesAndIndex[i][2] + " = " + distancesAndIndex[i][0] + " " + "First Index : " + (int) distancesAndIndex[i][1] + " " + "Second Index : " + (int) distancesAndIndex[i][2]);
        }

    }

    public static void searchTwoNearCircles(CircleWithCoordinates[] circles) {

        double distance = circles[0].distanceBetweenCenters(circles[1]);
        int indexFirstCircle = 0;
        int indexSecondCircle = 0;

        for (int i = 0; i < circles.length; i++) {
            for (int j = i + 1; j < circles.length; j++) {
                if (distance > circles[i].distanceBetweenCenters(circles[j])) {
                    distance = circles[i].distanceBetweenCenters(circles[j]);
                    indexFirstCircle = i;
                    indexSecondCircle = j;


                }
            }
        }

        System.out.println("IndexOfTwoNearestCircles: " + "First = " + indexFirstCircle + " " + "Second = " + indexSecondCircle + " " + "Distance = " + distance);

    }

    public static void searchTwoNearTriangles(TriangleWithCoordinates[] triangles) {

        double distance = triangles[0].distance(triangles[1]);
        int indexFirstTriangle = 0;
        int indexSecondTriangle = 0;

        for (int i = 0; i < triangles.length; i++) {
            for (int j = i + 1; j < triangles.length; j++) {
                if (distance > triangles[i].distance(triangles[j])) {
                    distance = triangles[i].distance(triangles[j]);
                    indexFirstTriangle = i;
                    indexSecondTriangle = j;


                }
            }
        }
        System.out.println("IndexOfTwoNearestTriangles: " + "First = " + indexFirstTriangle + " " + "Second = " + indexSecondTriangle + " " + "Distance = " + distance);
    }

    public static void searchNearTriangles(int n, TriangleWithCoordinates[] triangles) {

        int size = calculateVariants(triangles.length);
        double[][] distancesAndIndex = new double[size][3];

        for (int i = 0, k = 0; i < triangles.length; i++) {
            for (int j = i + 1; j < triangles.length; j++) {
                distancesAndIndex[k][0] = triangles[i].distance(triangles[j]);
                distancesAndIndex[k][1] = i;
                distancesAndIndex[k][2] = j;
                k++;

            }

        }

        sortCoordinates(distancesAndIndex);
        System.out.println("Nearest of " + n + " " + "triangles");

        for (int i = 0; i < n; i++) {
            System.out.println("Distance between triangles " + (int) distancesAndIndex[i][1] + " and " + (int) distancesAndIndex[i][2] + " = " + distancesAndIndex[i][0] + " " + "First Index : " + (int) distancesAndIndex[i][1] + " " + "Second Index : " + (int) distancesAndIndex[i][2]);
        }

    }

    private static double[][] sortCoordinates(double distancesAndIndex[][]) {
        boolean isSorted = false;
        double temp;
        double temp2;
        double temp3;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < distancesAndIndex.length - 1; i++) {
                if (distancesAndIndex[i][0] > distancesAndIndex[i + 1][0]) {
                    isSorted = false;

                    temp = distancesAndIndex[i][0];
                    distancesAndIndex[i][0] = distancesAndIndex[i + 1][0];
                    distancesAndIndex[i + 1][0] = temp;

                    temp2 = distancesAndIndex[i][1];
                    distancesAndIndex[i][1] = distancesAndIndex[i + 1][1];
                    distancesAndIndex[i + 1][1] = temp2;

                    temp3 = distancesAndIndex[i][2];
                    distancesAndIndex[i][2] = distancesAndIndex[i + 1][2];
                    distancesAndIndex[i + 1][2] = temp3;
                }
            }
        }
        return distancesAndIndex;
    }

    private static int calculateVariants(int length) {
        int p = 0;//Количество расстояний между точками
        for (int i = length - 1; i > 0; i--) {
            p += i;
        }
        return p;
    }


}
