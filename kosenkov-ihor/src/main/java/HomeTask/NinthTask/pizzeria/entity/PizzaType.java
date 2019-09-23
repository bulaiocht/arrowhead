package HomeTask.NinthTask.pizzeria.entity;

public enum PizzaType {
    MEAT("Мясная"),
    VEGETARIAN("Вегетарианская"),
    WITH_SEAFOOD("С морепродуктами");

    private String name;

    PizzaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
