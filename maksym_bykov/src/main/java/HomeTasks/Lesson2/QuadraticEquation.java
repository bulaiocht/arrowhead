package HomeTasks.Lesson2;

import java.util.Scanner;

public class QuadraticEquation {

//    7.  Найти корни квадратного уравнения. Параметры уравнения передавать как аргументы командной строки.

    public static void main(String[] args) {

        double a, b, c, d;

        System.out.println("There is such equation:");
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Enter a, b и c:");

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        d = b * b - 4 * a * c;
        if (d > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(d)) / (2 * a);
            x2 = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println("Quadratic roots: x1 = " + x1 + ", x2 = " + x2);
        }
        else if (d == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("The equation has one root: x = " + x);
        }
        else {
            System.out.println("The equation has one roots");
        }
    }
}
