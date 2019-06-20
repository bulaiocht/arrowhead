package HomeTask.ThirdTask.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CircleWithCoordinates[] circleWithCoordinates = new CircleWithCoordinates[5];
        for (int i = 0; i < circleWithCoordinates.length; i++) {
            circleWithCoordinates[i] = new CircleWithCoordinates(new Point(50-i*5,50-i*5));
        }
        search(circleWithCoordinates);

         CircleWithCoordinates cwc = new CircleWithCoordinates(new Point(20,20), 8.0);
        System.out.println(cwc.getPerimeter());
    }

    public static void search(CircleWithCoordinates[] arr){
        double[][] distansec = new double[arr.length][arr.length];
        CircleWithCoordinates[] closest = new CircleWithCoordinates[2];
        for (int i = 0; i < distansec.length; i++) {
            for (int j = 0; j < distansec[i].length; j++) {
                if (i == j) {
                    distansec[i][j] = -1;
//                    continue;
                } else {
                    distansec[i][j] = arr[i].distance(arr[j].getCenter());
                }
            }
        }
        double minDistance = distansec[0][1];
        closest[0] = arr[0];
        closest[1] = arr[1];
        for (int i = 0; i < distansec.length; i++) {
            for (int j = 0; j < distansec[i].length; j++) {
                if(distansec[i][j]>-1&&distansec[i][j]<minDistance){
                    closest[0] = arr[i];
                    closest[1] = arr[j];
                    System.out.println(closest[0].getCenter()+" "+closest[1].getCenter());
                }
            }
        }
//        System.out.println(Arrays.toString(distansec));
        System.out.println("Closest circle with centers: "+closest[0].getCenter()+", "+closest[1].getCenter());
    }
}
