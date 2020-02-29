package HomeTasks.pizzeria.classes.objects;

import HomeTasks.pizzeria.type.PizzaType;

public class Pizza {

    private int id;
    private float price;
    private float timeOfCooking;
    private PizzaType type;
    private String name;
    private boolean isCooked;

    public Pizza(){

    }

    public Pizza(int id, float price, float timeOfCooking, PizzaType type, String name) {
        this.id = id;
        this.price = price;
        this.timeOfCooking = timeOfCooking;
        this.type = type;
        this.name = name;
        this.isCooked=false;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public float getTimeOfCooking() {
        return timeOfCooking;
    }

    public PizzaType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean isCooked() {
        return isCooked;
    }

    public void setCooked(boolean cooked) {
        isCooked = cooked;
    }

    @Override
    public String toString() {
        return name;
    }


}
