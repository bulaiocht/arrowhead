package HomeTasks.HomeTaskThird.Task1;

public class Car {
    private String carBrand;
    private Engine engine;
    private Wheel[] wheels;

    public Car (){
        this.carBrand = "?";
        this.engine=new Engine(false);
        this.wheels = new Wheel[4];
        for (Wheel wheel:wheels) {
            wheel = new Wheel(true);

        }

    }
    public Car (int numberWheel,String carBrand,int howManyBrokenWheel,boolean fuel){
        this.carBrand = carBrand;
        this.engine = new Engine(fuel);
        this.wheels = new Wheel[numberWheel];
        for (Wheel wheel:wheels) {
            if (howManyBrokenWheel==0){
                wheel = new Wheel(false);
            }else {
                wheel = new Wheel(true);
                howManyBrokenWheel--;
            }


        }




    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels.clone();
    }
    public void drive(){

    }
    public void refuel (){
        this.engine.refuel();

    }
    public void changeWheel(Wheel wheel){
        wheel.changeWheel();

    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand=" + carBrand +
                '}';
    }
}
