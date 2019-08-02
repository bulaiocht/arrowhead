package HomeTasks.HomeTaskSixth.utils;


import HomeTasks.HomeTaskSixth.classes.Point;
import HomeTasks.HomeTaskSixth.classes.PolygonWithCoordinates;
import HomeTasks.HomeTaskSixth.interfaces.PointMarker;
import HomeTasks.HomeTaskThird.Task2.CircleWithCoordinates;

import HomeTasks.HomeTaskThird.Task2.TriangleWithCoordinates;

import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    /**
     a.) параметризованный метод, который будет принимать
     коллекцию фигур и находить N ближайших из них и возвращать их в виде коллекии.
**/
    public static List<List<? super PointMarker> > find(List<? extends PointMarker>collection ,
                                                    int n ){
        List<List<? super PointMarker>> collect  = new ArrayList<>();
        Map<Double,List<?super PointMarker>> mapShapes = new HashMap<>();
        for (int i = 0; i <collection.size() ; i++) {
            PointMarker shape1 = collection.get(i);
            for (int j = 1; j <collection.size() ; j++) {
                PointMarker shape2 = collection.get(j);
                List<PointMarker> list  = new ArrayList<>();
                list.add(shape1);
                list.add(shape2);
                if(shape1 instanceof CircleWithCoordinates &&
                    shape2 instanceof CircleWithCoordinates){

                mapShapes.put(((CircleWithCoordinates) shape1)
                        .distance(((CircleWithCoordinates) shape2).getCenter()),
                        list);


                }else if (shape1 instanceof TriangleWithCoordinates &&
                    shape2 instanceof TriangleWithCoordinates){
                mapShapes.put(((TriangleWithCoordinates) shape1)
                                .distance(((TriangleWithCoordinates) shape2)),
                        list);
                }else if (shape1 instanceof PolygonWithCoordinates &&
                    shape2 instanceof PolygonWithCoordinates){
                mapShapes.put(((PolygonWithCoordinates) shape1)
                                .distance(((PolygonWithCoordinates) shape2)),
                        list);
                }else {
                    double minDistance = 0;
                for (int k = 0; k < shape1.countPoint(); k++) {
                    for (int l = 0; l < shape2.countPoint() ; l++) {
                        if (minDistance>shape1.getListPoint().get(k).distance(shape2.getListPoint().get(l))){
                            minDistance=shape1.getListPoint().get(k).distance(shape2.getListPoint().get(l));



                        }
                    }
                }mapShapes.put(minDistance,list);



                }

            }

        }

        Set<Double> doubles = mapShapes.keySet();
        for (int i = 0; i <n ; i++) {
            Double aDouble = doubles.stream().min(Double::compareTo).orElse(0.0);
            collect.add(mapShapes.get(aDouble));
            mapShapes.remove(aDouble);
            doubles.remove(aDouble);
        }



        return collect;
    }

    /**
     b.) параметризованный метод, который будет принимать
     2 коллекции фигур и находить N ближайших из них и возвращать их в виде коллекии.
**/
    public static List<List<? super PointMarker> > find(List<? extends PointMarker >collection1,
                                                         List<? extends PointMarker >collection2,
                                                         int n){
        List<List<? super PointMarker>> collect  = new ArrayList<>();
        Map<Double,List<?super PointMarker>> mapShapes = new HashMap<>();
        for (int i = 0; i <collection1.size() ; i++) {
            PointMarker shape1 = collection1.get(i);
            for (int j = 0; j <collection2.size() ; j++) {
                PointMarker shape2 = collection2.get(j);
                List<PointMarker> list  = new ArrayList<>();
                list.add(shape1);
                list.add(shape2);
                if(shape1 instanceof CircleWithCoordinates &&
                        shape2 instanceof CircleWithCoordinates){

                    mapShapes.put(((CircleWithCoordinates) shape1)
                                    .distance(((CircleWithCoordinates) shape2).getCenter()),
                            list);


                }else if (shape1 instanceof TriangleWithCoordinates &&
                        shape2 instanceof TriangleWithCoordinates){
                    mapShapes.put(((TriangleWithCoordinates) shape1)
                                    .distance(((TriangleWithCoordinates) shape2)),
                            list);
                }else if (shape1 instanceof PolygonWithCoordinates &&
                        shape2 instanceof PolygonWithCoordinates){
                    mapShapes.put(((PolygonWithCoordinates) shape1)
                                    .distance(((PolygonWithCoordinates) shape2)),
                            list);
                }else {
                    double minDistance = 0;
                    for (int k = 0; k < shape1.countPoint(); k++) {
                        for (int l = 0; l < shape2.countPoint() ; l++) {
                            if (minDistance>shape1.getListPoint().get(k).distance(shape2.getListPoint().get(l))){
                                minDistance=shape1.getListPoint().get(k).distance(shape2.getListPoint().get(l));



                            }
                        }
                    }mapShapes.put(minDistance,list);



                }

            }

        }

        Set<Double> doubleSet = mapShapes.keySet();
        for (int i = 0; i <n ; i++) {
            Double aDouble = doubleSet.stream().min(Double::compareTo).orElse(0.0);
            collect.add(mapShapes.get(aDouble));
            mapShapes.remove(aDouble);
            doubleSet.remove(aDouble);
        }



        return collect;
    }

    /**
     c.) параметризованный метод, который будет принимать коллекцию фигур и предикат
     и возвращать коллекцию фигур отвечающих требованиям предиката.
**/
    public static List<? super PointMarker > findWithPredicate(List<? extends PointMarker >collection ,
                                                                 Predicate<? super PointMarker> predicate){


        List<? super PointMarker> collect = new ArrayList<>();

        for (PointMarker pointMarker : collection) {
            if (predicate.test(pointMarker)){
                collect.add(pointMarker);
            }
        }

        return collect;
    }


    /**
     d.*) парметризованный метод, который будет принимать две фигуры и определять пересекаются ли они.
      **/
    public static <T extends PointMarker> boolean isCross (T  shape1,T shape2){
        if (shape1 instanceof CircleWithCoordinates || shape2 instanceof CircleWithCoordinates)throw new IllegalArgumentException("asd");
        List<Point> listPoint1 = shape1.getListPoint();
        List<Point> listPoint2 = shape2.getListPoint();
        for (int i = 0; i < listPoint1.size(); i++) {
            Point point1 = listPoint1.get(i);
            Point point2;
            if(i==listPoint1.size()-1){
                point2 = listPoint1.get(0);
            }else {
                point2 = listPoint1.get(i++);
            }
            for (int j = 0; j < listPoint2.size(); j++) {
                Point point3 = listPoint2.get(j);
                Point point4;
                if(i==listPoint1.size()-1){
                    point4 = listPoint2.get(0);
                }else {
                    point4 = listPoint2.get(j++);
                }
                if (point1.getX()>=point2.getX()){
                    double tmp1 = point1.getX();
                    double tmp2 = point1.getY();
                    point1.setX(point2.getX());
                    point1.setY(point2.getY());
                    point2.setX(tmp1);
                    point2.setY(tmp2);
                }
                if (point3.getX()>=point4.getX()){
                    double tmp3 = point3.getX();
                    double tmp4 = point4.getY();
                    point3.setX(point4.getX());
                    point3.setY(point4.getY());
                    point4.setX(tmp3);
                    point4.setY(tmp4);

                }
                double k1 = (point2.getY()-point1.getY())/(point2.getX()-point1.getY());
                double k2 = (point4.getY()-point3.getY())/(point4.getX()-point3.getY());
                if (k1==k2){
                    break;
                }

                double b1 = point1.getY() - (k1*point1.getX());
                double b2 = point3.getY() - (k2*point3.getX());

                double x = (b2-b1)/k2-k1;
                double y = k1*x+b1;

                if ((point1.getX()<=point4.getX()&&point4.getX()<=point2.getX())
                        ||(point1.getX()<=point3.getX()&&point3.getX()<=point2.getX())){
                    return true;
                }




            }

        }
        return false;
    }

    public static List<Point> generatorPoint (int n){
        return Stream.generate(Point::new)
                .peek(point ->{ point.setX(Math.random()*10);
                        point.setY(Math.random()*10);})
                .limit(n)
                .collect(Collectors.toList());
    }



}
