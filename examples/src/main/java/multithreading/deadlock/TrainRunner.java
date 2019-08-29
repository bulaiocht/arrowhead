package multithreading.deadlock;

public class TrainRunner {
    public static void main(String[] args) {

        CrossRoad crossRoad = new CrossRoad();

        TrainOne t1 = new TrainOne(crossRoad);
        TrainTwo t2 = new TrainTwo(crossRoad);

        t1.setName("Train 1");
        t2.setName("Train 2");

        t1.start();
        t2.start();

    }
}
