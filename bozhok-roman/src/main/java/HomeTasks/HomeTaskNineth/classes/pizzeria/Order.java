package HomeTasks.HomeTaskNineth.classes.pizzeria;

import java.util.List;

public class Order {

    private final int ID;
    private List<Pizza> pizzaList;
    private boolean isReady = false;

    public Order(int id,Pizza ... pizzas) {
        this.ID = id;
        for (Pizza pizza : pizzas) {
            this.pizzaList.add(pizza);
        }
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
}
