package HW2.Car;
//1. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
// Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.

public class Car {
    String label;
    int gasTank=10;
    private Wheel wheels[] = new Wheel[4];
    final static int FRONT_RIGHT_WHEEL = 0;
    final static int FRONT_LEFT_WHEEL = 1;
    final static int BACK_LEFT_WHEEL = 2;
    final static int BACK_RIGHT_WHEEL = 3;
    int x=0;
    int y=0;
    Engine engine = new Engine();

    public Car(String label) {
        this.label = label;
        for (int i=0;i<4;i++) {
            wheels[i]=new Wheel();
        }
    }

    public class Engine {
       void startEngine (){
           System.out.println("Vroom, vroom, vroom!");
       }

       void rollingWheels (){
           for (Wheel wheel:wheels) {
               wheel.rollTheWheel();
           }
       }
    }

    void drive(int x, int y) {
        if (gasTank==0){
            System.out.println("Low fuel!");
        } else {
        engine.startEngine();
        this.x=x;
        this.y=y;
        gasTank--;}

    }

    void refuel() {
        gasTank=10;
    }

    void changeWheel(Wheel wheel, int position) {

        if (position > wheels.length)
            return;
        wheels[position] = wheel;
    }

    public static void main(String[] args) {

        Car car = new Car("Toyota");

        car.engine.rollingWheels();
        car.drive(10,15);
        car.refuel();
        car.changeWheel(new Wheel(), FRONT_LEFT_WHEEL);

        car.showLabel();

    }

    void showLabel() {
        System.out.println(label);
    }
}
