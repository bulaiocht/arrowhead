package homework.lesson2;

import org.jetbrains.annotations.NotNull;

public class task6 {

//    6. Cконвертировать число переданное как аргумент командной строки
//    в градусы по шкале Фаренгейта и в градусы по шкале Кельвина и вывести их в консоль.

    public static void main(@NotNull String[] args) {


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