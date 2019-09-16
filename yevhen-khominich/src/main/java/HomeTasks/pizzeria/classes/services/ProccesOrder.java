package HomeTasks.pizzeria.classes.services;

import HomeTasks.pizzeria.classes.objects.Order;

import java.util.List;

public class ProccesOrder extends Thread {

    private Order currentOrder;

    @Override
    public void run() {
        Chef.processOrder(currentOrder);
    }

    public static void takeOrder() {

        List<Order> orders = Chef.getOrders();

        if (orders.size() == 0) {
            try {
                sleep(2000);
                takeOrder();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }

        for (Order order : orders) {
            if (!order.isReady()) {

                ProccesOrder proccesOrder = new ProccesOrder();
                proccesOrder.setCurrentOrder(order);
                proccesOrder.start();

                try {
                    proccesOrder.join();
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                break;
            }
        }

    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
