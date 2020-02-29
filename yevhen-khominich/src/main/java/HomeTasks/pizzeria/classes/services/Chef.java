package HomeTasks.pizzeria.classes.services;


import HomeTasks.pizzeria.classes.objects.Order;
import HomeTasks.pizzeria.classes.objects.Pizza;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Chef {

    private static List<Order> orders;

    public static List<Order> getOrders() {
        return orders;
    }

    static {
        orders = new ArrayList<>();
    }

    public static void addToChef(Order order) {
        orders.add(order);
    }

    public static void processOrder(Order currentOrder) {

        for (Pizza pizza : currentOrder.getPizzas()) {
            Chef.cook(pizza);
            PizzaService.notifyAboutPizza(pizza,currentOrder);
        }
        currentOrder.setReady(true);
        PizzaService.notifyAboutOrder(currentOrder);
        PizzaService.giveCheck(currentOrder);

    }

    private static void cook(Pizza pizza) {
        for (int i = 0; i < pizza.getTimeOfCooking(); i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pizza.setCooked(true);

    }

}