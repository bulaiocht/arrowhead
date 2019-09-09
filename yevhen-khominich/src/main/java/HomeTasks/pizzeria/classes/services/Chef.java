package HomeTasks.pizzeria.classes.services;


import HomeTasks.pizzeria.classes.objects.Order;
import HomeTasks.pizzeria.classes.objects.Pizza;

public class Chef extends Thread {

    //Пока выполняется, не может принять другой !

    //  private static int counter = 1;
    private Order currentOrder;
    //    private static Map<Integer, Order> orders = new HashMap<>();
    private Chef chef;

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
//
//    public static void work() {
//        Chef chef = new Chef();
//        chef.start();
//
//        for (int i = counter; i < orders.size() + 1; i++) {
//            if (orders.size() == 0 || currentOrder.isReady()) {
//                setCurrentOrder(orders.get(i));
//            }
//        }
//
//
//    }

//    public static void setOrders(Map<Integer, Order> ordersFrom) {
//        orders = ordersFrom;
//    }


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