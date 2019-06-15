package home_work.num_2.Vehicle;

public class TestAuto {
    public static void main(String[] args) {
        Automobile audi = new Automobile(4, "A8");

        audi.getName();

        audi.refuel();

        audi.changeAWheel();

        audi.drive();
    }
}
