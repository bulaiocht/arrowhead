package HW03.HW03o1;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", true);
        Car car2 = new Car("Cherry", false);
        Car car3 = new Car("Chevrolet", false);

        car1.getBrand();
        car1.checkTires();
        car1.getFuel();
        car1.move();
        System.out.println("========");
        car2.getFuel();
        car2.move();
        System.out.println("========");
        car3.getBrand();
        car3.move();
    }
}