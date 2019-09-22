package multithreading.deadlock;

public class TrainTwo extends Thread {

    private final CrossRoad crossRoad;

    public TrainTwo(CrossRoad crossRoad) {
        this.crossRoad = crossRoad;
    }

    @Override
    public void run() {
        while (true) {
            crossRoad.crossB();
        }
    }
}
