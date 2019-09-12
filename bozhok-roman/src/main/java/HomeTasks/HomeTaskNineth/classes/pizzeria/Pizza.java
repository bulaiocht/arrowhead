package HomeTasks.HomeTaskNineth.classes.pizzeria;

public class Pizza {

    private final int ID;
    private final String PRICE;
    private final long TIME_COOKING;
    private final PizzaType PIZZA_TYPE;
    private final String NAME;
    private final int ID_USER;
    private boolean IS_COOKED = false;





    public Pizza(String price, long time_cooking, PizzaType pizza_type, String name, int id, int id_user) {
        this.PRICE = price;
        this.TIME_COOKING = time_cooking;
        this.PIZZA_TYPE = pizza_type;
        this.NAME = name;
        this.ID = id;
        this.ID_USER = id_user;
    }
    public void setIS_COOKED() {
        this.IS_COOKED = true;
    }

    public long getTIME_COOKING() {
        return TIME_COOKING;
    }

    public boolean IS_COOKED() {
        return IS_COOKED;
    }
}
