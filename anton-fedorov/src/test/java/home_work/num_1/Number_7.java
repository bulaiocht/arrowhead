package home_work.num_1;

import java.util.Scanner;

public class Number_7 {
    /**
     * 7.  Найти корни квадратного уравнения. Параметры уравнения передавать как аргументы командной строки.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input A:");
        double a = scanner.nextDouble();
        System.out.println("Input B:");
        double b = scanner.nextDouble();
        System.out.println("Input C:");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;
        System.out.println("Discriminant is: " + discriminant);

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Root 1: " + root1 + " Root 2: " + root2);
        } else if (discriminant == 0) {
            double root12 = -b / (2 * a);
            System.out.println("Root 1 == Root 2: " + root12);
        } else {
            System.out.println("Discriminant is negative so no roots!");
        }
    }
}
