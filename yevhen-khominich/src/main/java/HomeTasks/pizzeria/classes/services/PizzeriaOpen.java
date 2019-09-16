package HomeTasks.pizzeria.classes.services;

public class PizzeriaOpen extends Thread {

    static boolean working = true;

    public static void offPizzeria() {
        working = false;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(3000);
                ProccesOrder.takeOrder();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
