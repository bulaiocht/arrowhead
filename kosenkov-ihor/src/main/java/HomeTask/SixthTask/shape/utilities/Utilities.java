package HomeTask.SixthTask.shape.utilities;

import HomeTask.SixthTask.shape.classes.Point;
import HomeTask.SixthTask.shape.classes.TriangleWithCoordinates;
import HomeTask.SixthTask.shape.interfaces.ShapeWithCoordinates;

import java.util.*;
import java.util.function.Predicate;

public class Utilities {

    public static List<? super ShapeWithCoordinates> getClosestFigures(List<? extends ShapeWithCoordinates> shapes, int numberOfFigures){

        List<? super ShapeWithCoordinates> result = new ArrayList<>();

        double[][] distances = new double[shapes.size()][shapes.size()];

        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size(); j++) {
                distances[i][j] = shapes.get(i).distance(shapes.get(j));
            }
            Arrays.sort(distances[i]);
        }
//        Arrays.sort(distances, (Comparator.comparingDouble(doubles -> doubles[1])));

        // Сортируем дистанции и сами фигуры чтобы потом перебором нужное количество раз возвращали нужное кол-во фигур
        bubbleSort(distances, shapes);

        // Кладем в результирующий массив нужное количество фигур
        // Если количество нужных нам фигур меньше всех фигур, то выводим все отсортированные фигуры
        if (shapes.size() < numberOfFigures) {
            result.addAll(shapes);
            return result;
        }

        for (int i = 0; i < numberOfFigures; i++) {
            result.add(shapes.get(i));
        }

        return result;

    }

    public static List<? super ShapeWithCoordinates> getClosestFigures(List<? extends ShapeWithCoordinates> shapes1, List<? extends ShapeWithCoordinates> shapes2, int numberOfFigures){

        List< ShapeWithCoordinates> listJoin = new ArrayList<>(shapes1);
        listJoin.addAll(shapes2);

        return getClosestFigures(listJoin, numberOfFigures);

    }

    public static List<? super ShapeWithCoordinates> sortWithPredicate(List<? extends ShapeWithCoordinates> shapes, Predicate<? super ShapeWithCoordinates> predicate) {

        List<ShapeWithCoordinates> result = new ArrayList<>();

        for (ShapeWithCoordinates shape :
                shapes) {
            boolean isSatisfy = predicate.test(shape);
            if (isSatisfy) result.add(shape);
        }

        return result;

    }

    public static<T extends ShapeWithCoordinates> boolean isIntersect(T shape1, T shape2) {

        for (int i = 0; i < shape1.getNumberOfPoint(); i++) {
            for (int j = 0; j < shape2.getNumberOfPoint(); j++) {
                if ((i == shape1.getNumberOfPoint() - 1) || (j == shape2.getNumberOfPoint() - 1)) {
                    return isIntersect(shape1.getPoint(i), shape1.getPoint(0), shape2.getPoint(j), shape2.getPoint(0));
                }
                if (isIntersect(shape1.getPoint(i), shape1.getPoint(i+1), shape2.getPoint(j), shape2.getPoint(j+1))) return true;
            }
        }
        return false;
    }

    private static <T extends ShapeWithCoordinates>void bubbleSort(double[][] arr, List<T> shapes) {
        for (int i = 0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[i][1] > arr[j][1]) {
                    double[] t = arr[i];                         //========================================
                    arr[i] = arr[j];                             // Делаем сортировку массива с дистанциями
                    arr[j] = t;                                  //========================================
                    T tswc = shapes.get(i);   //========================================
                    shapes.set(i, shapes.get(j));                // Сортируем сами фигуры по дистанции
                    shapes.set(j, tswc);                         //========================================
                }
            }
        }
    }

    private static boolean isIntersect(Point A, Point B, Point C, Point D) {

        // Шаг 1. Ввод данных (x1;y1) (x2; y2) (x3;y3) (x4; y4)
        double x1 = A.getX();
        double x2 = B.getX();
        double x3 = C.getX();
        double x4 = D.getX();

        double y1 = A.getY();
        double y2 = B.getY();
        double y3 = C.getY();
        double y4 = D.getY();

        double k1;
        double k2;

        double b1;
        double b2;

        // Шаг 2. Если x1 ≥ x2 то  меняем между собой значения x1 и x2 и y1 и y2
        if (x1 >= x2) {
            double tmp = x1;
            x1 = x2;
            x2 = tmp;
            tmp = y1;
            y1 = y2;
            y2 = tmp;
        }

        // Шаг 3. Если x3 ≥ x4 то  меняем между собой значения x3 и x4 и y3 и y4
        if (x3 >= x4) {
            double tmp = x3;
            x3 = x4;
            x4 = tmp;
            tmp = y3;
            y3 = y4;
            y4 = tmp;
        }

        // Шаг 4. Проверяем, равны ли между собой  у2 и у1,
        // если у2 = у1 да, то принимаем  k1 = 0 иначе
        // Определяем угловой коэффициент в уравнении прямой:
        // k1 =  ( у2 - у1 ) / ( x2 - x1 )
        if (y2 == y1) k1 = 0;
        else k1 = (y2 - y1) / (x2 - x1);

        // Шаг 5. Проверяем, равны ли между собой  у3 и у4,
        // если у3 = у4 да, то принимаем  k2 = 0 иначе
        // Определяем угловой коэффициент в уравнении прямой:
        // k2 =  ( у4 - у3 ) / ( x4 - x3 )
        if (y3 == y4) k2 = 0;
        else k2 = (y4 - y3) / (x4 - x3);

        // Шаг 6.  Проверим отрезки на параллельность.
        // Если k1 = k2 , то прямые параллельны и отрезки пересекаться не могут. Решение задачи прекращаем.
        if (k1 == k2) return false;

        // Шаг 7. Вычисляем значения свободных переменных
        // Определяем свободные члены в уравнении прямой:
        // b1 = у1 - k1 * x1
        // b2 = у3  - k2 * x3
        b1 = y1 - k1 * x1;
        b2 = y3 - k2 * x3;

        // Шаг 8. Решаем систему уравнений:
        // y = k1 x + b1
        // y = k2 x + b2
        //
        // Если прямые имеют точку пересечения, то
        // k1 x + b1 = k2 x + b2
        //
        // Откуда и вычисляем точку пересечения прямых
        // x = ( b2 - b1 ) / ( k1 -  k2 )
        // y = k1 x + b1.
        double x = (b2 - b1) /(k1 - k2);
        double y = k1 * x + b1;

        // Шаг 9.Учтем, что точка пересечения прямых может лежать вне отрезков, принадлежащих этим прямым.
        // Таким образом, если отрезки пересекаются, то, поскольку
        // x1 ≤ x2; x3 ≤ x4;
        // должны выполняться условия:
        // x1  ≤ x4 и x4  ≤ x2
        // или
        // x1  ≤ x3 и x3  ≤ x2
        //
        // Если одно из двух условий верно, то отрезки имеют точку пересечения, иначе - отрезки не пересекаются.
        return (x1 <= x4 && x4 <= x2) || (x1 <= x3 && x3 <= x2);


    }

}
