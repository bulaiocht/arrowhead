package HomeTask.NinthTask.pizzeria.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {


    private static int count = 1;
    private int orderID;
    private List<Pizza> pizzas = new ArrayList<>();
    private long orderCookingTime = 0;
    private double orderPrice = 0;
    private boolean ready;

    public Order() {
        orderID = count++;
        ready = false;
    }

    public int getOrderID() {
        return orderID;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public long getOrderCookingTime() {
        return orderCookingTime;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public boolean isReady() {
        return ready;
    }

    public static int getCount() {
        return count;
    }

    public void addPizza(Pizza pizza){
        orderPrice += pizza.getPrice();
        orderCookingTime += pizza.getCookingTime();

        pizzas.add(pizza);
    }

    @Override
    public String toString() {
        return String.format("Заказ №%d:\n%s\nЦена заказа: %.2fгрн\nОбщее время приготовления %dc.\n"
                , orderID,pizzas.
                stream()
                .map(Pizza::toString)
                .collect(Collectors.joining("\n"))
                ,orderPrice
                ,orderCookingTime/1000);
    }
}
