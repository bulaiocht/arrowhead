package HomeTasks.HomeTaskNineth.classes.pizzeria;

public class ChefThread extends Thread {

    private Pizza pizza;

    public ChefThread (Pizza pizza){
        this.pizza=pizza;

    }

    @Override
    public void run() {
        try {
            sleep(pizza.getTIME_COOKING());
            pizza.setIS_COOKED();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
