package HomeTasks.HomeTaskThird.Task2;

public class Main {
    public static void main(String[] args) {
        CircleWithCoordinates[] circleWithCoordinates = new CircleWithCoordinates[5];
        for (int i = 0; i < circleWithCoordinates.length; i++) {
            int j = (int)(Math.random()*50);
            circleWithCoordinates[i] = new CircleWithCoordinates(new Point(Math.random()*j,Math.random()*j));

        }
        searchClosestCyrcle(circleWithCoordinates);
    }

    public static void searchClosestCyrcle (CircleWithCoordinates[] circles){
        double minDistance= circles[0].distance(circles[1].getCenter());
        int index1 = 0 ;
        int index2 = 1 ;

        for (int i = 0; i < circles.length; i++) {
            for (int j = 0; j <circles.length ; j++) {

                if (minDistance>circles[i].distance(circles[j].getCenter())){
                    minDistance=circles[i].distance(circles[j].getCenter());
                    index1=i;
                    index2=j;


                }
            }

        }
        System.out.println("Closest Cyrcle with center : " + circles[index1].getCenter() + "," + circles[index2].getCenter());

    }
    public static void searchClosestTriangle(TriangleWithCoordinates[] triangles){

    }

}
