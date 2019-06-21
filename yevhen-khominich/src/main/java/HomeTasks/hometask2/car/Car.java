package car;

public class Car {
    private String mark;
    private Wheel[] wheels = {new Wheel(1, "origin"), new Wheel(2, "origin"), new Wheel(3, "origin"), new Wheel(4, "origin")};
    private Engine engine = new Engine();
    private int fuel = 40;

    public Car() {
    }

    public Car(String mark) {
        this.mark = mark;
    }

    public Car(String mark, int fuel) {
        this.mark = mark;
        this.fuel = fuel;
    }


    public void ride(int wasteFuel) {

        System.out.println("Car start going");
        engine.setStart(true);
        this.fuel = this.fuel - wasteFuel;
        System.out.println("Now fuel is " + fuel);
    }

    public void fuelCar(int fuelIn) {
        engine.setStart(false);
        this.fuel += fuelIn;
        System.out.println("Fuel car " + "Now fuel is " + fuel);
    }

    public void changeWheel(int numberOfWheel) {
        engine.setStart(false);
        wheels[numberOfWheel] = new Wheel(numberOfWheel, "changed");
        System.out.println("Wheel is " + numberOfWheel + " changed ");
    }

    public void showMark() {
        System.out.println("Mark of Car: " + this.mark);
    }

}
