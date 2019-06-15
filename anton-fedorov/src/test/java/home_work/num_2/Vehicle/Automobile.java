package home_work.num_2.Vehicle;

public class Automobile {
    private String name;

    private final Wheel wheel;
    private final Engine engine;

    public Automobile(int wheelAmount, String name) {
        wheel = new Wheel(wheelAmount);
        engine = new Engine();
        this.name = name;
    }

    public void refuel() {
        System.out.println("Refuel fuel");
    }

    public void getName() {
        System.out.println(name);
    }

    public void changeAWheel() {
        this.wheel.changeAWheel();
    }

    public void drive() {
        this.engine.drive();
    }
}
