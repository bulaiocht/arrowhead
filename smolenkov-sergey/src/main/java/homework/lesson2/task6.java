package homework.lesson2;

public class task6 {

    public static void main(String[] args) {

        for (int i = 0; i < args.length ; i++) {
            double degreesCelsius = Double.parseDouble(args[i]);
            double degreesFahrenheit = degreesCelsius * 1.8 + 32;
            double degreesKelvin = degreesCelsius + 273.15;

            System.out.println();
            System.out.println("**********");
            System.out.println();
            System.out.println(degreesCelsius + " degrees Celsius equal " + degreesFahrenheit + " degrees Fahrenheit;");
            System.out.println(degreesCelsius + " degrees Celsius equal " + degreesKelvin + " degrees Kelvin;");
        }
    }
}