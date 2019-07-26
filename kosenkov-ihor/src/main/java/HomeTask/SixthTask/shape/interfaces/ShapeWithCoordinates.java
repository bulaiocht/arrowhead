package HomeTask.SixthTask.shape.interfaces;

public interface ShapeWithCoordinates extends Shape{

    default double distance(ShapeWithCoordinates shape) {
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
            if(distances[i]<distance) distance = distances[i];
        }
        return distance;
    }

}
