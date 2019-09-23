package HomeTask.NinthTask.pizzeria.entity;

import java.util.Objects;

public class Pizza {

    private String title;
    private PizzaType pizzaType;
    private double price;
    private long cookingTime;
    private int OrderID;
    private boolean cooked = false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(long cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public boolean isCooked() {
        return cooked;
    }

    public void setCooked(boolean cooked) {
        this.cooked = cooked;
    }
    @Override
    public String toString() {
        return String.format("Пицца %-17s |(%-18s |цена %.2fгрн, |время приготовления %dc"
                ,title
                ,pizzaType.getName()+"),"
                ,price
                ,cookingTime/1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return title.equals(pizza.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
