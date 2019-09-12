package HomeTasks.HomeTaskNineth.classes.pizzeria.hall;

import HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int ID;
    private List<Pizza> pizzaList ;
    private int priceForOrder ;
    private boolean isReady = false;

    public Order(int id) {
        this.ID = id;
        this.pizzaList = new ArrayList<>();
    }

    public void setReady() {
        this.isReady = true;

    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public int getID() {
        return ID;
    }

    public boolean isReady() {
        return isReady;
    }
    public void addPizzaOrder(Pizza pizza){
        this.pizzaList.add(pizza);
    }

    public void setPriceForOrder(int priceForOrder) {
        this.priceForOrder = priceForOrder;
    }

    public int getPriceForOrder() {
        return pizzaList.stream()
                .mapToInt(l -> l.getPrice())
                .sum();
    }
}
