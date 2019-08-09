package HomeTask.SixthTask.shape.interfaces;

public interface ShapeWithCoordinates extends Shape{

    default double distance(ShapeWithCoordinates shape) {

//        Set<Point> points = shape.getPoints();
//        Set<Point> myPoints = this.getPoints();

//        return myPoints
//                .stream()
//                .map(p1 -> points.stream().map(p2 -> p2.distance(p1)))
//                .flatMap(Function.identity())
//                .min(Double::compareTo)
//                .orElseThrow(IllegalArgumentException::new);


        double[] distances = new double[this.getNumberOfPoint()*shape.getNumberOfPoint()];

        int k = 0;
        for (int i = 0; i < this.getNumberOfPoint(); i++) {
            for (int j = 0; j < shape.getNumberOfPoint(); j++) {
                distances[k] = this.getPoint(i).distance(shape.getPoint(j));
                k++;
            }
        }

        double distance = distances[0];
        for (int i = 1; i < distances.length; i++) {
            if(distances[i]<distance)
                distance = distances[i];
        }
        return distance;
    }

}
