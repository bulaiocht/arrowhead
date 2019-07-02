package HomeTasks.HomeTask2e1;
//Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
// Методы: ехать, заправляться, менять колесо,
// вывести на консоль марку автомобиля.
public class Test {
    public static void main(String[] args) {
        Car car = new Car() {
            @Override
            public int changeWheel() {
                return 0;
            }

            @Override
            public int refuel() {
                return 0;
            }
        };
        car.drive();
    }
}
