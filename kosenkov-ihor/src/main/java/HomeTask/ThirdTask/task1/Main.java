package HomeTask.ThirdTask.task1;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car(4,"Lamborghini");

        car1.printCarBrand();
        System.out.println(car1.isCarDrive());
        car1.drive();
        System.out.println(car1.isCarDrive());
        car1.refuel();
        System.out.println(car1.isCarDrive());
        car1.drive();
        System.out.println(car1.isCarDrive());
        car1.changeWheel(2);
        System.out.println(car1.isCarDrive());

    }
}
