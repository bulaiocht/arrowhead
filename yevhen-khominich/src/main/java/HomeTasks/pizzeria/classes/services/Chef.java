package HomeTasks.pizzeria.classes.services;


import HomeTasks.pizzeria.classes.objects.Order;
import HomeTasks.pizzeria.classes.objects.Pizza;

public class Chef extends Thread {

    private Order currentOrder;
    private Chef chef;

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public void run() {
        // Обработка заказа, готовка, обсчет счета
        processOrder();
    }

    public void processOrder() {

        for (Pizza pizza : currentOrder.getPizzas()) {
            chef.cook(pizza);
        }
        currentOrder.setReady(true);
        PizzaService.notifyAboutOrder(currentOrder);
        PizzaService.giveCheck(currentOrder);

    }

    private void cook(Pizza pizza) {
        for (int i = 0; i < pizza.getTimeOfCooking(); i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pizza.setCooked(true);
        PizzaService.notifyAboutPizza(pizza, currentOrder);
    }

}