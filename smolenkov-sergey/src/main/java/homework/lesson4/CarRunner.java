package homework.lesson4;

public class CarRunner {
    public static void main(String[] args) {
        Car car = new Car();
        initializeCar(car);
        System.out.println(car.getCarName());
        car.ride();
        car.chargeFuel(100);
        car.ride();
        car.startEngine();
        car.changeWheel(21);
        car.ride();
        System.out.println("Level of fuel is " + car.getFuel() + " liters.");
        car.chargeFuel(119);
        car.ride();
        car.startEngine();
        car.ride();
        car.changeWheel(20);
        System.out.println("Level of fuel is " + car.getFuel() + " liters.");

        System.out.println(car.toString());
    }

    public static void initializeCar(Car car){
        car.setExpense(5);
        car.setCarName("Volga");
        car.setTank(120);
    }
}
