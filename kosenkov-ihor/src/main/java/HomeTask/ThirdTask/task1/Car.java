package HomeTask.ThirdTask.task1;

public class Car {

    private Engine engine = new Engine();
    private Wheel[] wheel;
    private String carBrand;

    private int numberOfWheels;

    public Car() {
        this.carBrand = "Undefined";
        this.numberOfWheels = 4;
        wheel = new Wheel[numberOfWheels];
        for (Wheel wheel1 : wheel) {
            wheel1 = new Wheel();
        }

    }

    public Car(int numberOfWheels, String carBrand){
        this.carBrand = carBrand;
        this.numberOfWheels = numberOfWheels;
        wheel = new Wheel[numberOfWheels];
        for (Wheel wheel1 : wheel) {
            wheel1 = new Wheel();
        }
    }

    public boolean isCarDrive(){
        return engine.isEngineWork();
    }

    public void drive(){
        engine.setEngineWork(true);
    }

    public void refuel(){
        engine.setEngineWork(false);
    }

    public void changeWheel(int numberOfWheel){
        engine.setEngineWork(false);
        wheel[numberOfWheel] = new Wheel();
    }

    public void printCarBrand(){
        System.out.println(carBrand);
    }

}
