package multithreading.deadlock;

public class TrainOne extends Thread {

    private final CrossRoad crossRoad;

    public TrainOne(CrossRoad crossRoad) {
        this.crossRoad = crossRoad;
    }

    @Override
    public void run() {
        while (true) {
            crossRoad.crossA();
        }
    }
}
