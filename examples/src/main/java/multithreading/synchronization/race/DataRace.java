package multithreading.synchronization.race;

public class DataRace {
    public static void main(String[] args) {

        SharedData data = new SharedData();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                data.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                data.dataRaceCheck();
            }
        });

        t1.start();
        t2.start();

    }

    private static class SharedData {

        private volatile int x;
        private volatile int y;

        public void increment() {
            x++;
            y++;
        }

        public void dataRaceCheck() {
            if (y > x) {
                System.err.println("Data race detected!");
            }
        }

    }
}
