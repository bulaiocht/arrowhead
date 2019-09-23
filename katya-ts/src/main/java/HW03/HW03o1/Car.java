package HW03.HW03o1;

import java.util.Random;

public class Car {
    private Engine engine;
    private Tire rightFrontTire;
    private Tire leftFrontTire;
    private Tire rightBackTire;
    private Tire leftBackTire;
    private String brand;
    private boolean tankIsFull;
    private boolean isOn;

    public Car(String brand, boolean tankIsFull) {
        this.engine = new Engine();
        this.rightFrontTire = new Tire();
        this.leftFrontTire = new Tire();
        this.rightBackTire = new Tire();
        this.leftBackTire = new Tire();
        this.brand = brand;
        this.isOn = false;
        this.tankIsFull = tankIsFull;
    }

    public void getFuel() {
        if (this.tankIsFull == false) {
            this.tankIsFull = true;
            System.out.println("The gas tank is refilled! The price will be deducted from your account.");
        } else {
            System.out.println("The gas tank is not empty, ride with peace, adventurer.");
        }
    }

    public void checkTires() {
        Random random = new Random();
        rightFrontTire.setState(random.nextBoolean());
        leftFrontTire.setState(random.nextBoolean());
        rightBackTire.setState(random.nextBoolean());
        leftBackTire.setState(random.nextBoolean());

        if (this.rightFrontTire.getState() == false && this.leftFrontTire.getState() == false &&
                this.rightBackTire.getState() == false && this.leftBackTire.getState() == false) {
            System.out.println("All of the tires are okay, no need to change them.");
        }
        if (this.rightFrontTire.getState() == true) {
            System.out.println("The right front tire is flat!");
            this.rightFrontTire.setState(false);
            System.out.println("... The right front tire's been fixed.");
        }
        if (this.leftFrontTire.getState() == true) {
            System.out.println("The left front tire is flat!");
            this.leftFrontTire.setState(false);
            System.out.println("... The left front tire has been fixed.");
        }
        if (this.rightBackTire.getState() == true) {
            System.out.println("The right back tire is flat!");
            this.rightBackTire.setState(false);
            System.out.println("... The right back tire has been fixed.");
        }
        if (this.leftBackTire.getState() == true) {
            System.out.println("The left back tire is flat!");
            this.leftBackTire.setState(false);
            System.out.println("... The left back tire has been fixed.");
        }
    }

    public void move() {
        if (this.tankIsFull && !this.rightFrontTire.getState() && !this.leftFrontTire.getState() &&
                !this.rightBackTire.getState() && !this.leftBackTire.getState()) {
            this.engine.setState(isOn);
            System.out.println("The " + this.brand + " is cruising through space and time.");
        } else {
            System.out.println("Something is wrong with the " + this.brand + ". Please, check the fuel level and tires.");
            this.checkTires();
            this.getFuel();
            System.out.println("Everything seems to be okay now. Let's fly by wheat fields and water towers.");
        }
    }

    public void getBrand() {
        System.out.println("Thank you for choosing " + this.brand + ".");
    }
}