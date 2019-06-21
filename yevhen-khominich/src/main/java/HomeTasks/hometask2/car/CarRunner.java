package car;

public class CarRunner {
    public static void main(String[] args) {
        Car mazda = new Car("Mazda");
        mazda.showMark();
        mazda.ride(15);
        mazda.changeWheel(3);
        mazda.ride(20);
        mazda.fuelCar(10);

    }
}
