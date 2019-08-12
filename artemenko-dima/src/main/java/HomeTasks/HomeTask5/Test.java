package HomeTasks.HomeTask5;

import HomeTasks.HomeTask5.Classes.Circle;
import HomeTasks.HomeTask5.Classes.Distance;
import HomeTasks.HomeTask5.Classes.Point;
import HomeTasks.HomeTask5.Classes.Triangle;
import HomeTasks.HomeTask5.Utilities.DistanceList;
import HomeTasks.HomeTask5.Utilities.FiguresAndPredicate;
import HomeTasks.HomeTask5.Utilities.JoinLists;
import HomeTasks.HomeTask5.Utilities.NClosestFigures;

import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args ) {

        System.out.print( "Enter the number (more than 4) of geometric shapes to be verified: " );
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt( );

        System.out.println( "==============================" + "\n" +
                "Circle collection :" + "\n");

        List <Circle> circleList = new Circle().circles( n );

        System.out.println( "==============================" + "\n" +
                "Triangle collection :" + "\n");

        List <Triangle> triangleList = new Triangle().triangles( n );

        System.out.println( "==============================" + "\n" +
                "Circle distance collection :" + "\n");

        List<Distance> distanceList1 = DistanceList.distanceList( circleList );

        System.out.println( "==============================" + "\n" +
                "3 coming figures :" + "\n");

        List<Distance> minDist = NClosestFigures.closestFigures( distanceList1, 3 );

        System.out.println( "==============================" + "\n" +
                "Figure distance collection :" + "\n");

        List<? extends Point> shapesAL = JoinLists.joinLists( circleList, triangleList );
        List<Distance> distanceArray2 = DistanceList.distanceList(shapesAL );

        System.out.println( "==============================" + "\n" +
                "3 coming figures :" + "\n");

        List<Distance> minDist2 = NClosestFigures.closestFigures( distanceArray2, 3 );

        System.out.println( "==============================" );

        System.out.print( "Predicate: circles with radius less than r. Enter the value of the radius r = " );
        Scanner sc2 = new Scanner( System.in );
        int r = sc2.nextInt( );

        FiguresAndPredicate.figuresAndPredicate( circleList, r );

        System.out.println( "==============================" );

    }
}
