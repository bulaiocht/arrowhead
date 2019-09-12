package HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen;

public class ChefThread extends Thread {

    private Pizza pizza;

    public ChefThread (Pizza pizza){
        this.pizza=pizza;

    }

    @Override
    public void run() {
        try {
            sleep(pizza.getTime_cooking()*1000);
            pizza.setIs_cooked(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
