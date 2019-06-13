package homework.lesson4;

public class Car {
    private final int FUEL = 0;

    private String carName;
    private int maxFuel;
    private int fuel;

    private Engine engine = new Engine(5);

    private Wheel frontRight = new Wheel();
    private Wheel frontLeft = new Wheel();
    private Wheel rearRight = new Wheel();
    private Wheel rearLeft = new Wheel();

    Car(){
        this.carName = "Undefined";
        this.maxFuel = FUEL;
        this.fuel = maxFuel;
    }
    Car(String name, int fuel){
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("The car has to have some name");
        } else
            this.carName = name;
        if(fuel < 0)
            throw new IllegalArgumentException("The tank capacity can't be negative");
        else
            this.maxFuel = fuel;
        this.fuel = maxFuel;
    }
    Car(String name, int fuel, int tank){
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("The car has to have some name");
        } else
            this.carName = name;
        if(fuel < 0)
            throw new IllegalArgumentException("The tank capacity can't be negative");
        else
            this.maxFuel = tank;
        this.fuel = maxFuel;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setTank(int tank){
        this.maxFuel = tank;
        this.fuel = this.maxFuel;
    }

    public int getFuel(){
        return this.fuel;
    }

    public void ride() {
        if(this.fuel==0)
            System.out.println("The tank is empty, please refuel.");
        else if (!engine.hasStartedUp()){
            System.out.println("The engine isn't started up");
        }
        else {
            System.out.println("The car started moving");
            isRide();
        }
    }

    private void isRide(){
        int balance = this.fuel;
        int border = this.engine.getExpense();
        for(int i = balance; i > 0; i-=border){
            if(balance - this.engine.getExpense() < 0){
                this.engine.stopEngine();
                break;
            }
        }
        this.fuel = balance;
        this.engine.stopEngine();
        System.out.println("Not enough fuel, need to refuel");
    }

    public void chargeFuel(int fuel) {
        int balance = this.maxFuel - this.fuel;
        int availability = this.maxFuel - balance;
        if(this.maxFuel==0)
            System.out.println("Tank capacity not indicated");
        else if(this.maxFuel < fuel)
            System.out.println("Tank capacity ia " + this.maxFuel + " liters, you can refuel " + fuel + " liters");
        else if (availability + fuel == this.maxFuel){
            System.out.println("The car is successfully refilled to" + fuel + " liters");
        }
        else if (this.fuel == this.maxFuel && this.maxFuel - this.fuel!=0){
            System.out.println("It is impossible to refuel tank to " + fuel + " liters");
            System.out.println("The tank isn't empty. There are " + availability + " liters");
            System.out.println("You can refuel tank to " + balance + " liters");
        }
        else {
            this.fuel = fuel;
            System.out.println("The car is successfully refilled to " + fuel + " liters");
        }
    }

    public void changeWheel(double size) {
        if(this.engine.hasStartedUp()){
            System.out.println("You mustn't change wheel when car is ridding");
        } else {
            this.frontRight = new Wheel(size);
            this.frontLeft = new Wheel(size);
            this.rearRight = new Wheel(size);
            this.rearLeft = new Wheel(size);
            System.out.println("The wheels is successfully changed");
        }
    }

    public void startEngine(){
        if(this.fuel!=0)
            this.engine.startEngine();
        else
            System.out.println("It's impossible to started up because tank is empty");
    }

    public void setExpense(int expense){
        this.engine.setExpense(expense);
    }

}
