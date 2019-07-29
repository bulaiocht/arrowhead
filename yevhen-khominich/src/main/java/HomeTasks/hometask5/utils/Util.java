package HomeTasks.hometask5.utils;

import HomeTasks.hometask5.interfaces.FigureWithCoord;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Util {

    //a) параметризованный метод, который будет принимать
    //       коллекцию фигур и находить N ближайших из них и возвращать их в виде коллекии.

    public static <T extends FigureWithCoord> List<List<T>> searchNearFigures(int n, List<T> figures) {

        SortedMap<Double, List<T>> map = new TreeMap();
        List<List<T>> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < figures.size() - 1; i++) {
            for (int j = 1; j < figures.size(); j++) {
                if (i >= j) continue;
                List<T> pairFigures = new ArrayList<>();
                pairFigures.add(figures.get(i));
                pairFigures.add(figures.get(j));
                double dist = figures.get(i).distanceTo(figures.get(j));
                map.put(dist, pairFigures);

            }
        }

        for (List<T> pair : map.values()) {
            if (count == n) break;
            result.add(pair);
            count++;
        }

        return result;
    }

    //  b) параметризованный метод, который будет принимать
    //   2 коллекции фигур и находить N ближайших из них и возвращать их в виде коллекии.

    public static <T extends FigureWithCoord> List<List<T>> searchNearFigures(int n, List<T> figures1, List<T> figures2) {
        SortedMap<Double, List<T>> map = new TreeMap();
        List<List<T>> result = new ArrayList<>();
        int count = 0;

        for (T figure1 : figures1) {
            for (T figure2 : figures2) {
                List<T> pairFigures = new ArrayList<>();
                double dist = figure1.distanceTo(figure2);
                pairFigures.add(figure1);
                pairFigures.add(figure2);
                map.put(dist, pairFigures);
            }
        }

        for (List<T> pair : map.values()) {
            if (count == n) break;
            result.add(pair);
            count++;
        }

        return result;

    }


    //   c) параметризованный метод, который будет принимать коллекцию фигур и предикат
    //       и возвращать коллекцию фигур отвечающих требованиям предиката.
    public static List<? extends FigureWithCoord> findWithPredicate(List<? extends FigureWithCoord> list,
                                                                    Predicate<? super FigureWithCoord> predicate) {

        List<? extends FigureWithCoord> collect = list.stream()
                .filter(predicate).collect(Collectors.toList());

        return collect;

    }

    //d.*) парметризованный метод, который будет принимать две фигуры и определять пересекаются ли они.

}