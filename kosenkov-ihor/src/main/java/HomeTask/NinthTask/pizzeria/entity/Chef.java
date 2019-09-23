package HomeTask.NinthTask.pizzeria.entity;

import java.util.ArrayList;
import java.util.List;

public class Chef extends Thread{

    private List<Order> orders = new ArrayList<>();
    private Order currentOrder;
    private boolean free = true;



    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                waitOrder();
                cook();
            }
            throw new InterruptedException();
        } catch (InterruptedException e) {
            System.out.println("Шеф пошел отдыхать!");
        }
    }

    private void cook() throws InterruptedException {
        if (orders.size() > 0) {
            currentOrder = orders.get(0);
            for (int i = 0; i < currentOrder.getPizzas().size(); i++) {
                sleep(currentOrder.getPizzas().get(i).getCookingTime());
            }
            System.out.printf("Заказ №%d готов!\n", currentOrder.getOrderID());
            orders.remove(currentOrder);
        } else {
            free = true;
        }
    }

    public void takeOrder(Order order) {
        orders.add(order);
        free = false;
    }

    private void waitOrder() throws InterruptedException {
        while (free) {
            sleep(2000);
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public boolean isFree() {
        return free;
    }
}
