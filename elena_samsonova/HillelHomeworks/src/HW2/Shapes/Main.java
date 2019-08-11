package HW2.Shapes;

public class Main {
    //Написать методы для:
    // - поиска 2 наиболее близких кругов в массиве.
    // - поиска n наиболее близких кругов в массиве.
    // - поиска 2 наиболее близких фигур в массиве. (для многоугольников ищем расстояние до ближайшего угла)
    // - поиска n наиболее близких фигур в массиве. (для многоугольников ищем расстояние до ближайшего угла)

    public static void main(String[] args) {
        CircleWithCoordinates circles[] = new CircleWithCoordinates[5];
        circles[0] = new CircleWithCoordinates(new Point(3, 4), 3);
        circles[1] = new CircleWithCoordinates(new Point(3, 5), 5);
        circles[2] = new CircleWithCoordinates(new Point(4, 8), 1);
        circles[3] = new CircleWithCoordinates(new Point(10, 4), 8);
        circles[4] = new CircleWithCoordinates(new Point(1, 4), 3);

        //System.out.println(circles[0].distance(circles[0]));

        searchTwoClosestCircles(circles);
        searchNClosestCircles(circles, 10);

        TriangleWithCoordinates triangles[] = new TriangleWithCoordinates[4];

        triangles[0] = new TriangleWithCoordinates(new Point(0, 1), new Point(1, 3), new Point(4, 0));
        triangles[1] = new TriangleWithCoordinates(new Point(2, 5), new Point(7, 5), new Point(4, 9));
        triangles[2] = new TriangleWithCoordinates(new Point(2, 1), new Point(3, 4), new Point(13, 2));
        triangles[3] = new TriangleWithCoordinates(new Point(9, 5), new Point(12, 3), new Point(14, 5));

        searchTwoClosestTriangles(triangles);
        searchNClosestTriangles(triangles,4);


    }

    public static void searchTwoClosestCircles(CircleWithCoordinates[] circles) {

        double minDist = circles[0].distance(circles[1]) + 1;
        int circle1 = 0;
        int circle2 = 0;
        for (int i = 0; i < circles.length; i++) {
            for (int j = 0; j < circles.length; j++) {
                if (i != j) {
                    if (minDist > circles[i].distance(circles[j])) {
                        minDist = circles[i].distance(circles[j]);
                        circle1 = i;
                        circle2 = j;
                    }
                }

            }
        }

        System.out.println("Two closest circles are " + circle1 + " and " + circle2 + " at distance " + minDist);

    }

    public static void searchTwoClosestTriangles(TriangleWithCoordinates triangles[]) {
        double minDist = triangles[0].distance(triangles[1]) + 10;
        int triangle1 = 0;
        int triangle2 = 0;

        for (int i = 0; i < triangles.length; i++) {
            for (int j = 0; j < triangles.length; j++) {
                if (i != j) {
                    if (minDist > triangles[i].distance(triangles[j])) {
                        minDist = triangles[i].distance(triangles[j]);
                        triangle1 = i;
                        triangle2 = j;
                    }
                }
            }
        }

        System.out.println("Two closest triangles are " + triangle1 + " and " + triangle2 + " at distance " + minDist);
    }

    public static void searchNClosestCircles(CircleWithCoordinates[] circles, int n) {
        // ArrayList<Distances> distances1= new ArrayList<Distances>();
        Distances distances[] = new Distances[numberOfDistances(circles.length)];

        for (int i = 0; i < distances.length; i++) {
            distances[i] = new Distances(0, -1, -1);
        }
        int k = 0;
        for (int i = 0; i < circles.length; i++) {
            for (int j = 0; j < circles.length; j++) {
                if (i < j) {
                    distances[k].distance = circles[i].distance(circles[j]);
                    distances[k].index1 = i;
                    distances[k].index2 = j;
                    k++;
                    //distances1.add(new Distances(distances[k].distance,i,j));
                }
            }
        }


        boolean isSorted = false;
        Distances buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < distances.length - 1; i++) {
                if (distances[i].distance > distances[i + 1].distance) {
                    isSorted = false;

                    buf = distances[i];
                    distances[i] = distances[i + 1];
                    distances[i + 1] = buf;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Closest " + (i + 1) + ". " + distances[i].index1 + " and " + distances[i].index2 +
                    " on distance " + distances[i].distance);
        }

    }

    public static void searchNClosestTriangles(TriangleWithCoordinates triangles[], int n) {
        Distances distances[] = new Distances[numberOfDistances(triangles.length)];

        for (int i = 0; i < distances.length; i++) {
            distances[i] = new Distances(0, -1, -1);
        }
        int k = 0;
        for (int i = 0; i < triangles.length; i++) {
            for (int j = 0; j < triangles.length; j++) {
                if (i < j) {
                    distances[k].distance = triangles[i].distance(triangles[j]);
                    distances[k].index1 = i;
                    distances[k].index2 = j;
                    k++;
                }
            }
        }

        boolean isSorted = false;
        Distances buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < distances.length - 1; i++) {
                if (distances[i].distance > distances[i + 1].distance) {
                    isSorted = false;

                    buf = distances[i];
                    distances[i] = distances[i + 1];
                    distances[i + 1] = buf;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Closest " + (i + 1) + ". " + distances[i].index1 + " and " + distances[i].index2 +
                    " on distance " + distances[i].distance);
        }


    }

    private static int numberOfDistances(int numberOfCircles) {

        return factorial(numberOfCircles) / (factorial(numberOfCircles - 2) * 2);
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }


}
