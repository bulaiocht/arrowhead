package HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen;

import HomeTasks.HomeTaskNineth.enums.pizzeria.kitchen.PizzaType;

import java.util.Objects;

public class Pizza implements Cloneable{
    private int id;
    private  int price;
    private  long time_cooking;
    private PizzaType pizza_type;
    private  String name;
    private  int customer;
    private boolean is_cooked = false ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getTime_cooking() {
        return time_cooking;
    }

    public void setTime_cooking(long time_cooking) {
        this.time_cooking = time_cooking;
    }

    public PizzaType getPizza_type() {
        return pizza_type;
    }

    public void setPizza_type(PizzaType pizza_type) {
        this.pizza_type = pizza_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public boolean isIs_cooked() {
        return is_cooked;
    }

    public void setIs_cooked(boolean is_cooked) {
        this.is_cooked = is_cooked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id &&
                time_cooking == pizza.time_cooking &&
                customer == pizza.customer &&
                is_cooked == pizza.is_cooked &&
                Objects.equals(price, pizza.price) &&
                pizza_type == pizza.pizza_type &&
                Objects.equals(name, pizza.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, time_cooking, pizza_type, name, customer, is_cooked);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("№ %-2s; "+
                "Name: %-10s;"+
                " Type: %-10s;" +
                " Time cooking %s minutes ;" +
                " Price %s$;",id,name,pizza_type,time_cooking,price);

    }
}
