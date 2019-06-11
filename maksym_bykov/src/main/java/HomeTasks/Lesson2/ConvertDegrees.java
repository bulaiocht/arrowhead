package HomeTasks.Lesson2;

import java.util.Scanner;

public class ConvertDegrees {

//    6. Cконвертировать число переданное как аргумент командной строки в градусы по шкале Фаренгейта и в градусы по шкале Кельвина и вывести их в консоль.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double c = scanner.nextFloat();
        System.out.println("Degree celsius C: " + c);

        double k = c + 273.16;
        System.out.println("Degree Kelvin K: " + k);

        double f = c * 1.8 + 32;
        System.out.println("Degree Fahrenheit F: " + f);
    }
}
