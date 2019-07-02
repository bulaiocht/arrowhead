package HomeTasks.HomeTask2e1;

public abstract class Car extends Wheel{

    void drive (){
        System.out.println("car model");
    }

    @Override
    public abstract int changeWheel();

    @Override
    public abstract int refuel();

}
