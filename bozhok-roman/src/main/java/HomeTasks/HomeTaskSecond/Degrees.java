package main.java.HomeTasks.HomeTaskSecond;

public class Degrees {
    public static void main(String[] args) {
            converter(args);


    }
    private static void converter(String[]args){
        double celsius=Double.parseDouble(args[0]);
        double kelvin=celsius+273.15;
        double fahrenheit= celsius*1.8+32;
        System.out.println("Celsius: "+celsius+"\n" +"Kelvin: "+kelvin+"\n"+"Fahrenheit: "+fahrenheit);
    }

}
