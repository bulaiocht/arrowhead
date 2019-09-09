package HomeTasks.pizzeria.classes.objects;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int idOfOrder;
    List<Pizza> pizzas;
    private boolean isReady;

    public int getIdOfOrder() {
        return idOfOrder;
    }

    public Order(int idOfOrder) {
        this.idOfOrder = idOfOrder;
        pizzas = new ArrayList<>();
        isReady = false;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isReady() {
        return isReady;
    }
}
