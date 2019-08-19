package multithreading.deadlock;

public class CrossRoad {

    private final Object sectionA = new Object();
    private final Object sectionB = new Object();

    public void crossA() {
        synchronized (sectionA) {
            System.out.println(Thread.currentThread().getName() + " blocked section A");
            synchronized (sectionB){
                System.out.println(Thread.currentThread().getName() + " going through section B");
            }
        }
    }

    public void crossB() {
        synchronized (sectionA) {
            System.out.println(Thread.currentThread().getName() + " blocked section A");
            synchronized (sectionB) {
                System.out.println(Thread.currentThread().getName() + " going through section B");
            }
        }
    }



}
